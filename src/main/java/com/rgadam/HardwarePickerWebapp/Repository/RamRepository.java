package com.rgadam.HardwarePickerWebapp.Repository;

import com.rgadam.HardwarePickerWebapp.Model.Ram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RamRepository extends JpaRepository<Ram, Long> {
}
