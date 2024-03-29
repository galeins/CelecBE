package ec.gob.celec.persistencia;
// Generated 27/06/2014 11:55:07 AM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * BeOfertaEmpleo generated by hbm2java
 */
public class BeOfertaEmpleo  implements java.io.Serializable {


     private Integer coOfertaEmpleo;
     private BeCatalogo beCatalogoByCoAreaEstudio;
     private BeCatalogo beCatalogoByCoDepartamentoOfe;
     private BeCatalogo beCatalogoByCoRelaLabOferemp;
     private AdUsuario adUsuario;
     private BeEmpresa beEmpresa;
     private BeCatalogo beCatalogoByCoCategoriaOfertaOfe;
     private BeCatalogo beCatalogoByCoInstruccionOferemp;
     private String nbOfertaEmpleo;
     private String deDescripcionOferemp;
     private Integer coProvinciaOfermp;
     private Integer coCantonOferemp;
     private Integer coSectorOferemp;
     private String deBarrioOferemp;
     private int coSalarioOferemp;
     private Integer coUrgenOferemp;
     private Date feInivigenOferemp;
     private Date feFinvigenOferemp;
     private Integer coExpCargoOferemp;
     private Integer nuAniosExpCargoOferemp;
     private Integer nuVacntesOferemp;
     private String nbSupervisaaOferemp;
     private String nbSupervisadoxOferemp;
     private Integer coJornadaOferemp;
     private String deJornadaOferemp;
     private BigDecimal vaMensualOferemp;
     private String deConoCargoOferemp;
     private String deActiviCargoOferemp;
     private String deCategoriaOferemp;
     private int coTipoServicioOferemp;
     private String nbContactoOferemp;
     private String nuFonoContactoOferemp;
     private String nuCelularContactoOferemp;
     private String nuFaxContactoOferemp;
     private String deMailContactoOferemp;
     private String coDiscapacidadOferemp;
     private BigDecimal nuPorceDiscapacidaOferemp;
     private Integer coTipoDiscapacidadOferemp;
     private String deDiscapacidadOferemp;
     private String esOfertaEmpleo;
     private String deProcesoSelec;
     private String esSeleccion;
     private Date feCreacion;
     private String deSoloConquito;
     private String coCodigoOfertaOfe;
     private String vaPublicadoOfe;
     private BigDecimal vaAsignacionSalarialOfe;
     private Integer vaCodigoOfertaOfe;
     private String vaLocalidadOfe;
     private String vaObjetivoCargoOfe;
     private Integer vaPorcentajeDiscapacidadOfe;
     private String vaExperienciaRequeridaOfe;
     private String vaConocimientosRequeridosOfe;
     private String vaCompetenciasOfe;
     private Integer nuCapacitacion;
     private Set beComentarioOfertas = new HashSet(0);
     private Set beSelecionCvOfers = new HashSet(0);
     private Set bePesoOfertas = new HashSet(0);
     private Set beModoEmpleoOfertas = new HashSet(0);
     private Set beColocacions = new HashSet(0);
     private Set beCategOfertas = new HashSet(0);
     private Set beCalificacionEducacions = new HashSet(0);

