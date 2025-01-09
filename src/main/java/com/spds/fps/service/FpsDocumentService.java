package com.spds.fps.service;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.FpsDocument;

import java.util.List;


/**
 * @author muhammad talib
 * This class was creaded on 08-Jan-2025.
 */

public interface FpsDocumentService {


    FpsDocument saveAndUpdateFpsDocument(FpsDocument fpsDocument);

    FpsDocument getFpsDocumentById(Long id);

    List<FpsDocument> getAllFpsDocument();

    GenericResponse deleteFpsDocumentById(Long id);

    FpsDocument getFpsDocumentByFpsId(Long fpsId);

    FpsDocument getFpsDocumentByFpsDealerDetailsId(Long fpsDealerDetailsId);


}
