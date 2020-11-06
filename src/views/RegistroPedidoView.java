package views;

import controllers.ClienteController;
import controllers.PedidoController;
import daos.ClienteDAO;
import models.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class RegistroPedidoView extends JFrame {
    private JPanel PanelRegistro_pedido;
    private JButton btnBuscarCliente;
    private JTextField tfCpf_cliente;
    private JTextField tfNome_cliente;
    private JComboBox cbVeiculos;
    private JTextArea taLista_itens;
    private JTextField tfValor_pedido;
    private JCheckBox cfRestricao_idade;
    private JButton btnSalvar;

    private ClienteController clienteController = new ClienteController();
    private PedidoController pedidoController = new PedidoController();
    Cliente cliente = new Cliente();

    public RegistroPedidoView(String titulo) {
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PanelRegistro_pedido);

        tfCpf_cliente = new JTextField();
        btnSalvar = new JButton("Salvar");
        //btnBuscarCliente = new JButton("Buscar Cliente");


        btnSalvar.addActionListener(new ActionListener() {
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
                catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public void buscaCliente() throws Exception {
        if(!tfCpf_cliente.getText().equals("")) {
            cliente = clienteController.buscaClientePorCPF(tfCpf_cliente.getText());
            tfNome_cliente.setText(cliente.getNome());
        }
        else {
            JOptionPane.showMessageDialog(this, "Campo CPF não preenchido.");
        }
    }

    public void salvar() throws Exception{
        if(!tfCpf_cliente.getText().equals("")) {
            Cliente cliente = new Cliente();
            cliente = clienteController.buscaClientePorCPF(tfCpf_cliente.getText());
            float valorPedido = Float.parseFloat(tfValor_pedido.getText());
            boolean restricaoIdade = cfRestricao_idade.isSelected();
            //pedidoController.salvar(cliente, cbVeiculos, taLista_itens.getText(), valorPedido, restricaoIdade);//tratar combo veiculo
        }
    }
}
