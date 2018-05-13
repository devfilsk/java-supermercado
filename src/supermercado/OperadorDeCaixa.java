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
    
    public OperadorDeCaixa(String nome, EstoqueDeProdutos estoque) {
        super(nome, estoque);
    }

    @Override
    public void adicionarProduto(Produto produto, double quantidade) {
        System.out.println("**** ATENÇÃO ****\n");
        System.out.println("Operadores de caixa NÂO podem adicionar produtos ao estoque. \n");
    }

    @Override
    public void removerProduto(Produto produto, double quantidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarEstoque() {
        System.out.println("**** ATENÇÃO ****\n");
        System.out.println("Operadores de caixa NÂO possuem acesso para mostrar o estoque.\n");
    }
    
    
    
}
