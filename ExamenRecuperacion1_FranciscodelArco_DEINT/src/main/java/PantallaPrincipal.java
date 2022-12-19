import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PantallaPrincipal extends JPanel {
    private Ventana ventana;

    String codigo; // debe ser alfanumerico y max 10 car
    String modelo; // debe ser alfanumerico y max 15 car
    String marca; // max 10 car
    String[] tipoMotor = {"gasolina", "diesel", "hibrido", "electrico"};
    String[] tipoVehiculo = {"Turismo", "Monovolumen", "SUV", "Todoterreno"};
    String[] tipoCambio = {"Manual", "Automatico"};
    DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate hoy = LocalDate.now();
    String proveedor; //max 10 car
    String telefono; // max 10 dig y solo caracteres del 0 al 9
    int precioCoste; // no mayor de 50.000€
    String[] ubicacion = {"Almacen", "Tienda", "Taller"};
    float pvp;


    public PantallaPrincipal(Ventana v) {
        this.ventana = v;
        setLayout(null);


        JLabel tituloLabel = new JLabel("Gestión de Venta de Vehículos");
        tituloLabel.setBounds(450, 30, 300, 100);
        tituloLabel.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 20));
        add(tituloLabel);

        //codigo
        JTextArea codigoTextArea = new JTextArea("Código");
        codigoTextArea.setBounds(100, 150, 250, 30);
        codigoTextArea.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 18));
        codigoTextArea.setToolTipText("Introduzca el codigo del vehiculo");

        codigoTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                codigoTextArea.setText("");
                codigoTextArea.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 18));

            }
        });
        add(codigoTextArea);
        codigo = codigoTextArea.getText();


        //modelo
        JTextArea modeloTextArea = new JTextArea("Modelo");
        modeloTextArea.setBounds(470, 150, 250, 30);
        modeloTextArea.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 18));
        modeloTextArea.setToolTipText("Introduzca el modelo del vehiculo");


        modeloTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                modeloTextArea.setText("");
                modeloTextArea.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 18));
            }
        });
        add(modeloTextArea);
        modelo = modeloTextArea.getText();


        //marca
        JTextArea marcaTextArea = new JTextArea("Marca");
        marcaTextArea.setBounds(820, 150, 250, 30);
        marcaTextArea.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 18));
        marcaTextArea.setToolTipText("Introduzca la marca del vehiculo");


        marcaTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                marcaTextArea.setText("");
                marcaTextArea.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 18));
            }
        });
        add(marcaTextArea);
        marca = marcaTextArea.getText();

        //Botones
        JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(300, 700, 250, 30);
        aceptar.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
        add(aceptar);


        JButton cancelar = new JButton("Cancelar");
        cancelar.setBounds(650, 700, 250, 30);
        cancelar.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
        add(cancelar);


    }


}
