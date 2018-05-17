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
public class Balanca{

    public Balanca() {
    }
    
    public static double calcularValorPorPeso(double pesoDoProduto, double quantidade){
        return pesoDoProduto*quantidade;
    }
    
    public static double calcularValorPorItem(double valorDoProduto, int quantidade){
        return valorDoProduto*quantidade;
    }
}
