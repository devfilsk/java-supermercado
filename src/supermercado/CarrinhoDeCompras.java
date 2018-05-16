
package supermercado;

import java.util.ArrayList;
import java.util.Iterator;

public class CarrinhoDeCompras{
    private ArrayList<Produto> produtosCarrinho;
    private double valorCompra;
    
    
    public CarrinhoDeCompras(){
        produtosCarrinho = new ArrayList<Produto>();
        valorCompra = 0;
    }
    
    public double getValorCompra(){
        return this.valorCompra;
    }
    public void setValorCompra(double valor){
        this.valorCompra = valor;
    }
    public void addProduto(Produto produto){
        produtosCarrinho.add(produto);
    }
    public double calcularValorCompra(){
        /*Iterator it = produtosCarrinho.iterator();
        double valor = 0;
        while(it.hasNext()){
            Produto p = (Produto)it.next();
            if(String.valueOf(p.getCodigo().charAt(p.getCodigo().length()-1)).equals(0)){
                valor += p.calcularValor(valor);
            }else if(String.valueOf(p.getCodigo().charAt(p.getCodigo().length()-1)).equals(1)){
                
            }
        }*/
        return this.getValorCompra();
    }
    public void mostrarProdutosSelecionados(){
        Iterator it = produtosCarrinho.iterator();

        while(it.hasNext()){
            Produto p = (Produto) it.next();
            System.out.println("Produto: "+ p.getNome());
            System.out.println("Codigo: "+ p.getCodigo());
            System.out.println("valor: "+ p.getValor());
            System.out.println("");
        }
    }
    
}
