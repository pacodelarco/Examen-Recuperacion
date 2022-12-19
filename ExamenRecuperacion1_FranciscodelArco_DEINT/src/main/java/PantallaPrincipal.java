import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class PantallaPrincipal extends JPanel {
    private Ventana ventana;

    String codigo; // debe ser alfanumerico y max 10 car
    String modelo; // debe ser alfanumerico y max 15 car
    String marca; // max 10 car
    String[] tipoMotor = {"Gasolina", "Diesel", "Hibrido", "Electrico"};
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


        JRadioButton gasolinaButton = new JRadioButton(tipoMotor[0]);
        gasolinaButton.setBounds(100, 250, 250, 30);
        gasolinaButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
        add(gasolinaButton);

        JRadioButton dieselButton = new JRadioButton(tipoMotor[1]);
        dieselButton.setBounds(350, 250, 250, 30);
        dieselButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
        add(dieselButton);

        JRadioButton hibridoButton = new JRadioButton(tipoMotor[2]);
        hibridoButton.setBounds(600, 250, 250, 30);
        hibridoButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
        add(hibridoButton);

        JRadioButton electricoButton = new JRadioButton(tipoMotor[3]);
        electricoButton.setBounds(850, 250, 250, 30);
        electricoButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
        add(electricoButton);


        //Tipo de vehiculo
        JRadioButton turismoButton = new JRadioButton(tipoVehiculo[0]);
        turismoButton.setBounds(100, 320, 250, 30);
        turismoButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
        add(turismoButton);

        JRadioButton monovolumenButton = new JRadioButton(tipoVehiculo[1]);
        monovolumenButton.setBounds(350, 320, 250, 30);
        monovolumenButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
        add(monovolumenButton);

        JRadioButton SUVButton = new JRadioButton(tipoVehiculo[2]);
        SUVButton.setBounds(600, 320, 250, 30);
        SUVButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
        add(SUVButton);

        JRadioButton todoterrenoButton = new JRadioButton(tipoVehiculo[3]);
        todoterrenoButton.setBounds(850, 320, 250, 30);
        todoterrenoButton.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
        add(todoterrenoButton);


        //tipo de caja de cambios
        JComboBox<String> tipoCajaCambios = new JComboBox<>(tipoCambio);
        tipoCajaCambios.setBounds(100, 400, 250, 30);
        tipoCajaCambios.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
        tipoCajaCambios.setEnabled(false);
        if((turismoButton.isSelected()&&gasolinaButton.isSelected()) || (monovolumenButton.isSelected()&&dieselButton.isSelected())){
            tipoCajaCambios.setEnabled(true);
        };
        add(tipoCajaCambios);


        // Spinner de la fecha de alta
        Date hoy = new Date();
        JSpinner fechaAltaSpinner = new JSpinner(new SpinnerDateModel(hoy, null, null, Calendar.MONTH));
        JSpinner.DateEditor editor = new JSpinner.DateEditor(fechaAltaSpinner, "dd/MM/yyyy");
        fechaAltaSpinner.setEditor(editor);
        fechaAltaSpinner.setBounds(470, 400, 250, 30);
        fechaAltaSpinner.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 18));
        add(fechaAltaSpinner);


        //proveedor
        JTextArea proveedorTextArea = new JTextArea("Proveedor");
        proveedorTextArea.setBounds(820, 400, 250, 30);
        proveedorTextArea.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 18));
        proveedorTextArea.setToolTipText("Introduzca proveedor de vehículo");


        proveedorTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                proveedorTextArea.setText("");
                proveedorTextArea.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 18));
            }
        });
        add(proveedorTextArea);
        proveedor = proveedorTextArea.getText();


        //telefono de contacto
        JTextArea contactoTextArea = new JTextArea("Telf. Contacto");
        contactoTextArea.setBounds(100, 500, 250, 30);
        contactoTextArea.setFont(new Font("Microsoft PhagsPa", Font.ITALIC, 18));

        contactoTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                contactoTextArea.setText("");
                contactoTextArea.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 18));

            }
        });
        add(contactoTextArea);
        codigo = contactoTextArea.getText();


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
