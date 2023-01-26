package com.ista.springtboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ista.springtboot.models.Empleado;
import com.ista.springtboot.repository.empleadoRepository;
@Service
public class empleadoServiceImpl extends GenericServiceImpl<Empleado, Integer> implements empleadoService{
    @Autowired
    empleadoRepository empleadoR;

    @Override
    public CrudRepository<Empleado, Integer> getDao() {
        return empleadoR;
    }

    
}
