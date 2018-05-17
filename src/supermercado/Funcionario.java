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
public class Funcionario implements IOperacoesDoEstoque{
    private String nome;
    private String userName;
    private String senha;
    private EstoqueDeProdutos estoqueDeProdutos;

    public Funcionario(String nome, String userName, String senha, EstoqueDeProdutos estoque) {
        this.nome = nome;
        this.estoqueDeProdutos = estoque;
        this.userName = userName;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstoqueDeProdutos getEstoqueDeProdutos() {
        return estoqueDeProdutos;
    }

    public void setEstoqueDeProdutos(EstoqueDeProdutos estoqueDeProdutos) {
        this.estoqueDeProdutos = estoqueDeProdutos;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public void adicionarProduto(Produto produto, double quantidade) {
        this.estoqueDeProdutos.adicionarProduto(produto, quantidade);
    }

    @Override
    public void removerProduto(String codigo, double quantidade) {
        this.estoqueDeProdutos.removerProduto(codigo, quantidade);
    }

    @Override
    public void mostrarEstoque() {
        EstoqueDeProdutos.mostrarEstoque();
    }
}
