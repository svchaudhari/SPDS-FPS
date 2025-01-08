package com.spds.fps.service.imp;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.FpsDocument;
import com.spds.fps.repository.FpsDocumentRepository;
import com.spds.fps.service.FpsDocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/***
 *
 * @author muhammad talib This class was creaded on 08-Jan-2025.
 */
@Slf4j
@Service
public class FpsDocumentsServiceImpl implements FpsDocumentService {

    @Autowired
    private FpsDocumentRepository fpsDocumentRepository;

    @Override
    public FpsDocument saveAndUpdateFpsDocument(FpsDocument fpsDocument) {
        return fpsDocumentRepository.save(fpsDocument);
    }

    @Override
    public FpsDocument getFpsDocumentById(Long id) {
        return fpsDocumentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("FPS Documents details not found."));
    }

    @Override
    public List<FpsDocument> getAllFpsDocument() {
        return fpsDocumentRepository.findAll();
    }

    @Override
    public GenericResponse deleteFpsDocumentById(Long id) {
        GenericResponse response = new GenericResponse();
        Optional<FpsDocument> fpsDocumentDetails = fpsDocumentRepository.findByIdAndActiveTrueAndDeletedFalse(id);
        if (fpsDocumentDetails.isEmpty()) {
            log.error("Fps documents not found..!!!{} ", id);
            response.setError(true);
            response.setErrorMsg("Fps documents not found " + id);
            response.setData(fpsDocumentDetails);
            return response;
        }
        fpsDocumentDetails.get().setDeleted(true);
        fpsDocumentDetails.get().setActive(false);
        fpsDocumentRepository.save(fpsDocumentDetails.get());
        log.info("FPS documents retrieved successfully..!!!{} ", id);
        response.setError(false);
        response.setSuccessMsg("Delete successfully " + id);
        response.setData(fpsDocumentDetails);
        return response;
    }

    @Override
    public FpsDocument getFpsDocumentByFpsId(Long fpsId) {
        return fpsDocumentRepository.findByFpsIdAndActiveTrueAndDeletedFalse(fpsId).orElseThrow(() -> new NoSuchElementException("Fps documents not found" + fpsId));
    }

    @Override
    public FpsDocument getFpsDocumentByFpsDealerDetailsId(Long fpsDealerDetailsId) {
        return fpsDocumentRepository.findByFpsDealerDetailsIdAndActiveTrueAndDeletedFalse(fpsDealerDetailsId).orElseThrow(() -> new NoSuchElementException("Fps documents not found" + fpsDealerDetailsId));
    }
}
