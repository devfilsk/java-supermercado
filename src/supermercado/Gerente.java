/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Richiely Batista
 */
public class Gerente extends Funcionario {
    
    private EstoqueDeProdutos estoqueTemp;
    
    public Gerente(String nome, String userName, String senha, EstoqueDeProdutos estoque) {
        super(nome, userName, senha, estoque);
        //this.estoqueTemp = EstoqueDeProdutos.clonarEstoque();
    }

    public void emitirRelatorioDeEstoque() {
        System.out.println("*********************************************************");
        System.out.println("RELATÓRIO DE ESTOQUE");
        System.out.println("*********************************************************");
        System.out.println("***** Estoque no INÍCIO do dia *****");
        
        //estoqueTemp.mostrarEstoque();
        
        System.out.println("*********************************************************");
        System.out.println("***** Estoque no FINAL do dia *****");
        
        EstoqueDeProdutos.mostrarEstoque();
    }
    
    public void emitirRelatorioDeVendas(){}
}
