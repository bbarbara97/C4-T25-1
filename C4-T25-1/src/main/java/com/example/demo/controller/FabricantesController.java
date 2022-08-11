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

import com.example.demo.dto.Fabricantes;
import com.example.demo.service.FabricantesServiceImpl;


@RestController
@RequestMapping("/api")
public class FabricantesController {

	@Autowired
	FabricantesServiceImpl fabricanteServideImpl;

	@GetMapping("/fabricantes")
	public List<Fabricantes> listarFabricantes(){
		return fabricanteServideImpl.listarFabricantes();
	}

	@PostMapping("/fabricantes")
	public Fabricantes salvarFabricantes(@RequestBody Fabricantes fabricantes) {

		return fabricanteServideImpl.guardarFabricante(fabricantes);
	}

	@GetMapping("/fabricantes/{codigo}")
	public Fabricantes fabricanteXID(@PathVariable(name="codigo") Long codigo) {

		Fabricantes fabricante_xid= new Fabricantes();

		fabricante_xid=fabricanteServideImpl.fabricanteXID(codigo);

		System.out.println("fabricante XID: "+fabricante_xid);

		return fabricante_xid;
	}

	@PutMapping("/fabricantes/{codigo}")
	public Fabricantes actualizarVideo(@PathVariable(name="codigo")Long codigo,@RequestBody Fabricantes fabricantes) {

		Fabricantes fabricantes_seleccionado;
		Fabricantes fabricantes_actualizado;

		fabricantes_seleccionado= fabricanteServideImpl.fabricanteXID(codigo);

		fabricantes_seleccionado.setNombre(fabricantes.getNombre());
		fabricantes_seleccionado.setArticulo(fabricantes.getArticulo());

		fabricantes_actualizado = fabricanteServideImpl.actualizarFabricante(fabricantes_seleccionado);

		System.out.println("El fabricantes actualizado es: "+ fabricantes_actualizado);

		return fabricantes_actualizado;
	}

	@DeleteMapping("/fabricantes/{codigo}")
	public void eliminarFabricante(@PathVariable(name="codigo")Long codigo) {
		fabricanteServideImpl.eliminarFabricante(codigo);
	}
}
