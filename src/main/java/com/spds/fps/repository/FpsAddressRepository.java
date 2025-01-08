package com.spds.fps.repository;

import com.spds.fps.entity.FpsAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/***
 *
 *@author muhammad talib
 *This class was creaded on 08-Jan-2025.
 */

@Repository
public interface FpsAddressRepository extends JpaRepository<FpsAddress, Long> {

    List<FpsAddress> findByFpsIdAndActiveTrueAndDeletedFalse(Long fpsId);

    Optional<FpsAddress> findByIdAndActiveTrueAndDeletedFalse(Long id);
}
