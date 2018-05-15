
package supermercado;

import java.util.ArrayList;

public class Cliente {
    private ArrayList<Produto> carrinhoDeCompras;
    
    public Cliente(){
        carrinhoDeCompras = new ArrayList<Produto>();
    }

    public ArrayList<Produto> getCarrinhoDeCompras() {
        return carrinhoDeCompras;
    }
    
    public void addProduto(Produto produto){
        carrinhoDeCompras.add(produto);
    }
    public void realizarCompra(){
        
    }
    public String consultarValor(String codigo){
        return Leitor.mostrarValorProduto(codigo);
    }
    
    
}
