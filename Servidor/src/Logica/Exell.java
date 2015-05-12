
package Logica;


import java.util.ArrayList;

import java.io.IOException;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

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
    
    Exell(String path) {
        this.pathArchivo = path;
        
                try{
            /**
             * Abrir el exell
             */
            libroDeTrabajo = Workbook.getWorkbook(new File (path));
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


    
    
    


    @Override
    public ArrayList<Tickets> cargarTiketsDeArchivo() {
        setHojaActual(libroDeTrabajo.getSheet(0));
        ArrayList<Tickets> lista = new ArrayList();
        int numFilas = hojaActual.getRows();
        for( int fila = 0; fila < numFilas; fila++ ){
            Tickets ticket= new Tickets();
            
            Date fechaHoraActual = new Date();
            String strFechaHora = new SimpleDateFormat("ddMMyyyyHHmm").format(fechaHoraActual);
            System.out.print(strFechaHora+"   ");  //<--------------------------------------------------------
            
            ticket.setFechayHoraRecepcion(strFechaHora);
            
            Cell celdaIDcliente = hojaActual.getCell(fila+1,0);
            ticket.setID_CLIENTE(celdaIDcliente.getContents());        
            System.out.print(celdaIDcliente.getContents()+"   ");  //<--------------------------------------------------------
            
            Cell celdaAsunto = hojaActual.getCell(fila+1,2);
            ticket.setAsunto(celdaAsunto.getContents()); 
            System.out.println(celdaAsunto.getContents());  //<--------------------------------------------------------
        }
        
        
        
        return  lista;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
        public static void main(String[] args) {
       
        System.out.println("hooooola MUndo");
        Exell myExell = new  Exell("/root/NetBeansProjects/Principal/src/principal/SampleData.xls");
        myExell.cargarTiketsDeArchivo();
       
        
        
        
        
        
        
        
            
        
        
    }
    
    
    
    
    
    
    
    
}



