package com.spds.fps.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spds.fps.dto.UserPrincipal;
import com.spds.fps.entity.RoleOffice;
import com.spds.fps.entity.User;
import com.spds.fps.entity.UserAccessMapping;
import com.spds.fps.repository.UserAccessRepository;
import com.spds.fps.repository.UserRepository;
import com.spds.fps.service.UserService;

import lombok.extern.slf4j.Slf4j;

/***
 * 
 * @author abinjola This class was creaded on 02-Dec-2024.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private UserRepository userRepository;

	private UserAccessRepository userAccessRepository;
	
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder, UserAccessRepository userAccessRepository) {
		this.userRepository = userRepository;
		this.passwordEncoder=passwordEncoder;
		this.userAccessRepository = userAccessRepository;
	}

	@Override
	public User getUserDetails(Long userId) throws Exception {
		log.info("Get user details for: {}", userId);
		return userRepository.findById(userId).orElseThrow(() -> new Exception("user not found!"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findById(Long.valueOf(username));
		return user.map(UserPrincipal::new)
				.orElseThrow(() -> new UsernameNotFoundException("UserName not found: " + username));
	}

	@Override
	public List<RoleOffice> getAuthorities(Long userId) {
		return userAccessRepository.getUserPrivilagesByUserId(userId);
	}

	@Override
	public List<UserAccessMapping> assignRoleAndOffice(List<UserAccessMapping> userAccess) {
		return userAccessRepository.saveAll(userAccess);
	}

}
