package gio.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data @RequiredArgsConstructor @NoArgsConstructor
@Document(collection = "usuario_externo")
public class UsuarioExterno{

	@MongoId(value = FieldType.OBJECT_ID)
	private String id;
	@NonNull
	private String nombres;
	@NonNull
	private String usuario;
	@NonNull
	private String password;
	@NonNull
	private String tipo;
	@NonNull
	private String celular;
	@NonNull
	private String email;
	@NonNull
	private String direccion;
		
	
}
