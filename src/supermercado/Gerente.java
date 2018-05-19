/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static supermercado.Supermercado.scanner;

/**
 *
 * @author Richiely Batista
 */
public class Gerente extends Funcionario {
    
    public Gerente(String nome, String userName, String senha) {
        super(nome, userName, senha);
        EstoqueDeProdutos.copiarEstoque();
    }

    public void emitirRelatorioDeEstoque() {
        System.out.println("*********************************************************");
        System.out.println("RELATÓRIO DE ESTOQUE");
        System.out.println("*********************************************************");
        System.out.println("***** Estoque no INÍCIO do dia *****");
        
        // TODO
        EstoqueDeProdutos.exibirCopiaInicialDoEstoque();

        //teste de comparacao dos estoques
        //this.adicionarProduto(new ProdutoQuilo("21", "Maça", 1.99, 53.8), 0);
        //this.adicionarProduto(new ProdutoQuilo("21", "Maça", 1.99, 16.2), 0);
        
        System.out.println("*********************************************************");
        System.out.println("***** Estoque no FINAL do dia *****");

        //teste de comparacao dos estoques
        //this.removerProduto("20", 8);
        //this.removerProduto("21", 100);
        
        EstoqueDeProdutos.mostrarEstoque(1);
        Scanner sc = new Scanner(System.in);
        System.out.println("Aperte ENTER para continuar ...");
        scanner.nextLine();
    }
    
    public void emitirRelatorioDeVendas(){}
}
