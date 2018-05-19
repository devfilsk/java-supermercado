/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Richiely Batista
 */
public class EstoqueDeProdutos {
    // key = codigo do produto , value = lista com a quantidade do mesmo produto em estoque
    public static Map<String, List<Produto>> estoque;
    private static Map<String, List<Produto>> copiaDoEstoque;
    private static Produto p;
    
    public EstoqueDeProdutos() {
        estoque = new LinkedHashMap<String, List<Produto>>();
    }

    private static Map<String, List<Produto>> getCopiaDoEstoque() {
        return copiaDoEstoque;
    }

    private static void setCopiaDoEstoque(Map<String, List<Produto>> copiaDoEstoque) {
        copiaDoEstoque = copiaDoEstoque;
    }
    
    public static void adicionarProduto(Produto produto, double quantidade){
        List<Produto> produtosDoCodigo;
        String codigo = produto.getCodigo();
        
        if(estoque.containsKey(codigo)){
            produtosDoCodigo = estoque.get(codigo);
            
            if (produto instanceof ProdutoUnitario) {
                while (quantidade > 0) {                
                    produtosDoCodigo.add(produto);
                    quantidade--;
                }
            }
            else if (produto instanceof ProdutoQuilo) {
                ProdutoQuilo pdt = (ProdutoQuilo)produtosDoCodigo.get(0);
                pdt.setQtdQuilos(pdt.getQtdQuilos() +  ((ProdutoQuilo) produto).getQtdQuilos());
                produtosDoCodigo = new LinkedList<Produto>();
                produtosDoCodigo.add(pdt);
            }
            
            estoque.put(codigo, produtosDoCodigo);
        }else{
            produtosDoCodigo = new LinkedList<Produto>();
            
            if (produto instanceof ProdutoUnitario) {
                while (quantidade > 0) {                
                    produtosDoCodigo.add(produto);
                    quantidade--;
                }
            } 
            else if (produto instanceof ProdutoQuilo) {
                produtosDoCodigo.add(produto);
            }
            
            estoque.put(codigo, produtosDoCodigo);
        }
    }
    
    public static void removerProduto(String codigo, double quantidade){
        List<Produto> produtosDoCodigo;
        boolean removerDoEstoque = false;
        
        if(estoque.containsKey(codigo)){
            produtosDoCodigo = estoque.get(codigo);
            p = produtosDoCodigo.get(0);
            if (produtosDoCodigo.get(0) instanceof ProdutoUnitario) {
                double temp = quantidade;
                for (int i = 0; i < quantidade; i++) {
                    if(produtosDoCodigo.size() > 0 && temp > 0) {                
                        produtosDoCodigo.remove(produtosDoCodigo.get(0));
                        //System.out.println("Removendo um produto de codigo: " + codigo);
                        temp--;
                    }
                    else {
                        //System.out.println("ATENÇÃO! O estoque desse produto acabou: " + p.getNome()); 
                        removerDoEstoque = true;
                        break;
                    }
                }
            }
            else if (p instanceof ProdutoQuilo){
                ProdutoQuilo pdtQuilo = (ProdutoQuilo)p;    
                double peso = pdtQuilo.getQtdQuilos() - quantidade;
                removerDoEstoque = peso < 0 ? true : false;
                pdtQuilo.setQtdQuilos(peso);
                produtosDoCodigo.clear();
                produtosDoCodigo.add(pdtQuilo);
            }
            if (removerDoEstoque) {
                System.out.println("ATENÇÃO! O estoque desse produto acabou: " + p.getNome()); 
                estoque.remove(codigo);
            }
            else{
                estoque.put(codigo, produtosDoCodigo);
            }
        }else{
            System.out.println("ATENÇÃO! Não existe produto em estoque com o código " + codigo + "."); 
        }
        System.out.println();
    }
    
