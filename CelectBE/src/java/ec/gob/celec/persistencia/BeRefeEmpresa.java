package ec.gob.celec.persistencia;
// Generated 17/06/2014 12:52:51 AM by Hibernate Tools 3.2.1.GA



/**
 * BeRefeEmpresa generated by hbm2java
 */
public class BeRefeEmpresa  implements java.io.Serializable {


     private Integer coRefeEmpresa;
     private BeCatalogo beCatalogo;
     private BeEmpresa beEmpresa;
     private String nbRefeEmpresa;
     private String nbContactoRefeEmpresa;
     private String nuTelefonoRefeEmpresa;
     private String deDireccionRefeEmpresa;

    public BeRefeEmpresa() {
    }

	
    public BeRefeEmpresa(BeEmpresa beEmpresa, String nbRefeEmpresa, String nbContactoRefeEmpresa, String nuTelefonoRefeEmpresa) {
        this.beEmpresa = beEmpresa;
        this.nbRefeEmpresa = nbRefeEmpresa;
        this.nbContactoRefeEmpresa = nbContactoRefeEmpresa;
        this.nuTelefonoRefeEmpresa = nuTelefonoRefeEmpresa;
    }
    public BeRefeEmpresa(BeCatalogo beCatalogo, BeEmpresa beEmpresa, String nbRefeEmpresa, String nbContactoRefeEmpresa, String nuTelefonoRefeEmpresa, String deDireccionRefeEmpresa) {
       this.beCatalogo = beCatalogo;
       this.beEmpresa = beEmpresa;
       this.nbRefeEmpresa = nbRefeEmpresa;
       this.nbContactoRefeEmpresa = nbContactoRefeEmpresa;
       this.nuTelefonoRefeEmpresa = nuTelefonoRefeEmpresa;
       this.deDireccionRefeEmpresa = deDireccionRefeEmpresa;
    }
   
    public Integer getCoRefeEmpresa() {
        return this.coRefeEmpresa;
    }
    
    public void setCoRefeEmpresa(Integer coRefeEmpresa) {
        this.coRefeEmpresa = coRefeEmpresa;
    }
    public BeCatalogo getBeCatalogo() {
        return this.beCatalogo;
    }
    
    public void setBeCatalogo(BeCatalogo beCatalogo) {
        this.beCatalogo = beCatalogo;
    }
    public BeEmpresa getBeEmpresa() {
        return this.beEmpresa;
    }
    
    public void setBeEmpresa(BeEmpresa beEmpresa) {
        this.beEmpresa = beEmpresa;
    }
    public String getNbRefeEmpresa() {
        return this.nbRefeEmpresa;
    }
    
    public void setNbRefeEmpresa(String nbRefeEmpresa) {
        this.nbRefeEmpresa = nbRefeEmpresa;
    }
    public String getNbContactoRefeEmpresa() {
        return this.nbContactoRefeEmpresa;
    }
    
    public void setNbContactoRefeEmpresa(String nbContactoRefeEmpresa) {
        this.nbContactoRefeEmpresa = nbContactoRefeEmpresa;
    }
    public String getNuTelefonoRefeEmpresa() {
        return this.nuTelefonoRefeEmpresa;
    }
    
    public void setNuTelefonoRefeEmpresa(String nuTelefonoRefeEmpresa) {
        this.nuTelefonoRefeEmpresa = nuTelefonoRefeEmpresa;
    }
    public String getDeDireccionRefeEmpresa() {
        return this.deDireccionRefeEmpresa;
    }
    
    public void setDeDireccionRefeEmpresa(String deDireccionRefeEmpresa) {
        this.deDireccionRefeEmpresa = deDireccionRefeEmpresa;
    }




}


