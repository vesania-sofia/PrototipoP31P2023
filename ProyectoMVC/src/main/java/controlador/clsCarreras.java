/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoCarreras;
/**
 *
 * @author visitante
 */
public class clsCarreras {
    private String CodigoCarrera;
    private String NombreCarrera;
    private String CodFacultadCarrera;
    private String EstatusCarrera;

    public String getCodigoCarrera() {
        return CodigoCarrera;
    }

    public void setCodigoCarrera(String CodigoCarrera) {
        this.CodigoCarrera = CodigoCarrera;
    }

    public String getNombreCarrera() {
        return NombreCarrera;
    }

    public void setNombreCarrera(String NombreCarrera) {
        this.NombreCarrera = NombreCarrera;
    }

    public String getCodFacultadCarrera() {
        return CodFacultadCarrera;
    }

    public void setCodFacultadCarrera(String CodFacultadCarrera) {
        this.CodFacultadCarrera = CodFacultadCarrera;
    }

    public String getEstatusCarrera() {
        return EstatusCarrera;
    }

    public void setEstatusCarrera(String EstatusCarrera) {
        this.EstatusCarrera = EstatusCarrera;
    }

    public clsCarreras(String CodigoCarrera, String NombreCarrera, String CodFacultadCarrera, String EstatusCarrera) {
        this.CodigoCarrera = CodigoCarrera;
        this.NombreCarrera = NombreCarrera;
        this.CodFacultadCarrera = CodFacultadCarrera;
        this.EstatusCarrera = EstatusCarrera;
    }

    public clsCarreras(String NombreCarrera, String CodFacultadCarrera, String EstatusCarrera) {
        this.NombreCarrera = NombreCarrera;
        this.CodFacultadCarrera = CodFacultadCarrera;
        this.EstatusCarrera = EstatusCarrera;
    }

    public clsCarreras(String CodigoCarrera) {
        this.CodigoCarrera = CodigoCarrera;
    }

    public clsCarreras() {
    }

 
@Override
    public String toString() {
        return "clsCarreras{" + "CodigoCarrera=" + CodigoCarrera + ", NombreCarrera=" + NombreCarrera + ", CodFacultadaCarrera=" + CodFacultadCarrera + ", EstatusCarrera=" + EstatusCarrera + '}';
    }


    //Metodos de acceso a la capa controlador
    public clsCarreras getBuscarInformacionCarreraPorNombre(clsCarreras carrera)
    {
        daoCarreras daoCarrera = new daoCarreras();
        return daoCarrera.consultaCarreraPorNombre(carrera);
    }
    public clsCarreras getBuscarInformacionCarreranPorCodigo(clsCarreras carrera)
    {
        daoCarreras daoCarrera = new daoCarreras();
        return daoCarrera.consultaCarreraPorCodigo(carrera);
    }    
    public List<clsCarreras> getListadoCarrera()
    {
        daoCarreras daoCarrera = new daoCarreras();
        List<clsCarreras> listadoCarreras= daoCarrera.consultaCarrera();
        return listadoCarreras;
    }
    public int setBorrarCarrera(clsCarreras carrera)
    {
        daoCarreras daoCarrera = new daoCarreras();
        return daoCarrera.borrarCarrera(carrera);
    }          
    public int setIngresarCarreran(clsCarreras carrera)
    {
        daoCarreras daoCarrera = new daoCarreras();
        return daoCarrera.ingresaCarrera(carrera);
    }              
    public int setModificarCarrera(clsCarreras carrera)
    {
        daoCarreras daoCarrera = new daoCarreras();
        return daoCarrera.actualizaCarrera(carrera);
    }              
}
