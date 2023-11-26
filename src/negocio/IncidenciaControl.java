package negocio;

import datos.impl.IncidenciaDaoImpl;
import dominio.Incidencia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import datos.IncidenciaDao;

public class IncidenciaControl {

    private final IncidenciaDao DATOS;
    private Incidencia obj;

    public IncidenciaControl() {
        this.DATOS = new IncidenciaDaoImpl();
        this.obj = new Incidencia();
    }

    private DefaultTableModel modeloTabla;

    public DefaultTableModel listar(String texto) {
        List<Incidencia> lista = new ArrayList<>();
        lista.addAll(DATOS.listar(texto));
        // Establecemos la columna del tableModel
        String[] titulos = {"ID", "DENUNCIANTE", "URBANIZACION", "CALLE", "REFERENCIAS", "DESCRIPCION", "FECHA", "CREATED_AT", "UPDATED_AT"};
        // Declaramos un vector que será el que agreguemos como registro al DefaultTableModel
        String[] registro = new String[9];
        // Agrego los títulos al DefaultTableModel
        this.modeloTabla = new DefaultTableModel(null, titulos);
        // Recorrer toda mi lista y la pasaré al DefaultTableModel
        for (Incidencia item : lista) {
            registro[0] = Integer.toString(item.getId());
            registro[1] = item.getDenunciante();
            registro[2] = item.getUrbanizacion();
            registro[3] = item.getCalle();
            registro[4] = item.getReferencias();
            registro[5] = item.getDescripcion();
            registro[6] = item.getFecha();
            this.modeloTabla.addRow(registro);
        }
        return this.modeloTabla;
    }

    public String insertar(Incidencia obj) {
        if (DATOS.insertar(obj)) {
            return "OK";
        } else {
            return "Error en el ingreso de datos.";
        }
    }

    public String actualizar(Incidencia obj) {
        if (DATOS.actualizar(obj)) {
            return "OK";
        } else {
            return "Error en la actualización de datos.";
        }
    }

    public String eliminar(int id) {
        if (DATOS.eliminar(id)) {
            return "OK";
        } else {
            return "Error en la eliminación de datos.";
        }
    }
}
