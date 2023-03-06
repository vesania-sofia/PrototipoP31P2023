/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoFacultad;
/**
 *
 * @author visitante
 */
//clsFacultad, Hecho por Nelson Josué Pineda Culajay, 9959-21-10015
public class clsFacultad {
    private String CodFacultad;
    private String NombreFacultad;
    private String EstatusFacultad;

    public clsFacultad() {
    }

    public clsFacultad(String CodFacultad) {
        this.CodFacultad = CodFacultad;
    }

    public clsFacultad(String CodFacultad, String NombreFacultad) {
        this.CodFacultad = CodFacultad;
        this.NombreFacultad = NombreFacultad;
    }

    public clsFacultad(String CodFacultad, String NombreFacultad, String EstatusFacultad) {
        this.CodFacultad = CodFacultad;
        this.NombreFacultad = NombreFacultad;
        this.EstatusFacultad = EstatusFacultad;
    }

    public String getCodFacultad() {
        return CodFacultad;
    }

    public void setCodFacultad(String CodFacultad) {
        this.CodFacultad = CodFacultad;
    }

    public String getNombreFacultad() {
        return NombreFacultad;
    }

    public void setNombreFacultad(String NombreFacultad) {
        this.NombreFacultad = NombreFacultad;
    }

    public String getEstatusFacultad() {
        return EstatusFacultad;
    }

    public void setEstatusFacultad(String EstatusFacultad) {
        this.EstatusFacultad = EstatusFacultad;
    }


    @Override
    public String toString() {
        return "clsFacultad{" + "CodFacultad=" + CodFacultad + ", NombreFacultad=" + NombreFacultad + ",EstatusFacultad=" + EstatusFacultad + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsFacultad getBuscarInformacionFacultadPorNombre(clsFacultad facultad)
    {
        daoFacultad daofacultad = new daoFacultad();
        return daofacultad.consultaFacultadesPorNombre(facultad);
    }
    public clsFacultad getBuscarInformacionFacultadPorId(clsFacultad facultad)
    {
        daoFacultad daofacultad = new daoFacultad();
        return daofacultad.consultaFacultadesPorId(facultad);
    }    
    public List<clsFacultad> getListadoFacultades()
    {
        daoFacultad daofacultad = new daoFacultad();
        List<clsFacultad> listadoFacultades = daofacultad.consultaFacultades();
        return listadoFacultades;
    }
    public int setBorrarFacultad(clsFacultad facultad)
    {
        daoFacultad daofacultad= new daoFacultad();
        return daofacultad.borrarFacultades(facultad);
    }          
    public int setIngresarFacultad(clsFacultad facultad)
    {
        daoFacultad daofacultad = new daoFacultad();
        return daofacultad.ingresaFacultades(facultad);
    }              
    public int setModificarFacultad(clsFacultad facultad)
    {
        daoFacultad daofacultad = new daoFacultad();
        return daofacultad.actualizaFacultades(facultad);
    }              
}
