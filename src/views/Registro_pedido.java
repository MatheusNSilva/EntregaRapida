package views;

import controllers.ClienteController;
import daos.ClienteDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class Registro_pedido extends JFrame {
    private JPanel PanelRegistro_pedido;
    private JButton btnBuscarCliente;
    private JTextField tfCpf_cliente;
    private JTextField tfNome_cliente;
    private JComboBox cbVeiculos;
    private JTextArea taLista_itens;
    private JTextField tfValor_pedido;
    private JCheckBox cfRestricao_idade;
    private JButton salvarButton;

    private ClienteController clienteController = new ClienteController();

    public Registro_pedido(String titulo) {
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PanelRegistro_pedido);

        tfCpf_cliente = new JTextField();
        salvarButton = new JButton("Salvar");
        //btnBuscarCliente = new JButton("Buscar Cliente");


        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnBuscarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    buscaCliente();
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public void buscaCliente() throws SQLException {
        if(!tfCpf_cliente.getText().equals("")) {
            clienteController.buscaClientePorCPF(tfCpf_cliente.getText());
        }
        else {
            JOptionPane.showMessageDialog(this, "Campo CPF não preenchido.");
        }
    }

    public void salvar() {

    }
}
