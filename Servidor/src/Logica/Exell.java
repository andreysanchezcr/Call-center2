
package Logica;

import java.util.ArrayList;




/**
 * @author root
 * Clase que tendra la responsabilidad de ejecutar la apertura y guardado de archivos .xls
 * Para el cargado de Tikets nuevos al sistema y el guardado de los cambios es ellos.
 */
public class Exell implements ExcellInterface{
    /**
    * Atributos usados para un mejor desempeño de Exell.class
    */
    private int pagina;

    @Override
    public void setPathDeArchivo(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Tickets> cargarTiketsDeArchivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Tickets> cargarTiketsPendientesDeArchivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Tickets> cargarTiketsRojosDeArchivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Tickets> cargarTiketsVerdesDeArchivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Tickets> cargarTiketsAmarillosDeArchivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargarGuardarCambiosEnArchivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
