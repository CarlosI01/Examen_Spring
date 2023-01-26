package com.ista.springtboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.springtboot.models.Empleado;
import com.ista.springtboot.service.empleadoService;
@RestController
@RequestMapping("/api")
public class empleadoController {

		@Autowired
		private empleadoService empleadoS;

		@GetMapping("/emple/listar")
		public ResponseEntity<List<Empleado>> obtenerLista() {
			return new ResponseEntity<>(empleadoS.findByAll(), HttpStatus.OK);

		}

		@GetMapping("/emple/search/{id}")
		public ResponseEntity<Empleado> getById(@PathVariable Integer id) {
			return new ResponseEntity<>(empleadoS.findById(id), HttpStatus.OK);
		}

		@PostMapping("/emple/crear")
		public ResponseEntity<Empleado> crear(@RequestBody Empleado c ) {
	    	
			return new ResponseEntity<>(empleadoS.save(c), HttpStatus.CREATED);
		}

		@DeleteMapping("/emple/delete/{id}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public void delete(@PathVariable Integer id) {
			empleadoS.delete(id);
		}
		

	    @PutMapping("emple/update/{id}")
	    public ResponseEntity<Empleado> updateEmpleado(@RequestBody Empleado employees, @PathVariable("id") Integer id){
	    	Empleado empleadoUp = empleadoS.findById(id);

	        System.out.println("Lo que no me devuelve"+empleadoUp);
	        if(empleadoUp == null){
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }else{
	            try {
	            	empleadoUp.setApellido(employees.getApellido());
	            	empleadoUp.setNombre(employees.getNombre());
	            	empleadoUp.setTelefono(employees.getTelefono());
	            	empleadoUp.setDireccion(employees.getDireccion());
	            	empleadoUp.setFecha_nacimiento(employees.getFecha_nacimiento());
	            	empleadoUp.setObservacion(employees.getObservacion());
	            	empleadoUp.setDias_trabajo(employees.getDias_trabajo());
	            	empleadoUp.setSueldo(employees.getSueldo());
	              
	                return new ResponseEntity<>(empleadoS.save(empleadoUp), HttpStatus.CREATED);
	            }catch (Exception e){
	                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	            }
	        }
	    }
}
