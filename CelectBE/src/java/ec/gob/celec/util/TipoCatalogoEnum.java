/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.util;

/**
 *
 * @author Personal
 */
public enum TipoCatalogoEnum {
    CATEGORIA_OFERTA("Categoria de perfiles de cargo"),
    TIPO_IDENTIFICACION("Tipo Identificación"),
    NIVEL_ESTUDIO("Nivel de Estudios"),
    GENERO("Género"),
    ESTADO_CIVIL("Estado Civil"),
    PAISES("Paises"),
    LUGAR_RESIDENCIA("Lugar de Residencia"),
    TIPO_LICENCIA("Tipo Licencia"),
    TIPO_DISCAPACIDAD("Tipo Discapacidad"),
    GRUPO_ETNICO("Grupo étnico"),
    IDIOMA("Idioma"),
    NIVEL_IDIOMA("Nivel de Idioma"),
    TIPO_REFERENCIA("Tipo de referencia"),
    AREA_CONOCIMIENTO("Area de conocimiento"),
    PATH_REPORTES("Parametro Reporte"),
    ASUNTO_CORREO("Asunto correo"),
    HOST_CORREO("Host Correo"),
    PUERTO_CORREO("Puerto Correo"),
    FROM_CORREO("From Correo"),
    PROTOCOL_CORREO("Protocolo Correo"),
    USUARIO_CORREO("Usuario Correo"),
    CLAVE_CORREO("Clave Correo"),
    DEPARTAMENTO("Departamento"),
    TIPO_RELACION_LABORAL("Tipo de Relacion Laboral"),
    CARGOS("Cargo"),
    AREA_PONDERACION("Area Ponderación"),
    TIPO_MERITO("Tipo mérito"),
    TIPO_PRUEBA("Tipo prueba"),
    TIPO_ENTREVISTA("Tipo entrevista");
    
    
    private String categoria;
    
    TipoCatalogoEnum(String categoria)
    {
        this.categoria=categoria;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}
