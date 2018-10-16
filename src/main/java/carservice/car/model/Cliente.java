package carservice.car.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = "ins",
        procedureName = "EYNERARIAS.CLIENTE_tapi.ins",
        parameters = {
          @StoredProcedureParameter(mode=ParameterMode.IN, name="p_PRIMERNOMBRE", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="p_PRIMERAPELLIDO", type=String.class),
          @StoredProcedureParameter(mode=ParameterMode.IN, name="p_NUMEROIDENTIFICACION", type=Long.class)
    })
})
public class Cliente {

	@Id
	@GeneratedValue(generator="InvSeq") 
    @SequenceGenerator(name="InvSeq",sequenceName="SEQ_CLIENTE", allocationSize=5) 
	private Long id;
	
	@Column(name="PRIMERNOMBRE")
	private String primerNombre;
	
	@Column(name="PRIMERAPELLIDO")
	private String primerApellido;
	
	@Column(name="NUMEROIDENTIFICACION")
	private Long numeroIdentificacion;
	
	public Cliente() {
	}
	
	public Cliente(Long id, String primerNombre, String primerApellido, Long numeroIdentificacion) {
		super();
		this.id = id;
		this.primerNombre = primerNombre;
		this.primerApellido = primerApellido;
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public Long getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(Long numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	
	
	
}
