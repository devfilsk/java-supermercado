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
public class FuncionarioGraduacao extends FuncionarioEnsinoMedio {
    private String universidade;
    
    public FuncionarioGraduacao(String nome, int id, String escolaBasico, String escolaMedio, String universidade){
        super(nome, id, escolaBasico, escolaMedio);
        this.universidade = universidade;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    @Override
    public double calculaRenda() {
        return super.calculaRenda() + super.calculaRenda();
    }
}
