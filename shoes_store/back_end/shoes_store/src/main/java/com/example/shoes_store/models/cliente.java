package com.example.shoes_store.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class cliente {
    
	@Id
	@GeneratedValue(strategy =GenerationType.UUID)
	@Column(name="id_cliente", nullable=false, length = 36)
	private String id_cliente;
    
	@Column(name="tipo_identificacion", nullable=false, length = 2)
	private String tipo_identificacion;
	
	@Column(name="numero_identificacion", nullable=false, length = 10)
	private String numero_identificacion;
	
	@Column(name="nombre_cliente", nullable=false, length = 45)
	private String nombre_cliente;
	
	
	@Column(name="apellido_cliente", nullable=false, length = 45)
	private String apellido_cliente;
	
	
	@Column(name="telefono", nullable=false, length = 13)
	private String telefono;
	
	
	@Column(name="direccion", nullable=false, length = 45)
	private String direccion;
	
	@Column(name="ciudad", nullable=false, length = 45)
	private String ciudad;

	@Column(name="correo", nullable=false, length = 100)
	private String correo;

	@Column(name = "estado", nullable = false, length = 2)
	private String estado;


	public cliente() {
		super();
	}


	public cliente(String id_cliente, String tipo_identificacion, String numero_identificacion, String nombre_cliente,
			String apellido_cliente, String telefono, String direccion, String ciudad, String correo, String estado) {
		super();
		this.id_cliente = id_cliente;
		this.tipo_identificacion = tipo_identificacion;
		this.numero_identificacion = numero_identificacion;
		this.nombre_cliente = nombre_cliente;
		this.apellido_cliente = apellido_cliente;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.correo = correo;
		this.estado = estado;
	}


	public String getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getTipo_identificacion() {
		return tipo_identificacion;
	}


	public void setTipo_identificacion(String tipo_identificacion) {
		this.tipo_identificacion = tipo_identificacion;
	}


	public String getNumero_identificacion() {
		return numero_identificacion;
	}


	public void setNumero_identificacion(String numero_identificacion) {
		this.numero_identificacion = numero_identificacion;
	}


	public String getNombre_cliente() {
		return nombre_cliente;
	}


	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}


	public String getApellido_cliente() {
		return apellido_cliente;
	}


	public void setApellido_cliente(String apellido_cliente) {
		this.apellido_cliente = apellido_cliente;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


}
