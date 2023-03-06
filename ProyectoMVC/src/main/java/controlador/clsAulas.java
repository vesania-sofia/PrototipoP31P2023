/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoAulas;
/**
 *
 * @author visitante
 */
public class clsAulas {
    private String codigoAula;
    private String NombreAula;
    private String EstatusAula;

    public String getCodidoAula() {
        return codigoAula;
    }

    public void setcodigoAula(String codigoAula) {
        this.codigoAula = codigoAula;
    }

    public String getNombreAula() {
        return NombreAula;
    }

    public void setNombreAula(String NombreAula) {
        this.NombreAula = NombreAula;
    }

    public String getEstatusAula() {
        return EstatusAula;
    }

    public void setEstatusAula(String EstatusAula) {
        this.EstatusAula = EstatusAula;
    }

    public clsAulas(String codigoAula, String NombreAula, String EstatusAula) {
        this.codigoAula = codigoAula;
        this.NombreAula = NombreAula;
        this.EstatusAula = EstatusAula;
    }

    public clsAulas(String NombreAula, String EstatusAula) {
        this.NombreAula = NombreAula;
        this.EstatusAula = EstatusAula;
    }

    public clsAulas(String codigoAula) {
        this.codigoAula = codigoAula;
    }

    public clsAulas() {
    }

    @Override
    public String toString() {
        return "clsAulas{" + "codigoAula=" + codigoAula + ", NombreAula=" + NombreAula + ", EstatusAula=" + EstatusAula + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsAulas getBuscarInformacionAulaPorNombre(clsAulas aula)
    {
        daoAulas daoaula = new daoAulas();
        return daoaula.consultaAulasPorNombre(aula);
    }
    public clsAulas getBuscarInformacionAulaPorCodigo(clsAulas aula)
    {
        daoAulas daoaula = new daoAulas();
        return daoaula.consultaAulasPorCodigo(aula);
    }    
    public List<clsAulas> getListadoAulas()
    {
        daoAulas daoaula = new daoAulas();
        List<clsAulas> listadoUsuarios = daoaula.consultaAulas();
        return listadoUsuarios;
    }
    public int setBorrarAulas(clsAulas aula)
    {
        daoAulas daoaula = new daoAulas();
        return daoaula.borrarAulas(aula);
    }          
    public int setIngresarAulas(clsAulas aula)
    {
        daoAulas daoaula = new daoAulas();
        return daoaula.ingresaAulas(aula);
    }              
    public int setModificarAulas(clsAulas aula)
    {
        daoAulas daoaula = new daoAulas();
        return daoaula.actualizaAulas(aula);
    }              
}
