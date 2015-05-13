
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
        
        setHojaActual(libroDeTrabajo.getSheet(3));
        ArrayList<Tickets> listaTiketsRojos = new ArrayList();
        
        int numFilas = hojaActual.getRows();
        
        for( int fila = 0; fila+1 < numFilas; fila++ ){
            
            Cell celdaFechayHoraRecepcion = hojaActual.getCell(0,fila+1);
            String strFechayHoraRecepcion = celdaFechayHoraRecepcion.getContents();

            Cell celdaID_CLIENTE = hojaActual.getCell(1,fila+1);
            String strID_CLIENTE = celdaID_CLIENTE.getContents();

            Cell celdaAsunto = hojaActual.getCell(2,fila+1);
            String strAsunto = celdaAsunto.getContents();

            Cell celdaIDTicket = hojaActual.getCell(3,fila+1);
            String strIDTicket = celdaIDTicket.getContents();

            Cell celdaCategoria = hojaActual.getCell(4,fila+1);
            String strCategoria = celdaCategoria.getContents();

            Cell celdaID_EMPLEADO = hojaActual.getCell(5,fila+1);
            String strID_EMPLEADO = celdaID_EMPLEADO.getContents();

            Cell celdaFechayHoraAtencion = hojaActual.getCell(6,fila+1);
            String strFechayHoraAtencion = celdaFechayHoraAtencion.getContents();

            Cell celdaTiempoSegundos = hojaActual.getCell(7,fila+1);
            String strTiempoSegundos = celdaTiempoSegundos.getContents();

            Cell celdaComentario = hojaActual.getCell(8,fila+1);
            String strComentario = celdaComentario.getContents();

            Cell celdaEstado = hojaActual.getCell(9,fila+1);
            String strEstado = celdaEstado.getContents();        
            
            Tickets tempTicket = new Tickets(strFechayHoraRecepcion, strID_CLIENTE, strAsunto, 
            Integer.parseInt(strIDTicket), strCategoria, strID_EMPLEADO, 
            strFechayHoraAtencion, strTiempoSegundos, 
            strComentario, strEstado );
            
            
            
            listaTiketsRojos.add(tempTicket);
            
        }
        return listaTiketsRojos;
    }

    @Override
    public ArrayList<Tickets> cargarTiketsVerdesDeArchivo() {
        setHojaActual(libroDeTrabajo.getSheet(1));
        ArrayList<Tickets> listaTiketsRojos = new ArrayList();
        
        int numFilas = hojaActual.getRows();
        
        for( int fila = 0; fila+1 < numFilas; fila++ ){
            
            Cell celdaFechayHoraRecepcion = hojaActual.getCell(0,fila+1);
            String strFechayHoraRecepcion = celdaFechayHoraRecepcion.getContents();

            Cell celdaID_CLIENTE = hojaActual.getCell(1,fila+1);
            String strID_CLIENTE = celdaID_CLIENTE.getContents();

            Cell celdaAsunto = hojaActual.getCell(2,fila+1);
            String strAsunto = celdaAsunto.getContents();

            Cell celdaIDTicket = hojaActual.getCell(3,fila+1);
            String strIDTicket = celdaIDTicket.getContents();

            Cell celdaCategoria = hojaActual.getCell(4,fila+1);
            String strCategoria = celdaCategoria.getContents();

            Cell celdaID_EMPLEADO = hojaActual.getCell(5,fila+1);
            String strID_EMPLEADO = celdaID_EMPLEADO.getContents();

            Cell celdaFechayHoraAtencion = hojaActual.getCell(6,fila+1);
            String strFechayHoraAtencion = celdaFechayHoraAtencion.getContents();

            Cell celdaTiempoSegundos = hojaActual.getCell(7,fila+1);
            String strTiempoSegundos = celdaTiempoSegundos.getContents();

            Cell celdaComentario = hojaActual.getCell(8,fila+1);
            String strComentario = celdaComentario.getContents();

            Cell celdaEstado = hojaActual.getCell(9,fila+1);
            String strEstado = celdaEstado.getContents();        
            
            Tickets tempTicket = new Tickets(strFechayHoraRecepcion, strID_CLIENTE, strAsunto, 
            Integer.parseInt(strIDTicket), strCategoria, strID_EMPLEADO, 
            strFechayHoraAtencion, strTiempoSegundos, 
            strComentario, strEstado );
            
            
            
            listaTiketsRojos.add(tempTicket);
            
        }
        return listaTiketsRojos;
        
    }

    @Override
    public ArrayList<Tickets> cargarTiketsAmarillosDeArchivo() {
        setHojaActual(libroDeTrabajo.getSheet(2));
        ArrayList<Tickets> listaTiketsAmarillos = new ArrayList();
        
        int numFilas = hojaActual.getRows();
        
        for( int fila = 0; fila+1 < numFilas; fila++ ){
            
            Cell celdaFechayHoraRecepcion = hojaActual.getCell(0,fila+1);
            String strFechayHoraRecepcion = celdaFechayHoraRecepcion.getContents();

            Cell celdaID_CLIENTE = hojaActual.getCell(1,fila+1);
            String strID_CLIENTE = celdaID_CLIENTE.getContents();

            Cell celdaAsunto = hojaActual.getCell(2,fila+1);
            String strAsunto = celdaAsunto.getContents();

            Cell celdaIDTicket = hojaActual.getCell(3,fila+1);
            String strIDTicket = celdaIDTicket.getContents();

            Cell celdaCategoria = hojaActual.getCell(4,fila+1);
            String strCategoria = celdaCategoria.getContents();

            Cell celdaID_EMPLEADO = hojaActual.getCell(5,fila+1);
            String strID_EMPLEADO = celdaID_EMPLEADO.getContents();

            Cell celdaFechayHoraAtencion = hojaActual.getCell(6,fila+1);
            String strFechayHoraAtencion = celdaFechayHoraAtencion.getContents();

            Cell celdaTiempoSegundos = hojaActual.getCell(7,fila+1);
            String strTiempoSegundos = celdaTiempoSegundos.getContents();

            Cell celdaComentario = hojaActual.getCell(8,fila+1);
            String strComentario = celdaComentario.getContents();

            Cell celdaEstado = hojaActual.getCell(9,fila+1);
            String strEstado = celdaEstado.getContents();        
            
            Tickets tempTicket = new Tickets(strFechayHoraRecepcion, strID_CLIENTE, strAsunto, 
            Integer.parseInt(strIDTicket), strCategoria, strID_EMPLEADO, 
            strFechayHoraAtencion, strTiempoSegundos, 
            strComentario, strEstado );
            
            
            
            listaTiketsAmarillos.add(tempTicket);
            
        }
        return listaTiketsAmarillos;
    }

    @Override
    public void cargarGuardarCambiosEnArchivo(ArrayList<Tickets> listaPendientes,
                                                ArrayList<Tickets> listaVerdes,
                                                ArrayList<Tickets> listaAmarillos,
                                                ArrayList<Tickets> listaRojos) {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            copiaDeLibro =  Workbook.createWorkbook(new File ("/root/NetBeansProjects/CallCenter/Call-center2/Libro1.xls"),libroDeTrabajo);
            
            insertSheet(listaPendientes,0);
            insertSheet(listaVerdes,1);
            insertSheet(listaAmarillos,2);
            insertSheet(listaRojos,3);
            
        } catch (IOException wse) {
           System.out.println("ERROR---->>"+wse.getMessage());
        }
    
    }

    
    
        public static void main(String[] args) {
       // WritableSheet hojaTiketsPendientes = copiaDeLibro.getSheet(0);
       // System.out.println("hooooola MUndo");
       // Exell myExell = new  Exell("/root/NetBeansProjects/CallCenter/Call-center2/Libro1.xls");
       // myExell.cargarTiketsDeArchivo();
              
    }
    
    
    
    
    
    private void insertSheet(ArrayList<Tickets> lista , int numeroHoja){
    try {
            copiaDeLibro =  Workbook.createWorkbook(new File ("/root/NetBeansProjects/CallCenter/Call-center2/Libro1.xls"),libroDeTrabajo);
            
            WritableSheet hojaTikets = copiaDeLibro.getSheet(numeroHoja);
            
            try{
                for(int i =0; i+1<lista.size(); i++){
                    
                    Label lblFechaHoraRecepcion = new Label(0,i,"Mario Bross");
                    Tickets tempTiket = lista.get(i);
                    
                    
                    Label lblFechayHoraRecepcion = new Label(0,i+1,tempTiket.getFechayHoraRecepcion());
                    hojaTikets.addCell(lblFechayHoraRecepcion);
                    Label lblID_CLIENTE = new Label(1,i+1,tempTiket.getID_CLIENTE());
                    hojaTikets.addCell(lblID_CLIENTE);
                    Label lblasunto = new Label(2,i+1,tempTiket.getAsunto());
                    hojaTikets.addCell(lblasunto);
                    Label lblIDTicket = new Label(3,i+1,Integer.toString(tempTiket.getIDTicket()));
                    hojaTikets.addCell(lblIDTicket);
                    Label lblcategoria= new Label(4,i+1,tempTiket.getCategoria());
                    hojaTikets.addCell(lblcategoria);
                    Label lblID_EMPLEADO = new Label(5,i+1,tempTiket.getID_EMPLEADO());
                    hojaTikets.addCell(lblID_EMPLEADO);
                    Label lblfechayHoraAtencion = new Label(6,i+1,tempTiket.getFechayHoraAtencion());
                    hojaTikets.addCell(lblfechayHoraAtencion);
                    Label lbltiempoSegundos = new Label(7,i+1,tempTiket.getTiempoSegundos());
                    hojaTikets.addCell(lbltiempoSegundos);
                    Label lblComentario = new Label(8,i+1,tempTiket.getComentario());
                    hojaTikets.addCell(lblComentario);
                    Label lblestado = new Label(9,i+1,tempTiket.getEstado());
                    hojaTikets.addCell(lblestado);

                }
                copiaDeLibro.write();
                copiaDeLibro.close();    
            }
            catch (WriteException wexep){
                System.out.println("ERROR---->>"+wexep.getMessage());
            }
            
            
        } catch (IOException wse) {
           System.out.println("ERROR---->>"+wse.getMessage());
        }
    }
    
    
    
}



