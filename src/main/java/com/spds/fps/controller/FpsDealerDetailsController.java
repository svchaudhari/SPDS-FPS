package com.spds.fps.controller;

import com.spds.fps.entity.FpsDealerDetails;
import com.spds.fps.service.FpsDealerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fpsDealer/")
public class FpsDealerDetailsController {

    @Autowired
    private FpsDealerDetailsService fpsDealerDetailsService;

    @PostMapping("create-update")
    public ResponseEntity<?> createOrUpdateFpsDealerDetails(@RequestBody FpsDealerDetails fpsDealerDetails) {
        return ResponseEntity.ok(fpsDealerDetailsService.saveAndUpdateFpsDealerDetails(fpsDealerDetails));
    }

    @GetMapping("get")
    public ResponseEntity<?> getFpsDealerDetailsById(@RequestParam(required = true) Long id) {
        return ResponseEntity.ok(fpsDealerDetailsService.getFpsDealerDetailsById(id));
    }

    @GetMapping("get-all")
    public ResponseEntity<?> getAllFpsDealerDetails() {
        return ResponseEntity.ok(fpsDealerDetailsService.getAllFpsDealerDetails());
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteFpsDealerDetailsById(@RequestParam(required = true) Long id) {
        return ResponseEntity.ok(fpsDealerDetailsService.deleteFpsDealerDetailsById(id));
    }

    @GetMapping("getByFpsId")
    public ResponseEntity<?> getFpsDealerDetailsByFpsId(@RequestParam(required = true) Long fpsId) {
        return ResponseEntity.ok(fpsDealerDetailsService.getFpsDealerDetailsByFpsId(fpsId));
    }

}
