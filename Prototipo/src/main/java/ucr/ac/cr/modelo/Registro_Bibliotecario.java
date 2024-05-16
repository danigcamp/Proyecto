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

public class Registro_Bibliotecario {

    private ArrayList<Bibliotecario> listaBibliotecario;
    private String filePath = "bibliotecario.json";

    public Registro_Bibliotecario() {
        this.listaBibliotecario = leerJSON();
    }

    public void agregarBibliotecario(Bibliotecario bibliotecario) {
        listaBibliotecario.add(bibliotecario);
        escribirJSON();
    }

    public void modificarBibliotecario(Bibliotecario b) {
    for (int i = 0; i < listaBibliotecario.size(); i++) {
            if (b.getCarnet().equals(listaBibliotecario.get(i).getCarnet())) {
                listaBibliotecario.set(i, b);
                escribirJSON();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el Bibliotecario");
    }

    public Bibliotecario buscarBibliotecario(String carnet) {
           boolean encontrado = false;
        int i = listaBibliotecario.size() - 1;
        while (!encontrado && 0 <= i) {
            if (carnet.equals(listaBibliotecario.get(i).getCarnet())) {
                encontrado = true;
                Bibliotecario BibliotecarioEncontrado = listaBibliotecario.get(i);
                JOptionPane.showMessageDialog(null, "Se encontró el Bibliotecario");
                escribirJSON();
                return BibliotecarioEncontrado;
            }
            i--;
        }
        JOptionPane.showMessageDialog(null, "No se encontró el Bibliotecario");
        return null;
    }

    public void eliminarBibliotecario(Bibliotecario bibliotecario) {
        for (int i = 0; i < listaBibliotecario.size(); i++) {
            if (listaBibliotecario.get(i).getCarnet().equals(bibliotecario.getCarnet())) {
                listaBibliotecario.remove(i);
                escribirJSON();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el Bibliotecario");
    }

    public ArrayList<Bibliotecario> getListaBibliotecario() {
        return listaBibliotecario;
    }

    public void setListaBibliotecario(ArrayList<Bibliotecario> al) {
        this.listaBibliotecario = al;
    }

    private void escribirJSON() {
        JSONArray jsonArray = new JSONArray();

        for (Bibliotecario bibliotecario : listaBibliotecario) {
            JSONObject newObject = new JSONObject();

            newObject.put("carnet", bibliotecario.getCarnet());
            newObject.put("nombre", bibliotecario.getNombre());
            newObject.put("apellidos", bibliotecario.getApellidos());
            newObject.put("contrasena", bibliotecario.getContrasena());
            newObject.put("celular", bibliotecario.getCelular());

            jsonArray.add(newObject);
        }

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Bibliotecario> leerJSON() {
        ArrayList<Bibliotecario> bibliotecarios = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            // Verificar el tamaño del archivo antes de intentar parsearlo
            if (reader.ready()) {
                Object obj = parser.parse(reader);

                if (obj instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) obj;

                    for (Object object : jsonArray) {
                        JSONObject jsonObject = (JSONObject) object;

                        String carnet = (String) jsonObject.get("carnet");
                        String nombre = (String) jsonObject.get("nombre");
                        String apellidos = (String) jsonObject.get("apellidos");
                        String contrasena = (String) jsonObject.get("contrasena");
                        int celular = ((Long) jsonObject.get("celular")).intValue();

                        Bibliotecario bibliotecario = new Bibliotecario(carnet, nombre, apellidos, contrasena, celular);
                        bibliotecarios.add(bibliotecario);
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

        return bibliotecarios;
    }

}
