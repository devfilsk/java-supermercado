
package supermercado;

public class Leitor {
    
    public static void mostrarValorProduto(String codigo){
        System.out.println("*****************************************************");
        System.out.println("*   Procurando produto de cógido '" + codigo + "'   *");
        
        Produto produto = EstoqueDeProdutos.seekProduto(codigo);
        if(produto != null) {
            System.out.println("*   Produto: "+ produto.getNome() + "   *\n*   Preço: R$ " + produto.getValor() + "   *");
        }
        else{
            System.out.println("*   Produto não encontrado!    *");
        }
        System.out.println("*****************************************************");
    }
    
}
