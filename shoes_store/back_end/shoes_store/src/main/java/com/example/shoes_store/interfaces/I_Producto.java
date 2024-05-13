package com.example.shoes_store.interfaces;

import org.springframework.data.repository.CrudRepository;


import com.example.shoes_store.models.productos;

public interface I_Producto extends CrudRepository<productos,String>{

	/*
	
	@Query("SELECT m FROM producto m WHERE "
			+ "m.tipo_documento LIKE %?1% OR "
			+ "m.numero_documento LIKE %?1% OR "
			+ "m.primer_name LIKE %?1% OR "
			+ "m.segundo_name LIKE %?1% OR "
			+ "m.primer_apellido LIKE %?1% OR "
			+ "m.segundo_apellido LIKE %?1% OR "
			+ "m.telefono LIKE %?1% OR "
			+ "m.correo LIKE %?1% OR "
			+ "m.estado LIKE %?1%")
	
	List<producto>filtroMedico (String filtro);
   
    /*
     * Incluye las funciones básicas del CRUD
    */
	
	
	
	
}
