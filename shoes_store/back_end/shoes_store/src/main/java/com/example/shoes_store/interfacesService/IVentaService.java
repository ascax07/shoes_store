package com.example.shoes_store.interfacesService;

import java.util.List;
import java.util.Optional;


import com.example.shoes_store.models.ventas;




public interface IVentaService {

	
    public String save(ventas ventas);    
    public List<ventas> findAll();
    public List<ventas> filtroVentas(String filtro);
    public Optional<ventas> findOne(String id);
    public int delete(String id);

	
	
	
}
