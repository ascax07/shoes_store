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




import com.example.shoes_store.interfacesService.IClienteService;
import com.example.shoes_store.models.cliente;


@RequestMapping("/api/v1/cliente")
@RestController
@CrossOrigin
public class clienteController {

@Autowired
    
    private IClienteService clienteService;
    
    @PostMapping("/")
    public ResponseEntity<Object> save(
            
            @ModelAttribute("cliente") cliente cliente
            ){
        
    	clienteService.save(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
        
    }
    
    @GetMapping("/")
    public ResponseEntity<Object> findAll(){
        var ListaCliente = clienteService.findAll();
        return new ResponseEntity<>(ListaCliente, HttpStatus.OK);
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
        var cliente = clienteService.findOne(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id){
    	clienteService.delete(id);
        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @ModelAttribute("cliente") cliente clienteUpdate){
        var cliente = clienteService.findOne(id).orElse(null);
        if (cliente != null) {
            cliente.setTipo_identificacion(clienteUpdate.getTipo_identificacion());
            cliente.setNumero_identificacion(clienteUpdate.getNumero_identificacion());
            cliente.setNombre_cliente(clienteUpdate.getNombre_cliente());
            cliente.setApellido_cliente(clienteUpdate.getApellido_cliente());
            cliente.setTelefono(clienteUpdate.getTelefono());
            cliente.setDireccion(clienteUpdate.getDireccion());
            cliente.setCiudad(clienteUpdate.getCiudad());
            cliente.setCorreo(clienteUpdate.getCorreo());
            cliente.setEstado(clienteUpdate.getEstado());
            
            clienteService.save(cliente);
            return new ResponseEntity<>("Guardado", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error: cliente no encontrado", HttpStatus.BAD_REQUEST);
        }
    }
	
	
	
}
