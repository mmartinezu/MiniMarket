package logica;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.Cliente;
import persistencia.Producto;

public class GestorProducto {
    Connection conexion = Conexion.getConexion();
    private String sql = "";
    
    public DefaultTableModel cargar(){
        DefaultTableModel modeloTabla;
        
        String [] titulos = {"Id", "Producto", "Marca","Precio Compra","Precio Venta", "Stock", "Fecha Elaboración", "Fecha Vencimiento", "Categoría"};
        String [] registro = new String[9];
        
        modeloTabla = new DefaultTableModel(null, titulos);
        sql = "SELECT P.ID_PRO, P.NOM_PRO, P.MAR_PRO, P.PRE_COM_PRO, P.PRE_VEN_PRO, P.STOCK, P.FEC_ELA_PRO, P.FEC_VEN_PRO, C.NOM_CAT"
                + "'FROM PRODUCTOS AS P, CATEGORIAS AS C WHERE C.ID_CAT = P.ID_CAT_PRO";
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
                registro[4] = rs.getString(5);
                registro[5] = rs.getString(6);
                registro[6] = rs.getString(7);
                registro[7] = rs.getString(8);
                registro[8] = rs.getString(9);
                modeloTabla.addRow(registro);
            }
            return modeloTabla;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public boolean insertar(Producto producto){
        sql = "INSERT INTO PRODUCTOS(NOM_PRO, MAR_PRO, PRE_COM_PRO, PRE_VEN_PRO, STOCK, FEC_ELA_PRO, FEC_VEN_PRO, ID_CAT_PRO)'"
                + "'VALUES (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setDouble(3, producto.getPrecioCompra());
            ps.setDouble(4, producto.getPrecioVenta());
            ps.setInt(5, producto.getStock());
            ps.setDate(6, producto.getFecElaboracion());
            ps.setDate(7, producto.getFecVencimiento());
            ps.setInt(8, producto.getCategoria().getId());
            //Compruebo si se hizo el insert
            int n = ps.executeUpdate();
            return n !=0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
    //Se podra actualizar el nombre, marca, precio de compra y venta, stock, fec de elaboracion y vencimiento del producto
    public boolean editar(Producto producto){
        sql = "UPDATE PRODUCTOS SET NOM_PRO=?, MAR_PRO=?, PRE_COM_PRO=?, PRE_VEN_PRO=?, STOCK=? FEC_ELA_PRO =?, FEC_VEN_PRO=? WHERE ID_PRO=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setDouble(3, producto.getPrecioCompra());
            ps.setDouble(4, producto.getPrecioVenta());
            ps.setInt(5, producto.getStock());
            ps.setDate(6, producto.getFecElaboracion());
            ps.setDate(7, producto.getFecVencimiento());
            ps.setInt(9, producto.getId());
            
            int n = ps.executeUpdate();
            return n !=0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(Producto producto){
        sql = "DELETE FROM PRODUCTOS WHERE ID_PRO = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, producto.getId());
            
            int n = ps.executeUpdate();
            return n != 0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
}
