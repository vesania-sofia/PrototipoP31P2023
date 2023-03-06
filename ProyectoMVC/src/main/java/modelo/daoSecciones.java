/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsSecciones;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoSecciones {

    private static final String SQL_SELECT = "SELECT codigo_seccion, nombre_seccion, estatus_seccion FROM secciones";
    private static final String SQL_INSERT = "INSERT INTO secciones(codigo_seccion, nombre_seccion, estatus_seccion) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE secciones SET nombre_seccion=?, estatus_seccion=? WHERE codigo_seccion = ?";
    private static final String SQL_DELETE = "DELETE FROM secciones WHERE codigo_seccion=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_seccion, nombre_seccion, estatus_seccion FROM secciones WHERE nombre_seccion = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_seccion, nombre_seccion, estatus_seccion FROM secciones WHERE codigo_seccion = ?";    

    public List<clsSecciones> consultaSecciones() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsSecciones> secciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_seccion");
                String nombre = rs.getString("nombre_seccion");
                String estatus = rs.getString("estatus_seccion");
                clsSecciones seccion = new clsSecciones();
                seccion.setCodigoSeccion(codigo);
                seccion.setNombreSeccion(nombre);
                seccion.setEstatusSeccion(estatus);
                secciones.add(seccion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return secciones;
    }

    public int ingresaSecciones(clsSecciones seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, seccion.getCodigoSeccion());
            stmt.setString(2, seccion.getNombreSeccion());
            stmt.setString(3, seccion.getEstatusSeccion());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaSecciones(clsSecciones seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, seccion.getCodigoSeccion());
            stmt.setString(2, seccion.getNombreSeccion());
            stmt.setString(3, seccion.getEstatusSeccion());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarSecciones(clsSecciones seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, seccion.getCodigoSeccion());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsSecciones consultaSeccionesPorNombre(clsSecciones seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + seccion);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, seccion.getNombreSeccion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_seccion");
                String nombre = rs.getString("nombre_seccion");
                String estatus = rs.getString("estatus_seccion");

                //usuario = new clsUsuario();
                seccion.setCodigoSeccion(codigo);
                seccion.setNombreSeccion(nombre);
                seccion.setEstatusSeccion(estatus);
                System.out.println(" registro consultado: " + seccion);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return seccion;
    }
    public clsSecciones consultaSeccionesPorCodigo(clsSecciones seccion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + seccion);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setString(1, seccion.getCodigoSeccion());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_seccion");
                String nombre = rs.getString("nombre_seccion");
                String estatus = rs.getString("estatus_seccion");

                //usuario = new clsUsuario();
                seccion.setCodigoSeccion(codigo);
                seccion.setNombreSeccion(nombre);
                seccion.setEstatusSeccion(estatus);
                System.out.println(" registro consultado: " + seccion);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return seccion;
    }    
}
