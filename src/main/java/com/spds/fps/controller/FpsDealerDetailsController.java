package com.spds.fps.controller;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.FpsDealerDetails;
import com.spds.fps.entity.FpsMaster;
import com.spds.fps.service.FpsDealerDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author muhammad talib
 * This class was creaded on 08-Jan-2025.
 */

@RestController
@RequestMapping("/api/v1/fpsDealer/")
@Slf4j
public class FpsDealerDetailsController {

    @Autowired
    private FpsDealerDetailsService fpsDealerDetailsService;

    @PostMapping("create-update")
    public ResponseEntity<?> createOrUpdateFpsDealerDetails(@RequestBody FpsDealerDetails fpsDealerDetails) {

        try {
            FpsDealerDetails savedFpsDealerDetails = fpsDealerDetailsService.saveAndUpdateFpsDealerDetails(fpsDealerDetails);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", savedFpsDealerDetails));
        } catch (Exception e) {
            log.error("Error in saving Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error is saving details-" + e.getMessage(), null, null));
        }
    }

    @GetMapping("get")
    public ResponseEntity<?> getFpsDealerDetailsById(@RequestParam(required = true) Long id) {
        try {
            FpsDealerDetails fpsDealerDetails = fpsDealerDetailsService.getFpsDealerDetailsById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", fpsDealerDetails));
        } catch (Exception e) {
            log.error("Error in fetching Details for id-" + id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-" + e.getMessage(), null, null));
        }
    }

    @GetMapping("get-all")
    public ResponseEntity<?> getAllFpsDealerDetails(@RequestParam(required = false , defaultValue = "true") Boolean isActive) {
        try {
            List<FpsDealerDetails> allFpsDealerDetails = fpsDealerDetailsService.getAllFpsDealerDetails(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", allFpsDealerDetails));
        } catch (Exception e) {
            log.error("Error in fetched Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error is fetched details-" + e.getMessage(), null, null));
        }
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteFpsDealerDetailsById(@RequestParam(required = true) Long id) {
        return ResponseEntity.ok(fpsDealerDetailsService.deleteFpsDealerDetailsById(id));
    }

    @GetMapping("getByFpsId")
    public ResponseEntity<?> getFpsDealerDetailsByFpsId(@RequestParam(required = true) Long fpsId) {
        try {
            FpsDealerDetails fpsDealerDetailsByFpsId = fpsDealerDetailsService.getFpsDealerDetailsByFpsId(fpsId);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", fpsDealerDetailsByFpsId));
        } catch (Exception e) {
            log.error("Error in fetching Details for FPS id-" + fpsId, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-" + e.getMessage(), null, null));
        }
    }

}
