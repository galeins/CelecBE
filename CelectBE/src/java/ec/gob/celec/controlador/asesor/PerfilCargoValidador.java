/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.asesor;

import ec.gob.celec.persistencia.BeCatalogo;
import java.math.BigDecimal;
import java.util.Date;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import java.util.Map;
import org.zkoss.bind.Property;

/**
 *
 * @author Personal
 */
public class PerfilCargoValidador  extends AbstractValidator{

    public void validate(ValidationContext ctx) {
       Map<String,Property> beanProps = ctx.getProperties(ctx.getProperty().getBase());
         
     //  validarDenominacionCargo(ctx)
       validarCatalogo(ctx, (BeCatalogo)beanProps.get("beCatalogoByCoCategoriaOfertaOfe").getValue());
       validarCatalogo(ctx, (BeCatalogo)beanProps.get("beCatalogoByCoDepartamentoOfe").getValue());
       validarCatalogo(ctx, (BeCatalogo)beanProps.get("beCatalogoByCoRelaLabOferemp").getValue());
       validarCatalogo(ctx, (BeCatalogo)beanProps.get("beCatalogoByCoInstruccionOferemp").getValue());
       validarCatalogo(ctx, (BeCatalogo)beanProps.get("beCatalogoByCoAreaEstudio").getValue());       
       validarAsignacionSalarial(ctx, (BigDecimal) beanProps.get("vaMensualOferemp").getValue());         
       validarTexto(ctx,(String) beanProps.get("vaLocalidadOfe").getValue());  
       validarEntero(ctx,(Integer) beanProps.get("nuVacntesOferemp").getValue());
       validarTexto(ctx,(String) beanProps.get("vaObjetivoCargoOfe").getValue());
       validarTexto(ctx,(String) beanProps.get("esOfertaEmpleo").getValue());
       validarFecha(ctx, (Date)beanProps.get("feInivigenOferemp").getValue(),(Date)beanProps.get("feFinvigenOferemp").getValue());
       //validarEntero(ctx,(Integer) beanProps.get("nuAniosExpCargoOferemp").getValue());
       validarTexto(ctx,(String) beanProps.get("vaExperienciaRequeridaOfe").getValue());
       validarTexto(ctx,(String) beanProps.get("vaConocimientosRequeridosOfe").getValue());
       validarTexto(ctx,(String) beanProps.get("vaCompetenciasOfe").getValue());
   }
    
    public void validarFecha(ValidationContext ctx,Date fechaInicial, Date fechaFinal)
    {
        if (fechaInicial == null || fechaFinal == null)
            this.addInvalidMessage(ctx, "FechaError", "Debe ingresar fechas de inicio y fin.");
        if (fechaFinal.before(fechaInicial))
         this.addInvalidMessage(ctx, "FechaError", "La fecha final debe ser mayor a la fecha inicial.");
    }
    public void validarTexto(ValidationContext ctx,String valorString)
    {
        if (valorString == null)
             this.addInvalidMessage(ctx, "Error", "Mensaje de error");
    }
    
    public void validarCatalogo(ValidationContext ctx, BeCatalogo beCatalogo)
    {
        if (beCatalogo.getCoCatalogo()== null)
             this.addInvalidMessage(ctx, "Error", "Mensaje de error");

    }
    
    public void validarEntero(ValidationContext ctx,Integer valorEntero)
    {
        if (valorEntero == null || valorEntero<0)
            this.addInvalidMessage(ctx, "Error", "Mensaje de error");
    }
    
    public void validarAsignacionSalarial(ValidationContext ctx,BigDecimal valorAsignacionSalarial)
    {
      if (valorAsignacionSalarial.compareTo(BigDecimal.ZERO) ==-1)
        this.addInvalidMessage(ctx, "Error", "Mensaje de error");
     
    }
}
