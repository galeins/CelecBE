package ec.gob.celec.persistencia;
// Generated 17/06/2014 12:52:51 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AdUsuario generated by hbm2java
 */
public class AdUsuario  implements java.io.Serializable {


     private Integer coUsuario;
     private AdGrupoUsuario adGrupoUsuario;
     private String nbCuentaUsu;
     private String deContrasenaUsu;
     private Short coPreguntaSecretaUsu;
     private String deRespuestaSecretaUsu;
     private Date feRegistroUsu;
     private String esUsuario;
     private String esAsesorParaDcp;
     private Set adAuditorias = new HashSet(0);
     private Set beOfertaEmpleos = new HashSet(0);
     private Set bePersonas = new HashSet(0);
     private Set beColocacions = new HashSet(0);

    public AdUsuario() {
    }

	
    public AdUsuario(String nbCuentaUsu, String deContrasenaUsu, Date feRegistroUsu, String esUsuario) {
        this.nbCuentaUsu = nbCuentaUsu;
        this.deContrasenaUsu = deContrasenaUsu;
        this.feRegistroUsu = feRegistroUsu;
        this.esUsuario = esUsuario;
    }
    public AdUsuario(AdGrupoUsuario adGrupoUsuario, String nbCuentaUsu, String deContrasenaUsu, Short coPreguntaSecretaUsu, String deRespuestaSecretaUsu, Date feRegistroUsu, String esUsuario, String esAsesorParaDcp, Set adAuditorias, Set beOfertaEmpleos, Set bePersonas, Set beColocacions) {
       this.adGrupoUsuario = adGrupoUsuario;
       this.nbCuentaUsu = nbCuentaUsu;
       this.deContrasenaUsu = deContrasenaUsu;
       this.coPreguntaSecretaUsu = coPreguntaSecretaUsu;
       this.deRespuestaSecretaUsu = deRespuestaSecretaUsu;
       this.feRegistroUsu = feRegistroUsu;
       this.esUsuario = esUsuario;
       this.esAsesorParaDcp = esAsesorParaDcp;
       this.adAuditorias = adAuditorias;
       this.beOfertaEmpleos = beOfertaEmpleos;
       this.bePersonas = bePersonas;
       this.beColocacions = beColocacions;
    }
   
    public Integer getCoUsuario() {
        return this.coUsuario;
    }
    
    public void setCoUsuario(Integer coUsuario) {
        this.coUsuario = coUsuario;
    }
    public AdGrupoUsuario getAdGrupoUsuario() {
        return this.adGrupoUsuario;
    }
    
    public void setAdGrupoUsuario(AdGrupoUsuario adGrupoUsuario) {
        this.adGrupoUsuario = adGrupoUsuario;
    }
    public String getNbCuentaUsu() {
        return this.nbCuentaUsu;
    }
    
    public void setNbCuentaUsu(String nbCuentaUsu) {
        this.nbCuentaUsu = nbCuentaUsu;
    }
    public String getDeContrasenaUsu() {
        return this.deContrasenaUsu;
    }
    
    public void setDeContrasenaUsu(String deContrasenaUsu) {
        this.deContrasenaUsu = deContrasenaUsu;
    }
    public Short getCoPreguntaSecretaUsu() {
        return this.coPreguntaSecretaUsu;
    }
    
    public void setCoPreguntaSecretaUsu(Short coPreguntaSecretaUsu) {
        this.coPreguntaSecretaUsu = coPreguntaSecretaUsu;
    }
    public String getDeRespuestaSecretaUsu() {
        return this.deRespuestaSecretaUsu;
    }
    
    public void setDeRespuestaSecretaUsu(String deRespuestaSecretaUsu) {
        this.deRespuestaSecretaUsu = deRespuestaSecretaUsu;
    }
    public Date getFeRegistroUsu() {
        return this.feRegistroUsu;
    }
    
    public void setFeRegistroUsu(Date feRegistroUsu) {
        this.feRegistroUsu = feRegistroUsu;
    }
    public String getEsUsuario() {
        return this.esUsuario;
    }
    
    public void setEsUsuario(String esUsuario) {
        this.esUsuario = esUsuario;
    }
    public String getEsAsesorParaDcp() {
        return this.esAsesorParaDcp;
    }
    
    public void setEsAsesorParaDcp(String esAsesorParaDcp) {
        this.esAsesorParaDcp = esAsesorParaDcp;
    }
    public Set getAdAuditorias() {
        return this.adAuditorias;
    }
    
    public void setAdAuditorias(Set adAuditorias) {
        this.adAuditorias = adAuditorias;
    }
    public Set getBeOfertaEmpleos() {
        return this.beOfertaEmpleos;
    }
    
    public void setBeOfertaEmpleos(Set beOfertaEmpleos) {
        this.beOfertaEmpleos = beOfertaEmpleos;
    }
    public Set getBePersonas() {
        return this.bePersonas;
    }
    
    public void setBePersonas(Set bePersonas) {
        this.bePersonas = bePersonas;
    }
    public Set getBeColocacions() {
        return this.beColocacions;
    }
    
    public void setBeColocacions(Set beColocacions) {
        this.beColocacions = beColocacions;
    }




}


