package com.example.shoes_store.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.shoes_store.interfacesService.IProductoService;
import com.example.shoes_store.models.productos;

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


@RequestMapping("/api/v1/productos")
@RestController
@CrossOrigin
public class productoController {

	
@Autowired
    
    private IProductoService productoService;
    
    @PostMapping("/")
    public ResponseEntity<Object> save(
            
            @ModelAttribute("productos") productos productos
            ){
        
    	productoService.save(productos);
        return new ResponseEntity<>(productos, HttpStatus.OK);
        
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        var Listaproductos = productoService.findAll();
        return new ResponseEntity<>(Listaproductos, HttpStatus.OK);
    }
    
   
  /*  //filtro 
  	@GetMapping("/busquedafiltro/{filtro}")
  	public ResponseEntity<Object>findFiltro(@PathVariable String filtro){
  		var Listaproductos = productosService.filtroMedico(filtro);
  		return new ResponseEntity<>(Listaproductos, HttpStatus.OK);
  	}
       */
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id){
        var productos = productoService.findOne(id);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
    	productoService.delete(id);
        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @ModelAttribute("productos") productos productosUpdate){
        var productos = productoService.findOne(id).orElse(null);
        if (productos != null) {
            productos.setNombre_producto(productosUpdate.getNombre_producto());
            productos.setDescripcion(productosUpdate.getDescripcion());
            productos.setCantidad(productosUpdate.getCantidad());
            productos.setPrecio(productosUpdate.getPrecio());
            productos.setPorcentaje_iva(productosUpdate.getPorcentaje_iva());
            productos.setPorcentaje_descuento(productosUpdate.getPorcentaje_descuento());
            productos.setEstado(productosUpdate.getEstado());
            
            
            productoService.save(productos);
            return new ResponseEntity<>("Guardado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error: producto no encontrado", HttpStatus.BAD_REQUEST);
        }
    }
	
	
	
}
