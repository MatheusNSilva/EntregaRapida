package views;

import javax.swing.*;
import controllers.Cliente_controller;
import models.Regiao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Cadastro_cliente implements ActionListener {
    private JButton btNovo;
    private JButton btCancelar;
    private JButton btEditar;
    private JComboBox<Regiao>cbRegioes;
    private JTextField jtNome;
    private JTextField jtIdade;
    private JTextField jtIdentidade;
    private JTextField jtTelefone;
    private JTextField jtEndereco;
    Cliente_controller cliente_controller = new Cliente_controller();

    //

    private void createUIComponents() {
        // TODO: place custom component creation code here

        btNovo.addActionListener(this);


        cbRegioes.setModel(new javax.swing.DefaultComboBoxModel(Regiao.values()));
    }


    public void actionPerformed(ActionEvent e) {
        String documentoString = jtIdentidade.getSelectedText();
        int documento = Integer.parseInt(documentoString);
        String nome = jtNome.getSelectedText();
        String idadeString = jtIdade.getSelectedText();
        int idade = Integer.parseInt(idadeString);
        String telefone = jtTelefone.getSelectedText();
        String endereco = jtEndereco.getSelectedText();
        String regiao = cbRegioes.getSelectedItem().toString();
        this.cliente_controller.cadastrar_cliente(0, documento, nome, idade, telefone, endereco, regiao);

    }
}
