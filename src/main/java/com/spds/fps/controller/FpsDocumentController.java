package com.spds.fps.controller;

import com.spds.fps.entity.FpsDocument;
import com.spds.fps.service.FpsDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fpsDocument/")
public class FpsDocumentController {

    @Autowired
    private FpsDocumentService fpsDocumentService;

    @PostMapping("create-update")
    public ResponseEntity<?> createOrUpdateFpsDocument(@RequestBody FpsDocument fpsDocument) {
        return ResponseEntity.ok(fpsDocumentService.saveAndUpdateFpsDocument(fpsDocument));
    }

    @GetMapping("get")
    public ResponseEntity<?> getFpsDocumentById(@RequestParam(required = true) Long id) {
        return ResponseEntity.ok(fpsDocumentService.getFpsDocumentById(id));
    }

    @GetMapping("get-all")
    public ResponseEntity<?> getAllFpsDocument() {
        return ResponseEntity.ok(fpsDocumentService.getAllFpsDocument());
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteFpsDocumentById(@RequestParam(required = true) Long id) {
        return ResponseEntity.ok(fpsDocumentService.deleteFpsDocumentById(id));
    }

    @GetMapping("getByFpsId")
    public ResponseEntity<?> getFpsDocumentsByFpsId(@RequestParam(required = true) Long fpsId) {
        return ResponseEntity.ok(fpsDocumentService.getFpsDocumentByFpsId(fpsId));
    }

    @GetMapping("getByFpsDealerId")
    public ResponseEntity<?> getFpsDocumentsByFpsDealerDetailsId(@RequestParam(required = true) Long fpsDealerId) {
        return ResponseEntity.ok(fpsDocumentService.getFpsDocumentByFpsDealerDetailsId(fpsDealerId));
    }
}
