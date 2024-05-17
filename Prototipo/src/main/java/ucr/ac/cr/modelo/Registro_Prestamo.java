package ucr.ac.cr.modelo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Registro_Prestamo {

    private String filePath = "prestamos.json";
    private ArrayList<Prestamo> listaPrestamos;

    public Registro_Prestamo() {
        this.listaPrestamos = leerJSON();
    }

    public void modificarPrestamo(Prestamo prestamo) {
        for (int i = 0; i < listaPrestamos.size(); i++) {
            if (prestamo.getId() == listaPrestamos.get(i).getId()) {
                listaPrestamos.set(i, prestamo);
                escribirJSON();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el préstamo");
    }

    public void agregarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
        escribirJSON();
    }

    public Prestamo buscarPrestamoBibliotecario(int id) {
        for (Prestamo prestamo : listaPrestamos) {
            if (id == prestamo.getId()) {
                JOptionPane.showMessageDialog(null, "Se encontró el préstamo");
                return prestamo;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el préstamo");
        return null;
    }

    public Prestamo buscarPrestamoEstudiante(String carnet) {
        for (Prestamo prestamo : listaPrestamos) {
            if (carnet.equals(prestamo.getCarnet())) {
                JOptionPane.showMessageDialog(null, "Se encontró el préstamo");
                return prestamo;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el préstamo");
        return null;
    }

    public void eliminarPrestamo(Prestamo prestamo) {
        listaPrestamos.remove(prestamo);
        escribirJSON();
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    private void escribirJSON() {
        JSONArray jsonArray = new JSONArray();

        for (Prestamo prestamo : listaPrestamos) {
            JSONObject newObject = new JSONObject();

            newObject.put("id", prestamo.getId());
            newObject.put("carnet", prestamo.getCarnet());

            // Construir un JSONArray para los libros solicitados
            JSONArray librosArray = new JSONArray();
            for (Libro libro : prestamo.getLibro_Solicitidos()) {
                JSONObject libroObject = new JSONObject();
                libroObject.put("id", libro.getId());
                libroObject.put("titulo", libro.getTitulo());
                libroObject.put("editorial", libro.getEditorial());
                libroObject.put("estado", libro.isEstado());
                libroObject.put("ano", libro.getAno());
                libroObject.put("genero", libro.getGenero());
                libroObject.put("autor", libro.getAutor());
                librosArray.add(libroObject);
            }
            newObject.put("libro_Solicitados", librosArray);

            newObject.put("fecha_Inicio", prestamo.getFecha_Inicio().toString());
            newObject.put("fecha_fin", prestamo.getFecha_fin().toString());

            jsonArray.add(newObject);
        }

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Prestamo> leerJSON() {
        ArrayList<Prestamo> listaPrestamos = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            // Verificar el tamaño del archivo antes de intentar parsearlo
            if (reader.ready()) {
                Object obj = parser.parse(reader);

                if (obj instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) obj;

                    for (Object object : jsonArray) {
                        JSONObject jsonObject = (JSONObject) object;
                        int id = jsonObject.get("id") != null ? ((Long) jsonObject.get("id")).intValue() : 0;
                        String carnet = (String) jsonObject.get("carnet");
                        ArrayList<Libro> librosSolicitados = new ArrayList<>();

                        // Verificar si "librosArray" está presente y no es nulo
                        JSONArray librosArray = (JSONArray) jsonObject.get("libro_Solicitados");
                        if (librosArray != null) {
                            for (Object libroObject : librosArray) {
                                JSONObject libroJSON = (JSONObject) libroObject;
                                int libroId = libroJSON.get("id") != null ? ((Long) libroJSON.get("id")).intValue() : 0;
                                String titulo = (String) libroJSON.get("titulo");
                                String editorial = (String) libroJSON.get("editorial");
                                boolean estado = (boolean) libroJSON.get("estado");
                                int ano = libroJSON.get("ano") != null ? ((Long) libroJSON.get("ano")).intValue() : 0;
                                String genero = (String) libroJSON.get("genero");
                                String autor = (String) libroJSON.get("autor");

                                Libro libro = new Libro(libroId, titulo, editorial, estado, ano, genero, autor);
                                librosSolicitados.add(libro);
                            }
                        }

                        String fechaInicioStr = (String) jsonObject.get("fecha_Inicio");
                        String fechaFinStr = (String) jsonObject.get("fecha_fin");

                        if (fechaInicioStr != null && fechaFinStr != null) {
                            try {
                                LocalDate fecha_Inicio = LocalDate.parse(fechaInicioStr);
                                LocalDate fecha_fin = LocalDate.parse(fechaFinStr);

                                Prestamo prestamo = new Prestamo(id, carnet, librosSolicitados, fecha_Inicio, fecha_fin);
                                listaPrestamos.add(prestamo);
                            } catch (DateTimeParseException e) {
                                // Manejar el error de parseo de fecha aquí
                                e.printStackTrace();
                            }
                        } else {
                            // Manejar el caso en que la cadena de texto sea nula
                            System.out.println("La cadena de texto de fecha es nula.");
                        }
                    }
                } else {
                    System.out.println("El archivo JSON está vacío.");
                }
            } else {
                System.out.println("El archivo JSON está vacío.");
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return listaPrestamos;
    }

}
