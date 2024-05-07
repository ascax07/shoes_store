package com.example.shoes_store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoes_store.interfaces.I_Producto;
import com.example.shoes_store.interfacesService.IProductoService;
import com.example.shoes_store.models.productos;

@Service
public class productoService  implements IProductoService{

	
	 @Autowired
	    private I_Producto data;

	    @Override
	    public String save(productos productos) {
	        data.save(productos);
	        return productos.getId_producto();
	    }

	    @Override
	    public List<productos> findAll() {
	        List<productos> listaProductos = (List<productos>) data.findAll();
	        
	        return listaProductos;
	    }
	    
	    /*
	    @Override
		public List<productos> filtroMedico(String filtro) {
			List <productos> listaProductos=data.filtroMedico(filtro);
			return listaProductos;
		}
		*/

	    
	    @Override
	    public Optional<productos> findOne(String id) {
	        Optional<productos> productos = data.findById(id);
	        
	        return productos;
	    }

	    @Override
	    public int delete(String id) {
	        data.deleteById(id);
	        return 1;
	    }

	
	
	
	
}
