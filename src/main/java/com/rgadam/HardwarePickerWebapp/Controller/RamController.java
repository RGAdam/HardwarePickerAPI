package com.rgadam.HardwarePickerWebapp.Controller;

import com.rgadam.HardwarePickerWebapp.Exception.ResourceNotFoundException;
import com.rgadam.HardwarePickerWebapp.Model.Ram;
import com.rgadam.HardwarePickerWebapp.Repository.RamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RamController {

    @Autowired
    private RamRepository ramRepository;

    // get all ram
    @GetMapping("/ram")
    public List<Ram> getAllRam() {
        return ramRepository.findAll();
    }

    // add new ram
    @PostMapping("/ram")
    public Ram createRam(@RequestBody Ram ram) {
        return this.ramRepository.save(ram);
    }

    // get ram by id
    @GetMapping("/ram/{id}")
    public Ram getRamById(@PathVariable(value = "id") Long ramId) throws ResourceNotFoundException {
        return this.ramRepository.findById(ramId).orElseThrow(() -> new ResourceNotFoundException("Ram not found for this id :: " + ramId));
    }

    // update ram
    @PutMapping("/ram/{id}")
    public ResponseEntity<Ram> updateRam(@PathVariable(value = "id") Long ramId, @Validated @RequestBody Ram ramDetails) throws ResourceNotFoundException {
        Ram ram = ramRepository.findById(ramId).orElseThrow(() -> new ResourceNotFoundException("Ram not found for this id :: " + ramId));

        ram.setName(ramDetails.getName());
        ram.setMemory(ramDetails.getMemory());
        ram.setClockspeed(ramDetails.getClockspeed());
        ram.setPrice(ramDetails.getPrice());

        return ResponseEntity.ok(this.ramRepository.save(ram));
    }

    // delete ram
    @DeleteMapping("/ram/{id}")
    public Map<String, Boolean> deleteRam(@PathVariable(value = "id") Long ramId) throws ResourceNotFoundException {
        Ram ram = ramRepository.findById(ramId).orElseThrow(() -> new ResourceNotFoundException("Ram not found for this id :: " + ramId));

        this.ramRepository.delete(ram);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
