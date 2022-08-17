package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Articulos;
import com.example.demo.service.ArticulosServiceImpl;

@RestController
@RequestMapping("/api")
public class ArticulosController {

	@Autowired
	ArticulosServiceImpl articulosServideImpl;
	
	@GetMapping("/articulos")
	public List<Articulos> listarArticulos(){
		return articulosServideImpl.listarArticulos();
	}
	
	@PostMapping("/articulos")
	public Articulos salvarArticulo(@RequestBody Articulos articulos) {
		
		return articulosServideImpl.guardarArticulo(articulos);
	}
	
	@GetMapping("/articulos/{codigo}")
	public Articulos articulosXID(@PathVariable(name="codigo") Long codigo) {
		
		Articulos articulos_xid= new Articulos();
		
		articulos_xid=articulosServideImpl.articuloXID(codigo);
		
		System.out.println("Articulo XID: "+articulos_xid);
		
		return articulos_xid;
	}
	
	@PutMapping("/articulos/{codigo}")
	public Articulos actualizarArticulo(@PathVariable(name="codigo")Long codigo,@RequestBody Articulos articulos) {
		
		Articulos articulos_seleccionado;
		Articulos articulos_actualizado;
		
		articulos_seleccionado= articulosServideImpl.articuloXID(codigo);
		
		articulos_seleccionado.setCodigo(articulos.getCodigo());
		articulos_seleccionado.setNombre(articulos.getNombre());
		articulos_seleccionado.setPrecio(articulos.getPrecio());
		articulos_seleccionado.setFabricante(articulos.getFabricante());
		
		articulos_actualizado = articulosServideImpl.actualizarArticulo(articulos_seleccionado);
		
		System.out.println("El articulo actualizado es: "+ articulos_actualizado);
		
		return articulos_actualizado;
	}
	
	@DeleteMapping("/articulos/{codigo}")
	public void eleiminarArticulo(@PathVariable(name="codigo")Long codigo) {
		articulosServideImpl.eliminarArticulo(codigo);
	}
}
