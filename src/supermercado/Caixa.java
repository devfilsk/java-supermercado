
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
        vendas = new ArrayList<>();
    }    

    public Caixa(int numero){
        this.numeroDoCaixa = numero;
        this.balanca = new Balanca();
        vendas = new ArrayList<>();
    } 
    
    public void relatorioCaixa(){
        if (vendas.size() > 0) {
            Iterator it = vendas.iterator();
            while(it.hasNext()){
                Venda venda = (Venda) it.next();
                Utilitario.ImprimaMensagem(venda.dadosVenda());
            }
        }else{
            Utilitario.ImprimaMensagem("*           Não há vendas registradas nesse caixa              *");
        }
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
    
    public Venda iniciarVenda(Cliente cliente){
        Venda venda = new Venda(this, cliente);
        venda.vender();
        boolean pagamento = venda.formaDePagamento();
        if(pagamento){
             vendas.add(venda);
        }else{
            Utilitario.ImprimaMensagem("*  !!!! FALHA AO COMPRAR !!!!  *");
            return null;
        }
       
        return venda;
    }
}
