package logica;

import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import persistencia.Ciudad;
import persistencia.CiudadDAO;

public class GestorCiudad {

    CiudadDAO ciudadDAO = new CiudadDAO();
    List<Ciudad> ciudades = ciudadDAO.getCiudades();
    
    public DefaultComboBoxModel cargarCiudades(){
        DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
        for(Ciudad c: ciudades){
            modeloCombo.addElement(c);
        }
        return modeloCombo;
    }
}
