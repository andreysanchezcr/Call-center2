
package Logica;


import java.util.ArrayList;

import java.io.IOException;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Import Java Pakages to handle exel files
 */
import jxl.*;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.*;
import jxl.read.biff.BiffException;



/**
 * @author root
 * Clase que tendra la responsabilidad de ejecutar la apertura y guardado de archivos .xls
 * Para el cargado de Tikets nuevos al sistema y el guardado de los cambios es ellos.
 */
public class Exell implements ExcellInterface{
    /**
    * Atributos usados para un mejor desempeño de Exell.class
    */
    
    private Workbook libroDeTrabajo;
    private WritableWorkbook copiaDeLibro;    
    private String pathArchivo;
    private Sheet hojaActual;

    Exell(){}
    
    public Exell(String file) {
        //this.pathArchivo = path;
        
                try{
            /**
             * Abrir el exell
             */
            File temp = new File(file);
                 
            
            libroDeTrabajo = Workbook.getWorkbook(temp);
        }
        //----------------------------------------------------------
        catch (IOException ioex) {
            System.out.println("ERROR---->>"+ioex.getMessage());
        } 
        catch (NumberFormatException nfe) {
            System.out.println("ERROR---->>"+nfe.getMessage());    
        }
        catch (BiffException biff){
            System.out.println("ERROR---->>"+biff.getMessage());
        }
        //----------------------------------------------------------
    }

    

    public void setCopiaDeLibro(WritableWorkbook copiaDeLibro) {
        this.copiaDeLibro = copiaDeLibro;
    }

    public void setPathArchivo(String pathArchivo) {
        this.pathArchivo = pathArchivo;
    }

    public void setHojaActual(Sheet hojaActual) {
        this.hojaActual = hojaActual;
    }


    
    
    

    /**
     * Metodo que carga los tikets pendientes del .xls 
     * @return Lista con Tikets con la informacion principal, hora de ingreso, ID cliente y Asunto
     */
    @Override
    public ArrayList<Tickets> cargarTiketsDeArchivo() {
        
        setHojaActual(libroDeTrabajo.getSheet(0));
        ArrayList<Tickets> listaTikets = new ArrayList();
        
        int numFilas = hojaActual.getRows();
        
        for( int fila = 0; fila+1 < numFilas; fila++ ){
            
            Date fechaHoraActual = new Date();
            String strFechaHora = new SimpleDateFormat("dd/MM/yyyy hh:mm aaa").format(fechaHoraActual);
            System.out.print(strFechaHora+"   ");  //<--------------------------------------------------------
            
            Sheet hoja = libroDeTrabajo.getSheet(0);
            Cell celdaIDcliente = hoja.getCell(1,fila+1);
            String strIDcliente = celdaIDcliente.getContents();       
            System.out.print(celdaIDcliente.getContents()+"   ");  //<--------------------------------------------------------
            
            Cell celdaAsunto = hojaActual.getCell(2,fila+1);
            String strAsunto = celdaAsunto.getContents();
            System.out.println(celdaAsunto.getContents());  //<--------------------------------------------------------
            
            Tickets ticket = new Tickets(strFechaHora, strIDcliente, strAsunto );
            listaTikets.add(ticket);
        }
        
        return listaTikets;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            copiaDeLibro =  Workbook.createWorkbook(new File ("/root/NetBeansProjects/CallCenter/Call-center2/Libro1.xls"),libroDeTrabajo);
            
            
            
            WritableSheet hojaTiketsRojos = copiaDeLibro.getSheet(1);
            hojaTiketsRojos.
            
            
        } catch (IOException wse) {
           System.out.println("ERROR---->>"+wse.getMessage());
        }
    
    }

    
    
        public static void main(String[] args) {
       
        System.out.println("hooooola MUndo");
        Exell myExell = new  Exell("/root/NetBeansProjects/CallCenter/Call-center2/Libro1.xls");
        myExell.cargarTiketsDeArchivo();
       
        
        
        
        
        
        
        
            
        
        
    }
    
    
    
    
    
    
    
    
}



