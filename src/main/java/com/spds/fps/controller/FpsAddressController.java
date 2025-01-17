package com.spds.fps.controller;

import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.FpsAddress;
import com.spds.fps.entity.FpsDocument;
import com.spds.fps.service.FpsAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fpsAddress/")
@Slf4j
public class FpsAddressController {

    @Autowired
    private FpsAddressService fpsAddressService;

    @PostMapping("create-update")
    public ResponseEntity<?> createOrUpdateFpsAddress(@RequestBody FpsAddress fpsAddress) {
        try {
            FpsAddress fpsAddressDetails = fpsAddressService.saveAndUpdateFpsAddress(fpsAddress);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details saved successfully", fpsAddressDetails));
        } catch (Exception e) {
            log.error("Error in saving Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error is saving details-" + e.getMessage(), null, null));
        }
    }

    @GetMapping("get")
    public ResponseEntity<?> getFpsAddressById(@RequestParam(required = true) Long id) {
        try {
            FpsAddress fpsAddress = fpsAddressService.getFpsAddressById(id);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", fpsAddress));
        } catch (Exception e) {
            log.error("Error in fetching Details for id-" + id, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-" + e.getMessage(), null, null));
        }

    }

    @GetMapping("get-all")
    public ResponseEntity<?> getAllFpsAddress(@RequestParam(required = false , defaultValue = "true") Boolean isActive) {
        try {
            List<FpsAddress> allFpsAddress = fpsAddressService.getAllFpsAddress(isActive);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", allFpsAddress));
        } catch (Exception e) {
            log.error("Error in fetching all Details ", e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error fetching details-" + e.getMessage(), null, null));
        }
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteFpsAddressById(@RequestParam(required = true) Long id) {
        return ResponseEntity.ok(fpsAddressService.deleteFpsAddressById(id));
    }

    @GetMapping("getByFpsId")
    public ResponseEntity<?> getFpdAddressByFpsId(@RequestParam(required = true) Long fpsId) {
        try {
            List<FpsAddress> fpsAddressByFpsId = fpsAddressService.getFpsAddressByFpsId(fpsId);
            return ResponseEntity.ok(new GenericResponse<>(false, null, "Details fetched successfully", fpsAddressByFpsId));
        } catch (Exception e) {
            log.error("Error in fetching Details for FPS id-" + fpsId, e.getMessage(), e);
            return ResponseEntity.badRequest().body(new GenericResponse<>(true, "Error in fetching details-" + e.getMessage(), null, null));
        }
    }
}