    public BeOfertaEmpleo() {
    }

	
    public BeOfertaEmpleo(BeCatalogo beCatalogoByCoRelaLabOferemp, String nbOfertaEmpleo, int coSalarioOferemp, Date feInivigenOferemp, Date feFinvigenOferemp, int coTipoServicioOferemp) {
        this.beCatalogoByCoRelaLabOferemp = beCatalogoByCoRelaLabOferemp;
        this.nbOfertaEmpleo = nbOfertaEmpleo;
        this.coSalarioOferemp = coSalarioOferemp;
        this.feInivigenOferemp = feInivigenOferemp;
        this.feFinvigenOferemp = feFinvigenOferemp;
        this.coTipoServicioOferemp = coTipoServicioOferemp;
    }
    public BeOfertaEmpleo(BeCatalogo beCatalogoByCoAreaEstudio, BeCatalogo beCatalogoByCoDepartamentoOfe, BeCatalogo beCatalogoByCoRelaLabOferemp, AdUsuario adUsuario, BeEmpresa beEmpresa, BeCatalogo beCatalogoByCoCategoriaOfertaOfe, BeCatalogo beCatalogoByCoInstruccionOferemp, String nbOfertaEmpleo, String deDescripcionOferemp, Integer coProvinciaOfermp, Integer coCantonOferemp, Integer coSectorOferemp, String deBarrioOferemp, int coSalarioOferemp, Integer coUrgenOferemp, Date feInivigenOferemp, Date feFinvigenOferemp, Integer coExpCargoOferemp, Integer nuAniosExpCargoOferemp, Integer nuVacntesOferemp, String nbSupervisaaOferemp, String nbSupervisadoxOferemp, Integer coJornadaOferemp, String deJornadaOferemp, BigDecimal vaMensualOferemp, String deConoCargoOferemp, String deActiviCargoOferemp, String deCategoriaOferemp, int coTipoServicioOferemp, String nbContactoOferemp, String nuFonoContactoOferemp, String nuCelularContactoOferemp, String nuFaxContactoOferemp, String deMailContactoOferemp, String coDiscapacidadOferemp, BigDecimal nuPorceDiscapacidaOferemp, Integer coTipoDiscapacidadOferemp, String deDiscapacidadOferemp, String esOfertaEmpleo, String deProcesoSelec, String esSeleccion, Date feCreacion, String deSoloConquito, String coCodigoOfertaOfe, String vaPublicadoOfe, BigDecimal vaAsignacionSalarialOfe, Integer vaCodigoOfertaOfe, String vaLocalidadOfe, String vaObjetivoCargoOfe, Integer vaPorcentajeDiscapacidadOfe, String vaExperienciaRequeridaOfe, String vaConocimientosRequeridosOfe, String vaCompetenciasOfe, Set beComentarioOfertas, Set beSelecionCvOfers, Set bePesoOfertas, Set beModoEmpleoOfertas, Set beColocacions, Set beCategOfertas, Set beCalificacionEducacions) {
       this.beCatalogoByCoAreaEstudio = beCatalogoByCoAreaEstudio;
       this.beCatalogoByCoDepartamentoOfe = beCatalogoByCoDepartamentoOfe;
       this.beCatalogoByCoRelaLabOferemp = beCatalogoByCoRelaLabOferemp;
       this.adUsuario = adUsuario;
       this.beEmpresa = beEmpresa;
       this.beCatalogoByCoCategoriaOfertaOfe = beCatalogoByCoCategoriaOfertaOfe;
       this.beCatalogoByCoInstruccionOferemp = beCatalogoByCoInstruccionOferemp;
       this.nbOfertaEmpleo = nbOfertaEmpleo;
       this.deDescripcionOferemp = deDescripcionOferemp;
       this.coProvinciaOfermp = coProvinciaOfermp;
       this.coCantonOferemp = coCantonOferemp;
       this.coSectorOferemp = coSectorOferemp;
       this.deBarrioOferemp = deBarrioOferemp;
       this.coSalarioOferemp = coSalarioOferemp;
       this.coUrgenOferemp = coUrgenOferemp;
       this.feInivigenOferemp = feInivigenOferemp;
       this.feFinvigenOferemp = feFinvigenOferemp;
       this.coExpCargoOferemp = coExpCargoOferemp;
       this.nuAniosExpCargoOferemp = nuAniosExpCargoOferemp;
       this.nuVacntesOferemp = nuVacntesOferemp;
       this.nbSupervisaaOferemp = nbSupervisaaOferemp;
       this.nbSupervisadoxOferemp = nbSupervisadoxOferemp;
       this.coJornadaOferemp = coJornadaOferemp;
       this.deJornadaOferemp = deJornadaOferemp;
       this.vaMensualOferemp = vaMensualOferemp;
       this.deConoCargoOferemp = deConoCargoOferemp;
       this.deActiviCargoOferemp = deActiviCargoOferemp;
       this.deCategoriaOferemp = deCategoriaOferemp;
       this.coTipoServicioOferemp = coTipoServicioOferemp;
       this.nbContactoOferemp = nbContactoOferemp;
       this.nuFonoContactoOferemp = nuFonoContactoOferemp;
       this.nuCelularContactoOferemp = nuCelularContactoOferemp;
       this.nuFaxContactoOferemp = nuFaxContactoOferemp;
       this.deMailContactoOferemp = deMailContactoOferemp;
       this.coDiscapacidadOferemp = coDiscapacidadOferemp;
       this.nuPorceDiscapacidaOferemp = nuPorceDiscapacidaOferemp;
       this.coTipoDiscapacidadOferemp = coTipoDiscapacidadOferemp;
       this.deDiscapacidadOferemp = deDiscapacidadOferemp;
       this.esOfertaEmpleo = esOfertaEmpleo;
       this.deProcesoSelec = deProcesoSelec;
       this.esSeleccion = esSeleccion;
       this.feCreacion = feCreacion;
       this.deSoloConquito = deSoloConquito;
       this.coCodigoOfertaOfe = coCodigoOfertaOfe;
       this.vaPublicadoOfe = vaPublicadoOfe;
       this.vaAsignacionSalarialOfe = vaAsignacionSalarialOfe;
       this.vaCodigoOfertaOfe = vaCodigoOfertaOfe;
       this.vaLocalidadOfe = vaLocalidadOfe;
       this.vaObjetivoCargoOfe = vaObjetivoCargoOfe;
       this.vaPorcentajeDiscapacidadOfe = vaPorcentajeDiscapacidadOfe;
       this.vaExperienciaRequeridaOfe = vaExperienciaRequeridaOfe;
       this.vaConocimientosRequeridosOfe = vaConocimientosRequeridosOfe;
       this.vaCompetenciasOfe = vaCompetenciasOfe;
       this.beComentarioOfertas = beComentarioOfertas;
       this.beSelecionCvOfers = beSelecionCvOfers;
       this.bePesoOfertas = bePesoOfertas;
       this.beModoEmpleoOfertas = beModoEmpleoOfertas;
       this.beColocacions = beColocacions;
       this.beCategOfertas = beCategOfertas;
       this.beCalificacionEducacions = beCalificacionEducacions;
    }
   
