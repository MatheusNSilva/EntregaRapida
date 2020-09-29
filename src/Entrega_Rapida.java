import controllers.Cliente_controller;
import models.Cliente;
import  models.Regiao;
import views.Cadastro_cliente;

import java.util.ArrayList;

public class Entrega_Rapida {


    //ArrayList<Cliente> clientesTest = new ArrayList();


    public static void main(String[] args) {

        //Cliente_controller cliente_controller = new Cliente_controller();
        Cadastro_cliente cadastro_cliente = new Cadastro_cliente();
        cadastro_cliente.setVisible(true);

        //cliente_controller.cadastrar_cliente(cliente2);
        /*cliente_controller.cadastrar_cliente(0,5555554, "Bira", 19,"Test1", "00000000000", "Regiao.CACHOEIRA");
        cliente_controller.cadastrar_cliente(0,5555556, "Bira", 19,"Test3", "00000000000", "Regiao.CACHOEIRA");
        Cliente clienteteste = new Cliente(0,5555557, "Bira", 19,"Test3", "00000000000", "Regiao.CACHOEIRA");
        System.out.println("o numero de cadastrados eh:"  +cliente_controller.listar_clientes());
        cliente_controller.remover_cliente(5555556);
        System.out.println("o numero de cadastrados eh:"  +cliente_controller.listar_clientes());*/
    }


}
