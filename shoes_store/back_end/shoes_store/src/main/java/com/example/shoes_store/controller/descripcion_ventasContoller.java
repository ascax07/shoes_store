package com.example.shoes_store.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.shoes_store.interfacesService.IDescripcionVentasService;
import com.example.shoes_store.models.descripcion_ventas;




@RequestMapping("/api/v1/descripcion_ventasContoller")
@RestController
@CrossOrigin
public class descripcion_ventasContoller {

	

@Autowired
    
    private IDescripcionVentasService DescripcionVentasService;
    
    @PostMapping("/")
    public ResponseEntity<Object> save(
            
            @ModelAttribute("descripcion_ventas") descripcion_ventas descripcion_ventas
            ){
        
                DescripcionVentasService.save(descripcion_ventas);
        return new ResponseEntity<>(descripcion_ventas, HttpStatus.OK);
        
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        var ListaDescripcion_ventas = DescripcionVentasService.findAll();
        return new ResponseEntity<>(ListaDescripcion_ventas, HttpStatus.OK);
    }
    
   
  /*  //filtro 
  	@GetMapping("/busquedafiltro/{filtro}")
  	public ResponseEntity<Object>findFiltro(@PathVariable String filtro){
  		var ListaCliente = clienteService.filtroMedico(filtro);
  		return new ResponseEntity<>(ListaCliente, HttpStatus.OK);
  	}
       */
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id){
        var descripcion_ventas = DescripcionVentasService.findOne(id);
        return new ResponseEntity<>(descripcion_ventas, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
    	DescripcionVentasService.delete(id);
        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @ModelAttribute("descripcion_ventas") descripcion_ventas descripcion_ventasUpdate){
        var descripcion_ventas = DescripcionVentasService.findOne(id).orElse(null);
        if (descripcion_ventas != null) {
            descripcion_ventas.setVentas(descripcion_ventasUpdate.getVentas());
            descripcion_ventas.setProductos(descripcion_ventasUpdate.getProductos());
            descripcion_ventas.setCantidad(descripcion_ventasUpdate.getCantidad());
            descripcion_ventas.setPrecio(descripcion_ventasUpdate.getPrecio());
            descripcion_ventas.setDescuento(descripcion_ventasUpdate.getDescuento());
            descripcion_ventas.setSub_total(descripcion_ventasUpdate.getSub_total());

            
            DescripcionVentasService.save(descripcion_ventas);
            return new ResponseEntity<>("Guardado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error: descripcion de ventas no encontrado", HttpStatus.BAD_REQUEST);
        }
    }
	

}
