/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.List;

/**
 *
 * @author Richiely Batista
 */
public class Gerente extends Funcionario implements IOperacoesDoEstoque {
    
    public Gerente(String nome, String userName, String senha, EstoqueDeProdutos estoque) {
        super(nome, userName, senha, estoque);
    }

    @Override
    public void adicionarProduto(Produto produto, double quantidade) {
       this.getEstoqueDeProdutos().adicionarProduto(produto, quantidade);
    }

    @Override
    public void removerProduto(String codigo, double quantidade) {
       this.getEstoqueDeProdutos().removerProduto(codigo, quantidade);
    }

    @Override
    public void mostrarEstoque() {
        this.getEstoqueDeProdutos().mostrarEstoque();
    }

    public void emitirRelatorioDeEstoque() {
        System.out.println("*********************************************************");
        System.out.println("RELATÓRIO DE ESTOQUE");
        System.out.println("*********************************************************");
        System.out.println("***** Estoque no INÍCIO do dia *****");
        
        //estoqueTemp.mostrarEstoque();
        
        System.out.println("*********************************************************");
        System.out.println("***** Estoque no FINAL do dia *****");
        
        this.getEstoqueDeProdutos().mostrarEstoque();
    }
}
