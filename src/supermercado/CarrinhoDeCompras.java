
package supermercado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import static supermercado.EstoqueDeProdutos.estoque;

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
                ProdutoQuilo pdt = (ProdutoQuilo) novoProduto.get(0);
                pdt.setQtdQuilos(pdt.getQtdQuilos() + quantidade);
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
                ((ProdutoQuilo) produto).setQtdQuilos(quantidade);
                novoProduto.add(produto);
               
            } 
            
            produtosCarrinho.put(codigo, novoProduto);
        }
        
    }
    
    public void exibirCarrinhoCliente(){
        Produto p = null;
        System.out.println("***** PRODUTOS NO CARRINHO *****");
        Iterator it = produtosCarrinho.keySet().iterator();
        int quantidade = 0;
        double quilos = 0;
        while (it.hasNext()) {
            String codigo = (String)it.next();
            Iterator produtos = produtosCarrinho.get(codigo).iterator();
            boolean mostrarNomeProduto = true;
            ProdutoUnitario prodUnidade = (ProdutoUnitario) produtosCarrinho.get(codigo);
            while (produtos.hasNext()) {
                p = (Produto)produtos.next();
                
                if (mostrarNomeProduto) {
                    System.out.println("Código: " + codigo);
                    System.out.println("Produto: " + p.getNome());
                    mostrarNomeProduto = false;
                }
                if (p instanceof ProdutoQuilo) {
                    ProdutoQuilo pdt = (ProdutoQuilo)p;
                    System.out.println("Quilos: " + pdt.getQtdQuilos() + "kg\n");
                }
                if (p instanceof ProdutoUnitario) {
                    System.out.println("Quantidade no carrinho = " + quantidade + "\n");
                }
                quantidade++;
            }
            
           
            quantidade = 0;
        }
        System.out.println();
    }
    
     public double calcularPrecoCarrinho(){
        
        // Calcular o valor total da compra usando o somatorio de:
        // - calcularValorPorItem
        // - calcularValorPorPeso
        // Calcular troco do cliente se pagar em $
       double valorTotal = 0;
       Iterator itMap = produtosCarrinho.keySet().iterator();
       List<Produto> list;
       int quantidade = 0;
       double valorPeso = 0;
       double ktdKilo = 0;
       while(itMap.hasNext()){
           String codigo = (String) itMap.next();
           Iterator produtos = this.produtosCarrinho.get(codigo).iterator();
           list = (List) produtosCarrinho.get(codigo);
           
           while(produtos.hasNext()){
               Produto produtoList = (Produto) produtos.next();
               
               
                //Fazer a variavel "valorTotal" receber o valor do calculo por kilo
                if(produtoList instanceof ProdutoQuilo){
                    //Pega a quantidade de kilos e o valor do peso para que a balança possa calcular
                    ProdutoQuilo produtokg = (ProdutoQuilo) list.get(0);
                    valorPeso = produtokg.getValor();
                    ktdKilo = produtokg.getQtdQuilos();
                    valorTotal += Balanca.calcularValorPorPeso(valorPeso,ktdKilo);
                    
                }
                //Fazer a variavel "valorTotal" receber o valor do calculo por Unidade
                else if(produtoList instanceof ProdutoUnitario){
                    //QUAL A MELHOR FORMA DE CHAMAR O MÉTODO calcularValorPorUnidade chamar da balança ou do caixa???
                     quantidade = list.size();
                     System.out.println(list.size());
                     ProdutoUnitario produtounit = (ProdutoUnitario) list.get(0);
                     valorTotal += Balanca.calcularValorPorItem(produtounit.getValor(), quantidade);
                } 
           }
       }
       return valorTotal;
    }
    
    public double calcularValorCompra(){  
        return this.getValorCompra();
    }
    
}
