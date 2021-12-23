package dominio;

public class Geografia extends Libro {

	public Geografia(String codigo, String nombre, String autor) {
		super(codigo, nombre, autor);
		setTipoDeLibro(TipoDeLibro.GEOGRAFIA);
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
