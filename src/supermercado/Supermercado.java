/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Richiely Batista
 */
public class Supermercado{

    /**
     * @param args the command line arguments
     */
    static EstoqueDeProdutos listaDeProdutos = new EstoqueDeProdutos();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Saudacao();
        Feed();

        Gerente ger = new Gerente("GERENTE DO MERCADO", "admin", "admin", listaDeProdutos);
        OperadorDeCaixa funcionario1 = new OperadorDeCaixa("Manoelzinho", "f1", "1234", listaDeProdutos);
        OperadorDeCaixa funcionario2 = new OperadorDeCaixa("Pedrinho", "f2", "1234" , listaDeProdutos);
        OperadorDeCaixa funcionario3 = new OperadorDeCaixa("Joaozinho", "f3", "1234" , listaDeProdutos);
        OperadorDeCaixa funcionario4 = new OperadorDeCaixa("Robertinho", "f4", "1234" , listaDeProdutos);
        OperadorDeCaixa funcionario5 = new OperadorDeCaixa("Serginho","f5", "1234" , listaDeProdutos);
        List<Funcionario> funcionarios = new LinkedList<Funcionario>();
        
        //Criar caixas do supermercado
        Caixa c1 = new Caixa(01, funcionario1);
        Caixa c2 = new Caixa(02, funcionario2);
        Caixa c3 = new Caixa(03, funcionario3);
        
        
        
        funcionarios.add(ger);
        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);
        funcionarios.add(funcionario3);
        funcionarios.add(funcionario4);
        funcionarios.add(funcionario5);

//        funcionario1.mostrarEstoque();
//        funcionario1.adicionarProduto(new ProdutoQuilo("21", "Maça", 1.99, 53.8), 0);
        
        ger.adicionarProduto(new ProdutoQuilo("21", "Maça", 1.99, 53.8), 0);
        ger.adicionarProduto(new ProdutoQuilo("21", "Maça", 1.99, 16.2), 0);
        funcionario1.removerProduto("20", 8);
        funcionario1.removerProduto("21", 100);
        
        
        //Criar carrinho de produtos
        //CarrinhoDeCompras carrinho1 = new CarrinhoDeCompras();
        
        
        
        //ger.emitirRelatorioDeEstoque();
        System.out.println(Leitor.mostrarValorProduto("11"));
        //exibirEstoqueCliente();
        ger.emitirRelatorioDeEstoque();
        listaDeProdutos.mostrarEstoque();
        Comprar();
        
    }
    
   
    private static void Saudacao() {
        System.out.println("*********************************************************");
        System.out.println("Bem vindo ao Sistema de Controle e Vendas do Supermercado");
        System.out.println("*********************************************************");
        System.out.println("Aperte ENTER para continuar ...");
        scanner.nextLine();
    }

    private static void Feed() {
        System.out.println("*********************************************************");
        System.out.println("Carga inicial do estoque de produtos");
        System.out.println("*********************************************************");
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
        
        System.out.println("Estoque criado com sucesso!");
        System.out.println("Aperte ENTER para continuar ...");
        scanner.nextLine();
    }
    
    //ações de comprar vários produtos no mercado
    private static void Comprar(){
        System.out.println("**************** OPERAÇÕES DE COMPRA ****************");
        System.out.println(" ( 1 ) PARA COMPRAR \n ( 0 ) PARA OUTRA OPERAÇÃO ");
        String comp = scanner.nextLine();
        listaDeProdutos.mostrarEstoque();
        switch(comp){
            case "1":
                //Cria um cliente e atibui um carrinho a ele
                CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
                Cliente cli = new Cliente();
                String continuar = "1";
                    Integer quantidade = 0;
                    String codigo = "";
                while(continuar.equals("1")){
                   
                    System.out.println("***** DIGITE O CÓDIGO DO PRODUTO  *****");
                    codigo = scanner.nextLine();
                    
                    

                    List produtos = EstoqueDeProdutos.produtoParaCompra(codigo, quantidade);
                    //se existir produto em estoque, a quantidade e se o produto for por unidade
                    if(produtos != null && String.valueOf(codigo.charAt(codigo.length()-1)).equals(String.valueOf(0)) ){
                        System.out.println("PRODUTO UNITARIO");
                        Produto prod = (Produto) produtos.get(0);
                        System.out.println("***** DIGITE A QUANTIDADE DE "+prod.getNome()+"  *****");
                        quantidade = Integer.parseInt(scanner.nextLine());
                        
                        int cont = 0;
                        while(cont < quantidade){
                            Iterator it = produtos.iterator();
                            if(it.hasNext()){
                                Produto p = (Produto) it.next();
                                cli.getCarrinho().addProduto(p);
                                //cli.getCarrinho().setValorCompra(cli.getCarrinho().getValorCompra()+p.getValor());
                                /******* Colocar aqui a remoção de cada produto do estoque ******/
                            }
                             cont ++;
                        }
                         cli.getCarrinho().setValorCompra(cli.getCarrinho().getValorCompra() + prod.calcularValor(quantidade));
                        //se for produto por kilo, não insere mais de um no carrinho
                    }else if(produtos != null && String.valueOf(codigo.charAt(codigo.length()-1)).equals(String.valueOf(1))){
                        System.out.println("PRODUTO POR PESO");
                       
                        Iterator it = produtos.iterator();
                        if(it.hasNext()){
                            Produto p = (Produto) it.next();
                             System.out.println("***** QUANTOS KILOS DE "+p.getNome()+"?*****");
                            quantidade = Integer.parseInt(scanner.nextLine());
                            cli.getCarrinho().addProduto(p);
                            cli.getCarrinho().setValorCompra(cli.getCarrinho().getValorCompra() + p.calcularValor(quantidade));
                        }
                    }
                    System.out.println("********* DIGITE **********");
                    System.out.println(" ( 1 ) - para continuar comprando ou \n ( 2 ) - para finalizar compra ");
                    continuar = scanner.next();
                    
                    //limpa cache do teclado para a entrada de dados
                    scanner.nextLine();
                    
                }
                 if(continuar.equals("2")){
                        System.out.println("VALOR DA SUA COMPRA É: "+cli.realizarCompra().calcularValorCompra());
                    }
                break; 
        }
        
    }
   
}
