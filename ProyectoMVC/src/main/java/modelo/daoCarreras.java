/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsCarreras;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCarreras {

    private static final String SQL_SELECT = "SELECT codigo_carrera, nombre_carrera , codigo_facultad, estatus_carrera FROM carreras";
    private static final String SQL_INSERT = "INSERT INTO carreras(nombre_carrera , codigo_facultad, estatus_carrera) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE carreras SET nombre_carrera=?, codigo_facultad=?, estatus_carrera=? WHERE codigo_carrera=?";
    private static final String SQL_DELETE = "DELETE FROM carreras WHERE codigo_carrera=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera FROM carreras WHERE nombre_carrera = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_carrera, nombre_carrera, codigo_facultad, estatus_carrera FROM carreras WHERE codigo_carrera = ?";    

    public List<clsCarreras> consultaCarrera() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsCarreras> Carreras = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                String codfacultada = rs.getString("codigo_facultad");
                String estatus = rs.getString("estatus_carrera");
                clsCarreras Carrera = new clsCarreras();
                Carrera.setCodigoCarrera(codigo);
                Carrera.setNombreCarrera(nombre);
                Carrera.setCodFacultadCarrera(codfacultada);
                Carrera.setEstatusCarrera(estatus);
                Carreras.add(Carrera);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return Carreras;
    }

    public int ingresaCarrera(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, carrera.getNombreCarrera());
            stmt.setString(2, carrera.getCodFacultadCarrera());
            stmt.setString(3, carrera.getEstatusCarrera());

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

    public int actualizaCarrera(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, carrera.getNombreCarrera());
            stmt.setString(2, carrera.getCodFacultadCarrera());
            stmt.setString(3, carrera.getEstatusCarrera());
            stmt.setString(4, carrera.getCodigoCarrera());

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

    public int borrarCarrera(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, carrera.getCodigoCarrera());
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

    public clsCarreras consultaCarreraPorNombre(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + carrera);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, carrera.getNombreCarrera());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                String codfacultad = rs.getString("codigo_facultad");
                String estatus = rs.getString("estatus_carrera");

                //usuario = new clsUsuario();
                carrera.setCodigoCarrera(codigo);
                carrera.setNombreCarrera(nombre);
                carrera.setCodFacultadCarrera(codfacultad);
                carrera.setEstatusCarrera(estatus);
                System.out.println(" registro consultado: " + carrera);                
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
        return carrera;
    }
    public clsCarreras consultaCarreraPorCodigo(clsCarreras carrera) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + carrera);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setString(1, carrera.getCodigoCarrera());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_carrera");
                String nombre = rs.getString("nombre_carrera");
                String codfacultad = rs.getString("codigo_facultad");
                String estatus = rs.getString("estatus_carrera");

                //usuario = new clsUsuario();
                carrera.setCodigoCarrera(codigo);
                carrera.setNombreCarrera(nombre);
                carrera.setCodFacultadCarrera(codfacultad);
                carrera.setEstatusCarrera(estatus);
                System.out.println(" registro consultado: " + carrera);                
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
        return carrera;
    }    
}
