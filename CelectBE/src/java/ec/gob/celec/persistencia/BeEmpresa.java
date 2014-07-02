package ec.gob.celec.persistencia;
// Generated 17/06/2014 12:52:51 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * BeEmpresa generated by hbm2java
 */
public class BeEmpresa  implements java.io.Serializable {


     private Integer coEmpresa;
     private BePersona bePersona;
     private String nbEmpresa;
     private String nbComercialEmp;
     private int coPernaturalEmp;
     private String nuRucEmp;
     private String deDireccionEmp;
     private int coTipoEmp;
     private int coProvEmp;
     private int coCantonEmp;
     private Integer coSectorEmp;
     private String deBarrioEmp;
     private String nuFonoEmp;
     private String dePagwebEmp;
     private int coIndustriaEmp;
     private Integer coVentasEmp;
     private int coNumempleadosEmp;
     private String deProductosEmp;
     private String deDescripcionEmp;
     private String nbRepreLegalEmp;
     private String apRepreLegalEmp;
     private int coGenereoRepreLegalEmp;
     private String nuCelularRepreLegalEmp;
     private String nuCedulaRepreLegalEmp;
     private String nuFonoRepreLegalEmp;
     private byte[] imFotoEmp;
     private String dePathFotoEmp;
     private String deBajaEmp;
     private String esEmpresa;
     private String nbMailRepreLegalEmpr;
     private Set beOfertaEmpleos = new HashSet(0);
     private Set beRefeEmpresas = new HashSet(0);

    public BeEmpresa() {
    }

	
    public BeEmpresa(BePersona bePersona, String nbEmpresa, String nbComercialEmp, int coPernaturalEmp, String nuRucEmp, String deDireccionEmp, int coTipoEmp, int coProvEmp, int coCantonEmp, String deBarrioEmp, String nuFonoEmp, String dePagwebEmp, int coIndustriaEmp, int coNumempleadosEmp, String deProductosEmp, String deDescripcionEmp, String nbRepreLegalEmp, String apRepreLegalEmp, int coGenereoRepreLegalEmp, String nuCedulaRepreLegalEmp) {
        this.bePersona = bePersona;
        this.nbEmpresa = nbEmpresa;
        this.nbComercialEmp = nbComercialEmp;
        this.coPernaturalEmp = coPernaturalEmp;
        this.nuRucEmp = nuRucEmp;
        this.deDireccionEmp = deDireccionEmp;
        this.coTipoEmp = coTipoEmp;
        this.coProvEmp = coProvEmp;
        this.coCantonEmp = coCantonEmp;
        this.deBarrioEmp = deBarrioEmp;
        this.nuFonoEmp = nuFonoEmp;
        this.dePagwebEmp = dePagwebEmp;
        this.coIndustriaEmp = coIndustriaEmp;
        this.coNumempleadosEmp = coNumempleadosEmp;
        this.deProductosEmp = deProductosEmp;
        this.deDescripcionEmp = deDescripcionEmp;
        this.nbRepreLegalEmp = nbRepreLegalEmp;
        this.apRepreLegalEmp = apRepreLegalEmp;
        this.coGenereoRepreLegalEmp = coGenereoRepreLegalEmp;
        this.nuCedulaRepreLegalEmp = nuCedulaRepreLegalEmp;
    }
    public BeEmpresa(BePersona bePersona, String nbEmpresa, String nbComercialEmp, int coPernaturalEmp, String nuRucEmp, String deDireccionEmp, int coTipoEmp, int coProvEmp, int coCantonEmp, Integer coSectorEmp, String deBarrioEmp, String nuFonoEmp, String dePagwebEmp, int coIndustriaEmp, Integer coVentasEmp, int coNumempleadosEmp, String deProductosEmp, String deDescripcionEmp, String nbRepreLegalEmp, String apRepreLegalEmp, int coGenereoRepreLegalEmp, String nuCelularRepreLegalEmp, String nuCedulaRepreLegalEmp, String nuFonoRepreLegalEmp, byte[] imFotoEmp, String dePathFotoEmp, String deBajaEmp, String esEmpresa, String nbMailRepreLegalEmpr, Set beOfertaEmpleos, Set beRefeEmpresas) {
       this.bePersona = bePersona;
       this.nbEmpresa = nbEmpresa;
       this.nbComercialEmp = nbComercialEmp;
       this.coPernaturalEmp = coPernaturalEmp;
       this.nuRucEmp = nuRucEmp;
       this.deDireccionEmp = deDireccionEmp;
       this.coTipoEmp = coTipoEmp;
       this.coProvEmp = coProvEmp;
       this.coCantonEmp = coCantonEmp;
       this.coSectorEmp = coSectorEmp;
       this.deBarrioEmp = deBarrioEmp;
       this.nuFonoEmp = nuFonoEmp;
       this.dePagwebEmp = dePagwebEmp;
       this.coIndustriaEmp = coIndustriaEmp;
       this.coVentasEmp = coVentasEmp;
       this.coNumempleadosEmp = coNumempleadosEmp;
       this.deProductosEmp = deProductosEmp;
       this.deDescripcionEmp = deDescripcionEmp;
       this.nbRepreLegalEmp = nbRepreLegalEmp;
       this.apRepreLegalEmp = apRepreLegalEmp;
       this.coGenereoRepreLegalEmp = coGenereoRepreLegalEmp;
       this.nuCelularRepreLegalEmp = nuCelularRepreLegalEmp;
       this.nuCedulaRepreLegalEmp = nuCedulaRepreLegalEmp;
       this.nuFonoRepreLegalEmp = nuFonoRepreLegalEmp;
       this.imFotoEmp = imFotoEmp;
       this.dePathFotoEmp = dePathFotoEmp;
       this.deBajaEmp = deBajaEmp;
       this.esEmpresa = esEmpresa;
       this.nbMailRepreLegalEmpr = nbMailRepreLegalEmpr;
       this.beOfertaEmpleos = beOfertaEmpleos;
       this.beRefeEmpresas = beRefeEmpresas;
    }
   
