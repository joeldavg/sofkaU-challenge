package challenge.domain;

public enum Nivel {
	
	UNO("uno"),
	DOS("dos"),
	TRES("tres"),
	CUATRO("cuatro"),
	CINCO("cinco");
	
	private String nivel;

	private Nivel(String nivel) {
		this.nivel = nivel;
	}

	public String getNivel() {
		return nivel;
	}

}
