/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

public class Registro_Estudiante {

    private String filePath = "estudiantes.json";
    private ArrayList<Estudiante> listaEstudiantes;

    public Registro_Estudiante() {
        this.listaEstudiantes = leerJSON();
    }

    public void modificarEstudiante(Estudiante estudiante) {
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (estudiante.getCarnet().equals(listaEstudiantes.get(i).getCarnet())) {
                listaEstudiantes.set(i, estudiante);
                escribirJSON();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el estudiante");
    }

    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
        escribirJSON();
    }

    public Estudiante buscarEstudiante(String carnet) {
        boolean encontrado = false;
        int i = listaEstudiantes.size() - 1;
        while (!encontrado && 0 <= i) {
            if (carnet.equals(listaEstudiantes.get(i).getCarnet())) {
                encontrado = true;
                Estudiante estudianteEncontrado = listaEstudiantes.get(i);
                JOptionPane.showMessageDialog(null, "Se encontró el estudiante");
                escribirJSON();
                return estudianteEncontrado;
            }
            i--;
        }
        JOptionPane.showMessageDialog(null, "No se encontró el estudiante");
        return null;
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getCarnet().equals(estudiante.getCarnet())) {
                listaEstudiantes.remove(i);
                escribirJSON();
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró el estudiante");
    }

    public void getComboEstudiante() {

    }

    public void getMatrizEstudiante() {

    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    private void escribirJSON() {
        JSONArray jsonArray = new JSONArray();

        for (Estudiante estudiante : listaEstudiantes) {
            JSONObject newObject = new JSONObject();

            newObject.put("carnet", estudiante.getCarnet());
            newObject.put("numero_Telefonico", estudiante.getNumero_Telefonico());
            newObject.put("nombre", estudiante.getNombre());
            newObject.put("libros_Solicitados", estudiante.getLibros_Solicitados());
            newObject.put("Contrasena", estudiante.getContrasena());

            jsonArray.add(newObject);
        }

        try (FileWriter file = new FileWriter("estudiantes.json")) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Estudiante> leerJSON() {
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
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
                        int numero_Telefonico = ((Long) jsonObject.get("numero_Telefonico")).intValue();
                        String nombre = (String) jsonObject.get("nombre");
                        int libros_Solicitados = ((Long) jsonObject.get("libros_Solicitados")).intValue();
                        String Contrasena = (String) jsonObject.get("Contrasena");

                        Estudiante estudiante = new Estudiante(carnet, numero_Telefonico, nombre, libros_Solicitados, Contrasena);
                        listaEstudiantes.add(estudiante);
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

        return listaEstudiantes;
    }

}
