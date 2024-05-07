package com.example.shoes_store.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class descripcion_ventas {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_descripcion_venta", nullable = false, length = 36)
	private String id_descripcion_venta;

	@ManyToOne
	@JoinColumn(name = "ventas_id_venta", referencedColumnName = "id_venta")
	private ventas ventas;

	@ManyToOne
	@JoinColumn(name = "productos_id_producto", referencedColumnName = "id_producto")
	private productos productos;

	@Column(name = "cantidad", nullable = false)
	private String cantidad;

	@Column(name = "precio", nullable = false)
	private String precio;

	@Column(name = "descuento", nullable = false)
	private String descuento;

	@Column(name = "sub_total", nullable = false, length = 45)
	private String sub_total;

	public descripcion_ventas() {
		super();
	}

	public descripcion_ventas(String id_descripcion_venta, com.example.shoes_store.models.ventas ventas,
			com.example.shoes_store.models.productos productos, String cantidad, String precio, String descuento,
			String sub_total) {
		super();
		this.id_descripcion_venta = id_descripcion_venta;
		this.ventas = ventas;
		this.productos = productos;
		this.cantidad = cantidad;
		this.precio = precio;
		this.descuento = descuento;
		this.sub_total = sub_total;
	}

	public String getId_descripcion_venta() {
		return id_descripcion_venta;
	}

	public void setId_descripcion_venta(String id_descripcion_venta) {
		this.id_descripcion_venta = id_descripcion_venta;
	}

	public ventas getVentas() {
		return ventas;
	}

	public void setVentas(ventas ventas) {
		this.ventas = ventas;
	}

	public productos getProductos() {
		return productos;
	}

	public void setProductos(productos productos) {
		this.productos = productos;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getDescuento() {
		return descuento;
	}

	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}

	public String getSub_total() {
		return sub_total;
	}

	public void setSub_total(String sub_total) {
		this.sub_total = sub_total;
	}

	



}
