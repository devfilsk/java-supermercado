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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 *
 * @author Richiely Batista, Filipe Maciel
 */
public class Gerente extends Funcionario {
    
    public Gerente(String nome, String userName, String senha) {
        super(nome, userName, senha);
        EstoqueDeProdutos.copiarEstoque();
    }

    public void emitirRelatorioDeEstoque() {
        Scanner scanner = new Scanner(System.in);
        Utilitario.ImprimaMensagem("*                     RELATÓRIO DE ESTOQUE                      *", 
                "*                    Estoque no INÍCIO do dia                   *");
        EstoqueDeProdutos.exibirCopiaInicialDoEstoque();

        Utilitario.ImprimaMensagem("*                  Estoque no FINAL do dia                      *");
        EstoqueDeProdutos.mostrarEstoque(1);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Aperte ENTER para continuar ...");
        scanner.nextLine();
    }
    
    public void emitirRelatorioDeVendas(List<Caixa> caixas){
        Iterator i = caixas.iterator();
        // acessa caixa por caixa
        while (i.hasNext()) { 
            Caixa caixa = (Caixa)i.next();
            Utilitario.ImprimaMensagem(
                  "*                   Relatório do Caixa: "+ caixa.getNumeroDoCaixa() +"                  *");
            caixa.relatorioCaixa();
            Utilitario.Continuar();
        }
    }
}
