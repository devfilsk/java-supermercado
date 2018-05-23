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
public class Veterinario {
    public static void Examinar(Animal animal){
        System.out.print("Exanimando o " + animal.getNome() + ": ");
        animal.emitirSom();
    }
}
