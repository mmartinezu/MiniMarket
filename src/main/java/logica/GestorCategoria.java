package logica;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.Categoria;
import persistencia.Proveedor;

public class GestorCategoria {
    Connection conexion = Conexion.getConexion();
    private String sql = "";
    
    public DefaultTableModel cargar(){
        DefaultTableModel modeloTabla;
        
        String [] titulos = {"Id", "Categoría","Descripción"};
        String [] registro = new String[3];
        
        modeloTabla = new DefaultTableModel(null, titulos);
        sql = "SELECT * FROM CATEGORIAS";
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                modeloTabla.addRow(registro);
            }
            return modeloTabla;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public boolean insertar(Categoria categoria){
        sql = "INSERT INTO CATEGORIAS(NOM_CAT, DESC_CAT) VALUES (?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            //Compruebo si se hizo el insert
            int n = ps.executeUpdate();
            return n !=0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
    public boolean editar(Categoria categoria){
        sql = "UPDATE CATEGORIAS SET NOM_CAT=?, DESC_PRO=? WHERE ID_CAT=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            ps.setInt(3, categoria.getId());
            int n = ps.executeUpdate();
            return n !=0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(Categoria categoria){
        sql = "DELETE FROM CATEGORIAS WHERE ID_CAT = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, categoria.getId());
            
            int n = ps.executeUpdate();
            return n != 0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
    
}
