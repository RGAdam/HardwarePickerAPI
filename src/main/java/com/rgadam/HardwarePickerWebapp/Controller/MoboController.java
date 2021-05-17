package com.rgadam.HardwarePickerWebapp.Controller;

import com.rgadam.HardwarePickerWebapp.Exception.ResourceNotFoundException;
import com.rgadam.HardwarePickerWebapp.Model.Mobo;
import com.rgadam.HardwarePickerWebapp.Repository.MoboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MoboController {

    @Autowired
    private MoboRepository moboRepository;

    // get all mobo
    @GetMapping("/mobo")
    public List<Mobo> getAllMobo() {
        return moboRepository.findAll();
    }

    // add new mobo
    @PostMapping("/mobo")
    public Mobo createMobo(@RequestBody Mobo mobo) {
        return this.moboRepository.save(mobo);
    }

    // get mobo by id
    @GetMapping("/mobo/{id}")
    public Mobo getMoboById(@PathVariable(value = "id") Long moboId) throws ResourceNotFoundException {
        return this.moboRepository.findById(moboId).orElseThrow(() -> new ResourceNotFoundException("Motherboard not found for this id :: " + moboId));
    }

    // update mobo
    @PutMapping("/mobo/{id}")
    public ResponseEntity<Mobo> updateMobo(@PathVariable(value = "id") Long moboId, @Validated @RequestBody Mobo moboDetails) throws ResourceNotFoundException {
        Mobo mobo = moboRepository.findById(moboId).orElseThrow(() -> new ResourceNotFoundException("Motherboard not found for this id :: " + moboId));

        mobo.setName(moboDetails.getName());
        mobo.setCpuSocket(moboDetails.getCpuSocket());
        mobo.setPrice(moboDetails.getPrice());

        return ResponseEntity.ok(this.moboRepository.save(mobo));
    }

    // delete mobo
    @DeleteMapping("/mobo/{id}")
    public Map<String, Boolean> deleteMobo(@PathVariable(value = "id") Long moboId) throws ResourceNotFoundException {
        Mobo mobo = moboRepository.findById(moboId).orElseThrow(() -> new ResourceNotFoundException("Motherboard not found for this id :: " + moboId));

        this.moboRepository.delete(mobo);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
