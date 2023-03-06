/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.List;
import modelo.daoSedes;
/**
 *
 * @author visitante
 */
public class clsSedes {
    
    private String codigo_sede;
    private String nombre_sede;
    private String estatus_sede;

    public clsSedes() {
    }

    public clsSedes(String codigo_sede) {
        this.codigo_sede = codigo_sede;
    }

    public clsSedes(String nombre_sede, String estatus_sede) {
        this.nombre_sede = nombre_sede;
        this.estatus_sede = estatus_sede;
    }

    public clsSedes(String codigo_sede, String nombre_sede, String estatus_sede) {
        this.codigo_sede = codigo_sede;
        this.nombre_sede = nombre_sede;
        this.estatus_sede = estatus_sede;
    }

    public String getCodigo_sede() {
        return codigo_sede;
    }

    public void setCodigo_sede(String codigo_sede) {
        this.codigo_sede = codigo_sede;
    }

    public String getNombre_sede() {
        return nombre_sede;
    }

    public void setNombre_sede(String nombre_sede) {
        this.nombre_sede = nombre_sede;
    }

    public String getEstatus_sede() {
        return estatus_sede;
    }

    public void setEstatus_sede(String estatus_sede) {
        this.estatus_sede = estatus_sede;
    }

    @Override
    public String toString() {
        return "clsSedes{" + "codigo_sede=" + codigo_sede + ", nombre_sede=" + nombre_sede + ", estatus_sede=" + estatus_sede + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsSedes getBuscarInformacionSedesPorNombre(clsSedes sede)
    {
        daoSedes daosede= new daoSedes ();
        return daosede.consultaSedePorNombre(sede);
    }
    public clsSedes getBuscarInformacionSedesPorId(clsSedes sede)
    {
        daoSedes daosede= new daoSedes();
        return daosede.consultaSedeporId(sede);
    }    
    public List<clsSedes> getListadoSedes()
    {
        daoSedes daosede = new daoSedes();
        List<clsSedes> listadoSedes = daosede.consultaSede();
        return listadoSedes;
    }
    public int setBorrarSede(clsSedes sede)
    {
        daoSedes daosede = new daoSedes();
        return daosede.borrarSede(sede);
    }          
    public int setIngresarSede(clsSedes sede)
    {
        daoSedes daosede = new  daoSedes();
        return daosede.ingresaSede(sede);
    }              
    public int setModificarSede(clsSedes sede)
    {
        daoSedes daosede = new daoSedes();
        return daosede.actualizaSede(sede);
    }              

}