/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

/**
 *
 * @author Richiely Batista
 */
public class Supervisor extends Funcionario {
    
    public Supervisor(String nome, int codigo) {
        super(nome, codigo);
        this.setComissao(600);
    }
}
