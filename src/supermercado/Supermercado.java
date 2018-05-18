/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.ArrayList;
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
    static List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    static List<Caixa> caixas = new ArrayList<Caixa>();
    static List<String> senhas = new ArrayList<String>()
    {{ add("1111"); add("1122"); add("1133"); add("1144"); add("1155"); }};
    
    public static void main(String[] args) {
        //Saudacao();
        Feed();
        CriarFuncionarios();
        
        Gerente gerente = (Gerente)funcionarios.get(0);
        
        String opcao = "";
        Boolean sairMenu = false;
        do{
            int chances = 3;
            int tentativas = 0;
            System.out.println("**************** ACESSO ****************");
            System.out.println(" ( 1 ) Ger0ente \n ( 2 ) Funcionário \n ( 3 ) Cliente \n ( 0 ) Sair do sistema");
            opcao = scanner.nextLine();
        
            switch(opcao){
                case "1":
                    System.out.println("****    Login   ****");
                    Boolean acessou = false;
                    do{
                        System.out.println("Senha: ");
                        String senha = scanner.next();
                        if (gerente.getSenha().equals(senha)) {
                            acessou = true;
                            System.out.println("**************** Bem vindo, " + gerente.getNome() + "! ****************");
                            String opcaoFunGer = "";
                            Boolean sairMenuGer = false;
                            do{
                                MostrarMenuGerente();
                                opcaoFunGer = scanner.next();
                                switch(opcaoFunGer){
                                    case "1": // adicionar produto
                                        System.out.println("adicionando");
                                        gerente.adicionarProduto(new ProdutoQuilo("21", "Maça", 1.99, 53.8), 0);
                                        gerente.adicionarProduto(new ProdutoQuilo("21", "Maça", 1.99, 16.2), 0);
                                        break;
                                    case "2": // emitir relatorio estoque
                                        gerente.emitirRelatorioDeEstoque();
                                        break;
                                    case "3": // emitir relatorio vendas
                                        gerente.emitirRelatorioDeVendas();
                                        System.out.println("emitindo vendas...");
                                        break;
                                    case "0":
                                        System.out.println("Voltando para o menu de acesso...");
                                        //scanner.nextLine();
                                        sairMenuGer = true;
                                        break;
                                    default:
                                        //scanner.nextLine();
                                        break;
                                }
                                scanner.nextLine();
                            }while(!sairMenuGer);
                        }
                        else{
                            System.out.println("Senha incorreta.");
                            tentativas++;
                        }
                    }while(tentativas < chances && !acessou);
                    if ( tentativas >= chances && !acessou) {  
                        System.out.println("As tentativas de login acabaram.\nSaindo...");
                        scanner.nextLine();
                    }  
                    break;
                case "2":
                    Boolean sairMenuOperador = false;
                    do{
                        MostrarMenuListaDeCaixas(caixas);
                        String opCaixa = scanner.next();
                        sairMenuOperador = true;
                        System.out.println("Operador, digite sua senha");
                        switch(opCaixa){
                            case "1":
                                String senhaCaixa = scanner.next();
                                if (senhas.contains(senhaCaixa)) {
                                    Funcionario f = (Funcionario)funcionarios.stream().filter(x->x.getSenha().equals(senhaCaixa)).findFirst().get();
                                    System.out.println("****    Bem vindo ao Caixa 1 , " + f.getNome() + "    ****");
                                    System.out.println();
                                    sairMenuOperador = true;
                                }
                                break;
                            case "2":
                                gerente.emitirRelatorioDeEstoque();

                                break;
                            case "3":
                                gerente.emitirRelatorioDeVendas();
                                break;
                            case "0":
                                sairMenuOperador = true;
                                break;
                            default:
                                break;
                        }        
                    }while(!sairMenuOperador);
                    scanner.nextLine();
                    break;
                case "3":
                    System.out.println("**************** Bem vindo, caro cliente! ****************");
                    break;
                case "0":
                    sairMenu = true;
                    break;
                default:
                    break;
            }
        }while(!sairMenu);
        
//        gerente.adicionarProduto(new ProdutoQuilo("21", "Maça", 1.99, 53.8), 0);
//        gerente.adicionarProduto(new ProdutoQuilo("21", "Maça", 1.99, 16.2), 0);
//        funcionario1.removerProduto("20", 8);
//        funcionario1.removerProduto("21", 100);
        
        //Criar carrinho de produtos
        //CarrinhoDeCompras carrinho1 = new CarrinhoDeCompras();
        
        //Leitor.mostrarValorProduto("11");
        //Leitor.mostrarValorProduto("99");
        //exibirEstoqueCliente();
        //gerente.emitirRelatorioDeEstoque();
        
       // Comprar();
    }
   
    private static void Saudacao() {
        System.out.println("*****************************************************************");
        System.out.println("*   Bem vindo ao Sistema de Controle e Vendas do Supermercado   *");
        System.out.println("*****************************************************************");
        System.out.println();
        System.out.println("Aperte ENTER para continuar ...");
        scanner.nextLine();
    }

    private static void Feed() {
        listaDeProdutos.Feed();
        System.out.println();
//        System.out.println("Aperte ENTER para continuar ...");
//        scanner.nextLine();
    }
    
    private static void CriarFuncionarios(){
        Gerente gerente = new Gerente("GERENTE DO MERCADO", "admin", "admin" );
        OperadorDeCaixa funcionario1 = new OperadorDeCaixa("Manoelzinho", "f1", "1111" );
        OperadorDeCaixa funcionario2 = new OperadorDeCaixa("Pedrinho", "f2", "1122"  );
        OperadorDeCaixa funcionario3 = new OperadorDeCaixa("Joaozinho", "f3", "1133" );
        OperadorDeCaixa funcionario4 = new OperadorDeCaixa("Robertinho", "f4", "1144"  );
        OperadorDeCaixa funcionario5 = new OperadorDeCaixa("Serginho","f5", "1155" );

        funcionarios.add(gerente);          //[0]
        funcionarios.add(funcionario1);     
        funcionarios.add(funcionario2);     
        funcionarios.add(funcionario3);     
        funcionarios.add(funcionario4);
        funcionarios.add(funcionario5);

        //Criar caixas do supermercado
        Caixa c1 = new Caixa(01, funcionario1);
        Caixa c2 = new Caixa(02, funcionario2);
        Caixa c3 = new Caixa(03, funcionario3);
        
        caixas.add(c1); //[0]
        caixas.add(c2); //[1]
        caixas.add(c3); //[2]
    }
    
    private static void MostrarMenuGerente(){
        System.out.println("*****************************************************************");
        System.out.println("   1- Adicionar produto no estoque \n   2- Emitir relatório de estoque \n   3- Emitir relatório de vendas \n   0- Logout ");
        System.out.println("*****************************************************************");
        System.out.println();
    }
    
    private static void MostrarMenuListaDeCaixas(List<Caixa> caixas){
        System.out.println("*****************************************************************");
        
        System.out.println("    CAIXAS   ");
        Iterator i = caixas.iterator();
        int op = 1;
        while (i.hasNext()) {
            Caixa caixa = (Caixa)i.next();
            if (caixa.getOperadorCaixa()!= null) { // se não tiver operador setado
                System.out.print("  " + op + "- " + caixa +"\n");
            }
            else{
                System.out.print("  " + op + "- Logout " + caixa +"\n");
            }    
            op++;
        }
        System.out.println("  0- Sair");
        System.out.println("*****************************************************************");
        System.out.println();
    }
    
    //ações de comprar vários produtos no mercado
    private static void Comprar(){
        System.out.println("**************** OPERAÇÕES DE COMPRA ****************");
        System.out.println(" ( 1 ) PARA COMPRAR \n ( 0 ) PARA OUTRA OPERAÇÃO ");
        String comp = scanner.nextLine();
        EstoqueDeProdutos.mostrarEstoque();
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
                        System.out.println("***** DIGITE A QUANTIDADE DE "+prod.getNome().toUpperCase()+"  *****");
                        quantidade = Integer.parseInt(scanner.nextLine());
                        
                         cli.getCarrinho().addProduto(prod, quantidade);
                        
                         cli.getCarrinho().setValorCompra(cli.getCarrinho().getValorCompra() + prod.calcularValor(quantidade));
                        //se for produto por kilo, não insere mais de um no carrinho
                    }else if(produtos != null && String.valueOf(codigo.charAt(codigo.length()-1)).equals(String.valueOf(1))){
                        System.out.println("PRODUTO POR PESO");
                       
                        Iterator it = produtos.iterator();
                        if(it.hasNext()){
                            Produto p = (Produto) it.next();
                             System.out.println("***** QUANTIDADE DE "+p.getNome().toUpperCase()+" EM KILOS *****");
                            quantidade = Integer.parseInt(scanner.nextLine());
                            cli.getCarrinho().addProduto(p, quantidade);
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
