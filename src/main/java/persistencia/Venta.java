package persistencia;

import java.sql.Date;
import java.util.List;

public class Venta {
    int id, nivelSatisfaccion;
    Date fecha;
    Cliente cliente;
    Empleado empleado;
    String metodoPago;
    double subtotal, iva, total;
    List<DetalleVenta> listaDetalles;

    public Venta(int id, int nivelSatisfaccion, Date fecha, Cliente cliente, Empleado empleado, String metodoPago, double subtotal, double iva, double total, List<DetalleVenta> listaDetalles) {
        this.id = id;
        this.nivelSatisfaccion = nivelSatisfaccion;
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.metodoPago = metodoPago;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.listaDetalles = listaDetalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNivelSatisfaccion() {
        return nivelSatisfaccion;
    }

    public void setNivelSatisfaccion(int nivelSatisfaccion) {
        this.nivelSatisfaccion = nivelSatisfaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetalleVenta> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<DetalleVenta> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    
}
