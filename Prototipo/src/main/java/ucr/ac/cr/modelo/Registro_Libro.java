package ucr.ac.cr.modelo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Registro_Libro {

    private ArrayList<Libro> listaLibros;
    private String filePath = "libros.json";

    public Registro_Libro() {
        this.listaLibros = leerJSON();
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
        escribirJSON();
    }

    public void modificarLibro(Libro libro) {
        for (int i = 0; i < listaLibros.size(); i++) {
            if (libro.getId() == listaLibros.get(i).getId()) {
                listaLibros.set(i, libro);
                escribirJSON();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el libro");
    }

    public Libro buscarLibro(int id) {
         boolean encontrado = false;
        int i = listaLibros.size() - 1;
        while (!encontrado && 0 <= i) {
            if (id == listaLibros.get(i).getId()) {
                encontrado = true;
                Libro libro = listaLibros.get(i);
                JOptionPane.showMessageDialog(null, "Se encontró el Libro");
                escribirJSON();
                return libro;
            }
            i--;
        }
        JOptionPane.showMessageDialog(null, "No se encontró el Libro");
        return null;
    }

      public ArrayList<Libro> buscarPorTitulo(String titulo) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && !libro.isEstado()) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public ArrayList<Libro> buscarPorEditorial(String editorial) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getEditorial().equalsIgnoreCase(editorial) && !libro.isEstado()) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public ArrayList<Libro> buscarPorAno(int ano) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getAno() == ano && !libro.isEstado()) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public ArrayList<Libro> buscarPorGenero(String genero) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getGenero().equalsIgnoreCase(genero) && !libro.isEstado()) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public ArrayList<Libro> buscarPorAutor(String autor) {
        ArrayList<Libro> resultados = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getAutor().equalsIgnoreCase(autor) && !libro.isEstado()) {
                resultados.add(libro);
            }
        }
        return resultados;
    }
    
    public void eliminarLibro(Libro libro) {
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == libro.getId()) {
                listaLibros.remove(i);
                escribirJSON();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el libro");
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    private void escribirJSON() {
        JSONArray jsonArray = new JSONArray();

        for (Libro libro : listaLibros) {
            JSONObject newObject = new JSONObject();

            newObject.put("id", libro.getId());
            newObject.put("titulo", libro.getTitulo());
            newObject.put("editorial", libro.getEditorial());
            newObject.put("estado", libro.isEstado());
            newObject.put("ano", libro.getAno());
            newObject.put("genero", libro.getGenero());
            newObject.put("autor", libro.getAutor());

            jsonArray.add(newObject);
        }

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  private ArrayList<Libro> leerJSON() {
    ArrayList<Libro> listaLibros = new ArrayList<>();
    JSONParser parser = new JSONParser();

    try (FileReader reader = new FileReader(filePath)) {
        // Verificar el tamaño del archivo antes de intentar parsearlo
        if (reader.ready()) {
            Object obj = parser.parse(reader);
            
            if (obj instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) obj;

                for (Object object : jsonArray) {
                    JSONObject jsonObject = (JSONObject) object;
                    int id = ((Long) jsonObject.get("id")).intValue();
                    String titulo = (String) jsonObject.get("titulo");
                    String editorial = (String) jsonObject.get("editorial");
                    boolean estado = (boolean) jsonObject.get("estado");
                    int ano = ((Long) jsonObject.get("ano")).intValue();
                    String genero = (String) jsonObject.get("genero");
                    String autor = (String) jsonObject.get("autor");

                    Libro libro = new Libro(id, titulo, editorial, estado, ano, genero, autor);
                    listaLibros.add(libro);
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

    return listaLibros;
}
   public int obtenerUltimoId() {
        int ultimoId = 0;
        for (Libro libro : listaLibros) {
            if (libro.getId() > ultimoId) {
                ultimoId = libro.getId();
            }
        }
        return ultimoId;
    }

    public int obtenerSiguienteId() {
        int ultimoId = obtenerUltimoId();
        return ultimoId + 1;
    }

}
