package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="articulos")
public class Articulos {
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long codigo;
			@Column(name = "nombre")
			private String nombre;
			@Column(name = "precio")
			private String precio;
			
			@ManyToOne
		    @JoinColumn(name="Fabricante")
		    private Fabricantes fabricante;

			//Constructores
			
			/**
			 * 
			 * @param codigo
			 * @param nombre
			 * @param precio
			 * @param fabricante
			 */
			public Articulos(Long codigo, String nombre, String precio, Fabricantes fabricante) {
				this.codigo = codigo;
				this.nombre = nombre;
				this.precio = precio;
				this.fabricante = fabricante;
			}
			
			/**
			 * Constructor sin parametros
			 */
			public Articulos() {
				
			}

			//Getters y setters
			
			/**
			 * 
			 * @return codigo
			 */
			public Long getCodigo() {
				return codigo;
			}

			/**
			 * 
			 * @param codigo
			 */
			public void setCodigo(Long codigo) {
				this.codigo = codigo;
			}

			/**
			 * 
			 * @return nombre
			 */
			public String getNombre() {
				return nombre;
			}

			/**
			 * 
			 * @param nombre
			 */
			public void setNombre(String nombre) {
				this.nombre = nombre;
			}

			/**
			 * 
			 * @return precio
			 */
			public String getPrecio() {
				return precio;
			}

			/**
			 * 
			 * @param precio
			 */
			public void setPrecio(String precio) {
				this.precio = precio;
			}

			/**
			 * 
			 * @return fabricante
			 */
			public Fabricantes getFabricante() {
				return fabricante;
			}

			/**
			 * 
			 * @param fabricante
			 */
			public void setFabricante(Fabricantes fabricante) {
				this.fabricante = fabricante;
			}

			/**
			 * Metodo toString
			 */
			@Override
			public String toString() {
				return "Articulos [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + "]";
			}
			
			
}
