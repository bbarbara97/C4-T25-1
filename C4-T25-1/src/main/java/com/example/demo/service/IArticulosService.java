package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Articulos;

public interface IArticulosService {

public List<Articulos> listarArticulos(); //Listar All 
	
	public Articulos guardarArticulo(Articulos video);	//Guarda un video CREATE
	
	public Articulos articuloXID(Long id); //Leer datos de un video READ
	
	public Articulos actualizarArticulo(Articulos articulo); //Actualiza datos del video UPDATE
	
	public void eliminarArticulo(Long id);// Elimina el video DELETE
}
