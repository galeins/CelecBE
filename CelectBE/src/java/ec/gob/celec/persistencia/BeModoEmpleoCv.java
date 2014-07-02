package ec.gob.celec.persistencia;
// Generated 17/06/2014 12:52:51 AM by Hibernate Tools 3.2.1.GA



/**
 * BeModoEmpleoCv generated by hbm2java
 */
public class BeModoEmpleoCv  implements java.io.Serializable {


     private Integer coModoEmpleoCv;
     private BeCurriculo beCurriculo;
     private Integer coModoEmpleo;
     private String deEspecifique;

    public BeModoEmpleoCv() {
    }

	
    public BeModoEmpleoCv(BeCurriculo beCurriculo) {
        this.beCurriculo = beCurriculo;
    }
    public BeModoEmpleoCv(BeCurriculo beCurriculo, Integer coModoEmpleo, String deEspecifique) {
       this.beCurriculo = beCurriculo;
       this.coModoEmpleo = coModoEmpleo;
       this.deEspecifique = deEspecifique;
    }
   
    public Integer getCoModoEmpleoCv() {
        return this.coModoEmpleoCv;
    }
    
    public void setCoModoEmpleoCv(Integer coModoEmpleoCv) {
        this.coModoEmpleoCv = coModoEmpleoCv;
    }
    public BeCurriculo getBeCurriculo() {
        return this.beCurriculo;
    }
    
    public void setBeCurriculo(BeCurriculo beCurriculo) {
        this.beCurriculo = beCurriculo;
    }
    public Integer getCoModoEmpleo() {
        return this.coModoEmpleo;
    }
    
    public void setCoModoEmpleo(Integer coModoEmpleo) {
        this.coModoEmpleo = coModoEmpleo;
    }
    public String getDeEspecifique() {
        return this.deEspecifique;
    }
    
    public void setDeEspecifique(String deEspecifique) {
        this.deEspecifique = deEspecifique;
    }




}


