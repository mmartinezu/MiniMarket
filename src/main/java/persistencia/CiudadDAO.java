/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CiudadDAO {
    Connection conexion = Conexion.getConexion();
    public List<Ciudad> getCiudades(){
        List<Ciudad> ciudades = new ArrayList<>();
        String sql = "SELECT * FROM CIUDADES";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Ciudad ciudad = new Ciudad();
                ciudad.setId(rs.getInt(1));
                ciudad.setNombre(rs.getString(2));
                ciudad.setProvincia(rs.getString(3));
                
                ciudades.add(ciudad);
            }
        return ciudades;    
        } catch (Exception e) {
            return null;
        }
    }
    
}
