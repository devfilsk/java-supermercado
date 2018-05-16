
package supermercado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Cliente {
    private CarrinhoDeCompras carrinho;
    
    public Cliente(){
        this.carrinho = new CarrinhoDeCompras();
    }

    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }
    
    
    public void addProdutoPorCodigo(String codigo){
        
        
    }
    public CarrinhoDeCompras realizarCompra(){
        return this.carrinho;
    }
    public String consultarValor(String codigo){
        return Leitor.mostrarValorProduto(codigo);
    }
    
    
}
