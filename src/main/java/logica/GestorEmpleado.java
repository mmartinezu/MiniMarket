package logica;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.Empleado;

public class GestorEmpleado {
    Connection conexion = Conexion.getConexion();
    private String sql = "";
    
    public DefaultTableModel cargar(){
        DefaultTableModel modeloTabla;
        
        String [] titulos = {"Id", "Cédula", "Nombre","Apellido","Sueldo", "Ciudad","Direccion", "Titulo", "Género", "E.Civil"};
        String [] registro = new String[10];
        
        modeloTabla = new DefaultTableModel(null, titulos);
        sql = "SELECT E.ID_EMP, E.CED_EMP, E.NOM_EMP, E.APE_EMP, E.SUE_EMP, C.NOM_CIU, E.DIR_EMP, E.TIT_EMP, E.GEN_EMP, E.EST_CIV_EMP'"
                + "'FROM EMPLEADOS AS E, CIUDADES AS C WHERE C.ID_CIU = E.ID_CIU_EMP";
        
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
                modeloTabla.addRow(registro);
            }
            return modeloTabla;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    
    public boolean insertar(Empleado empleado){
        sql = "INSERT INTO EMPLEADOS(CED_EMP, NOM_EMP, APE_EMP, SUE_EMP, ID_CIU_EMP, TIT_EMP, DIR_EMP, GEN_EMP, EST_CIV_EMP)'"
                + "'VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, empleado.getCedula());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellido());
            ps.setDouble(4, empleado.getSueldo());
            ps.setInt(5, empleado.getCiudad().getId());
            ps.setString(6, empleado.getTitulo());
            ps.setString(7, empleado.getDireccion());
            ps.setString(8, empleado.getGenero());
            ps.setString(9, empleado.getEstado_civil());
            //Compruebo si se hizo el insert
            int n = ps.executeUpdate();
            return n !=0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
    //Se podra actualizar el sueldo,la direccion, estado civil y el titulo del empleado
    public boolean editar(Empleado empleado){
        sql = "UPDATE EMPLEADOS SET SUE_EMP=?, EST_CIV_EMP=?, TIT_EMP=?, DIR_EMP=? WHERE ID_EMP=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDouble(1, empleado.getSueldo());
            ps.setString(2, empleado.getEstado_civil());
            ps.setString(3, empleado.getTitulo());
            ps.setString(4, empleado.getDireccion());
            ps.setInt(5, empleado.getId());
            
            int n = ps.executeUpdate();
            return n !=0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(Empleado empleado){
        sql = "DELETE FROM EMPLEADOS WHERE ID_EMP = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, empleado.getId());
            
            int n = ps.executeUpdate();
            return n != 0 ;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
}