    public Integer getCoOfertaEmpleo() {
        return this.coOfertaEmpleo;
    }
    
    public void setCoOfertaEmpleo(Integer coOfertaEmpleo) {
        this.coOfertaEmpleo = coOfertaEmpleo;
    }
    public BeCatalogo getBeCatalogoByCoAreaEstudio() {
        return this.beCatalogoByCoAreaEstudio;
    }
    
    public void setBeCatalogoByCoAreaEstudio(BeCatalogo beCatalogoByCoAreaEstudio) {
        this.beCatalogoByCoAreaEstudio = beCatalogoByCoAreaEstudio;
    }
    public BeCatalogo getBeCatalogoByCoDepartamentoOfe() {
        return this.beCatalogoByCoDepartamentoOfe;
    }
    
    public void setBeCatalogoByCoDepartamentoOfe(BeCatalogo beCatalogoByCoDepartamentoOfe) {
        this.beCatalogoByCoDepartamentoOfe = beCatalogoByCoDepartamentoOfe;
    }
    public BeCatalogo getBeCatalogoByCoRelaLabOferemp() {
        return this.beCatalogoByCoRelaLabOferemp;
    }
    
    public void setBeCatalogoByCoRelaLabOferemp(BeCatalogo beCatalogoByCoRelaLabOferemp) {
        this.beCatalogoByCoRelaLabOferemp = beCatalogoByCoRelaLabOferemp;
    }
    public AdUsuario getAdUsuario() {
        return this.adUsuario;
    }
    
    public void setAdUsuario(AdUsuario adUsuario) {
        this.adUsuario = adUsuario;
    }
    public BeEmpresa getBeEmpresa() {
        return this.beEmpresa;
    }
    
    public void setBeEmpresa(BeEmpresa beEmpresa) {
        this.beEmpresa = beEmpresa;
    }
    public BeCatalogo getBeCatalogoByCoCategoriaOfertaOfe() {
        return this.beCatalogoByCoCategoriaOfertaOfe;
    }
    
    public void setBeCatalogoByCoCategoriaOfertaOfe(BeCatalogo beCatalogoByCoCategoriaOfertaOfe) {
        this.beCatalogoByCoCategoriaOfertaOfe = beCatalogoByCoCategoriaOfertaOfe;
    }
    public BeCatalogo getBeCatalogoByCoInstruccionOferemp() {
        return this.beCatalogoByCoInstruccionOferemp;
    }
    
    public void setBeCatalogoByCoInstruccionOferemp(BeCatalogo beCatalogoByCoInstruccionOferemp) {
        this.beCatalogoByCoInstruccionOferemp = beCatalogoByCoInstruccionOferemp;
    }
    public String getNbOfertaEmpleo() {
        return this.nbOfertaEmpleo;
    }
    
    public void setNbOfertaEmpleo(String nbOfertaEmpleo) {
        this.nbOfertaEmpleo = nbOfertaEmpleo;
    }
    public String getDeDescripcionOferemp() {
        return this.deDescripcionOferemp;
    }
    
