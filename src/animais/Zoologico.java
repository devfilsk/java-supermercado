/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animais;

import java.util.ArrayList;

/**
 *
 * @author Richiely Batista
 */
public class Zoologico {
    private Animal[] jaulas;
    private int qtdAnimais;
    
    public Zoologico() {
        this.jaulas = new Animal[10];
        this.qtdAnimais = 0;
    }
    
    public void enjaular(Animal animal){
        if (qtdAnimais < jaulas.length) {
            jaulas[qtdAnimais] = animal;
            qtdAnimais++;
        }
        else{
            System.out.println("Todas as jaulas estão ocupadas");
        }
    }
    
    public Animal[] getJaulas() {
        return jaulas;
    }

    public void setJaulas(Animal[] jaulas) {
        this.jaulas = jaulas;
    }
    
}
