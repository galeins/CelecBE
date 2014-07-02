/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.controlador.candidato;

import java.util.Map; 
import org.zkoss.bind.Property;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;

/**
 *
 * @author Personal
 */
public class ValidadorRegistrame extends AbstractValidator {

    public void validate(ValidationContext ctx) {                                         
         Map<String,Property> beanProps = ctx.getProperties(ctx.getProperty().getBase());         
         validarNombreUsuario(ctx,(String)beanProps.get("nbCuentaUsu").getValue()); 
         validarRepeticiónClave(ctx,(String)beanProps.get("deContrasenaUsu").getValue(),(String)ctx.getValidatorArg("claveRepetida"));
         
        //first let's check the passwords match
        //validarRepeticiónClave(vc, (String)beanProps.get("nbCuentaUsu").getValue(), (String)vc.getValidatorArg("claveRepetir"));
//        validateAge(vc, (Integer)beanProps.get("age").getValue());
//        validateWeight(vc, (Double)beanProps.get("weight").getValue());
//        validateEmail(vc, (String)beanProps.get("email").getValue());
//        validateCaptcha(vc, (String)ctx.getValidatorArg("captcha"), (String)ctx.getValidatorArg("captchaInput")); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void validarNombreUsuario(ValidationContext ctx,String nombreUsuario)
    {
        if (nombreUsuario==null)
            this.addInvalidMessage(ctx, "nbCuentaUsu","El nombre de usuario es obligatorio");
        
        
    }
      private void validarRepeticiónClave(ValidationContext ctx, String password, String retype) {
        if(password == null || retype == null || (!password.equals(retype))) {
            this.addInvalidMessage(ctx, "deContrasenaUsu", "Las claves ingresadas no coinciden!");
        }
    }
}
