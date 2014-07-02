/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.util;

/**
 *
 * @author Personal
 */
public enum GrupoUsuarioEnum {
    CANDIDATO ("Candidato",Short.valueOf("1")),
    ASESOR("Asesor BE",Short.valueOf("5")),
    ADMINISTRADOR("Asesor BE",Short.valueOf("5"));
    
    private String descripcion;
    private Short codigo;
    
    GrupoUsuarioEnum(String descripcion, Short codigo)
    {
        this.setDescripcion(descripcion);
        this.setCodigo(codigo);
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the codigo
     */
    public Short getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Short codigo) {
        this.codigo = codigo;
    }
    
}
