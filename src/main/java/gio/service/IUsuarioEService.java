package gio.service;

import java.util.List;

import gio.entity.UsuarioExterno;


public interface IUsuarioEService {
	
	void guardar(UsuarioExterno usuario);
	List<UsuarioExterno> buscarTodas();
	UsuarioExterno buscarPorId(Long id);	
	void eliminar (Long id);
	boolean existsById(Long id);

}
