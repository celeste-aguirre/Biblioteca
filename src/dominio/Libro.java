package dominio;

public abstract class Libro {

	private String codigo, nombre, autor;
	private TipoDeLibro tipoDeLibro;
	private Boolean fotocopiable, disponible;

	public Libro(String codigo, String nombre, String autor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.autor = autor;
	}

	public abstract String fotocopiable();

	public Boolean getFotocopiable() {
		return fotocopiable;
	}

	public void setFotocopiable(Boolean fotocopiable) {
		this.fotocopiable = fotocopiable;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public TipoDeLibro getTipoDeLibro() {
		return tipoDeLibro;
	}

	public void setTipoDeLibro(TipoDeLibro tipoDeLibro) {
		this.tipoDeLibro = tipoDeLibro;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", nombre=" + nombre + ", autor=" + autor + ", tipoDeLibro=" + tipoDeLibro
				+ ", fotocopiable=" + fotocopiable + ", disponible=" + disponible + ", fotocopiable()=" + fotocopiable()
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (disponible == null) {
			if (other.disponible != null)
				return false;
		} else if (!disponible.equals(other.disponible))
			return false;
		if (fotocopiable == null) {
			if (other.fotocopiable != null)
				return false;
		} else if (!fotocopiable.equals(other.fotocopiable))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tipoDeLibro != other.tipoDeLibro)
			return false;
		return true;
	}

}
