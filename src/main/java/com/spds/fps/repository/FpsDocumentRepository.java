package com.spds.fps.repository;

import com.spds.fps.entity.FpsDocument;
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
public interface FpsDocumentRepository extends JpaRepository<FpsDocument, Long> {

    Optional<FpsDocument> findByFpsIdAndActiveTrueAndDeletedFalse(Long fpsId);

    Optional<FpsDocument> findByFpsDealerDetailsIdAndActiveTrueAndDeletedFalse(Long fpsDealerDetailsId);

    Optional<FpsDocument> findByIdAndActiveTrueAndDeletedFalse(Long id);

    List<FpsDocument> findAllByActiveTrueAndDeletedFalse();

    List<FpsDocument> findAllByDeletedFalse();

}
