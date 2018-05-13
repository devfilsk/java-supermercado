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

    public Gerente(String nome, EstoqueDeProdutos estoque) {
        super(nome, estoque);
    }

    @Override
    public void adicionarProduto(Produto produto, double quantidade) {
       this.getEstoqueDeProdutos().adicionarProduto(produto, quantidade);
    }

    @Override
    public void removerProduto(Produto produto, double quantidade) {
       this.getEstoqueDeProdutos().removerProduto(produto, quantidade);
    }

    @Override
    public void mostrarEstoque() {
        this.getEstoqueDeProdutos().mostrarEstoque();
    }
    
    public void emitirRelatorioDeVendas() {

    }

    public void emitirRelatorioDeEstoque() {
    }
}
