package ec.gob.celec.persistencia;
// Generated 17/06/2014 12:52:51 AM by Hibernate Tools 3.2.1.GA



/**
 * BeIdioma generated by hbm2java
 */
public class BeIdioma  implements java.io.Serializable {


     private Integer coIdioma;
     private BeCatalogo beCatalogoByCoHabla;
     private BeCatalogo beCatalogoByCoEscribe;
     private BeCatalogo beCatalogoByCoNombreIdiioma;
     private BeCatalogo beCatalogoByCoEntiende;
     private BeCurriculo beCurriculo;
     private String deEspecifique;
     private String esEstado;

    public BeIdioma() {
    }

	
    public BeIdioma(BeCurriculo beCurriculo) {
        this.beCurriculo = beCurriculo;
    }
    public BeIdioma(BeCatalogo beCatalogoByCoHabla, BeCatalogo beCatalogoByCoEscribe, BeCatalogo beCatalogoByCoNombreIdiioma, BeCatalogo beCatalogoByCoEntiende, BeCurriculo beCurriculo, String deEspecifique, String esEstado) {
       this.beCatalogoByCoHabla = beCatalogoByCoHabla;
       this.beCatalogoByCoEscribe = beCatalogoByCoEscribe;
       this.beCatalogoByCoNombreIdiioma = beCatalogoByCoNombreIdiioma;
       this.beCatalogoByCoEntiende = beCatalogoByCoEntiende;
       this.beCurriculo = beCurriculo;
       this.deEspecifique = deEspecifique;
       this.esEstado = esEstado;
    }
   
    public Integer getCoIdioma() {
        return this.coIdioma;
    }
    
    public void setCoIdioma(Integer coIdioma) {
        this.coIdioma = coIdioma;
    }
    public BeCatalogo getBeCatalogoByCoHabla() {
        return this.beCatalogoByCoHabla;
    }
    
    public void setBeCatalogoByCoHabla(BeCatalogo beCatalogoByCoHabla) {
        this.beCatalogoByCoHabla = beCatalogoByCoHabla;
    }
    public BeCatalogo getBeCatalogoByCoEscribe() {
        return this.beCatalogoByCoEscribe;
    }
    
    public void setBeCatalogoByCoEscribe(BeCatalogo beCatalogoByCoEscribe) {
        this.beCatalogoByCoEscribe = beCatalogoByCoEscribe;
    }
    public BeCatalogo getBeCatalogoByCoNombreIdiioma() {
        return this.beCatalogoByCoNombreIdiioma;
    }
    
    public void setBeCatalogoByCoNombreIdiioma(BeCatalogo beCatalogoByCoNombreIdiioma) {
        this.beCatalogoByCoNombreIdiioma = beCatalogoByCoNombreIdiioma;
    }
    public BeCatalogo getBeCatalogoByCoEntiende() {
        return this.beCatalogoByCoEntiende;
    }
    
    public void setBeCatalogoByCoEntiende(BeCatalogo beCatalogoByCoEntiende) {
        this.beCatalogoByCoEntiende = beCatalogoByCoEntiende;
    }
    public BeCurriculo getBeCurriculo() {
        return this.beCurriculo;
    }
    
    public void setBeCurriculo(BeCurriculo beCurriculo) {
        this.beCurriculo = beCurriculo;
    }
    public String getDeEspecifique() {
        return this.deEspecifique;
    }
    
    public void setDeEspecifique(String deEspecifique) {
        this.deEspecifique = deEspecifique;
    }
    public String getEsEstado() {
        return this.esEstado;
    }
    
    public void setEsEstado(String esEstado) {
        this.esEstado = esEstado;
    }




}


