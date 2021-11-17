/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.Proveedor;

/**
 *
 * @author Usuario
 */
public class GestorProveedor{
    Connection conexion = Conexion.getConexion();
    private String sql = "";
    
    public DefaultTableModel cargar(){
        DefaultTableModel modeloTabla;
        
        String [] titulos = {"Id", "Proveedor", "Direccion","Descripcion", "Telefono", "Ciudad"};
        String [] registro = new String[6];
        
        modeloTabla = new DefaultTableModel(null, titulos);
        sql = "SELECT P.ID_PRO, P.NOM_PRO, P.DIR_PRO, P.DESC_PRO, P.TEL_PRO, C.NOM_CIU' "
                + "'FROM PROVEEDORES AS P, CIUDADES AS C WHERE C.ID_CIU = P.ID_CIU_PRO";
        
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
                modeloTabla.addRow(registro);
            }
            return modeloTabla;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public boolean insertar(Proveedor proveedor){
        sql = "INSERT INTO PROVEEDORES(NOM_PRO, DIR_PRO, DESC_PRO, TEL_PRO, ID_CIU_PRO) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getDescripcion());
            ps.setString(4, proveedor.getTelefono());
            ps.setInt(5, proveedor.getCuidad().getId());
            //Compruebo si se hizo el insert
            int n = ps.executeUpdate();
            return n !=0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
    public boolean editar(Proveedor proveedor){
        sql = "UPDATE PROVEEDORES SET NOM_PRO=?, DIR_PRO=?, DESC_PRO=?, TEL_PRO=?, ID_CIU_PRO=? WHERE ID_PRO=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getDescripcion());
            ps.setString(4, proveedor.getTelefono());
            ps.setInt(5, proveedor.getCuidad().getId());
            
            ps.setInt(6, proveedor.getId());
            int n = ps.executeUpdate();
            return n !=0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(Proveedor proveedor){
        sql = "DELETE FROM PROVEEDORES WHERE ID_PRO = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, proveedor.getId());
            
            int n = ps.executeUpdate();
            return n != 0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    

}
