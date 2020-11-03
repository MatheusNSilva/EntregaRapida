package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import connection.ConnectionFactory;

import java.sql.*;

public class Cadastro_cliente extends JFrame{
    private JPanel PanelCadastro_Cliente;
    private JButton btnCadastrar;
    private JButton btnAtualizar;
    private JButton btnVoltar;
    private JTextField tfNome;
    private JTextField tfIdade;
    private JTextField tfDocumento;
    private JTextField tfTelefone;
    private JTextField tfEndereco;
    private JComboBox cdRegioes;
    //Cliente_controller cliente_controller = new Cliente_controller();
    //Lista_cliente TelaLista_cliente= new Lista_cliente("Voltar para a  Lista");

    public Cadastro_cliente(String titulo) {
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(PanelCadastro_Cliente);
        this.pack();


        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        JFrame frame = new Cadastro_cliente("Cadastro de Clientes");
        frame.setVisible(true);

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperaConexao();

        Statement stm = connection.createStatement();
        stm.execute("SELECT * FROM pedido");
        System.out.println("testtando conexão");

        ResultSet resultSet = stm.getResultSet();
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String lista_itens = resultSet.getString("lista_itens");
        }
        connection.close();



    }
}
