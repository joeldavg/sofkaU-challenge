package challenge.domain;

public class Partida {
	
	private Long id;
	private Integer puntosTotales;
	private Boolean ganada;
	private Long jugadoresId;
	private Long categoriaIdAlcanzada;
	
	public Partida(Integer puntosTotales, Boolean ganada, Long jugadoresId, Long categoriaIdAlcanzada) {
		this.puntosTotales = puntosTotales;
		this.ganada = ganada;
		this.jugadoresId = jugadoresId;
		this.categoriaIdAlcanzada = categoriaIdAlcanzada;
	}

	public Partida(Long id, Integer puntosTotales, Boolean ganada, Long jugadoresId, Long categoriaIdAlcanzada) {
		this.id = id;
		this.puntosTotales = puntosTotales;
		this.ganada = ganada;
		this.jugadoresId = jugadoresId;
		this.categoriaIdAlcanzada = categoriaIdAlcanzada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPuntosTotales() {
		return puntosTotales;
	}

	public void setPuntosTotales(Integer puntosTotales) {
		this.puntosTotales = puntosTotales;
	}

	public Boolean getGanada() {
		return ganada;
	}

	public void setGanada(Boolean ganada) {
		this.ganada = ganada;
	}

	public Long getJugadoresId() {
		return jugadoresId;
	}

	public void setJugadoresId(Long jugadoresId) {
		this.jugadoresId = jugadoresId;
	}

	public Long getCategoriaIdAlcanzada() {
		return categoriaIdAlcanzada;
	}

	public void setCategoriaIdAlcanzada(Long categoriaIdAlcanzada) {
		this.categoriaIdAlcanzada = categoriaIdAlcanzada;
	}

	@Override
	public String toString() {
		return "Partida [id=" + id + ", puntosTotales=" + puntosTotales + ", ganada=" + ganada + ", jugadoresId="
				+ jugadoresId + ", categoriaIdAlcanzada=" + categoriaIdAlcanzada + "]";
	}
}
