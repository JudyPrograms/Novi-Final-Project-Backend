package com.judyprograms.temperthestorm.controller;

import com.judyprograms.temperthestorm.model.Slice;
import com.judyprograms.temperthestorm.model.User;
import com.judyprograms.temperthestorm.service.SliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SliceController {

    @Autowired
    private SliceService sliceService;

    @GetMapping("/slices")
    public ResponseEntity<Object> getSlices() {
        return ResponseEntity.ok().body(sliceService.getSlices());
    }

    @GetMapping("/slices/{sliceNumber}")
    public ResponseEntity<Object> getSlice(@PathVariable Long sliceNumber) {
        return ResponseEntity.ok().body(sliceService.getSlice(sliceNumber));
    }

    @PutMapping("/slices/{sliceNumber}")
    public ResponseEntity<Object> updateSlice(@PathVariable Long sliceNumber, @RequestBody Slice slice) {
        sliceService.updateSlice(sliceNumber, slice);
        return ResponseEntity.noContent().build();
    }

}
