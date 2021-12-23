package dominio;

public class Historia extends Libro {

	public Historia(String codigo, String nombre, String autor) {
		super(codigo, nombre, autor);
		setTipoDeLibro(TipoDeLibro.HISTORIA);
		setFotocopiable(true);
		setDisponible(true);
	}

	@Override
	public String fotocopiable() {
		String fotocopiable = "No soy fotocopiable";
		if (getFotocopiable() == true) {
			fotocopiable = "Soy fotocopiable";
			// System.out.println("Soy fotocopiable");
		}
		return fotocopiable;
	}

}
