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
public class OperadorDeCaixa extends Funcionario  {
    
    public OperadorDeCaixa(String nome, String userName, String senha) {
        super(nome, userName, senha);
    }

    @Override
    public void adicionarProduto(Produto produto, double quantidade) {
        System.out.println("********************************************************************");
        System.out.println("*                ATENÇÃO - OPERAÇÃO NÃO PERMITIDA                  *");
        System.out.println("*   Operadores de caixa NÂO podem adicionar produtos ao estoque    *");
        System.out.println("********************************************************************");
    }

    // Remover produto deve ser chamado ao efetuar venda
    @Override
    public void removerProduto(String codigo, double quantidade) {
        //this.getEstoqueDeProdutos().removerProduto(codigo, quantidade);
        EstoqueDeProdutos.removerProduto(codigo, quantidade);
    }

    @Override
    public void mostrarEstoque() {
        System.out.println("********************************************************************");
        System.out.println("*                ATENÇÃO - OPERAÇÃO NÃO PERMITIDA                  *");
        System.out.println("*  Operadores de caixa NÂO possuem acesso para mostrar o estoque   *");
        System.out.println("********************************************************************");
    }
    
    public void vender(){}
}
