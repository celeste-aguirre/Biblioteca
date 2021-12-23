package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import dominio.Biblioteca;
import dominio.Estudiante;
import dominio.Geografia;
import dominio.Historia;
import dominio.Matematica;
import dominio.Prestamo;

public class TestBiblioteca {
	Biblioteca biblioteca;
	Historia libroHistoria;
	Estudiante estudiante1;

	@Before
	public void before() {
		biblioteca = new Biblioteca();
		libroHistoria = new Historia("01", "La historia argentina", "Un Autor");
		estudiante1 = new Estudiante(42000000, "Aguirre", "Celeste");
	}

	@Test
	public void queSePuedaAgregarUnLibro() {
		// ejecucion
		Boolean valorEsperado = biblioteca.agregarLibro(libroHistoria);
		// test
		assertTrue(valorEsperado);
	}

	@Test
	public void queSePuedaAgregarUnEstudiante() {
		// ejecucion
		Boolean valorEsperado = biblioteca.agregarEstudiante(estudiante1);
		// test
		assertTrue(valorEsperado);
	}

	@Test
	public void queSePuedaPrestarUnLibro() {
		biblioteca.agregarLibro(libroHistoria);
		biblioteca.agregarEstudiante(estudiante1);

		// ejecucion
		Prestamo prestarLibro1 = new Prestamo("1", estudiante1, libroHistoria);
		// test
		assertTrue(biblioteca.prestaLibro(prestarLibro1));

	}

	@Test
	public void queUnLibroYaNoEsteDisponible() {
		biblioteca.agregarLibro(libroHistoria);
		biblioteca.agregarEstudiante(estudiante1);

		// ejecucion
		Prestamo prestarLibroHistoria = new Prestamo("1", estudiante1, libroHistoria);
		biblioteca.prestaLibro(prestarLibroHistoria);
		// test
		assertFalse(libroHistoria.getDisponible());

	}

	@Test
	public void queCantidadDeLibrosEnPoderTieneElEstudiante() {

		Geografia libroGeografia = new Geografia("02", "La Geografia argentina", "Un Autor");
		biblioteca.agregarLibro(libroHistoria);
		biblioteca.agregarLibro(libroGeografia);
		biblioteca.agregarEstudiante(estudiante1);

		Prestamo prestarLibroHistoria = new Prestamo("1", estudiante1, libroHistoria);
		biblioteca.prestaLibro(prestarLibroHistoria);
		Prestamo prestarLibroGeografia = new Prestamo("2", estudiante1, libroGeografia);
		biblioteca.prestaLibro(prestarLibroGeografia);
		// ejecucion
		Integer valorEsperado = 2;
		// test
		assertEquals(valorEsperado, estudiante1.getLibrosEnPoder());

	}

	@Test
	public void queCantidadDeLibrosSeaMenorADosParaPrestar() {
		Geografia libroGeografia = new Geografia("02", "La Geografia argentina", "Un Autor");
		Matematica libroMatematica = new Matematica("03", "La Matematica argentina", "Un Autor");
		biblioteca.agregarLibro(libroHistoria);
		biblioteca.agregarLibro(libroGeografia);
		biblioteca.agregarLibro(libroMatematica);

		biblioteca.agregarEstudiante(estudiante1);

		Prestamo prestarLibroHistoria = new Prestamo("1", estudiante1, libroHistoria);
		biblioteca.prestaLibro(prestarLibroHistoria);
		Prestamo prestarLibroGeografia = new Prestamo("2", estudiante1, libroGeografia);
		biblioteca.prestaLibro(prestarLibroGeografia);
		Prestamo prestarLibroMatematica = new Prestamo("3", estudiante1, libroMatematica);
		biblioteca.prestaLibro(prestarLibroMatematica);

		// test
		assertFalse(biblioteca.prestaLibro(prestarLibroMatematica));
	}

	@Test
	public void queSePuedaDevolverUnLibro() {
		biblioteca.agregarLibro(libroHistoria);

		biblioteca.agregarEstudiante(estudiante1);

		Prestamo prestamoLibroHistoria = new Prestamo("1", estudiante1, libroHistoria);
		biblioteca.prestaLibro(prestamoLibroHistoria);

		// test
		assertTrue(biblioteca.devolverLibro(prestamoLibroHistoria));

	}

	@Test
	public void queUnLibroVuelvaAEstarDisponible() {
		biblioteca.agregarLibro(libroHistoria);

		biblioteca.agregarEstudiante(estudiante1);

		Prestamo prestamoLibroHistoria = new Prestamo("1", estudiante1, libroHistoria);
		biblioteca.prestaLibro(prestamoLibroHistoria);

		// ejecucion
		biblioteca.devolverLibro(prestamoLibroHistoria);
		// test
		assertTrue(libroHistoria.getDisponible());

	}

	@Test
	public void queLaCantidadDeLibroDisminuyaCuandoDevuelve() {

		Geografia libroGeografia = new Geografia("02", "La Geografia argentina", "Un Autor");
		biblioteca.agregarLibro(libroHistoria);
		biblioteca.agregarLibro(libroGeografia);
		biblioteca.agregarEstudiante(estudiante1);

		Prestamo prestarLibroHistoria = new Prestamo("1", estudiante1, libroHistoria);
		biblioteca.prestaLibro(prestarLibroHistoria);
		Prestamo prestarLibroGeografia = new Prestamo("2", estudiante1, libroGeografia);
		biblioteca.prestaLibro(prestarLibroGeografia);

		biblioteca.devolverLibro(prestarLibroHistoria);
		// ejecucion
		Integer valorEsperado = 1;
		// test
		assertEquals(valorEsperado, estudiante1.getLibrosEnPoder());

	}

	@Test
	public void queDigaSiEsImprimible() {
		biblioteca.agregarLibro(libroHistoria);

		biblioteca.agregarEstudiante(estudiante1);

		Prestamo prestamoLibroHistoria = new Prestamo("1", estudiante1, libroHistoria);
		biblioteca.prestaLibro(prestamoLibroHistoria);

		// test
		assertEquals("Soy fotocopiable", libroHistoria.fotocopiable());

	}

	@Test
	public void queImprimaLosLibros() {

		Geografia libroGeografia = new Geografia("02", "La Geografia argentina", "Un Autor");
		biblioteca.agregarLibro(libroHistoria);
		biblioteca.agregarLibro(libroGeografia);
		biblioteca.agregarEstudiante(estudiante1);

		Prestamo prestarLibroHistoria = new Prestamo("1", estudiante1, libroHistoria);
		biblioteca.prestaLibro(prestarLibroHistoria);
		Prestamo prestarLibroGeografia = new Prestamo("2", estudiante1, libroGeografia);
		biblioteca.prestaLibro(prestarLibroGeografia);
		// test
		biblioteca.imprimir();

	}
}
