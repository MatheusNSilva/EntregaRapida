package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.Cadastro_cliente;

public class Lista_cliente extends JFrame {
    private JPanel PaineListagem_Cliente;
    private JButton btnBuscar;
    private JTextField tfCliente;
    private JButton btnRemover;
    private JButton registrarPedidoButton;
    private JButton btnNovo_cliente;
    private JList jlLista_clientes;
    Cadastro_cliente TelaCadastro_cliente = new Cadastro_cliente("Cadastro");

    public Lista_cliente(String titulo) {
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PaineListagem_Cliente);
        this.pack();

    }

   /**public static void main(String[] args) {
        JFrame frame = new Lista_cliente("Listagem de Clientes");
        frame.setVisible(true);
    }**/
}
