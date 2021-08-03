package gio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

import gio.entity.AUsuario;
import gio.entity.Mensaje;
import gio.entity.UsuarioInterno;
import gio.service.UsuarioIService;


@RestController
@RequestMapping("/usuario/api/v1")
@CrossOrigin("*")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class UsuarioController {
	
	@Autowired
	private UsuarioIService service;
	


	@GetMapping("/all/{opc}")
	public ResponseEntity<List<AUsuario>> list(@PathVariable("opc") String opc) {
		String opcion = opc.trim();
		if ((!opcion.equals("interno") && !opcion.equals("externo")) || opcion.equals("")) {
			return new ResponseEntity(new Mensaje("Tipo de usuario interno o externo"), HttpStatus.NOT_FOUND);
		}
		List<AUsuario> list = service.buscarUsuarios(opcion);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@PostMapping("/create/{opc}")
	public ResponseEntity<?> create(@PathVariable("opc") String opc, @RequestBody JsonNode usuario) {
		String opcion = opc.trim();
		if ((!opcion.equals("interno") && !opcion.equals("externo")) || opcion.equals("")) {
			return new ResponseEntity(new Mensaje("Tipo de usuario interno o externo"), HttpStatus.NOT_FOUND);
		}
		service.guardarUsuario(opcion, usuario);
		return new ResponseEntity(new Mensaje("Usuario creado"), HttpStatus.OK);
	}
	
	@GetMapping("/detail/{opc}/{id}")
	public ResponseEntity<?> getById(@PathVariable("opc") String opc, @PathVariable("id") String id) {
		if (!service.existeUsuarioId(opc,id)) {
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		}
		Optional<?> u = service.buscarUsuarioId(opc, id);
		return new ResponseEntity(u, HttpStatus.OK);
	}
	
	
	
	@PutMapping("/update/{opc}/{id}")
	public ResponseEntity<?> update(@PathVariable("opc") String opc, @PathVariable("id") String id, @RequestBody JsonNode usuario) {

		if (!service.existeUsuarioId(opc,id)) {
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		}
		service.actualizarUsuario(opc, id, usuario);
		return new ResponseEntity(new Mensaje("Usuario actualizado"), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{opc}/{id}")
	public ResponseEntity<?> update(@PathVariable("opc") String opc, @PathVariable("id") String id) {

		if (!service.existeUsuarioId(opc,id)) {
			return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
		}
		service.eliminarUsuario(opc, id);
		return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
	}


}
