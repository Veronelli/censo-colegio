package ar.com.censo.dominio;

public class Persona {
    static Integer contador = 0;
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer nacimiento;
    private Integer edad;

    public Persona(String nombre, String apellido, Integer nacimiento, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.edad = edad;
        this.id = Persona.contador++;

    }

    public Persona(){
        this(null,null,null,null);
    }

    public Persona(int edad){

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

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nacimiento=" + nacimiento +
                ", edad=" + edad +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Integer nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public boolean isEmpty()throws Exception{
        return this.id == null;

    }
}
