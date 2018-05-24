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
    public static Map<String, List<Produto>> estoque = new LinkedHashMap<String, List<Produto>>();;
    private static Map<String, List<Produto>> copiaDoEstoque;
    private static Produto p;

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
            
            if (produtosDoCodigo.get(0).getNome().equals(produto.getNome())) {
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
            }
            else{
                System.out.println("ATENÇÃO\tATENÇÃO\tATENÇÃO\tATENÇÃO\tATENÇÃO");
                System.out.println("Produto NÃO foi adicionado pois o codigo '" + produto.getCodigo() + "' possui apenas produtos '"
                +produtosDoCodigo.get(0).getNome() + "' e voce esta tentando adicionar '" + produto.getNome() + "'");
            }
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
                ProdutoQuilo pdtQuilo = ObtenhaProdutoQuiloTemporario(p);
                        
                double peso = pdtQuilo.getQtdQuilos() - quantidade;
                removerDoEstoque = peso < 0 ? true : false;
                pdtQuilo.setQtdQuilos(peso);
                produtosDoCodigo.clear();
                produtosDoCodigo.add(pdtQuilo);
            }
            if (removerDoEstoque) {
                Utilitario.ImprimaMensagem("*  ATENÇÃO! O estoque desse produto acabou: " + p.getNome() +"  *"); 
                estoque.remove(codigo);
            }
            else{
                estoque.put(codigo, produtosDoCodigo);
            }
        }else{
            Utilitario.ImprimaMensagem("*  ATENÇÃO! Produto com o código " + codigo + " não encontrado  *");
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
        Utilitario.ImprimaMensagem("*                    ESTOQUE DE PRODUTOS                        *");
        Iterator listasDeCodigos = estoqueTemp.keySet().iterator();
        int quantidade = 0;
        double quilos = 0;
        while (listasDeCodigos.hasNext()) {
            String codigo = (String)listasDeCodigos.next();
            if (estoqueTemp.get(codigo).size() > 0) { // listar apenas se existir produtos
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
                    System.out.println("Quantidade em estoque = " + quantidade + "\n");
                }
                quantidade = 0;
            }
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
    
    //Verifica s eexiste o produto no estoque, caso não exista, retorna null
    public static Produto seekProduto(String codigo) {
        Map<String, List<Produto>> temp = estoque.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e-> new LinkedList(e.getValue())));
        if(temp.containsKey(codigo)){
            Iterator it = temp.get(codigo).iterator();
            
            if(it.hasNext()){
                Produto pdt = (Produto) it.next();
                if (pdt instanceof ProdutoUnitario) {
                    String codigo_un = pdt.getCodigo();
                    String nome_un = pdt.getNome();
                    double valor_un = pdt.getValor();
                    ProdutoUnitario pdt_un = new ProdutoUnitario(codigo_un, nome_un, valor_un);
                    return pdt_un;
                }
                else if (pdt instanceof ProdutoQuilo){
                    return ObtenhaProdutoQuiloTemporario(pdt);
                }
            }
        }else{
                Utilitario.ImprimaMensagem("*                   Produto indisponível!                     *");
        }
        return null;
    }
    
    //método que verifica se tem o produto no estoque ou se existe a quanitdade desejada do mesmo, caso alguma dessas afirmações seja falsa, ele retorna null
    public static boolean produtoParaCompra(String codigo, double quantidade, Boolean validarQuantidade){
        //Verifica se existe o produto no estoque e se possui a quantidade esperada
        //if(EstoqueDeProdutos.estoque.containsKey(codigo) && EstoqueDeProdutos.estoque.get(codigo).size() >= quantidade){
        boolean retorno = false;
        List<Produto> produtosDoCodigo = null;
        if(EstoqueDeProdutos.estoque.containsKey(codigo)){
            //Iterator it = EstoqueDeProdutos.estoque.get(codigo).iterator();
            produtosDoCodigo = estoque.get(codigo);
            if(produtosDoCodigo.get(0) instanceof ProdutoUnitario){
                if(produtosDoCodigo.size() >= quantidade){
                    //retorno = produtosDoCodigo.get(0);
                    retorno = true;
                }else{
                    if (validarQuantidade) {
                        Utilitario.ImprimaMensagem("*                    Infelizmente só possuimos "+produtosDoCodigo.size()+" unidades                      *");
                        retorno = false;
                    }
                    else{
                        retorno = true;
                    }
                    
                }
            }
            if(produtosDoCodigo.get(0) instanceof ProdutoQuilo){
                //List listkg = EstoqueDeProdutos.estoque.get(codigo);
                ProdutoQuilo prodKg = (ProdutoQuilo) produtosDoCodigo.get(0);
               
                if(prodKg.getQtdQuilos() >= quantidade){
                    retorno = true;
                    
                }else{
                    Utilitario.ImprimaMensagem("*                    Infelizmente só temos "+prodKg.getQtdQuilos()+" KG deste produto!                      *");
                    retorno = false;
                }
            } 
        }else{
            Utilitario.ImprimaMensagem("*                    Produto Indisponível!                      *");
            retorno = false;
        }
        return retorno;
    }
    
     public static void exibirEstoqueCliente(){
        Produto p = null;
        Utilitario.ImprimaMensagem("*                     PRODUTOS DISPONÍVEIS                      *");
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
     
    private static ProdutoQuilo ObtenhaProdutoQuiloTemporario(Produto temp) {
        String codigo_quilo = temp.getCodigo();
        String nome_quilo = temp.getNome();
        double valor_quilo = temp.getValor();
        double qtd_quilo = ((ProdutoQuilo) temp).getQtdQuilos();
        ProdutoQuilo pdtQuilo = new ProdutoQuilo(codigo_quilo, nome_quilo,
                valor_quilo, qtd_quilo);
        return pdtQuilo;
    }
     
     // Método responsável por criar o estoque inicial de produtos. Alimentar o sistema.
    public static void Feed(){
        System.out.println("*****************************************************************");
        System.out.println("*              Carga inicial do estoque de produtos             *");
        System.out.println("*                            Aguarde...                         *");
        ProdutoUnitario leite = new ProdutoUnitario("10", "Leite", 2.50);
        adicionarProduto(leite, 2.0);
        
        ProdutoUnitario arroz = new ProdutoUnitario("20", "Arroz", 11.95);
        adicionarProduto(arroz, 6.0);
        
        ProdutoUnitario feijao = new ProdutoUnitario("30", "Feijão", 4.99);
        adicionarProduto(feijao, 8.0);
        
        ProdutoQuilo melancia = new ProdutoQuilo("11", "Tomate", 3.50, 100);
        adicionarProduto(melancia, 0);
        
        System.out.println("*                  Estoque criado com sucesso!                  *");
        System.out.println("*****************************************************************");
    }
    
    // Método responsável por criar uma cópia do estoque de produtos para que o gerente 
    // possa emitir o relatório de estoque inicial x estoque final
    public static void copiarEstoque(){
        copiaDoEstoque = estoque.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e-> new LinkedList(e.getValue())));
    }
    
    // Método responsável por chamar a exibição do estoque inicial.
    public static void exibirCopiaInicialDoEstoque(){
        mostrarEstoque(2);
    }
}