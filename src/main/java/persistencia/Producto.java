package persistencia;

import java.sql.Date;

public class Producto {
    int id, stock;
    Categoria categoria;
    String nombre, marca;
    double precioCompra, precioVenta;
    Date fecElaboracion, fecVencimiento;

    public Producto(int id, int stock, Categoria categoria, String nombre, String marca, double precioCompra, double precioVenta, Date fecElaboracion, Date fecVencimiento) {
        this.id = id;
        this.stock = stock;
        this.categoria = categoria;
        this.nombre = nombre;
        this.marca = marca;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.fecElaboracion = fecElaboracion;
        this.fecVencimiento = fecVencimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Date getFecElaboracion() {
        return fecElaboracion;
    }

    public void setFecElaboracion(Date fecElaboracion) {
        this.fecElaboracion = fecElaboracion;
    }

    public Date getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(Date fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }
}
