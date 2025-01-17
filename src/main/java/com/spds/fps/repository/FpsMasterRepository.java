package com.spds.fps.repository;

import com.spds.fps.entity.FpsMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/***
 *
 *@author muhammad talib
 *This class was creaded on 08-Jan-2025.
 */

public interface FpsMasterRepository extends JpaRepository<FpsMaster, Long> {

    Optional<FpsMaster> findByIdAndActiveTrueAndDeletedFalse(Long id);

    List<FpsMaster> findAllByActiveTrueAndDeletedFalse();

    List<FpsMaster> findAllByDeletedFalse();
}
