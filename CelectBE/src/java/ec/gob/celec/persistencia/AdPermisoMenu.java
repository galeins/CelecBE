package ec.gob.celec.persistencia;
// Generated 17/06/2014 12:52:51 AM by Hibernate Tools 3.2.1.GA



/**
 * AdPermisoMenu generated by hbm2java
 */
public class AdPermisoMenu  implements java.io.Serializable {


     private Integer coPermisoMenu;
     private AdMenuSistema adMenuSistema;
     private AdGrupoUsuario adGrupoUsuario;
     private short coTipoPermisoMenu;

    public AdPermisoMenu() {
    }

    public AdPermisoMenu(AdMenuSistema adMenuSistema, AdGrupoUsuario adGrupoUsuario, short coTipoPermisoMenu) {
       this.adMenuSistema = adMenuSistema;
       this.adGrupoUsuario = adGrupoUsuario;
       this.coTipoPermisoMenu = coTipoPermisoMenu;
    }
   
    public Integer getCoPermisoMenu() {
        return this.coPermisoMenu;
    }
    
    public void setCoPermisoMenu(Integer coPermisoMenu) {
        this.coPermisoMenu = coPermisoMenu;
    }
    public AdMenuSistema getAdMenuSistema() {
        return this.adMenuSistema;
    }
    
    public void setAdMenuSistema(AdMenuSistema adMenuSistema) {
        this.adMenuSistema = adMenuSistema;
    }
    public AdGrupoUsuario getAdGrupoUsuario() {
        return this.adGrupoUsuario;
    }
    
    public void setAdGrupoUsuario(AdGrupoUsuario adGrupoUsuario) {
        this.adGrupoUsuario = adGrupoUsuario;
    }
    public short getCoTipoPermisoMenu() {
        return this.coTipoPermisoMenu;
    }
    
    public void setCoTipoPermisoMenu(short coTipoPermisoMenu) {
        this.coTipoPermisoMenu = coTipoPermisoMenu;
    }




}


