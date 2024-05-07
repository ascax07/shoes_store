package com.example.shoes_store.interfacesService;

import java.util.List;
import java.util.Optional;

import com.example.shoes_store.models.descripcion_ventas;




public interface IDescripcionVentasService {

       public String save(descripcion_ventas descripcion_ventas);    
    public List<descripcion_ventas> findAll();
   // public List<producto> filtroProductos (String descripcion_ventas);
    public Optional<descripcion_ventas> findOne(String id);
    public int delete(String id);

}
