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
public class FuncionarioEnsinoBasico extends Funcionario {
    private String escola;

    public FuncionarioEnsinoBasico(String nome, int id, String escola) {
        super(nome, id);
        this.escola = escola;
    }

    public String getNomeEscola() {
        return escola;
    }

    public void setNomeEscola(String rscola) {
        this.escola = rscola;
    }

    @Override
    public double calculaRenda() {
        return super.calculaRenda() + (super.calculaRenda()*0.10);
    }
}