    public void setDeDescripcionOferemp(String deDescripcionOferemp) {
        this.deDescripcionOferemp = deDescripcionOferemp;
    }
    public Integer getCoProvinciaOfermp() {
        return this.coProvinciaOfermp;
    }
    
    public void setCoProvinciaOfermp(Integer coProvinciaOfermp) {
        this.coProvinciaOfermp = coProvinciaOfermp;
    }
    public Integer getCoCantonOferemp() {
        return this.coCantonOferemp;
    }
    
    public void setCoCantonOferemp(Integer coCantonOferemp) {
        this.coCantonOferemp = coCantonOferemp;
    }
    public Integer getCoSectorOferemp() {
        return this.coSectorOferemp;
    }
    
    public void setCoSectorOferemp(Integer coSectorOferemp) {
        this.coSectorOferemp = coSectorOferemp;
    }
    public String getDeBarrioOferemp() {
        return this.deBarrioOferemp;
    }
    
    public void setDeBarrioOferemp(String deBarrioOferemp) {
        this.deBarrioOferemp = deBarrioOferemp;
    }
    public int getCoSalarioOferemp() {
        return this.coSalarioOferemp;
    }
    
    public void setCoSalarioOferemp(int coSalarioOferemp) {
        this.coSalarioOferemp = coSalarioOferemp;
    }
    public Integer getCoUrgenOferemp() {
        return this.coUrgenOferemp;
    }
    
    public void setCoUrgenOferemp(Integer coUrgenOferemp) {
        this.coUrgenOferemp = coUrgenOferemp;
    }
    public Date getFeInivigenOferemp() {
        return this.feInivigenOferemp;
    }
    
    public void setFeInivigenOferemp(Date feInivigenOferemp) {
        this.feInivigenOferemp = feInivigenOferemp;
    }
    public Date getFeFinvigenOferemp() {
        return this.feFinvigenOferemp;
    }
    
    public void setFeFinvigenOferemp(Date feFinvigenOferemp) {
        this.feFinvigenOferemp = feFinvigenOferemp;
    }
    public Integer getCoExpCargoOferemp() {
        return this.coExpCargoOferemp;
    }
    
    public void setCoExpCargoOferemp(Integer coExpCargoOferemp) {
        this.coExpCargoOferemp = coExpCargoOferemp;
    }
    public Integer getNuAniosExpCargoOferemp() {
        return this.nuAniosExpCargoOferemp;
    }
    
    public void setNuAniosExpCargoOferemp(Integer nuAniosExpCargoOferemp) {
        this.nuAniosExpCargoOferemp = nuAniosExpCargoOferemp;
    }
    public Integer getNuVacntesOferemp() {
        return this.nuVacntesOferemp;
    }
    
    public void setNuVacntesOferemp(Integer nuVacntesOferemp) {
        this.nuVacntesOferemp = nuVacntesOferemp;
    }
    public String getNbSupervisaaOferemp() {
        return this.nbSupervisaaOferemp;
    }
    
    public void setNbSupervisaaOferemp(String nbSupervisaaOferemp) {
        this.nbSupervisaaOferemp = nbSupervisaaOferemp;
    }
    public String getNbSupervisadoxOferemp() {
        return this.nbSupervisadoxOferemp;
    }
    
    public void setNbSupervisadoxOferemp(String nbSupervisadoxOferemp) {
        this.nbSupervisadoxOferemp = nbSupervisadoxOferemp;
    }
    public Integer getCoJornadaOferemp() {
        return this.coJornadaOferemp;
    }
    
    public void setCoJornadaOferemp(Integer coJornadaOferemp) {
        this.coJornadaOferemp = coJornadaOferemp;
    }
    public String getDeJornadaOferemp() {
        return this.deJornadaOferemp;
    }
    
    public void setDeJornadaOferemp(String deJornadaOferemp) {
        this.deJornadaOferemp = deJornadaOferemp;
    }
    public BigDecimal getVaMensualOferemp() {
        return this.vaMensualOferemp;
    }
    
    public void setVaMensualOferemp(BigDecimal vaMensualOferemp) {
        this.vaMensualOferemp = vaMensualOferemp;
    }
    public String getDeConoCargoOferemp() {
        return this.deConoCargoOferemp;
    }
    
    public void setDeConoCargoOferemp(String deConoCargoOferemp) {
        this.deConoCargoOferemp = deConoCargoOferemp;
    }
    public String getDeActiviCargoOferemp() {
        return this.deActiviCargoOferemp;
    }
    
