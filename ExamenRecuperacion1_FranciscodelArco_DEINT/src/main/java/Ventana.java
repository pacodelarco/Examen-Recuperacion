import javax.swing.*;


public class Ventana extends JFrame {
    private JPanel pantallaActual;

    public Ventana() {
        this.setSize(1200, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Gestión de Venta de Vehículos");
        //this.setIconImage(new ImageIcon(getClass().getResource("./icon.png")).getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pantallaActual = new PantallaPrincipal(this);
        this.setContentPane(new PantallaPrincipal(this));
        this.setVisible(true);
    }

    public void irAPantalla(String nombrePantalla) {
        this.pantallaActual.setVisible(false);
        this.pantallaActual.setLayout(null);

        switch (nombrePantalla) {
            case "inicio":
                this.pantallaActual = new PantallaPrincipal(this);
                this.setSize(500, 400);
                this.setLocationRelativeTo(null);
                break;

        }
        this.setContentPane(pantallaActual);
        this.pantallaActual.setVisible(true);
    }

}

