package Logica;

public class Tickets {
    private String asunto;
    private int IDTicket;
    private String categoria;
    private String estado;


    
    
    private String FechayHoraRecepcion;
    private String ID_CLIENTE;        
    
    public Tickets(String FechayHoraRecepcion, String ID_CLIENTE, String asunto){
        this.FechayHoraRecepcion = FechayHoraRecepcion;
        this.ID_CLIENTE = ID_CLIENTE;
        this.asunto = asunto;
    }
    
    
    
        public String getFechayHoraRecepcion() {
        return FechayHoraRecepcion;
    }

    public void setFechayHoraRecepcion(String FechayHoraRecepcion) {
        this.FechayHoraRecepcion = FechayHoraRecepcion;
    }

    public String getID_CLIENTE() {
        return ID_CLIENTE;
    }

    public void setID_CLIENTE(String ID_CLIENTE) {
        this.ID_CLIENTE = ID_CLIENTE;
    }
    
    public Tickets(String asunto, int IDTicket, String categoria, String estado){
        this.asunto = asunto;
        this.IDTicket = IDTicket;
        this.categoria = categoria;
        this.estado = estado;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public int getIDTicket() {
        return IDTicket;
    }

    public void setIDTicket(int IDTicket) {
        this.IDTicket = IDTicket;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String toString(){
        String datos = "Asunto: " + getAsunto() + "\n" +
                       "ID: " + getIDTicket() + "\n" +
                       "Categoria: " + getCategoria() + "\n" +
                       "Estado: " + getEstado() + "\n" ;
        return datos;
    }
    
}