    public void setDeActiviCargoOferemp(String deActiviCargoOferemp) {
        this.deActiviCargoOferemp = deActiviCargoOferemp;
    }
    public String getDeCategoriaOferemp() {
        return this.deCategoriaOferemp;
    }
    
    public void setDeCategoriaOferemp(String deCategoriaOferemp) {
        this.deCategoriaOferemp = deCategoriaOferemp;
    }
    public int getCoTipoServicioOferemp() {
        return this.coTipoServicioOferemp;
    }
    
    public void setCoTipoServicioOferemp(int coTipoServicioOferemp) {
        this.coTipoServicioOferemp = coTipoServicioOferemp;
    }
    public String getNbContactoOferemp() {
        return this.nbContactoOferemp;
    }
    
    public void setNbContactoOferemp(String nbContactoOferemp) {
        this.nbContactoOferemp = nbContactoOferemp;
    }
    public String getNuFonoContactoOferemp() {
        return this.nuFonoContactoOferemp;
    }
    
    public void setNuFonoContactoOferemp(String nuFonoContactoOferemp) {
        this.nuFonoContactoOferemp = nuFonoContactoOferemp;
    }
    public String getNuCelularContactoOferemp() {
        return this.nuCelularContactoOferemp;
    }
    
    public void setNuCelularContactoOferemp(String nuCelularContactoOferemp) {
        this.nuCelularContactoOferemp = nuCelularContactoOferemp;
    }
    public String getNuFaxContactoOferemp() {
        return this.nuFaxContactoOferemp;
    }
    
    public void setNuFaxContactoOferemp(String nuFaxContactoOferemp) {
        this.nuFaxContactoOferemp = nuFaxContactoOferemp;
    }
    public String getDeMailContactoOferemp() {
        return this.deMailContactoOferemp;
    }
    
    public void setDeMailContactoOferemp(String deMailContactoOferemp) {
        this.deMailContactoOferemp = deMailContactoOferemp;
    }
    public String getCoDiscapacidadOferemp() {
        return this.coDiscapacidadOferemp;
    }
    
    public void setCoDiscapacidadOferemp(String coDiscapacidadOferemp) {
        this.coDiscapacidadOferemp = coDiscapacidadOferemp;
    }
    public BigDecimal getNuPorceDiscapacidaOferemp() {
        return this.nuPorceDiscapacidaOferemp;
    }
    
    public void setNuPorceDiscapacidaOferemp(BigDecimal nuPorceDiscapacidaOferemp) {
        this.nuPorceDiscapacidaOferemp = nuPorceDiscapacidaOferemp;
    }
    public Integer getCoTipoDiscapacidadOferemp() {
        return this.coTipoDiscapacidadOferemp;
    }
    
    public void setCoTipoDiscapacidadOferemp(Integer coTipoDiscapacidadOferemp) {
        this.coTipoDiscapacidadOferemp = coTipoDiscapacidadOferemp;
    }
    public String getDeDiscapacidadOferemp() {
        return this.deDiscapacidadOferemp;
    }
    
    public void setDeDiscapacidadOferemp(String deDiscapacidadOferemp) {
        this.deDiscapacidadOferemp = deDiscapacidadOferemp;
    }
    public String getEsOfertaEmpleo() {
        return this.esOfertaEmpleo;
    }
    
    public void setEsOfertaEmpleo(String esOfertaEmpleo) {
        this.esOfertaEmpleo = esOfertaEmpleo;
    }
    public String getDeProcesoSelec() {
        return this.deProcesoSelec;
    }
    
    public void setDeProcesoSelec(String deProcesoSelec) {
        this.deProcesoSelec = deProcesoSelec;
    }
    public String getEsSeleccion() {
        return this.esSeleccion;
    }
    
    public void setEsSeleccion(String esSeleccion) {
        this.esSeleccion = esSeleccion;
    }
    public Date getFeCreacion() {
        return this.feCreacion;
    }
    
    public void setFeCreacion(Date feCreacion) {
        this.feCreacion = feCreacion;
    }
    public String getDeSoloConquito() {
        return this.deSoloConquito;
    }
    
    public void setDeSoloConquito(String deSoloConquito) {
        this.deSoloConquito = deSoloConquito;
    }
    public String getCoCodigoOfertaOfe() {
        return this.coCodigoOfertaOfe;
    }
    
    public void setCoCodigoOfertaOfe(String coCodigoOfertaOfe) {
        this.coCodigoOfertaOfe = coCodigoOfertaOfe;
    }
    public String getVaPublicadoOfe() {
        return this.vaPublicadoOfe;
    }
    
