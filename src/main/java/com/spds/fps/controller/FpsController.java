package com.spds.fps.controller;


import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.FpsMaster;
import com.spds.fps.service.FpsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/fps/")
@Slf4j
public class FpsController {

    @Autowired
    private FpsService fpsService;

    @PostMapping("create-update")
    public ResponseEntity<?> saveAndUpdateFpsDetails(@RequestBody FpsMaster fpsDetails) {

        try {
            FpsMaster fps = fpsService.saveAndUpdateFps(fpsDetails);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", fps));
        } catch (Exception e) {
            log.error("Error in saving Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error is saving details-" + e.getMessage(), null, null));
        }

    }

    @GetMapping("get")
    public ResponseEntity<?> getFpsDetailsById(@RequestParam(required = true) Long id) {
        try {
            FpsMaster fpsDetails = fpsService.getFpsById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Setails fetched successfully", fpsDetails));
        } catch (Exception e) {
            log.error("Error in fetching Details for id-" + id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-" + e.getMessage(), null, null));
        }
    }

    @GetMapping("get-all")
    public ResponseEntity<?> getAllFpsDetails(@RequestParam(required = false,defaultValue = "true") Boolean isActive) {
        try {
            List<FpsMaster> allFpsDetails = fpsService.getAllFps(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", allFpsDetails));
        } catch (Exception e) {
            log.error("Error in fetching all Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching details-" + e.getMessage(), null, null));
        }
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteFpsDetailsById(@RequestParam(required = true) Long id) {
        GenericResponse response = fpsService.deleteFpsById(id);
        return ResponseEntity.ok(response);
    }

}
