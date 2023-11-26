package dominio;

public class Incidencia {
    // Atributos
    private int id;
    private String denunciante;
    private String urbanizacion;
    private String calle;
    private String referencias;
    private String descripcion;
    private String fecha;

    // Constructores
    public Incidencia() {
    }

    public Incidencia(int id, String denunciante, String urbanizacion, String calle, String referencias,
            String descripcion, String fecha) {
        this.id = id;
        this.denunciante = denunciante;
        this.urbanizacion = urbanizacion;
        this.calle = calle;
        this.referencias = referencias;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    // Métodos de acceso
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenunciante() {
        return denunciante;
    }

    public void setDenunciante(String denunciante) {
        this.denunciante = denunciante;
    }

    public String getUrbanizacion() {
        return urbanizacion;
    }

    public void setUrbanizacion(String urbanizacion) {
        this.urbanizacion = urbanizacion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
