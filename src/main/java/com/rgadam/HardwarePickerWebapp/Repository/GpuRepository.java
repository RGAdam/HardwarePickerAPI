package com.rgadam.HardwarePickerWebapp.Repository;

import com.rgadam.HardwarePickerWebapp.Model.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GpuRepository extends JpaRepository<Gpu, Long> {
}
