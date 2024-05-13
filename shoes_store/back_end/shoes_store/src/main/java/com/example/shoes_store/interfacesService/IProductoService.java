package com.example.shoes_store.interfacesService;


import java.util.List;
import java.util.Optional;

import com.example.shoes_store.models.productos;

public interface IProductoService {
	
	
    public String save(productos productos);    
    public List<productos> findAll();
   // public List<producto> filtroProductos (String productos);
    public Optional<productos> findOne(String id);
    public int delete(String id);

}
