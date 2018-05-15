
package supermercado;

public class Leitor {
    
    public static String mostrarValorProduto(String codigo){
        if(EstoqueDeProdutos.precoPorCodigo(codigo) > 0) {
            return "Valor: "+ EstoqueDeProdutos.precoPorCodigo(codigo);
        }else{
            return "Produto não encontrado!";
        }
    }
    
}
