package com.example.shoes_store.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ventas {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.UUID)
	    @Column(name = "id_venta", nullable = false, length = 36)
	    private String id_venta;

	  @ManyToOne
	    @JoinColumn(name = "cliente_ id_cliente", referencedColumnName = "id_cliente")
	    private cliente cliente;

	    @Column(name = "total", nullable = false, length = 45)
	    private String total;
	    
		@Column(name="estado", nullable=false, length = 2)
		private String estado;
		
		@Column(name="fecha_venta", nullable=false)
		private String fecha_venta;
		
	

		
	
		public ventas() {
			super();
		}


		public ventas(String id_venta, com.example.shoes_store.models.cliente cliente, String total, String estado,
				String fecha_venta) {
			super();
			this.id_venta = id_venta;
			this.cliente = cliente;
			this.total = total;
			this.estado = estado;
			this.fecha_venta = fecha_venta;
		}


		public String getId_venta() {
			return id_venta;
		}


		public void setId_venta(String id_venta) {
			this.id_venta = id_venta;
		}


		public cliente getCliente() {
			return cliente;
		}


		public void setCliente(cliente cliente) {
			this.cliente = cliente;
		}


		public String getTotal() {
			return total;
		}


		public void setTotal(String total) {
			this.total = total;
		}


		public String getEstado() {
			return estado;
		}


		public void setEstado(String estado) {
			this.estado = estado;
		}


		public String getFecha_venta() {
			return fecha_venta;
		}


		public void setFecha_venta(String fecha_venta) {
			this.fecha_venta = fecha_venta;
		}
				
		
}


