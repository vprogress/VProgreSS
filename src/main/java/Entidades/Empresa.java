package Entidades;

public class Empresa {

    private String Nombre;
    private String Direccion;
    private int Telefono;
    private String Nit;

    public Empresa(String nombre, String direccion, int telefono, String nit) {
        this.Nombre = nombre;
        this.Direccion = direccion;
        this.Telefono = telefono;
        this.Nit = nit;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        this.Direccion = direccion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        this.Telefono = telefono;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String nit) {
        this.Nit = nit;
    }

}
