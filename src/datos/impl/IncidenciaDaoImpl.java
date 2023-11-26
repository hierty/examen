package datos.impl;

import database.Conexion;
import dominio.Incidencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import datos.IncidenciaDao;

public class IncidenciaDaoImpl implements IncidenciaDao<Incidencia> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public IncidenciaDaoImpl() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Incidencia> listar(String texto) {
        List<Incidencia> registros = new ArrayList<>();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM incidencias WHERE denunciante LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Incidencia(
                    rs.getInt("id"),
                    rs.getString("denunciante"),
                    rs.getString("urbanizacion"),
                    rs.getString("calle"),
                    rs.getString("referencias"),
                    rs.getString("descripcion"),
                    rs.getString("fecha")
                ));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Incidencia obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("INSERT INTO incidencias (denunciante, urbanizacion, calle, referencias, descripcion, fecha) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, obj.getDenunciante());
            ps.setString(2, obj.getUrbanizacion());
            ps.setString(3, obj.getCalle());
            ps.setString(4, obj.getReferencias());
            ps.setString(5, obj.getDescripcion());
            ps.setString(6, obj.getFecha());

            if (ps.executeUpdate() > 0) {
                resp = true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Incidencia obj) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE incidencias SET denunciante=?, urbanizacion=?, calle=?, referencias=?, descripcion=?, fecha=? WHERE id=?");
            ps.setString(1, obj.getDenunciante());
            ps.setString(2, obj.getUrbanizacion());
            ps.setString(3, obj.getCalle());
            ps.setString(4, obj.getReferencias());
            ps.setString(5, obj.getDescripcion());
            ps.setString(6, obj.getFecha());
            ps.setInt(7, obj.getId());

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean eliminar(int id) {
        resp = false;
        try {
            ps = CON.conectar().prepareStatement("DELETE FROM incidencias WHERE id=?");
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ps = null;
            CON.desconectar();
        }
        return resp;
    }
}
