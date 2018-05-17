
package supermercado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Venda {
    private Cliente cliente;
    private Caixa caixa;
    private double valorTotal;
    private EnumTipoDePagamento formaDePAgamento;
    
    public Venda(Caixa caixa, Cliente cliente){
        this.cliente = cliente;
        this.caixa = caixa;
        this.valorTotal = 0;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
    public void finalizarVenda(){
        
        // Calcular o valor total da compra usando o somatorio de:
        // - calcularValorPorItem
        // - calcularValorPorPeso
        // Calcular troco do cliente se pagar em $
        
       Map car = this.cliente.getCarrinho().getProdutosCarrinho();
       Iterator itMap = car.keySet().iterator();
       int quantidade;
       double valor;
       while(itMap.hasNext()){
           String codigo = (String) itMap.next();
           List l = (List) this.cliente.getCarrinho().getProdutosCarrinho().get(codigo);
           Iterator itList = l.iterator();
           if(itList.hasNext()){
               List produtoList = (List) itList.next();
               Produto produto = (Produto) produtoList.get(0);
               
                quantidade = produtoList.size();
                valor = produto.getValor();
               
                //Fazer a variavel "valorTotal" receber o valor do calculo por kilo
                if(produto instanceof ProdutoQuilo){
                    //QUAL A MELHOR FORMA DE CHAMAR O MÉTODO calcularValorPorKilo chamar da balança ou do caixa???
                    this.valorTotal = Balanca.calcularValorPorPeso(quantidade, valor);
                }
                //Fazer a variavel "valorTotal" receber o valor do calculo por Unidade
                else if(produto instanceof ProdutoUnitario){
                    //QUAL A MELHOR FORMA DE CHAMAR O MÉTODO calcularValorPorUnidade chamar da balança ou do caixa???
                    //this.valorTotal = Balanca.calcularValorPorItem(quantidade, valor);
                }
                 
           }
       }
       
       
    }
    
}
