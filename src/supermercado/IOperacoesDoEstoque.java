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
interface IOperacoesDoEstoque {
    public void adicionarProduto(Produto produto, double quantidade);
    public void removerProduto(String codigo, double quantidade);
    public void mostrarEstoque();
}
