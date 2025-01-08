package com.spds.fps.repository;

import com.spds.fps.entity.Fps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/***
 *
 *@author muhammad talib
 *This class was creaded on 08-Jan-2025.
 */

public interface FpsRepository extends JpaRepository<Fps, Long> {

    Optional<Fps> findByIdAndActiveTrueAndDeletedFalse(Long fpsId);
}
