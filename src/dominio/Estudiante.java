package dominio;

public class Estudiante {

	private Integer dni;
	private String apellido, nombre;
	private Integer librosEnPoder;

	public Estudiante(Integer dni, String apellido, String nombre) {
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		librosEnPoder = 0;
	}

	public Integer getLibrosEnPoder() {
		return librosEnPoder;
	}

	public void setLibrosEnPoder(Integer librosEnPoder) {
		this.librosEnPoder += librosEnPoder;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
