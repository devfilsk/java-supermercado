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
public class Funcionario{

    private String nome;
    private int codigo;
    private double rendaBasica;
    private double comissao;

    public Funcionario(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.rendaBasica = 1000;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getRendaBasica() {
        return rendaBasica;
    }

    public void setRendaBasica(double rendaBasica) {
        this.rendaBasica = rendaBasica;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double calculaRenda(){
        return getRendaBasica() + comissao;
    }

    @Override
    public String toString() {
        return "Nome do funcionario: " + nome + "\n" +
                "Comissao: R$ "+ comissao + "\n" +
                "Salario total: R$ " + this.calculaRenda() + "\n";
    }
    
    
}
