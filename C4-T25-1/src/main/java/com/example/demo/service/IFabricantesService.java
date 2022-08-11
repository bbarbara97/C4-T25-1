package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Fabricantes;

public interface IFabricantesService {

	public List<Fabricantes> listarFabricantes(); //Listar All 
	
	public Fabricantes guardarFabricante(Fabricantes video);	//Guarda un video CREATE
	
	public Fabricantes fabricanteXID(Long id); //Leer datos de un video READ
	
	public Fabricantes actualizarFabricante(Fabricantes fabricante); //Actualiza datos del video UPDATE
	
	public void eliminarFabricante(Long id);// Elimina el video DELETE
}
