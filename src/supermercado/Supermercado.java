/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

/**
 *
 * @author Richiely Batista
 */
public class Supermercado {

    /**
     * @param args the command line arguments
     */
    static EstoqueDeProdutos listaDeProdutos = new EstoqueDeProdutos();
    
    public static void main(String[] args) {
        Feed();
        
        Gerente ger = new Gerente("GERENTE DO MERCADO", listaDeProdutos);
        
        OperadorDeCaixa funcionario1 = new OperadorDeCaixa("Manoelzinho", listaDeProdutos);
        funcionario1.mostrarEstoque();
        funcionario1.adicionarProduto(new ProdutoQuilo("21", "Maça", 1.99, 53.8), 0);
        
        ger.adicionarProduto(new ProdutoQuilo("21", "Maça", 1.99, 53.8), 0);
        ger.adicionarProduto(new ProdutoQuilo("21", "Maça", 1.99, 16.2), 0);
        ger.mostrarEstoque();
    }

    private static void Feed() {
        System.out.println("**** INICIANDO O ESTOQUE DE PRODUTOS DO SUPERMERCADO ****");
        ProdutoUnitario leite = new ProdutoUnitario("10", "Leite", 2.50);
        // Adiciona 2 produtos1
        listaDeProdutos.adicionarProduto(leite, 2.0);
        
        ProdutoUnitario arroz = new ProdutoUnitario("20", "Arroz", 11.95);
        // Adiciona 6 produto2
        listaDeProdutos.adicionarProduto(arroz, 6.0);
        
        ProdutoUnitario feijao = new ProdutoUnitario("30", "Feijão", 4.99);
        // Adiciona 8 feijao
        listaDeProdutos.adicionarProduto(feijao, 8.0);
        
        ProdutoQuilo melancia = new ProdutoQuilo("11", "Tomate", 3.50, 100);
        listaDeProdutos.adicionarProduto(melancia, 0);
        
        listaDeProdutos.removerProduto(feijao,5.0);
    }
    
}
