package ec.gob.celec.persistencia;
// Generated 17/06/2014 12:52:51 AM by Hibernate Tools 3.2.1.GA



/**
 * BeCategOferta generated by hbm2java
 */
public class BeCategOferta  implements java.io.Serializable {


     private Integer coCategOferta;
     private BeOfertaEmpleo beOfertaEmpleo;
     private Integer coCategoriaOferta;
     private String deEspecifique;

    public BeCategOferta() {
    }

	
    public BeCategOferta(BeOfertaEmpleo beOfertaEmpleo) {
        this.beOfertaEmpleo = beOfertaEmpleo;
    }
    public BeCategOferta(BeOfertaEmpleo beOfertaEmpleo, Integer coCategoriaOferta, String deEspecifique) {
       this.beOfertaEmpleo = beOfertaEmpleo;
       this.coCategoriaOferta = coCategoriaOferta;
       this.deEspecifique = deEspecifique;
    }
   
    public Integer getCoCategOferta() {
        return this.coCategOferta;
    }
    
    public void setCoCategOferta(Integer coCategOferta) {
        this.coCategOferta = coCategOferta;
    }
    public BeOfertaEmpleo getBeOfertaEmpleo() {
        return this.beOfertaEmpleo;
    }
    
    public void setBeOfertaEmpleo(BeOfertaEmpleo beOfertaEmpleo) {
        this.beOfertaEmpleo = beOfertaEmpleo;
    }
    public Integer getCoCategoriaOferta() {
        return this.coCategoriaOferta;
    }
    
    public void setCoCategoriaOferta(Integer coCategoriaOferta) {
        this.coCategoriaOferta = coCategoriaOferta;
    }
    public String getDeEspecifique() {
        return this.deEspecifique;
    }
    
    public void setDeEspecifique(String deEspecifique) {
        this.deEspecifique = deEspecifique;
    }




}


