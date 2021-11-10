package persistencia;
public class Proveedor {
    int id;
    Ciudad cuidad;
    String nombre, direccion, descripcion, telefono;

    public Proveedor(int id, Ciudad cuidad, String nombre, String direccion, String descripcion, String telefono) {
        this.id = id;
        this.cuidad = cuidad;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ciudad getCuidad() {
        return cuidad;
    }

    public void setCuidad(Ciudad cuidad) {
        this.cuidad = cuidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    
}
