package dominio;

public class Matematica extends Libro {

	public Matematica(String codigo, String nombre, String autor) {
		super(codigo, nombre, autor);
		setTipoDeLibro(TipoDeLibro.MATEMATICA);
		setFotocopiable(false);
		setDisponible(true);
	}

	@Override
	public String fotocopiable() {
		String fotocopiable = "No soy fotocopiable";
		if (getFotocopiable() == true) {
			fotocopiable = "Soy fotocopiable";
		}
		return fotocopiable;
	}

}
