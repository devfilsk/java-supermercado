
package supermercado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CarrinhoDeCompras{
    //private ArrayList<Produto> produtosCarrinho;
    private Map<String, List<Produto>> produtosCarrinho;
    private double valorCompra;
    
    public CarrinhoDeCompras(){
        produtosCarrinho = new LinkedHashMap<String, List<Produto>>();
        valorCompra = 0;
    }
    
    public Map getProdutosCarrinho(){
        return this.produtosCarrinho;
    }
    public double getValorCompra(){
        return this.valorCompra;
    }
    public void setValorCompra(double valor){
        this.valorCompra = valor;
    }
    public void addProduto(Produto produto, double quantidade){
        String codigo = produto.getCodigo();
        List<Produto> novoProduto;
        
        //Se ja existir um produto do mesmo código, ele soma o novo produto aos ja existentes no carrinho
        if(produtosCarrinho.containsKey(codigo)){
            
            novoProduto = produtosCarrinho.get(codigo);
            //Se for unitário, adiciona os produtos 1 por 1 na lista dentro do Map
            if(produto instanceof ProdutoUnitario){
                while (quantidade > 0) {                
                    novoProduto.add(produto);
                    quantidade--;
                }
                
                //Se for por Kilo, adiciona somente uma vez, pois a quantidade é dada em kilos
            }else if (produto instanceof ProdutoQuilo) {
                ProdutoQuilo pdt = (ProdutoQuilo)novoProduto.get(0);
                pdt.setQtdQuilos(pdt.getQtdQuilos() + ((ProdutoQuilo) produto).getQtdQuilos());
                novoProduto = new LinkedList<Produto>();
                novoProduto.add(pdt);
            }
            
            produtosCarrinho.get(codigo).add(produto);
            
            //se não existir este tipo de produto no carrinho, é então criado uma nova lista para ser adicionada ao Map juntamente com o 
            // código do novo produto como Key.
        }else{
            
            novoProduto = new LinkedList<Produto>();
            if (produto instanceof ProdutoUnitario) {
                while (quantidade > 0) {                
                    novoProduto.add(produto);
                    quantidade--;
                }
            } 
            else if (produto instanceof ProdutoQuilo) {
                novoProduto.add(produto);
               
            } 
            
            produtosCarrinho.put(codigo, novoProduto);
        }
        
    }
    
    
    
    public double calcularValorCompra(){  
        return this.getValorCompra();
    }
    
}
