/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoSecciones;
/**
 *
 * @author visitante
 */
public class clsSecciones {
    private String CodigoSeccion;
    private String NombreSeccion;
    private String EstatusSeccion;

    public String getCodigoSeccion() {
        return CodigoSeccion;
    }

    public void setCodigoSeccion(String CodigoSeccion) {
        this.CodigoSeccion = CodigoSeccion;
    }

    public String getNombreSeccion() {
        return NombreSeccion;
    }

    public void setNombreSeccion(String NombreSeccion) {
        this.NombreSeccion = NombreSeccion;
    }

    public String getEstatusSeccion() {
        return EstatusSeccion;
    }

    public void setEstatusSeccion(String EstatusSeccion) {
        this.EstatusSeccion = EstatusSeccion;
    }

    public clsSecciones(String CodigoSeccion, String NombreSeccion, String EstatusSeccion) {
        this.CodigoSeccion = CodigoSeccion;
        this.NombreSeccion = NombreSeccion;
        this.EstatusSeccion = EstatusSeccion;
    }

    public clsSecciones(String CodigoSeccion, String NombreSeccion) {
        this.CodigoSeccion = CodigoSeccion;
        this.NombreSeccion = NombreSeccion;
    }

    public clsSecciones(String CodigoSeccion) {
        this.CodigoSeccion = CodigoSeccion;
    }

    public clsSecciones() {
    }

    
    @Override
    public String toString() {
        return "clsSecciones{" + "CodigoSeccion=" + CodigoSeccion + ", NombreSeccion=" + NombreSeccion + ", EstatusSeccion=" + EstatusSeccion + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsSecciones getBuscarInformacionSeccionesPorNombre(clsSecciones seccion)
    {
        daoSecciones daosecciones = new daoSecciones();
        return daosecciones.consultaSeccionesPorNombre(seccion);
    }
    public clsSecciones getBuscarInformacionSeccionesPorCodigo(clsSecciones seccion)
    {
        daoSecciones daosecciones = new daoSecciones();
        return daosecciones.consultaSeccionesPorCodigo(seccion);
    }    
    public List<clsSecciones> getListadoSecciones()
    {
        daoSecciones daosecciones = new daoSecciones();
        List<clsSecciones> listadoSecciones = daosecciones.consultaSecciones();
        return listadoSecciones;
    }
    public int setBorrarSecciones(clsSecciones seccion)
    {
        daoSecciones daosecciones = new daoSecciones();
        return daosecciones.borrarSecciones(seccion);
    }          
    public int setIngresarSecciones(clsSecciones seccion)
    {
        daoSecciones daosecciones = new daoSecciones();
        return daosecciones.ingresaSecciones(seccion);
    }              
    public int setModificarSecciones(clsSecciones seccion)
    {
        daoSecciones daosecciones = new daoSecciones();
        return daosecciones.actualizaSecciones(seccion);
    }              
}
