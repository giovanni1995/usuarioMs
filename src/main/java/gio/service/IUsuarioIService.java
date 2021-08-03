package gio.service;

import java.util.List;
import java.util.Optional;

import gio.entity.UsuarioInterno;


public interface IUsuarioIService {

	void guardar(Optional<?> usuario);
	List<Optional<?>> buscarTodas();
	Optional<Optional<?>> buscarPorId(Long id);	
	void eliminar (Long id);
	boolean existsById(Long id);
}
