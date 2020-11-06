package views;

import controllers.ClienteController;
import controllers.PedidoController;
import daos.ClienteDAO;
import models.Cliente;
import models.Veiculo;

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

    Connection connection;
    private ClienteDAO clienteDAO = new ClienteDAO(connection);
    private PedidoController pedidoController = new PedidoController();
    Cliente cliente = new Cliente();
    Veiculo veiculo;

    public RegistroPedidoView(String titulo) throws SQLException {
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PanelRegistro_pedido);
        cbVeiculos.setModel(new javax.swing.DefaultComboBoxModel<>(veiculo.values()));

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    salvar();
                }
                catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        btnBuscarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    buscaCliente(tfCpf_cliente.getText());
                }
                catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    public void buscaCliente(String test) throws Exception {
        if(!tfCpf_cliente.getText().equals("")) {
            cliente = clienteDAO.buscaClientePorCPF(tfCpf_cliente.getText());
            tfNome_cliente.setText(cliente.getNome());
            System.out.println(tfCpf_cliente.getText());
            System.out.println(cliente.toString());
        }
        else {
            System.out.println(tfCpf_cliente.getText());
            JOptionPane.showMessageDialog(this, "Campo CPF não preenchido.");
        }
    }

    public void salvar() throws Exception{
        if(!tfCpf_cliente.getText().equals("")) {
            Cliente cliente = new Cliente();
            cliente = clienteDAO.buscaClientePorCPF(tfCpf_cliente.getText());
            float valorPedido = Float.parseFloat(tfValor_pedido.getText());
            boolean restricaoIdade = cfRestricao_idade.isSelected();
            String veiculo = cbVeiculos.getSelectedItem().toString();
            System.out.println(cbVeiculos.getName());
            pedidoController.salvar(cliente, cbVeiculos.getName(), taLista_itens.getText(), valorPedido, restricaoIdade);//tratar combo veiculo
        }
    }
}
