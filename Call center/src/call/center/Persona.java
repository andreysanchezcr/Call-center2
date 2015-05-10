package call.center;

public class Persona {
    private String nombre;
    private String correo;
    private String contraseña;
    private String categoria;
    private boolean conectado;
    private boolean tipo;

    public Persona(String nombre, String correo, String contraseña, String categoria, boolean tipo){
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.categoria = categoria;
        this.tipo = tipo;
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    public String isTipo() {
        String nombreTipo;
        if(tipo == false){
            nombreTipo = "Empleado";
        }
        else{
            nombreTipo = "Administrador";
        }
        return nombreTipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
    
    public String toString(){
        String datos = "Nombre: " + getNombre() + "\n" +
                       "Correo: " + getCorreo() + "\n" +
                       "Contraseña: " + getContraseña() + "\n" +
                       "Categoria: " + getCategoria() + "\n" +
                       "Tipo: " + isTipo() + "\n";
        return datos;
    }
    
}
