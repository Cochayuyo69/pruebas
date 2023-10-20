package egresado;

public class Egresado {
    private String codigo;
    private String nombre;
    private String telefono;
    private String correo;
    private String labura;

    public Egresado() {
    }

    
    public Egresado(String codigo, String nombre, String telefono, String correo, String labura) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.labura = labura;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLabura() {
        return labura;
    }

    public void setLabura(String labura) {
        this.labura = labura;
    }
    
    
    
}
