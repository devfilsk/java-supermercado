
package supermercado;

public class Leitor {
    
    public static void mostrarValorProduto(String codigo){
        Utilitario.ImprimaMensagem("*               Procurando produto de cógido '" + codigo + "'           *");    
        
        Produto produto = EstoqueDeProdutos.seekProduto(codigo);
        if(produto != null) {
            System.out.println("*   Produto: "+ produto.getNome() + "   *\n*   Preço: R$ " + produto.getValor() + "   *");
        }
        else{
            Utilitario.ImprimaMensagem("*                    Produto não encontrado!                    *");
        }
        System.out.println();
        System.out.println();
        System.out.println("*****************************************************");
    }
    
}
