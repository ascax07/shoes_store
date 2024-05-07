package com.example.shoes_store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoes_store.interfaces.I_cliente;
import com.example.shoes_store.interfacesService.IClienteService;
import com.example.shoes_store.models.cliente;

@Service
public class clienteService implements IClienteService {

	  @Autowired
	    private I_cliente data;

	    @Override
	    public String save(cliente cliente) {
	        data.save(cliente);
	        return cliente.getId_cliente();
	    }

	    @Override
	    public List<cliente> findAll() {
	        List<cliente> listaMedico = (List<cliente>) data.findAll();
	        
	        return listaMedico;
	    }
	    
	    /*
	    @Override
		public List<cliente> filtroMedico(String filtro) {
			List <cliente> listaMedico=data.filtroMedico(filtro);
			return listaMedico;
		}
		*/

	    
	    @Override
	    public Optional<cliente> findOne(String id) {
	        Optional<cliente> cliente = data.findById(id);
	        
	        return cliente;
	    }

	    @Override
	    public int delete(String id) {
	        data.deleteById(id);
	        return 1;
	    }

	
	
	
	
	
	
}
