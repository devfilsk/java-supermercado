
package supermercado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Venda {
    private Cliente cliente;
    private Caixa caixa;
    private EnumTipoDePagamento formaDePAgamento;
    private double valorVenda;
    
    public Venda(){
        
    }
    
    public Venda(Caixa caixa, Cliente cliente){
        this.cliente = cliente;
        this.caixa = caixa;
    }
    
    public double getValorVenda(){
        return this.valorVenda;
    }
    
    public void vender(){
        this.valorVenda = cliente.getCarrinho().calcularPrecoCarrinho();        
    }
    public void formaDePagamento(){
        Scanner scan = new Scanner(System.in);
        System.out.println("***********************************************************");
        System.out.println("*   ESCOLHA SUA FORMA DE PAGAMENTO!  \n 1- DINHEIRO  \n 2- CARTÃO  *");
        System.out.println("***********************************************************");
        String formaPagamento = scan.nextLine();
        EnumTipoDePagamento[] formaPag = EnumTipoDePagamento.values();
        System.out.println(formaPag);
        
    }
}
