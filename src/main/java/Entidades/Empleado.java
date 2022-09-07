package Entidades;

public class Empleado {

    private String nombre;
    private String apellido;
    private String email;
    private String empresa;
    private String administrativo;
    private String operativo;

    public Empleado(String nombre, String apellido, String email, String empresa, String administrativo, String operativo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.empresa = empresa;
        this.administrativo = administrativo;
        this.operativo = operativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(String administrativo) {
        this.administrativo = administrativo;
    }

    public String getOperativo() {
        return operativo;
    }

    public void setOperativo(String operativo) {
        this.operativo = operativo;
    }
}
