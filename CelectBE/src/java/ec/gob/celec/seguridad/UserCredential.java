/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.celec.seguridad;

import ec.gob.celec.persistencia.AdUsuario;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserCredential implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String account;
	String name;
        private Integer codigo;
        private Integer codigoEmpresa;
        private Integer codigoPersona;
        private Short codigoPerfil;
        private AdUsuario adUsuario;
	
	Set<String> roles = new HashSet<String>();

	public UserCredential(String account, String name,Integer codigo,Integer codigoPersona,Short codigoPerfil,AdUsuario adUsuario) {
		this.account = account;
		this.name = name;
                this.codigo=codigo;
                this.codigoPersona=codigoPersona;              
                this.codigoPerfil=codigoPerfil;
                this.adUsuario=adUsuario;	}

	public UserCredential() {
		this.account = "anonymous";
		this.name = "Anonymous";
		roles.add("anonymous");
	}

	public boolean isAnonymous() {
		return hasRole("anonymous") || "anonymous".equals(account);
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean hasRole(String role){
		return roles.contains(role);
	}
	
	public void addRole(String role){
		roles.add(role);
	}

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the codigoEmpresa
     */
    public Integer getCodigoEmpresa() {
        return codigoEmpresa;
    }

    /**
     * @param codigoEmpresa the codigoEmpresa to set
     */
    public void setCodigoEmpresa(Integer codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    /**
     * @return the codigoPersona
     */
    public Integer getCodigoPersona() {
        return codigoPersona;
    }

    /**
     * @param codigoPersona the codigoPersona to set
     */
    public void setCodigoPersona(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    /**
     * @return the codigoPerfil
     */
    public Short getCodigoPerfil() {
        return codigoPerfil;
    }

    /**
     * @param codigoPerfil the codigoPerfil to set
     */
    public void setCodigoPerfil(Short codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }

    /**
     * @return the adUsuario
     */
    public AdUsuario getAdUsuario() {
        return adUsuario;
    }

    /**
     * @param adUsuario the adUsuario to set
     */
    public void setAdUsuario(AdUsuario adUsuario) {
        this.adUsuario = adUsuario;
    }

}
