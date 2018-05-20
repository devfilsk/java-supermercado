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
import java.util.stream.Collectors;

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
        Saudacao();
        Feed();
        CriarFuncionarios();
        
        Gerente gerente = (Gerente)funcionarios.get(0);
        
        Boolean sairMenu = false;
        do{
            int chances = 3;
            int tentativas = 0;
            Utilitario.ImprimaMensagem("*                            ACESSO                             *");
            System.out.println(" ( 1 ) Gerente \n ( 2 ) Funcionário \n ( 3 ) Cliente \n ( 0 ) Sair do sistema");
            int opcao = scanner.nextInt();
        
            switch(opcao){
                case 1: // Gerente
                    ControleMenuGerente(gerente, tentativas, chances);
                    break;
                case 2: // Funcionário (operador)
                    Boolean sairMenuOperador = false;
                    
                    do{
                        MostrarMenuListaDeCaixas(caixas);
                        int opCaixa = scanner.nextInt();
                        
                        switch(opCaixa){
                            case 1:
                                Caixa c1 = caixas.get(0);
                                if (c1.getOperadorCaixa() == null) {
                                    Boolean acessouCaixa = false;
                                    
                                    do{
                                        System.out.println("Operador, digite sua senha");
                                        String senhaCaixa = scanner.next();
                                       
                                        if (senhas.contains(senhaCaixa)){
                                            Funcionario f = (Funcionario)funcionarios.stream().filter(x->x.getSenha().equals(senhaCaixa)).findFirst().get();
                                            
                                            if(FuncionarioLogado(senhaCaixa) == null){
                                                Utilitario.ImprimaMensagem("*               Bem vindo ao Caixa 1, " + f.getNome() + "               *");
                                                
                                                System.out.println();
                                                c1.setOperadorCaixa(f);
                                                sairMenuOperador = true;
                                                acessouCaixa = true;
                                            }else{
                                                System.out.println("****    Atenção!    ****\nOperador já " + f.getNome() + " está logado em outro caixa.");
                                            }
                                        }else{
                                            System.out.println("****    Atenção!    ****\nSenha incorreta.");
                                            tentativas++;
                                        }
                                    }while(tentativas < chances && !acessouCaixa);
                                    
                                }else{
                                    Utilitario.ImprimaMensagem("*                   LOGOUT EFETUADO NO CAIXA 1                  *",
                                                               "*                       CAIXA 1 ESTÁ LIVRE                      *");
                                    c1.setOperadorCaixa(null);
                                }
                                
                                break;
                            case 2:
                                Caixa c2 = caixas.get(1);
                                
                                if (c2.getOperadorCaixa() == null) {
                                    Boolean acessouCaixa = false;
                                   
                                    do{
                                        System.out.println("Operador, digite sua senha");
                                        String senhaCaixa = scanner.next();
                                        
                                        if (senhas.contains(senhaCaixa)){
                                            Funcionario f = (Funcionario)funcionarios.stream().filter(x->x.getSenha().equals(senhaCaixa)).findFirst().get();
                                            
                                            if(FuncionarioLogado(senhaCaixa) == null){
                                                Utilitario.ImprimaMensagem("*               Bem vindo ao Caixa 2, " + f.getNome() + "               *");
                                                System.out.println();
                                                c2.setOperadorCaixa(f);
                                                sairMenuOperador = true;
                                                acessouCaixa = true;
                                            }else{
                                                System.out.println("****    Atenção!    ****\nOperador já " + f.getNome() + " está logado em outro caixa.");
                                            }
                                        }else{
                                            System.out.println("****    Atenção!    ****\nSenha incorreta.");
                                            tentativas++;
                                        }
                                    }while(tentativas < chances && !acessouCaixa);
                                    
                                }else{
                                    Utilitario.ImprimaMensagem("*                   LOGOUT EFETUADO NO CAIXA 2                  *",
                                                               "*                       CAIXA 2 ESTÁ LIVRE                      *");
                                    c2.setOperadorCaixa(null);
                                }
                                
                                break;
                            case 3:
                                Caixa c3 = caixas.get(2);
                                
                                if (c3.getOperadorCaixa() == null) {
                                    Boolean acessouCaixa = false;
                                    
                                    do{
                                        System.out.println("Operador, digite sua senha");
                                        String senhaCaixa = scanner.next();
                                        
                                        if (senhas.contains(senhaCaixa)){
                                            Funcionario f = (Funcionario)funcionarios.stream().filter(x->x.getSenha().equals(senhaCaixa)).findFirst().get();
                                            
                                            if(FuncionarioLogado(senhaCaixa) == null){
                                                Utilitario.ImprimaMensagem("*               Bem vindo ao Caixa 3, " + f.getNome() + "               *");
                                                System.out.println();
                                                c3.setOperadorCaixa(f);
                                                sairMenuOperador = true;
                                                acessouCaixa = true;
                                            }else{
                                                System.out.println("****    Atenção!    ****\nOperador já " + f.getNome() + " está logado em outro caixa.");
                                            }
                                        }else{
                                            System.out.println("****    Atenção!    ****\nSenha incorreta.");
                                            tentativas++;
                                        }
                                    }while(tentativas < chances && !acessouCaixa);
                                }else{
                                    Utilitario.ImprimaMensagem("*                   LOGOUT EFETUADO NO CAIXA 3                  *",
                                                               "*                       CAIXA 3 ESTÁ LIVRE                      *");
                                    c3.setOperadorCaixa(null);
                                }
                                break;
                            case 0:
                                sairMenuOperador = true;
                                break;
                            default:
                                break;
                        }        
                    }while(!sairMenuOperador);
                    
                    scanner.nextLine();
                    break;
                case 3: // cliente
                    Boolean sairMenuCliente = false;
                    Utilitario.ImprimaMensagem("*                    Bem vindo, caro cliente!                   *",
                                               "*               HOJE É UM ÓTIMO DIA PARA COMPRAS!               *");
                    Cliente cliente = new Cliente();
                   
                    do{
                        Boolean sairMenuEscolhaDeCaixas = false;
                        System.out.println(" ( 1 ) Escolher produtos \n ( 2 ) Comprar \n ( 3 ) Consultar Preço \n ( 0 ) Sair");
                        int opcaoCliente = scanner.nextInt();
                        
                        switch (opcaoCliente){
                            case 1:
                                // TODO atribuir os produtos escolhidos ao carrinho do cliente
                                EscolherProduto();
                                sairMenuCliente = true;
                                break;
                            case 2:
                                // TODO só prossegue com a listagem dos caixas se o cliente possuir itens no carrinho
                                if (true){
                                    int opcaoCaixaCompra;
                                    List<Caixa> caixasDisponiveis = ObtenhaCaixasDisponiveis();
                                    Utilitario.ImprimaMensagem("*                           CAIXAS                              *");
                                    do{
                                        Utilitario.ImprimaMensagem("*                    Selecione um caixa                         *");
                                        MostrarCaixasEmFuncionamento();
                                        opcaoCaixaCompra = scanner.nextInt();
                                        
                                        if (opcaoCaixaCompra > 0 && opcaoCaixaCompra <= caixasDisponiveis.size()) {
                                            Caixa caixaSelecionado = caixasDisponiveis.get(Integer.valueOf(opcaoCaixaCompra)-1);
                                            
                                            //caixaSelecionado.iniciarVenda(Cliente);
                                            
                                            sairMenuCliente = true;
                                            opcaoCaixaCompra = 0;
                                            Utilitario.ImprimaMensagem("*           Obrigado por comprar conosco! Volte sempre!         *");
                                        }
                                    }while(opcaoCaixaCompra != 0);
                                } else {
                                    Utilitario.ImprimaMensagem("*  Seu carrinho de compras está vazio. Escolha alguns produtos  *");
                                    sairMenuEscolhaDeCaixas = true;
                                }
                                break;
                            case 3:
                                Utilitario.ImprimaMensagem("*                   Informe o código do produto                 *");
                                String codigo = scanner.next();
                                Leitor.mostrarValorProduto(codigo);
                                break;
                            case 0: 
                                sairMenuCliente = true;
                                break;
                            default:
                                break;
                        }
                    }while(!sairMenuCliente);
                    
                    scanner.nextLine();
                    break;
                case 0:
                    sairMenu = true;
                    break;
                default:
                    break;
            }
        }while(!sairMenu);
    }
   
    // Método responsável por mostrar a mensagem de saudação do sistema.
    private static void Saudacao() {
        Utilitario.ImprimaMensagem("*   Bem vindo ao Sistema de Controle e Vendas do Supermercado   *");
        System.out.println();
        System.out.println("Aperte ENTER para continuar ...");
        scanner.nextLine();
    }

    // Método responsável por realizar a carga iniicial do estoque de produtos.
    private static void Feed() {
        listaDeProdutos.Feed();
        System.out.println();
        System.out.println("Aperte ENTER para continuar ...");
        scanner.nextLine();
    }
    
    // Método responsável por criar os funcionários do sistema.
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
        Caixa c1 = new Caixa(01);
        Caixa c2 = new Caixa(02);
        Caixa c3 = new Caixa(03);
        
        caixas.add(c1); //[0]
        caixas.add(c2); //[1]
        caixas.add(c3); //[2]
    }
    
    // Método responsável por controlar o menu Gerente
    private static void ControleMenuGerente(Gerente gerente, int tentativas, int chances) {
        Utilitario.ImprimaMensagem("*                             LOGIN                             *");
        Boolean acessou = false;
        
        do{
            System.out.println("Senha: ");
            String senha = scanner.next();
            
            if (gerente.getSenha().equals(senha)) {
                acessou = true;
                
                Utilitario.ImprimaMensagem("              Bem vindo, " + gerente.getNome() + "!              ");
                MenuGerente(gerente);
            }
            else{
                System.out.println("Senha incorreta.");
                tentativas++;
            }
        }while(tentativas < chances && !acessou);
        
        if (tentativas >= chances && !acessou) {
            System.out.println("As tentativas de login acabaram.\nSaindo...");
            scanner.nextLine();
        }
    }
    
    // Método com as opcoes do menu do gerente
    private static void MenuGerente(Gerente gerente) {
        Boolean sairMenuGer = false;
        do{
            MostrarMenuGerente();
            int opcaoFunGer = scanner.nextInt();
            
            switch(opcaoFunGer){
                case 1:
                    MenuGerenteAdicionarProduto(gerente);
                    break;
                case 2: // emitir relatorio estoque
                    gerente.emitirRelatorioDeEstoque();
                    break;
                case 3: // emitir relatorio vendas
                    gerente.emitirRelatorioDeVendas(caixas);
                    // TODO
                    System.out.println("emitindo vendas...");
                    break;
                case 0:
                    sairMenuGer = true;
                    break;
                default:
                    break;
            }
            scanner.nextLine();
        }while(!sairMenuGer);
    }
    
    // Método responsável por mostrar o menu do gerente.
    private static void MostrarMenuGerente(){
        Utilitario.ImprimaMensagem("*                      Menu de Gerente                          *");
        System.out.println(" ( 1 ) Adicionar produto no estoque \n ( 2 ) Emitir relatório de estoque \n ( 3 ) Emitir relatório de vendas \n ( 0 ) Logout ");
        System.out.println();
    }
    
    // Método responsável por mostrar o menu para o gerente adicionar o produto.
    private static void MenuGerenteAdicionarProduto(Gerente gerente) {
        // adicionar produto
        Boolean sairMenuProduto = false;
        
        do{
            Utilitario.ImprimaMensagem("*    Qual o tipo do produto que deseja adicionar ao estoque?    *");
            System.out.println(" ( 1 ) Produto unidade \n ( 2 ) Produto quilo \n ( 0 ) Sair");
            int tipoProduto  = scanner.nextInt();
            
            switch (tipoProduto){
                case 1:
                    WizardAddProdutoUnidade(gerente);
                    break;
                case 2:
                    WizardAddProdutoQuilo(gerente);
                    break;
                case 0:
                    sairMenuProduto = true;
                    break;
                default:
                    break;
            }
        }while(!sairMenuProduto);
    }
    
    // Método responsável por mostrar a escolha dos caixas.
    private static void MostrarMenuListaDeCaixas(List<Caixa> caixas){
        Utilitario.ImprimaMensagem("*                           CAIXAS                              *");
        Iterator i = caixas.iterator();
        int op = 1;
        while (i.hasNext()) {
            Caixa caixa = (Caixa)i.next();
            if (caixa.getOperadorCaixa() ==  null) { // se não tiver operador setado
                System.out.print(" ( " + op + " ) " + caixa +"\n");
            }
            else{
                System.out.print(" ( " + op + " ) Logout " + caixa +" ("+caixa.getOperadorCaixa().getNome()+")\n");
            }    
            op++;
        }
        System.out.println(" ( 0 ) Sair");
        System.out.println("*****************************************************************");
    }
    
    // Método repsonsável por identificar se existe usuário logado em algum dos caixas.
    private static Caixa FuncionarioLogado(String senha){
        return (Caixa)caixas.stream().filter(c->c.getOperadorCaixa() != null && c.getOperadorCaixa().getSenha().equals(senha)).findFirst().orElse(null);
    }
    
    // Método responsável por obter a lista de caixas disponíveis.
    private static List<Caixa> ObtenhaCaixasDisponiveis(){
        return caixas.stream().filter(c->c.getOperadorCaixa() != null).collect(Collectors.toList());
    }
    
    // Método responsável por mostrar caixas com operadores logados.
    private static void MostrarCaixasEmFuncionamento(){
        if (ObtenhaCaixasDisponiveis().isEmpty()) {
            System.out.println("Nenhum caixa está atendendo no momento. =(");
        }
        else {
            Iterator i = ObtenhaCaixasDisponiveis().iterator();
            int op = 1;
            while (i.hasNext()) {
                Caixa caixa = (Caixa)i.next();
                System.out.print(" ( " + op + " ) " + caixa +"\n");
                op++;
            }
            System.out.println(" ( 0 ) Sair");
        }
    }
    
    // Ações de comprar vários produtos no mercado.
    private static void EscolherProduto(){
        System.out.println("**************** OPERAÇÕES DE COMPRA ****************");
        System.out.println(" ( 1 ) PARA COMPRAR \n ( 0 ) PARA OUTRA OPERAÇÃO ");
        String comp = scanner.nextLine();
        EstoqueDeProdutos.mostrarEstoque(1);
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
                        //TODO: VERIFICAR SE EXISTE A QUANTIDADE DE PESO DISPONIVEL EM ESTOQUE.
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
                            //TODO: VERIFICAR SE EXISTE A QUANTIDADE DE PESO DISPONIVEL EM ESTOQUE.
                            cli.getCarrinho().addProduto(p, quantidade);
                            cli.getCarrinho().setValorCompra(cli.getCarrinho().getValorCompra() + p.calcularValor(quantidade));
                        }
                    }
                    System.out.println("********* DIGITE **********");
                    System.out.println(" ( 1 ) - para continuar comprando ou \n ( 2 ) - para finalizar compra ");
                    continuar = scanner.next();
                    
                    //limpa cache do teclado para a entrada de dados
                    scanner.nextLine();
                    if(continuar.equals("2")){
                        MostrarMenuListaDeCaixas(caixas);
                        //System.out.println("VALOR DA SUA COMPRA É: "+cli.realizarCompra().calcularValorCompra());
                        /****** ADICIONAR AQUI AS SELEÇÕES PARA OS CAIXAS *******/
                        
                        System.out.println("VALOR DA SUA COMPRA É: "+cli.getCarrinho().calcularPrecoCarrinho());
                        cli.getCarrinho().exibirCarrinhoCliente();
                        cli.realizarCompra(caixas.get(0));
                        
                        
                    }
                }
                 
                break; 
        }
        
    }
   
    // Método responsável por apresentar o menu de cadastro de produtos por unidade.
    private static void WizardAddProdutoUnidade(Gerente gerente) {
        Utilitario.ImprimaMensagem("*                    ADICIONANDO PRODUTO                        *");
        System.out.println("Código do produto:");
        String codigoProduto  = scanner.next();
        System.out.println("Nome do produto:");
        //String nomeProduto  = scanner.nextLine();
        String nomeProduto  = scanner.next();
        System.out.println("Preço da unidade do produto (exemplo: 99,99):");
        double precoProduto  = scanner.nextDouble();
        System.out.println("Quantidade de itens:");
        int quantidadeProduto  = scanner.nextInt();
        ProdutoUnitario produto = new ProdutoUnitario(codigoProduto + "0", nomeProduto, precoProduto);
        System.out.println("Adicionado " + quantidadeProduto + " unidades do produto: '" + produto.getCodigo() + "- " + produto.getNome() + "'");
        gerente.adicionarProduto(produto, quantidadeProduto);
    }
    
    // Método responsável por apresentar o menu de cadastro de produtos por quilo.
    private static void WizardAddProdutoQuilo(Gerente gerente) {
        Utilitario.ImprimaMensagem("*                    ADICIONANDO PRODUTO                        *");
        System.out.println("Código do produto:");
        String codigoProduto  = scanner.next();
        System.out.println("Nome do produto:");
        //String nomeProduto  = scanner.nextLine();
        String nomeProduto  = scanner.next();
        System.out.println("Preço do quilo de " + nomeProduto + " (exemplo: 99,99):");
        double precoProduto  = scanner.nextDouble();
        System.out.println("Quilos de " + nomeProduto + ":");
        double quantidadeProduto  = scanner.nextDouble();
        ProdutoQuilo produto = new ProdutoQuilo(codigoProduto + "0", nomeProduto, precoProduto, quantidadeProduto);
        System.out.println("Adicionado " + quantidadeProduto + " quilos de: '" + produto.getCodigo() + "- " + produto.getNome() + "'");
        gerente.adicionarProduto(produto, 0);
    }
}
