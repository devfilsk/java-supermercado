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
public class Cavalo extends Animal {
    
    public Cavalo(String nome, int idade) {
        super(nome, idade, Comportamento.CORRER);
    }
    
    @Override
    public void acao(){
        System.out.println("Cavalo correndo ...");
    }
    
    @Override
    public void emitirSom(){
        System.out.println("irrriluiluilu brrrr");
    }
}
