package ec.gob.celec.persistencia;
// Generated 17/06/2014 12:52:51 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * BeSegColocacion generated by hbm2java
 */
public class BeSegColocacion  implements java.io.Serializable {


     private Integer coSegColocacion;
     private BeColocacion beColocacion;
     private String nbContactoSegCol;
     private String nbCargoContactoSegCol;
     private Date feSegColocacion;
     private String coPermanenciaSegCol;
     private String deComentarioSegColo;
     private String vaSalidaSegCol;
     private String deSalidaSegCol;

    public BeSegColocacion() {
    }

	
    public BeSegColocacion(BeColocacion beColocacion) {
        this.beColocacion = beColocacion;
    }
    public BeSegColocacion(BeColocacion beColocacion, String nbContactoSegCol, String nbCargoContactoSegCol, Date feSegColocacion, String coPermanenciaSegCol, String deComentarioSegColo, String vaSalidaSegCol, String deSalidaSegCol) {
       this.beColocacion = beColocacion;
       this.nbContactoSegCol = nbContactoSegCol;
       this.nbCargoContactoSegCol = nbCargoContactoSegCol;
       this.feSegColocacion = feSegColocacion;
       this.coPermanenciaSegCol = coPermanenciaSegCol;
       this.deComentarioSegColo = deComentarioSegColo;
       this.vaSalidaSegCol = vaSalidaSegCol;
       this.deSalidaSegCol = deSalidaSegCol;
    }
   
    public Integer getCoSegColocacion() {
        return this.coSegColocacion;
    }
    
    public void setCoSegColocacion(Integer coSegColocacion) {
        this.coSegColocacion = coSegColocacion;
    }
    public BeColocacion getBeColocacion() {
        return this.beColocacion;
    }
    
    public void setBeColocacion(BeColocacion beColocacion) {
        this.beColocacion = beColocacion;
    }
    public String getNbContactoSegCol() {
        return this.nbContactoSegCol;
    }
    
    public void setNbContactoSegCol(String nbContactoSegCol) {
        this.nbContactoSegCol = nbContactoSegCol;
    }
    public String getNbCargoContactoSegCol() {
        return this.nbCargoContactoSegCol;
    }
    
    public void setNbCargoContactoSegCol(String nbCargoContactoSegCol) {
        this.nbCargoContactoSegCol = nbCargoContactoSegCol;
    }
    public Date getFeSegColocacion() {
        return this.feSegColocacion;
    }
    
    public void setFeSegColocacion(Date feSegColocacion) {
        this.feSegColocacion = feSegColocacion;
    }
    public String getCoPermanenciaSegCol() {
        return this.coPermanenciaSegCol;
    }
    
    public void setCoPermanenciaSegCol(String coPermanenciaSegCol) {
        this.coPermanenciaSegCol = coPermanenciaSegCol;
    }
    public String getDeComentarioSegColo() {
        return this.deComentarioSegColo;
    }
    
    public void setDeComentarioSegColo(String deComentarioSegColo) {
        this.deComentarioSegColo = deComentarioSegColo;
    }
    public String getVaSalidaSegCol() {
        return this.vaSalidaSegCol;
    }
    
    public void setVaSalidaSegCol(String vaSalidaSegCol) {
        this.vaSalidaSegCol = vaSalidaSegCol;
    }
    public String getDeSalidaSegCol() {
        return this.deSalidaSegCol;
    }
    
    public void setDeSalidaSegCol(String deSalidaSegCol) {
        this.deSalidaSegCol = deSalidaSegCol;
    }




}

