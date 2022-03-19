package challenge.domain;

public class Premio {
	
	private Long id;
	private Integer puntos;
	
	public Premio(Long id, Integer puntos) {
		this.id = id;
		this.puntos = puntos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "Premio [id=" + id + ", puntos=" + puntos + "]";
	}
	
}
