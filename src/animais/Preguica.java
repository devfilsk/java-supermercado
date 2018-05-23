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
public class Preguica extends Animal {
    public Preguica(String nome, int idade) {
        super(nome, idade, Comportamento.SUBIR_EM_ARVORE);
    }
    
    @Override
    public void acao(){
        System.out.println("Subindo em árvore ...");
    }
    
    @Override
    public void emitirSom(){
        System.out.println("ZZZzzzZZZ");
    }
}
