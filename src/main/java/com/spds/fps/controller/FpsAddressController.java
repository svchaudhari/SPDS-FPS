package com.spds.fps.controller;

import com.spds.fps.entity.FpsAddress;
import com.spds.fps.service.FpsAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fpsAddress/")
public class FpsAddressController {

    @Autowired
    private FpsAddressService fpsAddressService;

    @PostMapping("create-update")
    public ResponseEntity<?> createOrUpdateFpsAddress(@RequestBody FpsAddress fpsAddress) {
        return ResponseEntity.ok(fpsAddressService.saveAndUpdateFpsAddress(fpsAddress));
    }

    @GetMapping("get")
    public ResponseEntity<?> getFpsAddressById(@RequestParam(required = true) Long id) {
        return ResponseEntity.ok(fpsAddressService.getFpsAddressById(id));
    }

    @GetMapping("get-all")
    public ResponseEntity<?> getAllFpsAddress() {
        return ResponseEntity.ok(fpsAddressService.getAllFpsAddress());
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteFpsAddressById(@RequestParam(required = true) Long id) {
        return ResponseEntity.ok(fpsAddressService.deleteFpsAddressById(id));
    }

    @GetMapping("getByFpsId")
    public ResponseEntity<?> getFpdAddressByFpsId(@RequestParam(required = true) Long fpsId) {
        return ResponseEntity.ok(fpsAddressService.getFpsAddressByFpsId(fpsId));
    }
}
