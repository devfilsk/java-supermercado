
package supermercado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    public Caixa(int numero){
        this.numeroDoCaixa = numero;
        this.balanca = new Balanca();
    }    

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(ArrayList<Venda> vendas) {
        this.vendas = vendas;
    }
    
    public int getNumeroDoCaixa() {
        return numeroDoCaixa;
    }

    public void setNumeroDoCaixa(int numeroDoCaixa) {
        this.numeroDoCaixa = numeroDoCaixa;
    }

    public Funcionario getOperadorCaixa() {
        return operadorCaixa;
    }

    public void setOperadorCaixa(Funcionario  operadorCaixa) {
        this.operadorCaixa = operadorCaixa;
    }
    
    public void cancelarVenda(){
        
    }

    private double calcularValorPorItem(double valorDaUnidadeProduto, int quantidade){
        return balanca.calcularValorPorItem(valorDaUnidadeProduto, quantidade);
    }
    
    private double calcularValorPorPeso(double valorDoPeso, double quantidade){
        return balanca.calcularValorPorPeso(valorDoPeso, quantidade);
    } 

    @Override
    public String toString() {
        return "Caixa " + numeroDoCaixa;
    }
    
    public void iniciarVenda(Cliente cliente){
        Venda venda = new Venda(this, cliente);
        System.out.println("VENDA INICIADA");
        venda.vender();
        vendas.add(venda);
    }
    
    
    
}
