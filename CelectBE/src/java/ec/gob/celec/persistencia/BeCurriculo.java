package ec.gob.celec.persistencia;
// Generated 17/06/2014 12:52:51 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * BeCurriculo generated by hbm2java
 */
public class BeCurriculo  implements java.io.Serializable {


     private Integer coCurriculo;
     private BePersona bePersona;
     private String nbTituloCv;
     private String deCurriculo;
     private Integer coSalarioCv;
     private String coConduceCv;
     private String coLicenciaCv;
     private Integer coTipoLicenciaCv;
     private String coVehiculoCv;
     private Integer coTipoVehiculoCv;
     private String vaDiscapacidadCv;
     private BigDecimal dePorcentajeDiscaCv;
     private Integer coTipoDiscapacidadCv;
     private String deDiscapacidadCv;
     private String vaViajarCv;
     private Integer coAutorizaCv;
     private String vaEnviarOfertasCv;
     private String esCurriculo;
     private String deComentario;
     private String vaNombreCv;
     private String vaApellidoCv;
     private String vaCorreoCv;
     private Set beConocimientos = new HashSet(0);
     private Set beCapacitacions = new HashSet(0);
     private Set beFormAcademicas = new HashSet(0);
     private Set beRefePersonals = new HashSet(0);
     private Set beIdiomas = new HashSet(0);
     private Set beExpLaborals = new HashSet(0);
     private Set beColocacions = new HashSet(0);
     private Set beModoEmpleoCvs = new HashSet(0);
     private Set beComentarioCvs = new HashSet(0);
     private Set beCategoriaCvs = new HashSet(0);
     private Set beSelecionCvOfers = new HashSet(0);

    public BeCurriculo() {
    }

	
    public BeCurriculo(BePersona bePersona) {
        this.bePersona = bePersona;
    }
    public BeCurriculo(BePersona bePersona, String nbTituloCv, String deCurriculo, Integer coSalarioCv, String coConduceCv, String coLicenciaCv, Integer coTipoLicenciaCv, String coVehiculoCv, Integer coTipoVehiculoCv, String vaDiscapacidadCv, BigDecimal dePorcentajeDiscaCv, Integer coTipoDiscapacidadCv, String deDiscapacidadCv, String vaViajarCv, Integer coAutorizaCv, String vaEnviarOfertasCv, String esCurriculo, String deComentario, String vaNombreCv, String vaApellidoCv, String vaCorreoCv, Set beConocimientos, Set beCapacitacions, Set beFormAcademicas, Set beRefePersonals, Set beIdiomas, Set beExpLaborals, Set beColocacions, Set beModoEmpleoCvs, Set beComentarioCvs, Set beCategoriaCvs, Set beSelecionCvOfers) {
       this.bePersona = bePersona;
       this.nbTituloCv = nbTituloCv;
       this.deCurriculo = deCurriculo;
       this.coSalarioCv = coSalarioCv;
       this.coConduceCv = coConduceCv;
       this.coLicenciaCv = coLicenciaCv;
       this.coTipoLicenciaCv = coTipoLicenciaCv;
       this.coVehiculoCv = coVehiculoCv;
       this.coTipoVehiculoCv = coTipoVehiculoCv;
       this.vaDiscapacidadCv = vaDiscapacidadCv;
       this.dePorcentajeDiscaCv = dePorcentajeDiscaCv;
       this.coTipoDiscapacidadCv = coTipoDiscapacidadCv;
       this.deDiscapacidadCv = deDiscapacidadCv;
       this.vaViajarCv = vaViajarCv;
       this.coAutorizaCv = coAutorizaCv;
       this.vaEnviarOfertasCv = vaEnviarOfertasCv;
       this.esCurriculo = esCurriculo;
       this.deComentario = deComentario;
       this.vaNombreCv = vaNombreCv;
       this.vaApellidoCv = vaApellidoCv;
       this.vaCorreoCv = vaCorreoCv;
       this.beConocimientos = beConocimientos;
       this.beCapacitacions = beCapacitacions;
       this.beFormAcademicas = beFormAcademicas;
       this.beRefePersonals = beRefePersonals;
       this.beIdiomas = beIdiomas;
       this.beExpLaborals = beExpLaborals;
       this.beColocacions = beColocacions;
       this.beModoEmpleoCvs = beModoEmpleoCvs;
       this.beComentarioCvs = beComentarioCvs;
       this.beCategoriaCvs = beCategoriaCvs;
       this.beSelecionCvOfers = beSelecionCvOfers;
    }
   
