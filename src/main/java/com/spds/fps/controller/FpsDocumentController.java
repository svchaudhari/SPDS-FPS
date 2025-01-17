package com.spds.fps.controller;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.FpsDealerDetails;
import com.spds.fps.entity.FpsDocument;
import com.spds.fps.entity.FpsMaster;
import com.spds.fps.service.FpsDocumentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fpsDocument/")
@Slf4j
public class FpsDocumentController {

    @Autowired
    private FpsDocumentService fpsDocumentService;

    @PostMapping("create-update")
    public ResponseEntity<?> createOrUpdateFpsDocument(@RequestBody FpsDocument fpsDocument) {

        try {
            FpsDocument fpsDocumentDetails = fpsDocumentService.saveAndUpdateFpsDocument(fpsDocument);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", fpsDocumentDetails));
        } catch (Exception e) {
            log.error("Error in saving Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error is saving details-" + e.getMessage(), null, null));
        }
    }

    @GetMapping("get")
    public ResponseEntity<?> getFpsDocumentById(@RequestParam(required = true) Long id) {
        try {
            FpsDocument fpsDocument = fpsDocumentService.getFpsDocumentById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", fpsDocument));
        } catch (Exception e) {
            log.error("Error in fetching Details for id-" + id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-" + e.getMessage(), null, null));
        }
    }

    @GetMapping("get-all")
    public ResponseEntity<?> getAllFpsDocument(@RequestParam(required = false , defaultValue = "true")  Boolean isActive) {
        try {
            List<FpsDocument> allFpsDocument = fpsDocumentService.getAllFpsDocument(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", allFpsDocument));
        } catch (Exception e) {
            log.error("Error in fetching all Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching details-" + e.getMessage(), null, null));
        }

    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteFpsDocumentById(@RequestParam(required = true) Long id) {
        return ResponseEntity.ok(fpsDocumentService.deleteFpsDocumentById(id));
    }

    @GetMapping("getByFpsId")
    public ResponseEntity<?> getFpsDocumentsByFpsId(@RequestParam(required = true) Long fpsId) {
        try {
            FpsDocument fpsDocumentByFpsId = fpsDocumentService.getFpsDocumentByFpsId(fpsId);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", fpsDocumentByFpsId));
        } catch (Exception e) {
            log.error("Error in fetching Details for FPS id-" + fpsId, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-" + e.getMessage(), null, null));
        }
    }

    @GetMapping("getByFpsDealerId")
    public ResponseEntity<?> getFpsDocumentsByFpsDealerDetailsId(@RequestParam(required = true) Long fpsDealerId) {
        try {
            FpsDocument fpsDocumentByFpsDealerDetailsId = fpsDocumentService.getFpsDocumentByFpsDealerDetailsId(fpsDealerId);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", fpsDocumentByFpsDealerDetailsId));
        } catch (Exception e) {
            log.error("Error in fetching Details for FPS id-" + fpsDealerId, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-" + e.getMessage(), null, null));
        }
    }
}
