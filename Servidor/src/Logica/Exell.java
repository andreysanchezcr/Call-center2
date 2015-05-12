
package Logica;

import java.util.ArrayList;

import java.io.IOException;
import java.io.File;
import java.util.Date;

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

    
    
    public void Excell(String path) {
        this.pathArchivo = path;
        this.libroDeTrabajo = libroDeTrabajo;
                try{
            /**
             * Abrir el exell
             */
            libroDeTrabajo = Workbook.getWorkbook(new File (pathArchivo));
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
            ticket.sethora
                    set fecha
                            set id
                                    set asunto
            
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


    
        public static void main(String[] args)   {
        try{
            /**
             * Abrir el exell
             */
            Workbook workbook = Workbook.getWorkbook(new File ("/root/NetBeansProjects/Principal/src/principal/SampleData.xls"));
            
            /**
             * Pagina del exell.  Esta comienza con el indice 0 para la primera pagina
             */
            Sheet sheet = workbook.getSheet(0);
            
            /**
             * Objetos tipo celda para el manejo de la navegacion del exell
             */
            Cell a1 = sheet.getCell(0,1);
            Cell b2 = sheet.getCell(1,1);
            Cell c2 = sheet.getCell(2,1);
            
            /**
             * Obtenemos la informacion
             */ 
            String stringa1 = a1.getContents();
            String stringb2 = b2.getContents();
            String stringc2 = c2.getContents();
            
            System.out.println("My Exell tiene esto ---> "+stringa1+"  "+ stringb2+"  "+stringc2); 
            System.out.println("\n"+"Columnas"+sheet.getColumns()+"   FIlas"+sheet.getRows());
            
            
            
            
            WritableWorkbook copy =  Workbook.createWorkbook(new File ("/root/NetBeansProjects/Principal/src/principal/NewExel.xls"),workbook);
                    
    
            WritableSheet hojaTiketsRojos = copy.getSheet(1);
            //WritableCell  cell = hojaTiketsRojos.getWritableCell(1, 0);
            
            /* ESte if se tiene que hacer poque si la celda ya posee algo, si no se hace no esta la opcion setString y se tiene que crear una nuevacelda
            if (cell.getType() == CellType.LABEL){
                Label l =(Label) cell;
                l.setString("Salí a correr hoy");
            }
            */
            try{
                Label label = new Label(0,0,"Mario Bross");
                hojaTiketsRojos.addCell(label);
                copy.write();
                copy.close();
            }
            catch (WriteException wexep){
                System.out.println("ERROR---->>"+wexep.getMessage());
            }
            
            /**
             * Cerrarmos nuestro exell
             */
            workbook.close();
            
           
            
        }
        /**
         * catch the file openin errors
         */
        catch (IOException ioex) {
            System.out.println("ERROR---->>"+ioex.getMessage());
        } 
        catch (NumberFormatException nfe) {
            System.out.println("ERROR---->>"+nfe.getMessage());    
        }
        catch (BiffException biff){
            System.out.println("ERROR---->>"+biff.getMessage());
        }
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
}