    public static void mostrarEstoque(int opcaoDeEstoque){
        Map<String, List<Produto>> estoqueTemp = null;
        if (opcaoDeEstoque == 1) {
            estoqueTemp = estoque;
        }
        else if (opcaoDeEstoque == 2) {
            estoqueTemp = getCopiaDoEstoque();
        }
        System.out.println("***** ESTOQUE DE PRODUTOS *****");
        Iterator listasDeCodigos = estoqueTemp.keySet().iterator();
        int quantidade = 0;
        double quilos = 0;
        while (listasDeCodigos.hasNext()) {
            String codigo = (String)listasDeCodigos.next();
            Iterator produtos = estoqueTemp.get(codigo).iterator();
            boolean mostrarNomeProduto = true;
           
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

                quantidade++;
            }
            
            if (p instanceof ProdutoUnitario) {
                System.out.println("Quantidade em estoque = " +quantidade + "\n");
            }
            quantidade = 0;
        }
        System.out.println();
    }
 
    public static double precoPorCodigo(String codigo){
        if(estoque.containsKey(codigo)){
            Iterator it = EstoqueDeProdutos.estoque.get(codigo).iterator();
            Produto produto = null;
            if(it.hasNext()){
                produto = (Produto) it.next();
                return produto.calcularValor(1);
            }else{
                return 0.0;
            }
        }
        return 0.0;
    }
    
    public static Produto seekProduto(String codigo) {
        Produto produto = null;
        if(estoque.containsKey(codigo)){
            Iterator it = EstoqueDeProdutos.estoque.get(codigo).iterator();
            
            if(it.hasNext()){
                produto = (Produto) it.next();
                return produto;
            }else{
                System.out.println("Produto não encontrado!");
            }
        }
        return produto;
    }
    
    public static List produtoParaCompra(String codigo, int quantidade){
        //Verifica se existe o produto no estoque e se possui a quantidade esperada
        //if(EstoqueDeProdutos.estoque.containsKey(codigo) && EstoqueDeProdutos.estoque.get(codigo).size() >= quantidade){
        List<Produto> produtosDoCodigo;
        if(EstoqueDeProdutos.estoque.containsKey(codigo)){
            Iterator it = EstoqueDeProdutos.estoque.get(codigo).iterator();
             produtosDoCodigo = estoque.get(codigo);
            return produtosDoCodigo;
        }else{
            System.out.println("Produto Indisponível");
            return null;
        }
    }
    
     private static void exibirEstoqueCliente(){
        Produto p = null;
        System.out.println("***** PRODUTOS DISPONÍVEIS *****");
        Iterator listasDeCodigos = EstoqueDeProdutos.estoque.keySet().iterator();
        int quantidade = 0;
        double quilos = 0;
        while (listasDeCodigos.hasNext()) {
            String codigo = (String)listasDeCodigos.next();
            Iterator produtos = estoque.get(codigo).iterator();
            boolean mostrarNomeProduto = true;
           
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

                quantidade++;
            }
            
            if (p instanceof ProdutoUnitario) {
                System.out.println("Quantidade em estoque = " +quantidade + "\n");
            }
            quantidade = 0;
        }
        System.out.println();
    }
     
    //public static EstoqueDeProdutos clonarEstoque(){
        // Para clonar os valores e nÃ£o a referÃªncia, percorremos todo o estoque 
        // e copiamos os produtos no novo objeto.
//        EstoqueDeProdutos estoqueClone = new EstoqueDeProdutos();
//        for (String codigo : estoque.keySet()) {
//            estoqueClone.estoque.put(codigo, new LinkedList<Produto>());
//            List<Produto> lista = estoque.get(codigo);
//            for (Produto produto : lista) {
//                estoqueClone.estoque.get(codigo).add(produto);
//            }
//        } 
//        return estoqueClone;
    //}
    
    public void Feed(){
        System.out.println("*****************************************************");
        System.out.println("*       Carga inicial do estoque de produtos        *");
        
        ProdutoUnitario leite = new ProdutoUnitario("10", "Leite", 2.50);
        this.adicionarProduto(leite, 2.0);
        
        ProdutoUnitario arroz = new ProdutoUnitario("20", "Arroz", 11.95);
        this.adicionarProduto(arroz, 6.0);
        
        ProdutoUnitario feijao = new ProdutoUnitario("30", "Feijão", 4.99);
        this.adicionarProduto(feijao, 8.0);
        
        ProdutoQuilo melancia = new ProdutoQuilo("11", "Tomate", 3.50, 100);
        this.adicionarProduto(melancia, 0);
        
        System.out.println("*             Estoque criado com sucesso!           *");
        System.out.println("*****************************************************");
    }
    
    public static void copiarEstoque(){
        copiaDoEstoque = estoque.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e-> new LinkedList(e.getValue())));
    }
    
    public static void exibirCopiaInicialDoEstoque(){
        mostrarEstoque(2);
    }
}