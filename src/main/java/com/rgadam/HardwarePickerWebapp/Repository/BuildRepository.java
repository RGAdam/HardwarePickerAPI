package com.rgadam.HardwarePickerWebapp.Repository;

import com.rgadam.HardwarePickerWebapp.Model.Build;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildRepository extends JpaRepository<Build, Long> {
}
