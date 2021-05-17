package com.rgadam.HardwarePickerWebapp.Controller;

import com.rgadam.HardwarePickerWebapp.Exception.ResourceNotFoundException;
import com.rgadam.HardwarePickerWebapp.Model.Gpu;
import com.rgadam.HardwarePickerWebapp.Repository.GpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class GpuController {

    @Autowired
    private GpuRepository gpuRepository;

    // get all gpu
    @GetMapping("/gpu")
    public List<Gpu> getAllGpu() {
        return gpuRepository.findAll();
    }

    // add new gpu
    @PostMapping("/gpu")
    public Gpu createGpu(@RequestBody Gpu gpu) {
        return this.gpuRepository.save(gpu);
    }

    // get gpu by id
    @GetMapping("/gpu/{id}")
    public Gpu getGpuById(@PathVariable(value = "id") Long gpuId) throws ResourceNotFoundException {
        return this.gpuRepository.findById(gpuId).orElseThrow(() -> new ResourceNotFoundException("Gpu not found for this id :: " + gpuId));
    }

    // update gpu
    @PutMapping("/gpu/{id}")
    public ResponseEntity<Gpu> updateGpu(@PathVariable(value = "id") Long gpuId, @Validated @RequestBody Gpu gpuDetails) throws ResourceNotFoundException {
        Gpu gpu = gpuRepository.findById(gpuId).orElseThrow(() -> new ResourceNotFoundException("Gpu not found for this id :: " + gpuId));

        gpu.setName(gpuDetails.getName());
        gpu.setVram(gpuDetails.getVram());
        gpu.setClockspeed(gpuDetails.getClockspeed());
        gpu.setPrice(gpuDetails.getPrice());

        return ResponseEntity.ok(this.gpuRepository.save(gpu));
    }

    // delete gpu
    @DeleteMapping("/gpu/{id}")
    public Map<String, Boolean> deleteGpu(@PathVariable(value = "id") Long gpuId) throws ResourceNotFoundException {
        Gpu gpu = gpuRepository.findById(gpuId).orElseThrow(() -> new ResourceNotFoundException("Gpu not found for this id :: " + gpuId));

        this.gpuRepository.delete(gpu);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
