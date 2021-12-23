package dominio;

public class Biblioteca {

	private Libro[] libros;
	private Estudiante[] estudiantes;
	private Prestamo[] librosPrestados;

	public Biblioteca() {
		this.libros = new Libro[20];
		this.estudiantes = new Estudiante[50];
		this.librosPrestados = new Prestamo[20];
	}

	public Boolean agregarLibro(Libro libro) {
		Boolean seAgrego = false;
		for (int i = 0; i < libros.length; i++) {
			if (libros[i] == null) {
				libros[i] = libro;
				seAgrego = true;
				break;
			}
		}
		return seAgrego;
	}

	public Boolean agregarEstudiante(Estudiante estudiante) {
		Boolean seAgrego = false;
		for (int i = 0; i < estudiantes.length; i++) {
			if (estudiantes[i] == null) {
				estudiantes[i] = estudiante;
				seAgrego = true;
				break;
			}
		}
		return seAgrego;
	}

	public boolean prestaLibro(Prestamo prestarLibro) {
		Boolean sePresto = false;
		for (int i = 0; i < libros.length; i++) {
			if (libros[i] != null && libros[i].getCodigo().equals(prestarLibro.getLibro().getCodigo())
					&& libros[i].getDisponible().equals(prestarLibro.getLibro().getDisponible() == true)
					&& prestarLibro.getEstudiante().getLibrosEnPoder() <= 2) {
				for (int j = 0; j < librosPrestados.length; j++) {
					if (librosPrestados[j] == null) {
						librosPrestados[j] = prestarLibro;
						librosPrestados[j].getLibro().setDisponible(false);
						librosPrestados[j].getEstudiante().setLibrosEnPoder(1);
						sePresto = true;
						break;
					}

				}
			}
		}

		return sePresto;

	}

	public boolean devolverLibro(Prestamo prestarLibro) {
		Boolean seDevolvio = false;
		for (int i = 0; i < libros.length; i++) {
			if (libros[i] != null && libros[i].getCodigo().equals(prestarLibro.getLibro().getCodigo())
					&& prestarLibro.getLibro().getDisponible() == false) {
				for (int j = 0; j < librosPrestados.length; j++) {
					if (librosPrestados[j] != null
							&& librosPrestados[j].getIdentificador().equals(prestarLibro.getIdentificador())) {
						librosPrestados[j].getLibro().setDisponible(true);
						librosPrestados[j].getEstudiante().setLibrosEnPoder(-1);
						librosPrestados[j] = null;
						seDevolvio = true;
						break;

					}

				}

			}
		}
		return seDevolvio;
	}

	public void imprimir() {
		Libro[] librosAImprimir = libros;
		for (int i = 0; i < librosAImprimir.length; i++) {
			if (librosAImprimir[i] != null) {
				System.out.println(librosAImprimir[i].toString());
			}
		}
	}
}