    public Integer getCoEmpresa() {
        return this.coEmpresa;
    }
    
    public void setCoEmpresa(Integer coEmpresa) {
        this.coEmpresa = coEmpresa;
    }
    public BePersona getBePersona() {
        return this.bePersona;
    }
    
    public void setBePersona(BePersona bePersona) {
        this.bePersona = bePersona;
    }
    public String getNbEmpresa() {
        return this.nbEmpresa;
    }
    
    public void setNbEmpresa(String nbEmpresa) {
        this.nbEmpresa = nbEmpresa;
    }
    public String getNbComercialEmp() {
        return this.nbComercialEmp;
    }
    
    public void setNbComercialEmp(String nbComercialEmp) {
        this.nbComercialEmp = nbComercialEmp;
    }
    public int getCoPernaturalEmp() {
        return this.coPernaturalEmp;
    }
    
    public void setCoPernaturalEmp(int coPernaturalEmp) {
        this.coPernaturalEmp = coPernaturalEmp;
    }
    public String getNuRucEmp() {
        return this.nuRucEmp;
    }
    
    public void setNuRucEmp(String nuRucEmp) {
        this.nuRucEmp = nuRucEmp;
    }
    public String getDeDireccionEmp() {
        return this.deDireccionEmp;
    }
    
    public void setDeDireccionEmp(String deDireccionEmp) {
        this.deDireccionEmp = deDireccionEmp;
    }
    public int getCoTipoEmp() {
        return this.coTipoEmp;
    }
    
    public void setCoTipoEmp(int coTipoEmp) {
        this.coTipoEmp = coTipoEmp;
    }
    public int getCoProvEmp() {
        return this.coProvEmp;
    }
    
    public void setCoProvEmp(int coProvEmp) {
        this.coProvEmp = coProvEmp;
    }
    public int getCoCantonEmp() {
        return this.coCantonEmp;
    }
    
    public void setCoCantonEmp(int coCantonEmp) {
        this.coCantonEmp = coCantonEmp;
    }
    public Integer getCoSectorEmp() {
        return this.coSectorEmp;
    }
    
    public void setCoSectorEmp(Integer coSectorEmp) {
        this.coSectorEmp = coSectorEmp;
    }
    public String getDeBarrioEmp() {
        return this.deBarrioEmp;
    }
    
    public void setDeBarrioEmp(String deBarrioEmp) {
        this.deBarrioEmp = deBarrioEmp;
    }
    public String getNuFonoEmp() {
        return this.nuFonoEmp;
    }
    
    public void setNuFonoEmp(String nuFonoEmp) {
        this.nuFonoEmp = nuFonoEmp;
    }
    public String getDePagwebEmp() {
        return this.dePagwebEmp;
    }
    
    public void setDePagwebEmp(String dePagwebEmp) {
        this.dePagwebEmp = dePagwebEmp;
    }
    public int getCoIndustriaEmp() {
        return this.coIndustriaEmp;
    }
    
