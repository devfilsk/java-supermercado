/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

/**
 *
 * @author Richiely Batista
 */
public class OperadorDeCaixa extends Funcionario implements IOperacoesDoEstoque {
    
    public OperadorDeCaixa(String nome, String userName, String senha, EstoqueDeProdutos estoque) {
        super(nome, userName, senha, estoque);
    }

    @Override
    public void adicionarProduto(Produto produto, double quantidade) {
        System.out.println("**** ATENÇÃO ****");
        System.out.println("Operadores de caixa NÂO podem adicionar produtos ao estoque. \n");
    }

    // Remover produto deve ser chamado ao efetuar venda
    @Override
    public void removerProduto(String codigo, double quantidade) {
        this.getEstoqueDeProdutos().removerProduto(codigo, quantidade);
    }

    @Override
    public void mostrarEstoque() {
        System.out.println("**** ATENÇÃO ****");
        System.out.println("Operadores de caixa NÂO possuem acesso para mostrar o estoque.\n");
    }
}
