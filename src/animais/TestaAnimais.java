/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animais;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Richiely Batista
 */
public class TestaAnimais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Animal> animais = new LinkedList<Animal>();
        
        animais.add(new Cachorro("Doggo", 3));
        animais.add(new Cavalo("Eguinha", 5));
        animais.add(new Preguica("Pepe", 6));
        
        Iterator i = animais.iterator();
        while (i.hasNext()) {
            Animal animal = (Animal)i.next();
            animal.emitirSom();
        }
        
        Veterinario.Examinar(new Cachorro("Lulu", 10));
        
        Zoologico zoo = new Zoologico();
        zoo.enjaular(new Cachorro("Doggo", 10));
        zoo.enjaular(new Cavalo("Eguinha", 8));
        zoo.enjaular(new Preguica("Pepe", 3));
        zoo.enjaular(new Cachorro("Lulu", 4));
        zoo.enjaular(new Cavalo("Doggo", 6));
        zoo.enjaular(new Preguica("Doggo", 5));
        zoo.enjaular(new Cachorro("Doggo", 3));
        zoo.enjaular(new Cavalo("Doggo", 1));
        zoo.enjaular(new Preguica("Doggo", 2));
        zoo.enjaular(new Cachorro("Doggo", 12));
        
        for (Animal animal : zoo.getJaulas()) {
            animal.emitirSom();
            if (animal.getComportamento() == Comportamento.CORRER) {
                animal.acao();
            }
            System.out.println();
        }
        
        
    }
    
}
