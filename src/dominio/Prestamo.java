package dominio;

public class Prestamo {
	private String identificador;
	private Estudiante estudiante;
	private Libro libro;

	public Prestamo(String identificador, Estudiante estudiante, Libro libro) {
		this.identificador = identificador;
		this.estudiante = estudiante;
		this.libro = libro;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

}
