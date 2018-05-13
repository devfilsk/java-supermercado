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
    
    public void removerProduto(Produto produto, double quantidade){
        List<Produto> produtosDoCodigo;
        String codigo = produto.getCodigo();
        
        if(estoque.containsKey(codigo)){
            produtosDoCodigo = estoque.get(codigo);
        
            while (produtosDoCodigo.size() > 0 && quantidade > 0) {                
                produtosDoCodigo.remove(produto);
                System.out.println("Removendo um produto de codigo: " + codigo);
                quantidade--;
            }
            
            estoque.put(codigo, produtosDoCodigo);
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
            System.out.println("Código: " + codigo);
            boolean mostrarNomeProduto = true;
           
            while (produtos.hasNext()) {
                p = (Produto)produtos.next();
                
                if (mostrarNomeProduto) {
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
    
}
