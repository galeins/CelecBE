package ec.gob.celec.persistencia;
// Generated 27/06/2014 11:55:07 AM by Hibernate Tools 3.2.1.GA



/**
 * BeCalificacionEducacion generated by hbm2java
 */
public class BeCalificacionEducacion  implements java.io.Serializable {


     private Integer coCalificacionEducacion;
     private BeCatalogo beCatalogo;
     private BeOfertaEmpleo beOfertaEmpleo;
     private Integer vaCalificacion;
     private String vaTipoOferta;
     

    public BeCalificacionEducacion() {
    }

    public BeCalificacionEducacion(BeCatalogo beCatalogo, BeOfertaEmpleo beOfertaEmpleo, Integer vaCalificacion) {
       this.beCatalogo = beCatalogo;
       this.beOfertaEmpleo = beOfertaEmpleo;
       this.vaCalificacion = vaCalificacion;
    }
   
    public Integer getCoCalificacionEducacion() {
        return this.coCalificacionEducacion;
    }
    
    public void setCoCalificacionEducacion(Integer coCalificacionEducacion) {
        this.coCalificacionEducacion = coCalificacionEducacion;
    }
    public BeCatalogo getBeCatalogo() {
        return this.beCatalogo;
    }
    
    public void setBeCatalogo(BeCatalogo beCatalogo) {
        this.beCatalogo = beCatalogo;
    }
    public BeOfertaEmpleo getBeOfertaEmpleo() {
        return this.beOfertaEmpleo;
    }
    
    public void setBeOfertaEmpleo(BeOfertaEmpleo beOfertaEmpleo) {
        this.beOfertaEmpleo = beOfertaEmpleo;
    }
    public Integer getVaCalificacion() {
        return this.vaCalificacion;
    }
    
    public void setVaCalificacion(Integer vaCalificacion) {
        this.vaCalificacion = vaCalificacion;
    }

    /**
     * @return the vaTipoOferta
     */
    public String getVaTipoOferta() {
        return vaTipoOferta;
    }

    /**
     * @param vaTipoOferta the vaTipoOferta to set
     */
    public void setVaTipoOferta(String vaTipoOferta) {
        this.vaTipoOferta = vaTipoOferta;
    }




}


