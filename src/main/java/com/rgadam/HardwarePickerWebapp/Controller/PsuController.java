package com.rgadam.HardwarePickerWebapp.Controller;

import com.rgadam.HardwarePickerWebapp.Exception.ResourceNotFoundException;
import com.rgadam.HardwarePickerWebapp.Model.Psu;
import com.rgadam.HardwarePickerWebapp.Repository.PsuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PsuController {

    @Autowired
    private PsuRepository psuRepository;

    // get all psu
    @GetMapping("/psu")
    public List<Psu> getAllPsu() {
        return psuRepository.findAll();
    }

    // add new psu
    @PostMapping("/psu")
    public Psu createPsu(@RequestBody Psu psu) {
        return this.psuRepository.save(psu);
    }

    // get psu by id
    @GetMapping("/psu/{id}")
    public Psu getPsuById(@PathVariable(value = "id") Long psuId) throws ResourceNotFoundException {
        return this.psuRepository.findById(psuId).orElseThrow(() -> new ResourceNotFoundException("psu not found for this id :: " + psuId));
    }

    // update psu
    @PutMapping("/psu/{id}")
    public ResponseEntity<Psu> updatePsu(@PathVariable(value = "id") Long psuId, @Validated @RequestBody Psu psuDetails) throws ResourceNotFoundException {
        Psu psu = psuRepository.findById(psuId).orElseThrow(() -> new ResourceNotFoundException("psu not found for this id :: " + psuId));

        psu.setName(psuDetails.getName());
        psu.setWattage(psuDetails.getWattage());
        psu.setQualification(psuDetails.getQualification());
        psu.setPrice(psuDetails.getPrice());

        return ResponseEntity.ok(this.psuRepository.save(psu));
    }

    // delete psu
    @DeleteMapping("/psu/{id}")
    public Map<String, Boolean> deletePsu(@PathVariable(value = "id") Long psuId) throws ResourceNotFoundException {
        Psu psu = psuRepository.findById(psuId).orElseThrow(() -> new ResourceNotFoundException("psu not found for this id :: " + psuId));

        this.psuRepository.delete(psu);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
