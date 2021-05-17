package com.rgadam.HardwarePickerWebapp.Controller;

import com.rgadam.HardwarePickerWebapp.Exception.ResourceNotFoundException;
import com.rgadam.HardwarePickerWebapp.Model.Cpu;
import com.rgadam.HardwarePickerWebapp.Repository.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CpuController {

    @Autowired
    private CpuRepository cpuRepository;

    // get all cpu
    @GetMapping("/cpu")
    public List<Cpu> getAllCpu() {
        return cpuRepository.findAll();
    }

    // add new cpu
    @PostMapping("/cpu")
    public Cpu createCpu(@RequestBody Cpu cpu) {
        return this.cpuRepository.save(cpu);
    }

    // get cpu by id
    @GetMapping("/cpu/{id}")
    public Cpu getCpuById(@PathVariable(value = "id") Long cpuId) throws ResourceNotFoundException {
        return this.cpuRepository.findById(cpuId).orElseThrow(() -> new ResourceNotFoundException("Cpu not found for this id :: " + cpuId));
    }

    // update cpu
    @PutMapping("/cpu/{id}")
    public ResponseEntity<Cpu> updateCpu(@PathVariable(value = "id") Long cpuId, @Validated @RequestBody Cpu cpuDetails) throws ResourceNotFoundException {
        Cpu cpu = cpuRepository.findById(cpuId).orElseThrow(() -> new ResourceNotFoundException("Cpu not found for this id :: " + cpuId));

        cpu.setName(cpuDetails.getName());
        cpu.setCores(cpuDetails.getCores());
        cpu.setClockspeed(cpuDetails.getClockspeed());
        cpu.setSocket(cpuDetails.getSocket());
        cpu.setPrice(cpuDetails.getPrice());

        return ResponseEntity.ok(this.cpuRepository.save(cpu));
    }

    // delete cpu
    @DeleteMapping("/cpu/{id}")
    public String deleteCpu(@PathVariable(value = "id") Long cpuId) throws ResourceNotFoundException {
        Cpu cpu = cpuRepository.findById(cpuId).orElseThrow(() -> new ResourceNotFoundException("Cpu not found for this id :: " + cpuId));

        this.cpuRepository.delete(cpu);

        return "Successfully deleted!";
    }
}
