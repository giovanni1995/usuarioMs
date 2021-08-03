package gio.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


import gio.entity.UsuarioInterno;

public interface usuarioRepository extends MongoRepository<UsuarioInterno, String>{
	//boolean existsById(Long id);
//	@Query("{ 'id' : ?0 }")
	//Optional<UsuarioInterno> findById(String id);
	Optional<UsuarioInterno> findByNombres(String nombres);


}
