package com.judyprograms.temperthestorm.service;

import com.judyprograms.temperthestorm.exception.RecordNotFoundException;
import com.judyprograms.temperthestorm.model.Slice;
import com.judyprograms.temperthestorm.repository.SliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SliceService {

    @Autowired
    private SliceRepository sliceRepository;

//    TODO: get all slices for one subtask
    public Iterable<Slice> getSlices() {
        return sliceRepository.findAll();
    }

    public Optional<Slice> getSlice(Long sliceNumber) {
        Optional<Slice> optionalSlice = sliceRepository.findBySliceNumber(sliceNumber);
        if (optionalSlice.isPresent()) {
            return sliceRepository.findBySliceNumber(sliceNumber);
        }
        else throw new RecordNotFoundException();
    }

    public void updateSlice(Long sliceNumber, Slice newSlice) {
        Optional<Slice> optionalSlice = sliceRepository.findBySliceNumber(sliceNumber);
        if (optionalSlice.isPresent()) {
            Slice slice = optionalSlice.get();
            slice.setSliceText(newSlice.getSliceText());
            sliceRepository.save(slice);
        } else {
            throw new RecordNotFoundException();
        }
    }


}
