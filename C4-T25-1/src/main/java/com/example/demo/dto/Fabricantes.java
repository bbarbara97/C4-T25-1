package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Fabricantes")
public class Fabricantes {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private Long codigo;
		@Column(name = "nombre")//no hace falta si se llama igual
		private String nombre;
	    @OneToMany
	    @JoinColumn(name="codigo")
	    private List<Articulos> articulo;
	    
	    /**
	     * 
	     * @param codigo
	     * @param nombre
	     * @param articulo
	     */
		public Fabricantes(Long codigo, String nombre, List<Articulos> articulo) {
			this.codigo = codigo;
			this.nombre = nombre;
			this.articulo = articulo;
		}
		/**
		 * Constructor sin parametros
		 */
		public Fabricantes() {
			
		}
		
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
		 * @return articulo
		 */
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Articulos")
		public List<Articulos> getArticulo() {
			return articulo;
		}
		
		
		
		/**
		 * 
		 * @param articulo
		 */
		public void setArticulo(List<Articulos> articulo) {
			this.articulo = articulo;
		}
		
		/**
		 * Metodo toString
		 */
		@Override
		public String toString() {
			return "Fabricantes [codigo=" + codigo + ", nombre=" + nombre + ", articulo=" + articulo + "]";
		}
		
		
	    
}
