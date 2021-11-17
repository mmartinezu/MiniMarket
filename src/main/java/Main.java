
import java.util.List;
import persistencia.Ciudad;
import persistencia.CiudadDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        CiudadDAO ciudadDAO = new CiudadDAO();
        List<Ciudad> ciudades = ciudadDAO.getCiudades();
        
        for(Ciudad c : ciudades){
            System.out.println(c.getId());
            System.out.println(c.getNombre());
            System.out.println(c.getProvincia());
        }
       
    }
}
