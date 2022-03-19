package challenge.domain;

public class Categoria {
	
	private Long id;
	private Nivel nivel;
	private Long puntosId;
	
	public Categoria(Long id, Nivel nivel, Long puntosId) {
		this.id = id;
		this.nivel = nivel;
		this.puntosId = puntosId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Long getPuntosId() {
		return puntosId;
	}

	public void setPuntosId(Long puntosId) {
		this.puntosId = puntosId;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nivel=" + nivel + ", puntosId=" + puntosId + "]";
	}
	
}