    public Integer getCoCurriculo() {
        return this.coCurriculo;
    }
    
    public void setCoCurriculo(Integer coCurriculo) {
        this.coCurriculo = coCurriculo;
    }
    public BePersona getBePersona() {
        return this.bePersona;
    }
    
    public void setBePersona(BePersona bePersona) {
        this.bePersona = bePersona;
    }
    public String getNbTituloCv() {
        return this.nbTituloCv;
    }
    
    public void setNbTituloCv(String nbTituloCv) {
        this.nbTituloCv = nbTituloCv;
    }
    public String getDeCurriculo() {
        return this.deCurriculo;
    }
    
    public void setDeCurriculo(String deCurriculo) {
        this.deCurriculo = deCurriculo;
    }
    public Integer getCoSalarioCv() {
        return this.coSalarioCv;
    }
    
    public void setCoSalarioCv(Integer coSalarioCv) {
        this.coSalarioCv = coSalarioCv;
    }
    public String getCoConduceCv() {
        return this.coConduceCv;
    }
    
    public void setCoConduceCv(String coConduceCv) {
        this.coConduceCv = coConduceCv;
    }
    public String getCoLicenciaCv() {
        return this.coLicenciaCv;
    }
    
    public void setCoLicenciaCv(String coLicenciaCv) {
        this.coLicenciaCv = coLicenciaCv;
    }
    public Integer getCoTipoLicenciaCv() {
        return this.coTipoLicenciaCv;
    }
    
    public void setCoTipoLicenciaCv(Integer coTipoLicenciaCv) {
        this.coTipoLicenciaCv = coTipoLicenciaCv;
    }
    public String getCoVehiculoCv() {
        return this.coVehiculoCv;
    }
    
    public void setCoVehiculoCv(String coVehiculoCv) {
        this.coVehiculoCv = coVehiculoCv;
    }
    public Integer getCoTipoVehiculoCv() {
        return this.coTipoVehiculoCv;
    }
    
    public void setCoTipoVehiculoCv(Integer coTipoVehiculoCv) {
        this.coTipoVehiculoCv = coTipoVehiculoCv;
    }
    public String getVaDiscapacidadCv() {
        return this.vaDiscapacidadCv;
    }
    
    public void setVaDiscapacidadCv(String vaDiscapacidadCv) {
        this.vaDiscapacidadCv = vaDiscapacidadCv;
    }
    public BigDecimal getDePorcentajeDiscaCv() {
        return this.dePorcentajeDiscaCv;
    }
    
    public void setDePorcentajeDiscaCv(BigDecimal dePorcentajeDiscaCv) {
        this.dePorcentajeDiscaCv = dePorcentajeDiscaCv;
    }
    public Integer getCoTipoDiscapacidadCv() {
        return this.coTipoDiscapacidadCv;
    }
    
    public void setCoTipoDiscapacidadCv(Integer coTipoDiscapacidadCv) {
        this.coTipoDiscapacidadCv = coTipoDiscapacidadCv;
    }
    public String getDeDiscapacidadCv() {
        return this.deDiscapacidadCv;
    }
    
    public void setDeDiscapacidadCv(String deDiscapacidadCv) {
        this.deDiscapacidadCv = deDiscapacidadCv;
    }
    public String getVaViajarCv() {
        return this.vaViajarCv;
    }
    
