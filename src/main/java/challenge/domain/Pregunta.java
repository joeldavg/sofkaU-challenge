package challenge.domain;

public class Pregunta {
	
	private Long id;
	private String pregunta;
	private Long categoriaId;
	
	public Pregunta(Long id, String pregunta, Long categoriaId) {
		this.id = id;
		this.pregunta = pregunta;
		this.categoriaId = categoriaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", pregunta=" + pregunta + ", categoriaId=" + categoriaId + "]";
	}
	
	
}
