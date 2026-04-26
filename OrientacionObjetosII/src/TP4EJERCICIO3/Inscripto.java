package TP4EJERCICIO3;

public class Inscripto {
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private int idConcurso;

    public Inscripto(String nombre, String apellido, String telefono, String email, int idConcurso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.idConcurso = idConcurso;
    }

    public String aTexto() {
        return apellido + ", " + nombre + ", " + telefono + ", " + email + ", " + idConcurso;
    }

    public int getIdConcurso() { return idConcurso; }
    public String getNombre() { return nombre; }
    public String getApellido()  { return apellido; }
    public String getTelefono()  { return telefono; }
    public String getEmail()     { return email; }
}