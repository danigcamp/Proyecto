package ucr.ac.cr.vista;


import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import ucr.ac.cr.modelo.FechaHoraListener;

public class SeleccionFechaHora extends JFrame {

    private JLabel lblFecha, lblHora;
    private JSpinner spinnerFecha, spinnerHora, spinnerMinutos;
    private JButton btnAceptar;
    private String fechaHoraFormateada;
    private FechaHoraListener listener;

    public SeleccionFechaHora(FechaHoraListener listener) {
        super("Seleccionar Fecha y Hora");
        this.listener = listener;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        lblFecha = new JLabel("Fecha:");
        add(lblFecha);

        // Spinner para seleccionar la fecha
        spinnerFecha = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor fechaEditor = new JSpinner.DateEditor(spinnerFecha, "dd-MM-yyyy");
        spinnerFecha.setEditor(fechaEditor);
        add(spinnerFecha);

        lblHora = new JLabel("Hora:");
        add(lblHora);

        // Spinner para seleccionar la hora
        spinnerHora = new JSpinner(new SpinnerNumberModel(0, 0, 23, 1));
        add(spinnerHora);

        // Spinner para seleccionar los minutos
        spinnerMinutos = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        add(spinnerMinutos);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(e -> mostrarFechaHoraSeleccionada());
        add(btnAceptar);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mostrarFechaHoraSeleccionada() {
        // Obtener la fecha seleccionada
        Date fechaSeleccionada = (Date) spinnerFecha.getValue();

        // Obtener la hora seleccionada
        int hora = (int) spinnerHora.getValue();
        int minutos = (int) spinnerMinutos.getValue();

        // Crear un objeto LocalDateTime con la fecha y hora seleccionadas
        LocalDateTime fechaHoraSeleccionada = LocalDateTime.ofInstant(fechaSeleccionada.toInstant(), ZoneId.systemDefault())
                .withHour(hora).withMinute(minutos);

        // Formatear la fecha y hora seleccionada
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        setFechaHoraFormateada(fechaHoraSeleccionada.format(formatter));

        // Notificar al oyente (listener) con la fecha y hora seleccionada
        listener.fechaHoraSeleccionada(getFechaHoraFormateada());

        this.dispose();
    }

    public static void main(String[] args) {
        SeleccionFechaHora seleccionFechaHora = new SeleccionFechaHora(fechaHora -> {
            System.out.println("Fecha y hora seleccionada: " + fechaHora);
        });
    }

    public String getFechaHoraFormateada() {
        return fechaHoraFormateada;
    }

    public void setFechaHoraFormateada(String fechaHoraFormateada) {
        this.fechaHoraFormateada = fechaHoraFormateada;
    }
}
