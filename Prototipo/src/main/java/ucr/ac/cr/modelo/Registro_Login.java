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

public class Registro_Login {

    private ArrayList<Login> listaLogins;
    private String filePath = "registroLogins.json";

    public Registro_Login() {
        listaLogins = new ArrayList<>();
    }

    private void escribirJSON() {
        JSONArray jsonArray = new JSONArray();

        for (Login login : listaLogins) {
            JSONObject newObject = new JSONObject();

            newObject.put("carnet", login.getCarnet());
            newObject.put("contrasena", login.getContrasena());
            newObject.put("rol", login.getRol());

            jsonArray.add(newObject);
        }

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Login> leerJSON() {
        ArrayList<Login> logins = new ArrayList<>();
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
                        String contrasena = (String) jsonObject.get("contrasena");
                        String rol = (String) jsonObject.get("rol");

                        Login login = new Login(carnet, contrasena, contrasena);
                        logins.add(login);
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

        return logins;
    }

    public Login logiarse(String carnet, String contrasena) {
        Registro_Estudiante registroEstudiante = new Registro_Estudiante();
        Registro_Bibliotecario registroBibliotecario = new Registro_Bibliotecario();

        ArrayList<Estudiante> estudiantes = registroEstudiante.getListaEstudiantes();
        ArrayList<Bibliotecario> bibliotecarios = registroBibliotecario.getListaBibliotecario();

        // Buscar en la lista de estudiantes
        for (Estudiante estudiante : estudiantes) {
            if (carnet.equals(estudiante.getCarnet()) && contrasena.equals(estudiante.getContrasena())) {
                return new Login(carnet, contrasena, "Estudiante");
            }
        }

        // Buscar en la lista de bibliotecarios
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (carnet.equals(bibliotecario.getCarnet()) && contrasena.equals(bibliotecario.getContrasena())) {
                return new Login(carnet, contrasena, "Bibliotecario");
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontro el usuario /n Error en el usuario o contrasena");
        return null;
    }

}