    public void setCoIndustriaEmp(int coIndustriaEmp) {
        this.coIndustriaEmp = coIndustriaEmp;
    }
    public Integer getCoVentasEmp() {
        return this.coVentasEmp;
    }
    
    public void setCoVentasEmp(Integer coVentasEmp) {
        this.coVentasEmp = coVentasEmp;
    }
    public int getCoNumempleadosEmp() {
        return this.coNumempleadosEmp;
    }
    
    public void setCoNumempleadosEmp(int coNumempleadosEmp) {
        this.coNumempleadosEmp = coNumempleadosEmp;
    }
    public String getDeProductosEmp() {
        return this.deProductosEmp;
    }
    
    public void setDeProductosEmp(String deProductosEmp) {
        this.deProductosEmp = deProductosEmp;
    }
    public String getDeDescripcionEmp() {
        return this.deDescripcionEmp;
    }
    
    public void setDeDescripcionEmp(String deDescripcionEmp) {
        this.deDescripcionEmp = deDescripcionEmp;
    }
    public String getNbRepreLegalEmp() {
        return this.nbRepreLegalEmp;
    }
    
    public void setNbRepreLegalEmp(String nbRepreLegalEmp) {
        this.nbRepreLegalEmp = nbRepreLegalEmp;
    }
    public String getApRepreLegalEmp() {
        return this.apRepreLegalEmp;
    }
    
    public void setApRepreLegalEmp(String apRepreLegalEmp) {
        this.apRepreLegalEmp = apRepreLegalEmp;
    }
    public int getCoGenereoRepreLegalEmp() {
        return this.coGenereoRepreLegalEmp;
    }
    
    public void setCoGenereoRepreLegalEmp(int coGenereoRepreLegalEmp) {
        this.coGenereoRepreLegalEmp = coGenereoRepreLegalEmp;
    }
    public String getNuCelularRepreLegalEmp() {
        return this.nuCelularRepreLegalEmp;
    }
    
    public void setNuCelularRepreLegalEmp(String nuCelularRepreLegalEmp) {
        this.nuCelularRepreLegalEmp = nuCelularRepreLegalEmp;
    }
    public String getNuCedulaRepreLegalEmp() {
        return this.nuCedulaRepreLegalEmp;
    }
    
    public void setNuCedulaRepreLegalEmp(String nuCedulaRepreLegalEmp) {
        this.nuCedulaRepreLegalEmp = nuCedulaRepreLegalEmp;
    }
    public String getNuFonoRepreLegalEmp() {
        return this.nuFonoRepreLegalEmp;
    }
    
    public void setNuFonoRepreLegalEmp(String nuFonoRepreLegalEmp) {
        this.nuFonoRepreLegalEmp = nuFonoRepreLegalEmp;
    }
    public byte[] getImFotoEmp() {
        return this.imFotoEmp;
    }
    
    public void setImFotoEmp(byte[] imFotoEmp) {
        this.imFotoEmp = imFotoEmp;
    }
    public String getDePathFotoEmp() {
        return this.dePathFotoEmp;
    }
    
    public void setDePathFotoEmp(String dePathFotoEmp) {
        this.dePathFotoEmp = dePathFotoEmp;
    }
    public String getDeBajaEmp() {
        return this.deBajaEmp;
    }
    
    public void setDeBajaEmp(String deBajaEmp) {
        this.deBajaEmp = deBajaEmp;
    }
    public String getEsEmpresa() {
        return this.esEmpresa;
    }
    
    public void setEsEmpresa(String esEmpresa) {
        this.esEmpresa = esEmpresa;
    }
    public String getNbMailRepreLegalEmpr() {
        return this.nbMailRepreLegalEmpr;
    }
    
    public void setNbMailRepreLegalEmpr(String nbMailRepreLegalEmpr) {
        this.nbMailRepreLegalEmpr = nbMailRepreLegalEmpr;
    }
    public Set getBeOfertaEmpleos() {
        return this.beOfertaEmpleos;
    }
    
    public void setBeOfertaEmpleos(Set beOfertaEmpleos) {
        this.beOfertaEmpleos = beOfertaEmpleos;
    }
    public Set getBeRefeEmpresas() {
        return this.beRefeEmpresas;
    }
    
    public void setBeRefeEmpresas(Set beRefeEmpresas) {
        this.beRefeEmpresas = beRefeEmpresas;
    }




}


