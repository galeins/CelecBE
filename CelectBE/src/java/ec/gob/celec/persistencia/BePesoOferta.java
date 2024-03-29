package ec.gob.celec.persistencia;
// Generated 17/06/2014 12:52:51 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * BePesoOferta generated by hbm2java
 */
public class BePesoOferta  implements java.io.Serializable {


     private Integer coPesoOferta;
     private BeOfertaEmpleo beOfertaEmpleo;
     private BeCategPeso beCategPeso;
     private BigDecimal vaPesoOferta;
     private BigDecimal vaEvaPesoOferta;
     private Set beEvaluacionCvs = new HashSet(0);

    public BePesoOferta() {
    }

	
    public BePesoOferta(BeOfertaEmpleo beOfertaEmpleo, BeCategPeso beCategPeso) {
        this.beOfertaEmpleo = beOfertaEmpleo;
        this.beCategPeso = beCategPeso;
    }
    public BePesoOferta(BeOfertaEmpleo beOfertaEmpleo, BeCategPeso beCategPeso, BigDecimal vaPesoOferta, BigDecimal vaEvaPesoOferta, Set beEvaluacionCvs) {
       this.beOfertaEmpleo = beOfertaEmpleo;
       this.beCategPeso = beCategPeso;
       this.vaPesoOferta = vaPesoOferta;
       this.vaEvaPesoOferta = vaEvaPesoOferta;
       this.beEvaluacionCvs = beEvaluacionCvs;
    }
   
    public Integer getCoPesoOferta() {
        return this.coPesoOferta;
    }
    
    public void setCoPesoOferta(Integer coPesoOferta) {
        this.coPesoOferta = coPesoOferta;
    }
    public BeOfertaEmpleo getBeOfertaEmpleo() {
        return this.beOfertaEmpleo;
    }
    
    public void setBeOfertaEmpleo(BeOfertaEmpleo beOfertaEmpleo) {
        this.beOfertaEmpleo = beOfertaEmpleo;
    }
    public BeCategPeso getBeCategPeso() {
        return this.beCategPeso;
    }
    
    public void setBeCategPeso(BeCategPeso beCategPeso) {
        this.beCategPeso = beCategPeso;
    }
    public BigDecimal getVaPesoOferta() {
        return this.vaPesoOferta;
    }
    
    public void setVaPesoOferta(BigDecimal vaPesoOferta) {
        this.vaPesoOferta = vaPesoOferta;
    }
    public BigDecimal getVaEvaPesoOferta() {
        return this.vaEvaPesoOferta;
    }
    
    public void setVaEvaPesoOferta(BigDecimal vaEvaPesoOferta) {
        this.vaEvaPesoOferta = vaEvaPesoOferta;
    }
    public Set getBeEvaluacionCvs() {
        return this.beEvaluacionCvs;
    }
    
    public void setBeEvaluacionCvs(Set beEvaluacionCvs) {
        this.beEvaluacionCvs = beEvaluacionCvs;
    }




}


