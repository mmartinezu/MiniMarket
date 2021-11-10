package persistencia;
import java.sql.Date;
public class Pedido {
    int id;
    Proveedor proveedor;
    Empleado empleado;
    Date fechaPedido;
    double subtotal, iva, total;

    public Pedido(int id, Proveedor proveedor, Empleado empleado, Date fechaPedido, double subtotal, double iva, double total) {
        this.id = id;
        this.proveedor = proveedor;
        this.empleado = empleado;
        this.fechaPedido = fechaPedido;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
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

    

}


