package com.example.shoes_store.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.shoes_store.interfacesService.IVentaService;
import com.example.shoes_store.models.ventas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RequestMapping("/api/v1/ventas")
@RestController
@CrossOrigin
public class ventaController {
	
	

	
@Autowired
    
    private IVentaService ventasService;
    
    @PostMapping("/")
    public ResponseEntity<Object> save(
            
            @ModelAttribute("ventas") ventas ventas
            ){
        
    	ventasService.save(ventas);
        return new ResponseEntity<>(ventas, HttpStatus.OK);
        
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        var Listaventas = ventasService.findAll();
        return new ResponseEntity<>(Listaventas, HttpStatus.OK);
    }
    
   
   //filtro 
  	@GetMapping("/busquedafiltro/{filtro}")
  	public ResponseEntity<Object>findFiltro(@PathVariable String filtro){
  		var Listaventas = ventasService.filtroVentas(filtro);
  		return new ResponseEntity<>(Listaventas, HttpStatus.OK);
  	}
       
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id){
        var ventas = ventasService.findOne(id);
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
    	ventasService.delete(id);
        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @ModelAttribute("ventas") ventas ventasUpdate){
        var ventas = ventasService.findOne(id).orElse(null);
        if (ventas != null) {
            ventas.setCliente(ventasUpdate.getCliente());
            ventas.setTotal(ventasUpdate.getTotal());
            ventas.setEstado(ventasUpdate.getEstado());
            ventas.setFecha_venta(ventasUpdate.getFecha_venta());
            
            ventasService.save(ventas);
            return new ResponseEntity<>("Guardado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error: venta no encontrado", HttpStatus.BAD_REQUEST);
        }
    }

}
