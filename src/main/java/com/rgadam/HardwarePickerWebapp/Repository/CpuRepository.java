package com.rgadam.HardwarePickerWebapp.Repository;

import com.rgadam.HardwarePickerWebapp.Model.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CpuRepository extends JpaRepository<Cpu, Long> {

}
