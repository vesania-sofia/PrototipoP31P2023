/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsAlumnos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoAlumnos {

    private static final String SQL_SELECT = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM siu.alumnos";
    private static final String SQL_INSERT = "INSERT INTO siu.alumnos(carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE siu.alumnos SET nombre_alumno=?, direccion_alumno=?, telefono_alumno=?, email_alumno=?, estatus_allumno=? WHERE carnet_alumno = ?";
    private static final String SQL_DELETE = "DELETE FROM siu.alumnos WHERE carnet_alumno=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM siu.alumnos WHERE nombre_alumno = ?";
    private static final String SQL_SELECT_CARNET = "SELECT carnet_alumno, nombre_alumno, direccion_alumno, telefono_alumno, email_alumno, estatus_alumno FROM siu.alumnos WHERE carnet_alumnos = ?";    

    public List<clsAlumnos> consultaAlumnos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsAlumnos> alumnos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String carnet = rs.getString("carnet_alumno");
                String nombre = rs.getString("nombre_alumno");
                String direccion = rs.getString("direccion_alumno");
                String telefono = rs.getString("telefono_alumno");
                String email = rs.getString("email_alumno");
                String estatus = rs.getString("estatus_alumno");
                clsAlumnos alumno = new clsAlumnos();
                alumno.setCarnetAlumno(carnet);
                alumno.setNombreAlumno(nombre);
                alumno.setDireccionAlumno(direccion);
                alumno.setTelefonoAlumno(telefono);
                alumno.setEmailAlumno(email);
                alumno.setEstatusAlumno(estatus);
                alumnos.add(alumno);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return alumnos;
    }

    public int ingresaAlumnos(clsAlumnos alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumno.getCarnetAlumno());
            stmt.setString(2, alumno.getNombreAlumno());
            stmt.setString(3, alumno.getDireccionAlumno());
            stmt.setString(4, alumno.getTelefonoAlumno());
            stmt.setString(5, alumno.getEmailAlumno());
            stmt.setString(6, alumno.getEstatusAlumno());

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

    public int actualizaAlumnos(clsAlumnos alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alumno.getCarnetAlumno());
            stmt.setString(2, alumno.getNombreAlumno());
            stmt.setString(3, alumno.getDireccionAlumno());
            stmt.setString(4, alumno.getTelefonoAlumno());
            stmt.setString(5, alumno.getEmailAlumno());
            stmt.setString(6, alumno.getEstatusAlumno());

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

    public int borrarAlumnos(clsAlumnos alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, alumno.getCarnetAlumno());
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

    public clsAlumnos consultaAlumnosPorNombre(clsAlumnos alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + alumno);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, alumno.getNombreAlumno());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String carnet = rs.getString("carnet_alumno");
                String nombre = rs.getString("nombre_alumno");
                String direccion = rs.getString("direccion_alumno");
                String telefono = rs.getString("telefono_alumno");
                String email = rs.getString("email_alumno");
                String estatus = rs.getString("estatus_alumno");

                //usuario = new clsUsuario();
                alumno.setCarnetAlumno(carnet);
                alumno.setNombreAlumno(nombre);
                alumno.setDireccionAlumno(direccion);
                alumno.setTelefonoAlumno(telefono);
                alumno.setEmailAlumno(email);
                alumno.setEstatusAlumno(estatus);
                System.out.println(" registro consultado: " + alumno);                
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
        return alumno;
    }
    public clsAlumnos consultaAlumnosPorCarnet(clsAlumnos alumno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + alumno);
            stmt = conn.prepareStatement(SQL_SELECT_CARNET);
            stmt.setString(1, alumno.getCarnetAlumno());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String carnet = rs.getString("carnet_alumno");
                String nombre = rs.getString("nombre_alumno");
                String direccion = rs.getString("direccion_alumno");
                String telefono = rs.getString("telefono_alumno");
                String email = rs.getString("email_alumno");
                String estatus = rs.getString("estatus_alumno");

                //usuario = new clsUsuario();
                alumno.setCarnetAlumno(carnet);
                alumno.setNombreAlumno(nombre);
                alumno.setDireccionAlumno(direccion);
                alumno.setTelefonoAlumno(telefono);
                alumno.setEmailAlumno(email);
                alumno.setEstatusAlumno(estatus);
                System.out.println(" registro consultado: " + alumno);                
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
        return alumno;
    }    
}
