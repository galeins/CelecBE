/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.util;

/**
 *
 * @author Personal
 */
public enum EnumSesion {
    userCredential(1,"userCredential"),
    ofertaActiva(2,"ofertaActiva");
    
    private int codigo;
    private String nombre;
    
    EnumSesion (int codigo,String nombre)
    {
        this.codigo=codigo;    
        this.nombre = nombre;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
