package com.example.shoes_store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoes_store.interfaces.I_DescripcionVentas;
import com.example.shoes_store.interfacesService.IDescripcionVentasService;
import com.example.shoes_store.models.descripcion_ventas;


@Service
public class DescripcionVentasService implements IDescripcionVentasService{


	 @Autowired
	    private I_DescripcionVentas data;

	    @Override
	    public String save(descripcion_ventas descripcion_ventas) {
	        data.save(descripcion_ventas);
	        return descripcion_ventas.getId_descripcion_venta();
	    }

	    @Override
	    public List<descripcion_ventas> findAll() {
	        List<descripcion_ventas> listadescripcion_ventas = (List<descripcion_ventas>) data.findAll();
	        
	        return listadescripcion_ventas;
	    }
	    
	    /*
	    @Override
		public List<descripcion_ventas> filtroMedico(String filtro) {
			List <descripcion_ventas> listadescripcion_ventas=data.filtroMedico(filtro);
			return listadescripcion_ventas;
		}
		*/

	    
	    @Override
	    public Optional<descripcion_ventas> findOne(String id) {
	        Optional<descripcion_ventas> descripcion_ventas = data.findById(id);
	        
	        return descripcion_ventas;
	    }

	    @Override
	    public int delete(String id) {
	        data.deleteById(id);
	        return 1;
	    }

	
	
}
