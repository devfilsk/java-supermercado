/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animais;

/**
 *
 * @author Richiely Batista
 */
public class Animal {
    private String nome;
    private int idade;
    private Comportamento comportamento;

    public Animal(String nome, int idade, Comportamento comportamento) {
        this.nome = nome;
        this.idade = idade;
        this.comportamento = comportamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Comportamento getComportamento() {
        return comportamento;
    }

    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }
    
    public void emitirSom(){
        System.out.println("Som do animal...");
    }
    
    public void acao(){
        System.out.println("Ação do animal...");
    }
}
