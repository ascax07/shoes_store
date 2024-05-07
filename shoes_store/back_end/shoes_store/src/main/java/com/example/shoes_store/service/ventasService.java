package com.example.shoes_store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoes_store.interfaces.I_Venta;
import com.example.shoes_store.interfacesService.IVentaService;
import com.example.shoes_store.models.ventas;

@Service
public class ventasService implements IVentaService{


	 @Autowired
	    private I_Venta data;

	    @Override
	    public String save(ventas ventas) {
	        data.save(ventas);
	        return ventas.getId_venta();
	    }

	    @Override
	    public List<ventas> findAll() {
	        List<ventas> listaventas = (List<ventas>) data.findAll();
	        
	        return listaventas;
	    }
	    
	    /*
	    @Override
		public List<ventas> filtroMedico(String filtro) {
			List <ventas> listaventas=data.filtroMedico(filtro);
			return listaventas;
		}
		*/

	    
	    @Override
	    public Optional<ventas> findOne(String id) {
	        Optional<ventas> ventas = data.findById(id);
	        
	        return ventas;
	    }

	    @Override
	    public int delete(String id) {
	        data.deleteById(id);
	        return 1;
	    }

	
	
	
}
