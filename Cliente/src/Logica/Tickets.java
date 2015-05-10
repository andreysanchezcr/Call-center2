package call.center;

public class Tickets {
    private String asunto;
    private int IDTicket;
    private String categoria;
    private String estado;
    
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
