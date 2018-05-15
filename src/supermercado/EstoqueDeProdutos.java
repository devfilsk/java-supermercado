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

/**
 *
 * @author Richiely Batista
 */
public class EstoqueDeProdutos implements IOperacoesDoEstoque{
    // key = codigo do produto , value = lista com a quantidade do mesmo produto em estoque
    private static Map<String, List<Produto>> estoque;
    private Produto p;
    
    public EstoqueDeProdutos() {
        estoque = new LinkedHashMap<String, List<Produto>>();
    }
    
    public void adicionarProduto(Produto produto, double quantidade){
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
                pdt.setQtdQuilos(pdt.getQtdQuilos() + ((ProdutoQuilo) produto).getQtdQuilos());
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
    
    public void removerProduto(String codigo, double quantidade){
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
                        System.out.println("ATENÇÃO! O estoque desse produto acabou."); 
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
            // se a quantidade de produtos for = 0, mantem o codigo no estoque ou remove ?
            if (removerDoEstoque) {
                estoque.remove(codigo);
            }
            else{
                estoque.put(codigo, produtosDoCodigo);
            }
        }else{
            System.out.println("ATENÇÃO! Não existe produto em estoque."); 
        }
        
        System.out.println();
    }
    
    public void mostrarEstoque(){
        System.out.println("***** ESTOQUE DE PRODUTOS *****");
        Iterator listasDeCodigos = estoque.keySet().iterator();
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
 
    //Busca preço de produto por código
    public static double precoPorCodigo(String codigo){
        if(EstoqueDeProdutos.estoque.containsKey(codigo)){
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
    
}
