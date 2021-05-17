package com.rgadam.HardwarePickerWebapp.Repository;

import com.rgadam.HardwarePickerWebapp.Model.Psu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PsuRepository extends JpaRepository<Psu, Long> {
}
