
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


    
    
    


    @Override
    public void cargarTiketsDeArchivo() {
        setHojaActual(libroDeTrabajo.getSheet(0));
        //ArrayList<Tickets> lista = new ArrayList();
        int numFilas = hojaActual.getRows();
        for( int fila = 0; fila+1 < numFilas; fila++ ){
            
            Date fechaHoraActual = new Date();
            String strFechaHora = new SimpleDateFormat("dd/MM/yyyy hh:mm aaa").format(fechaHoraActual);
            System.out.print(strFechaHora+"   ");  //<--------------------------------------------------------
            
            //ticket.setFechayHoraRecepcion(strFechaHora);
            Sheet hoja = libroDeTrabajo.getSheet(0);
            Cell celdaIDcliente = hoja.getCell(1,fila+1);
            //ticket.setID_CLIENTE(celdaIDcliente.getContents());        
            System.out.print(celdaIDcliente.getContents()+"   ");  //<--------------------------------------------------------
            
            Cell celdaAsunto = hojaActual.getCell(2,fila+1);
            //ticket.setAsunto(celdaAsunto.getContents()); 
            System.out.println(celdaAsunto.getContents());  //<--------------------------------------------------------
        }
        
        
        
        
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
        Exell myExell = new  Exell("/root/NetBeansProjects/CallCenter/Call-center2/Libro1.xls");
        myExell.cargarTiketsDeArchivo();
       
        
        
        
        
        
        
        
            
        
        
    }
    
    
    
    
    
    
    
    
}



