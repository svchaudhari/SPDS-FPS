package com.spds.fps.controller;


import com.spds.fps.dto.GenericResponse;
import com.spds.fps.entity.Fps;
import com.spds.fps.service.FpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fps/")
public class FpsController {

    @Autowired
    private FpsService fpsService;

    @PostMapping("create-update")
    public ResponseEntity<?> saveAndUpdateFpsDetails(@RequestBody Fps fpsDetails) {
        Fps fps = fpsService.saveAndUpdateFps(fpsDetails);
        return ResponseEntity.ok(fps);
    }

    @GetMapping("get")
    public ResponseEntity<?> getFpsDetailsById(@RequestParam(required = true) Long id) {
        Fps fpsDetails = fpsService.getFpsById(id);
        return ResponseEntity.ok(fpsDetails);
    }

    @GetMapping("get-all")
    public ResponseEntity<?> getAllFpsDetails() {
        List<Fps> allFpsDetails = fpsService.getAllFps();
        return ResponseEntity.ok(allFpsDetails);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteFpsDetailsById(@RequestParam(required = true) Long id) {
        GenericResponse response = fpsService.deleteFpsById(id);
        return ResponseEntity.ok(response);
    }

}
