package com.example.shoes_store.interfacesService;


import java.util.List;
import java.util.Optional;

import com.example.shoes_store.models.cliente;


public interface IClienteService {

    public String save(cliente cliente);    
    public List<cliente> findAll();
   // public List<cliente> filtroMedico (String filtro);
    public Optional<cliente> findOne(String id);
    public int delete(String id);

	
}
