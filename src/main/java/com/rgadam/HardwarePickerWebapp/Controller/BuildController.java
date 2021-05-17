package com.rgadam.HardwarePickerWebapp.Controller;

import com.rgadam.HardwarePickerWebapp.Exception.ResourceNotFoundException;
import com.rgadam.HardwarePickerWebapp.Model.*;
import com.rgadam.HardwarePickerWebapp.Repository.BuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BuildController {

    @Autowired
    private BuildRepository buildRepository;

    @PostMapping("/build")
    public Build createBuild(@RequestBody Build build) {
        return this.buildRepository.save(build);
    }

    @GetMapping("/build/{id}")
    public Build getBuildById(@PathVariable(value = "id") Long buildId) throws ResourceNotFoundException {
        return this.buildRepository.findById(buildId).orElseThrow(() -> new ResourceNotFoundException("Build not found for this id :: " + buildId));
    }

    // delete build
    @DeleteMapping("/build/{id}")
    public String deleteBuild(@PathVariable(value = "id") Long buildId) throws ResourceNotFoundException {
        Build build = buildRepository.findById(buildId).orElseThrow(() -> new ResourceNotFoundException("Build not found for this id :: " + buildId));

        this.buildRepository.delete(build);

        return "Successfully deleted!";
    }
}
