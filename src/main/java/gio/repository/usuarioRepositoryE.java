package gio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import gio.entity.UsuarioExterno;


public interface usuarioRepositoryE extends MongoRepository<UsuarioExterno, String>{
	//boolean existsById(Long id);

}
