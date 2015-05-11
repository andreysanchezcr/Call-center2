
package Logica;

import java.util.ArrayList;

/**
 *
 * @author root
 * Interface para el correcto manejo de la clase Exell
 */
    public abstract interface  ExcellInterface{
        /**
         * Metodo para setear el path del Archivo a leer
         * @param path Proveniente del JChoser
         */
        public void setPathDeArchivo(String path);
        
        public ArrayList<Tickets>  cargarTiketsDeArchivo();
        public ArrayList<Tickets>  cargarTiketsPendientesDeArchivo();
        public ArrayList<Tickets>  cargarTiketsRojosDeArchivo();
        public ArrayList<Tickets>  cargarTiketsVerdesDeArchivo();
        public ArrayList<Tickets>  cargarTiketsAmarillosDeArchivo();
        public void cargarGuardarCambiosEnArchivo();
    
}
