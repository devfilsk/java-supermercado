/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.Scanner;

/**
 *
 * @author Richiely Batista, Filipe Maciel
 */
public class Utilitario {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void ImprimaMensagem(String mensagem){
        System.out.println("*****************************************************************");
        System.out.println(mensagem); 
        System.out.println("*****************************************************************");
    }
    
    public static void ImprimaMensagem(String mensagem1, String mensagem2){
        System.out.println("*****************************************************************");
        System.out.println(mensagem1); 
        System.out.println(mensagem2); 
        System.out.println("*****************************************************************");
    }
    
    public static void Continuar(){
        System.out.println();
        System.out.println("Aperte ENTER para continuar ...");
        scanner.nextLine();
    }
}
