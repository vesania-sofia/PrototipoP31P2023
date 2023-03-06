             /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.clsSedes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoSedes {

    private static final String SQL_SELECT = "SELECT codigo_sede, nombre_sede,estatus_sede FROM sedes";
    private static final String SQL_INSERT = "INSERT INTO sedes(codigo_sede, nombre_sede, estatus_sede) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE sedes SET nombre_sede=?, estatus_sede=? WHERE codigo_sede = ?";
    private static final String SQL_DELETE = "DELETE FROM sedes WHERE codigo_sede=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codigo_sede, nombre_sede, estatus_sede FROM jornadas WHERE nombre_sede = ?";
    private static final String SQL_SELECT_ID = "SELECT codigo_sede, nombre_sede, estatus_sede FROM sedes  WHERE codigo_sede = ?";    

    public List<clsSedes> consultaSede() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsSedes> sedes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_sede");
                String nombre = rs.getString("nombre_sede");
                String estatus = rs.getString("estatus_sede");
                clsSedes sede = new clsSedes();
                sede.setCodigo_sede(codigo);
                sede.setNombre_sede(nombre);
                sede.setEstatus_sede(estatus);
                sedes.add(sede);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return sedes;
    }

    public int ingresaSede(clsSedes sede) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, sede.getCodigo_sede());
            stmt.setString(2, sede.getNombre_sede());
            stmt.setString(3, sede.getEstatus_sede());

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

    public int actualizaSede(clsSedes sede) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, sede.getNombre_sede());
            stmt.setString(2, sede.getEstatus_sede());
            stmt.setString(3, sede.getCodigo_sede());

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

    public int borrarSede(clsSedes sede) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, sede.getCodigo_sede());
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

    public clsSedes consultaSedePorNombre(clsSedes sede) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + sede);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, sede.getNombre_sede());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_sede");
                String nombre = rs.getString("nombre_sede");
                String estatus = rs.getString("estatus_sede");

                //usuario = new clsUsuario();
                sede.setCodigo_sede(codigo);
                sede.setNombre_sede(nombre);
                sede.setEstatus_sede(estatus);
                System.out.println(" registro consultado: " + sede);                
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
        return sede;
    }
    public clsSedes consultaSedeporId(clsSedes sede) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + sede);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setString(1, sede.getCodigo_sede());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigo = rs.getString("codigo_sede");
                String nombre = rs.getString("nombre_sede");
                String estatus = rs.getString("estatus_sede");

                //usuario = new clsUsuario();
                sede.setCodigo_sede(codigo);
                sede.setNombre_sede(nombre);
                sede.setEstatus_sede(estatus);
                System.out.println(" registro consultado: " + sede);                
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
        return sede;
    }  
}
