package logica;

import conexion.Conexion;
import persistencia.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestorCliente {
    Connection conexion = Conexion.getConexion();
    private String sql = "";
    
    public DefaultTableModel cargar(){
        DefaultTableModel modeloTabla;
        
        String [] titulos = {"Id", "Cédula", "Nombre","Apellido","Fecha Nacimiento", "Ciudad","Direccion", "Titulo", "Género", "E.Civil", "Email"};
        String [] registro = new String[11];
        
        modeloTabla = new DefaultTableModel(null, titulos);
        sql = "SELECT E.ID_CLI, E.CED_CLI, E.NOM_CLI, E.APE_CLI, E.FEC_NAC_CLI, C.NOM_CIU, E.DIR_CLI, E.TIT_CLI, E.GEN_CLI, E.EST_CIV_CLI', E.EMAIL_CLI"
                + "'FROM CLIENTES AS E, CIUDADES AS C WHERE C.ID_CIU = E.ID_CIU_CLI";
        
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
                registro[9] = rs.getString(10);
                registro[10] = rs.getString(11);
                modeloTabla.addRow(registro);
            }
            return modeloTabla;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public boolean insertar(Cliente cliente){
        sql = "INSERT INTO CLIENTES(CED_CLI, NOM_CLI, APE_CLI, FEC_NAC_CLI, ID_CIU_CLI, TIT_CLI, DIR_CLI, GEN_CLI, EST_CIV_CLI, EMAIL_CLI)'"
                + "'VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, cliente.getCedula());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setDate(4, cliente.getFecha_nacimiento());
            ps.setInt(5, cliente.getCiudad().getId());
            ps.setString(6, cliente.getTitulo());
            ps.setString(7, cliente.getDireccion());
            ps.setString(8, cliente.getGenero());
            ps.setString(9, cliente.getEstado_civil());
            ps.setString(10, cliente.getEmail());
            //Compruebo si se hizo el insert
            int n = ps.executeUpdate();
            return n !=0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
    //Se podra actualizar el email,la direccion, estado civil y el titulo del cliente
    public boolean editar(Cliente cliente){
        sql = "UPDATE CLIENTES SET EMAIL_CLI=?, EST_CIV_CLI=?, TIT_CLI=?, DIR_CLI=? WHERE ID_CLI=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, cliente.getEmail());
            ps.setString(2, cliente.getEstado_civil());
            ps.setString(3, cliente.getTitulo());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getId());
            
            int n = ps.executeUpdate();
            return n !=0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(Cliente cliente){
        sql = "DELETE FROM CLIENTES WHERE ID_CLI = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            
            int n = ps.executeUpdate();
            return n != 0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
}
