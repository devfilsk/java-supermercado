
package supermercado;

import java.util.ArrayList;

public class Caixa {
    private ArrayList<Venda> vendas;
    private Funcionario operadorCaixa;
    private int numeroDoCaixa;
    
    public Caixa(int numero, OperadorDeCaixa operador){
        this.numeroDoCaixa = numero;
        this.operadorCaixa = operador;
    }
    
    public void finalizarVenda(){
        
    }
    
    public void cancelarVenda(){
        
    }
    
    public double calcularValorPorItem(double valor, int quantidade){
        return valor*quantidade;
    }
}
