package com.ista.springtboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ista.springtboot.models.Empleado;

public interface empleadoRepository extends JpaRepository<Empleado, Integer> {

}
