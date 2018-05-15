/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

/**
 *
 * @author Richiely Batista
 */
public class ProdutoQuilo extends Produto{
    private double qtdQuilos;
    
    public ProdutoQuilo(String codigo, String nome, double valor, double qtdQuilos) {
        super(codigo, nome, valor);
        this.qtdQuilos = qtdQuilos;
    }

    public double getQtdQuilos() {
        return qtdQuilos;
    }

    public void setQtdQuilos(double qtdQuilos) {
        if (qtdQuilos < 0) {
            this.qtdQuilos = 0;
        }
        else{
            this.qtdQuilos = qtdQuilos;
        }
    }
    
    @Override
    public double calcularValor(double quilos){
        return qtdQuilos * this.getValor();
    }
    
}
