
package supermercado;

import java.util.ArrayList;

public class Caixa {
    private ArrayList<Venda> vendas;
    private Funcionario operadorCaixa;
    private int numeroDoCaixa;
    private Balanca balanca;
    
    public Caixa(int numero, OperadorDeCaixa operador){
        this.numeroDoCaixa = numero;
        this.operadorCaixa = operador;
        this.balanca = new Balanca();
    }
    
    public void finalizarVenda(){
        
        // Calcular o valor total da compra usando o somatorio de:
        // - calcularValorPorItem
        // - calcularValorPorPeso
        // Calcular troco do cliente se pagar em $
    }
    
    public void cancelarVenda(){
    }

    private double calcularValorPorItem(double valorDaUnidadeProduto, int quantidade){
        return balanca.calcularValorPorItem(valorDaUnidadeProduto, quantidade);
    }
    
    private double calcularValorPorPeso(double valorDoPeso, double quantidade){
        return balanca.calcularValorPorPeso(valorDoPeso, quantidade);
    } 
    
}