    public void setVaViajarCv(String vaViajarCv) {
        this.vaViajarCv = vaViajarCv;
    }
    public Integer getCoAutorizaCv() {
        return this.coAutorizaCv;
    }
    
    public void setCoAutorizaCv(Integer coAutorizaCv) {
        this.coAutorizaCv = coAutorizaCv;
    }
    public String getVaEnviarOfertasCv() {
        return this.vaEnviarOfertasCv;
    }
    
    public void setVaEnviarOfertasCv(String vaEnviarOfertasCv) {
        this.vaEnviarOfertasCv = vaEnviarOfertasCv;
    }
    public String getEsCurriculo() {
        return this.esCurriculo;
    }
    
    public void setEsCurriculo(String esCurriculo) {
        this.esCurriculo = esCurriculo;
    }
    public String getDeComentario() {
        return this.deComentario;
    }
    
    public void setDeComentario(String deComentario) {
        this.deComentario = deComentario;
    }
    public String getVaNombreCv() {
        return this.vaNombreCv;
    }
    
    public void setVaNombreCv(String vaNombreCv) {
        this.vaNombreCv = vaNombreCv;
    }
    public String getVaApellidoCv() {
        return this.vaApellidoCv;
    }
    
    public void setVaApellidoCv(String vaApellidoCv) {
        this.vaApellidoCv = vaApellidoCv;
    }
    public String getVaCorreoCv() {
        return this.vaCorreoCv;
    }
    
    public void setVaCorreoCv(String vaCorreoCv) {
        this.vaCorreoCv = vaCorreoCv;
    }
    public Set getBeConocimientos() {
        return this.beConocimientos;
    }
    
    public void setBeConocimientos(Set beConocimientos) {
        this.beConocimientos = beConocimientos;
    }
    public Set getBeCapacitacions() {
        return this.beCapacitacions;
    }
    
    public void setBeCapacitacions(Set beCapacitacions) {
        this.beCapacitacions = beCapacitacions;
    }
    public Set getBeFormAcademicas() {
        return this.beFormAcademicas;
    }
    
    public void setBeFormAcademicas(Set beFormAcademicas) {
        this.beFormAcademicas = beFormAcademicas;
    }
    public Set getBeRefePersonals() {
        return this.beRefePersonals;
    }
    
    public void setBeRefePersonals(Set beRefePersonals) {
        this.beRefePersonals = beRefePersonals;
    }
    public Set getBeIdiomas() {
        return this.beIdiomas;
    }
    
    public void setBeIdiomas(Set beIdiomas) {
        this.beIdiomas = beIdiomas;
    }
    public Set getBeExpLaborals() {
        return this.beExpLaborals;
    }
    
    public void setBeExpLaborals(Set beExpLaborals) {
        this.beExpLaborals = beExpLaborals;
    }
    public Set getBeColocacions() {
        return this.beColocacions;
    }
    
    public void setBeColocacions(Set beColocacions) {
        this.beColocacions = beColocacions;
    }
    public Set getBeModoEmpleoCvs() {
        return this.beModoEmpleoCvs;
    }
    
    public void setBeModoEmpleoCvs(Set beModoEmpleoCvs) {
        this.beModoEmpleoCvs = beModoEmpleoCvs;
    }
    public Set getBeComentarioCvs() {
        return this.beComentarioCvs;
    }
    
    public void setBeComentarioCvs(Set beComentarioCvs) {
        this.beComentarioCvs = beComentarioCvs;
    }
    public Set getBeCategoriaCvs() {
        return this.beCategoriaCvs;
    }
    
    public void setBeCategoriaCvs(Set beCategoriaCvs) {
        this.beCategoriaCvs = beCategoriaCvs;
    }
    public Set getBeSelecionCvOfers() {
        return this.beSelecionCvOfers;
    }
    
    public void setBeSelecionCvOfers(Set beSelecionCvOfers) {
        this.beSelecionCvOfers = beSelecionCvOfers;
    }




}


