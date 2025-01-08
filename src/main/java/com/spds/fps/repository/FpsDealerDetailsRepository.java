package com.spds.fps.repository;

import com.spds.fps.entity.FpsDealerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/***
 *
 *@author muhammad talib
 *This class was creaded on 08-Jan-2025.
 */
@Repository
public interface FpsDealerDetailsRepository extends JpaRepository<FpsDealerDetails, Long> {

    Optional<FpsDealerDetails> findByFpsIdAndActiveTrueAndDeletedFalse(Long fpsId);

    Optional<FpsDealerDetails> findByIdAndActiveTrueAndDeletedFalse(Long id);

}
