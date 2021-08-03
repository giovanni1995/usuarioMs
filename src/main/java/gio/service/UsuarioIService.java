package gio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.mongodb.BasicDBObject;

import gio.entity.AUsuario;
import gio.entity.UsuarioExterno;
import gio.entity.UsuarioInterno;
import gio.repository.usuarioRepository;
import gio.repository.usuarioRepositoryE;

@Service
public class UsuarioIService {
	
	@Autowired
	usuarioRepository repo;

	@Autowired
	usuarioRepositoryE repoE;
	
	
	
	public List<AUsuario> buscarUsuarios(String tipo) {
		List<?> u;
		switch (tipo) {
		case "interno":
			u = repo.findAll();
			break;
		case "externo":
			u = repoE.findAll();
			break;
		default:
			u = null;
		}
		return (List<AUsuario>) u;
	}
	
	public boolean existeUsuarioId(String tipo, String id) {
		boolean resp=false;
		switch (tipo) {
		case "interno":
			return  repo.existsById(id);
		case "externo":
			return  repoE.existsById(id);
		default:
			resp = false;
		}
		return  resp;
	}
	
	public Optional<?> buscarUsuarioId(String tipo, String id) {
		Optional<?> u;
		switch (tipo) {
		case "interno":		
			u = repo.findById(id);
			return u;
		case "externo":
			u = repoE.findById(id);
			return u;
		default:
			u = null;
		}

		return  u;
	}
	
	
	public void guardarUsuario(String tipo, JsonNode u) {
		switch (tipo) {
		case "interno":
			UsuarioInterno usuario = new UsuarioInterno(
					u.get("nombres").asText(),u.get("usuario").asText(),
					u.get("password").asText(),tipo,
					u.get("rol").asText(),u.get("emailEmpresarial").asText(),
					u.get("departamento").asText());
			repo.save( usuario);
			break;
		case "externo":
			UsuarioExterno usuarioE = new UsuarioExterno(
					u.get("nombres").asText(),u.get("usuario").asText(),
					u.get("password").asText(),tipo,
					u.get("celular").asText(),u.get("email").asText(),
					u.get("direccion").asText());
			repoE.save(usuarioE);
			break;
		default:
			u = null;
		}

	}
	
	public void actualizarUsuario(String tipo, String id, JsonNode u) {
		
		switch (tipo) {
		case "interno":
			UsuarioInterno usuarioExistente = repo.findById(id).get();
			usuarioExistente.setNombres(u.get("nombres").asText());
			usuarioExistente.setUsuario(u.get("usuario").asText());
			usuarioExistente.setPassword(u.get("password").asText());
			usuarioExistente.setRol(u.get("rol").asText());
			usuarioExistente.setEmailEmpresarial(u.get("emailEmpresarial").asText());
			usuarioExistente.setDepartamento(u.get("departamento").asText());
			
			repo.save(usuarioExistente);
			break;
		case "externo":
			UsuarioExterno usuarioExistente2 = repoE.findById(id).get();
			usuarioExistente2.setNombres(u.get("nombres").asText());
			usuarioExistente2.setUsuario(u.get("usuario").asText());
			usuarioExistente2.setPassword(u.get("password").asText());
			usuarioExistente2.setCelular(u.get("celular").asText());
			usuarioExistente2.setEmail(u.get("email").asText());
			usuarioExistente2.setDireccion(u.get("direccion").asText());			
			repoE.save(usuarioExistente2);
			break;
		default:
			u = null;
		}
	}
		
		public void eliminarUsuario(String tipo, String id) {
			switch (tipo) {
			case "interno":		
				repo.deleteById(id);
			case "externo":
				repoE.findById(id);
				break;
			default:	
			}
		}

	

}
