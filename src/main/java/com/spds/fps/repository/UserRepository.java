package com.spds.fps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spds.fps.entity.User;

/***
 * 
 *@author abinjola
 *This class was creaded on 08-Dec-2024.
 */
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUserName(String userName);

}
