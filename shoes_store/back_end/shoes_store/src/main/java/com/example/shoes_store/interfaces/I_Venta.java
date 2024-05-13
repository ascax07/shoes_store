package com.example.shoes_store.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.shoes_store.models.ventas;



public interface I_Venta extends CrudRepository<ventas,String>{

	
	@Query("SELECT v FROM ventas v JOIN "
			+"v.cliente c "
			+"WHERE c.tipo_identificacion like %?1% "
			+"OR c.numero_identificacion LIKE %?1% "
			+"OR c.nombre_cliente LIKE %?1% "
			+"OR c.apellido_cliente LIKE %?1% "
			+"OR c.telefono LIKE %?1% "
			+"OR c.direccion LIKE %?1% "
			+"OR c.ciudad LIKE %?1% "
			+"OR c.correo LIKE %?1% "
			+"OR c.estado  LIKE %?1% "
			+"OR v.total  LIKE %?1% "
			+"OR v.fecha_venta= ?1 "
			+"OR v.estado  LIKE %?1% ")
	List<ventas>filtroVentas (String filtro);
	/*
	 * Imcluye las funciones basicas del CRUD
	*/
	
	
	
}
