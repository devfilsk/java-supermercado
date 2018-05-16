
package supermercado;

import java.util.ArrayList;

public class Venda {
    private CarrinhoDeCompras carrinho;
    private Caixa infoCaixa;
    private double valorTotal;
    private EnumTipoDePagamento formaDePAgamento;
    
    public Venda(Caixa caixa, CarrinhoDeCompras carrinho){
        this.carrinho = carrinho;
        this.infoCaixa = caixa;
    }
    public void realizarVenda(Cliente cliente){
        this.carrinho = cliente.realizarCompra();
    }
    
}
