package views;

import javax.swing.*;
import controllers.Cliente_controller;


public class Cadastro_cliente {
    private JButton btNovo;
    private JButton btCancelar;
    private JButton btEditar;
    private JComboBox cbRegioes;
    private JTextField jtNome;
    private JTextField jtIdade;
    private JTextField jtIdentidade;
    private JTextField jtTelefone;
    private JTextField jtEndereco;
    Cliente_controller cliente_controller = new Cliente_controller();


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
