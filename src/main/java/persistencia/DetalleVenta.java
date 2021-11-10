/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author Usuario
 */
public class DetalleVenta {
    Venta venta;
    int cantidad;
    double descuentoProducto, subtotal;
    Producto producto;

    public DetalleVenta(Venta venta, int cantidad, double descuentoProducto, double subtotal, Producto producto) {
        this.venta = venta;
        this.cantidad = cantidad;
        this.descuentoProducto = descuentoProducto;
        this.subtotal = subtotal;
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(double descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
    
    
}