    public void setVaPublicadoOfe(String vaPublicadoOfe) {
        this.vaPublicadoOfe = vaPublicadoOfe;
    }
    public BigDecimal getVaAsignacionSalarialOfe() {
        return this.vaAsignacionSalarialOfe;
    }
    
    public void setVaAsignacionSalarialOfe(BigDecimal vaAsignacionSalarialOfe) {
        this.vaAsignacionSalarialOfe = vaAsignacionSalarialOfe;
    }
    public Integer getVaCodigoOfertaOfe() {
        return this.vaCodigoOfertaOfe;
    }
    
    public void setVaCodigoOfertaOfe(Integer vaCodigoOfertaOfe) {
        this.vaCodigoOfertaOfe = vaCodigoOfertaOfe;
    }
    public String getVaLocalidadOfe() {
        return this.vaLocalidadOfe;
    }
    
    public void setVaLocalidadOfe(String vaLocalidadOfe) {
        this.vaLocalidadOfe = vaLocalidadOfe;
    }
    public String getVaObjetivoCargoOfe() {
        return this.vaObjetivoCargoOfe;
    }
    
    public void setVaObjetivoCargoOfe(String vaObjetivoCargoOfe) {
        this.vaObjetivoCargoOfe = vaObjetivoCargoOfe;
    }
    public Integer getVaPorcentajeDiscapacidadOfe() {
        return this.vaPorcentajeDiscapacidadOfe;
    }
    
    public void setVaPorcentajeDiscapacidadOfe(Integer vaPorcentajeDiscapacidadOfe) {
        this.vaPorcentajeDiscapacidadOfe = vaPorcentajeDiscapacidadOfe;
    }
    public String getVaExperienciaRequeridaOfe() {
        return this.vaExperienciaRequeridaOfe;
    }
    
    public void setVaExperienciaRequeridaOfe(String vaExperienciaRequeridaOfe) {
        this.vaExperienciaRequeridaOfe = vaExperienciaRequeridaOfe;
    }
    public String getVaConocimientosRequeridosOfe() {
        return this.vaConocimientosRequeridosOfe;
    }
    
    public void setVaConocimientosRequeridosOfe(String vaConocimientosRequeridosOfe) {
        this.vaConocimientosRequeridosOfe = vaConocimientosRequeridosOfe;
    }
    public String getVaCompetenciasOfe() {
        return this.vaCompetenciasOfe;
    }
    
    public void setVaCompetenciasOfe(String vaCompetenciasOfe) {
        this.vaCompetenciasOfe = vaCompetenciasOfe;
    }
    public Set getBeComentarioOfertas() {
        return this.beComentarioOfertas;
    }
    
    public void setBeComentarioOfertas(Set beComentarioOfertas) {
        this.beComentarioOfertas = beComentarioOfertas;
    }
    public Set getBeSelecionCvOfers() {
        return this.beSelecionCvOfers;
    }
    
    public void setBeSelecionCvOfers(Set beSelecionCvOfers) {
        this.beSelecionCvOfers = beSelecionCvOfers;
    }
    public Set getBePesoOfertas() {
        return this.bePesoOfertas;
    }
    
    public void setBePesoOfertas(Set bePesoOfertas) {
        this.bePesoOfertas = bePesoOfertas;
    }
    public Set getBeModoEmpleoOfertas() {
        return this.beModoEmpleoOfertas;
    }
    
    public void setBeModoEmpleoOfertas(Set beModoEmpleoOfertas) {
        this.beModoEmpleoOfertas = beModoEmpleoOfertas;
    }
    public Set getBeColocacions() {
        return this.beColocacions;
    }
    
    public void setBeColocacions(Set beColocacions) {
        this.beColocacions = beColocacions;
    }
    public Set getBeCategOfertas() {
        return this.beCategOfertas;
    }
    
    public void setBeCategOfertas(Set beCategOfertas) {
        this.beCategOfertas = beCategOfertas;
    }
    public Set getBeCalificacionEducacions() {
        return this.beCalificacionEducacions;
    }
    
    public void setBeCalificacionEducacions(Set beCalificacionEducacions) {
        this.beCalificacionEducacions = beCalificacionEducacions;
    }

    /**
     * @return the nuCapacitacion
     */
    public Integer getNuCapacitacion() {
        return nuCapacitacion;
    }

    /**
     * @param nuCapacitacion the nuCapacitacion to set
     */
    public void setNuCapacitacion(Integer nuCapacitacion) {
        this.nuCapacitacion = nuCapacitacion;
    }




}


