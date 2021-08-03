package gio.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data @RequiredArgsConstructor @NoArgsConstructor
@Document(collection = "usuario_interno")
public class UsuarioInterno {
	
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
	private String rol;
	@NonNull
	private String emailEmpresarial;
	@NonNull
	private String departamento;
	


}
