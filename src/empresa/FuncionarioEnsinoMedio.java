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
public class FuncionarioEnsinoMedio extends FuncionarioEnsinoBasico {
    private String escolaMedio;
    
    public FuncionarioEnsinoMedio(String nome, int id, String escolaBasico, String escolaMedio) {
        super(nome, id, escolaBasico);
        this.escolaMedio = escolaMedio;
    }

    public String getEscolaMedio() {
        return escolaMedio;
    }

    public void setEscolaMedio(String escolaMedio) {
        this.escolaMedio = escolaMedio;
    }

    @Override
    public double calculaRenda() {
        return super.calculaRenda() + (super.calculaRenda()*0.50);
    }
}