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
public class Funcionario {
    private String nome;
    private EstoqueDeProdutos estoqueDeProdutos;

    public Funcionario(String nome, EstoqueDeProdutos estoque) {
        this.nome = nome;
        estoqueDeProdutos = estoque;
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
}
