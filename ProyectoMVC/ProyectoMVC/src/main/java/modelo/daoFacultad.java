/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsFacultad;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
//daoFacultad, Hecho por Nelson Josué Pineda Culajay, 9959-21-10015
public class daoFacultad {

   private static final String SQL_SELECT = "SELECT codigo_facultad, nombre_facultad, estatus_facultad FROM facultades";
    private static final String SQL_INSERT = "INSERT INTO facultades (codigo_facultad, nombre_facultad, estatus_facultad) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE facultades SET nombre_facultad=?, estatus_facultad=? WHERE codigo_facultad = ?";
    private static final String SQL_DELETE = "DELETE FROM facultades WHERE codigo_facultad=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_facultad, nombre_facultad, estatus_facultad FROM facultades WHERE nombre_facultad = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_facultad, nombre_facultad, estatus_facultad FROM facultades WHERE codigo_facultad = ?";    

    public List<clsFacultad> consultaFacultades() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsFacultad> facultades = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cod = rs.getString("codigo_facultad");
                String Nombre = rs.getString("nombre_facultad");
                String Estatus = rs.getString("estatus_facultad");
                clsFacultad facultad = new clsFacultad();
                facultad.setCodFacultad(cod);
                facultad.setNombreFacultad(Nombre);
                facultad.setEstatusFacultad(Estatus);
                facultades.add(facultad);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return facultades;
    }

    public int ingresaFacultades(clsFacultad facultad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, facultad.getCodFacultad());
            stmt.setString(2, facultad.getNombreFacultad());
            stmt.setString(3, facultad.getEstatusFacultad());
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

    public int actualizaFacultades(clsFacultad facultad) {
        Connection conn = null;
        PreparedStatement stmt =null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, facultad.getNombreFacultad());
            stmt.setString(2, facultad.getEstatusFacultad());
            stmt.setString(3, facultad.getCodFacultad());

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

    public int borrarFacultades(clsFacultad facultad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, facultad.getCodFacultad());
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

    public clsFacultad consultaFacultadesPorNombre(clsFacultad facultad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + facultad);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, facultad.getNombreFacultad());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cod = rs.getString("codigo_facultad");
                String Nombre = rs.getString("nombre_facultad");
                String Estatus = rs.getString("estatus_facultad");

                //usuario = new clsUsuario();
                facultad.setCodFacultad(cod);
                facultad.setNombreFacultad(Nombre);
                facultad.setEstatusFacultad(Estatus);
                System.out.println(" registro consultado: " + facultad);                
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
        return facultad;
    }
    public clsFacultad consultaFacultadesPorId(clsFacultad facultad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + facultad);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setString(1, facultad.getCodFacultad());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String cod = rs.getString("codigo_facultad");
                String Nombre = rs.getString("nombre_facultad");
                String Estatus = rs.getString("estatus_facultad");

                //usuario = new clsUsuario();
                facultad.setCodFacultad(cod);
                facultad.setNombreFacultad(Nombre);
                facultad.setEstatusFacultad(Estatus);
                System.out.println(" registro consultado: " + facultad);                
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
        return facultad;
    }    
}
