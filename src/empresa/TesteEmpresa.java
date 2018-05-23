/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import java.util.Iterator;

/**
 *
 * @author Richiely Batista
 */
public class TesteEmpresa {

    public static void main(String[] args) {
        Funcionario[] funcionarios = new Funcionario[10];
        
        funcionarios[0] = new FuncionarioEnsinoBasico("Funcionario 0", 1, "Escola basica 1");
        funcionarios[1] = new FuncionarioEnsinoBasico("Funcionario 1", 2, "Escola basica 2");
        funcionarios[2] = new FuncionarioEnsinoBasico("Funcionario 2", 3, "Escola basica 3");
        funcionarios[3] = new FuncionarioEnsinoBasico("Funcionario 3", 4, "Escola basica 4");

        funcionarios[4] = new FuncionarioEnsinoMedio("Funcionario 4", 5, "Escola basica 4", "Escola media 1");
        funcionarios[5] = new FuncionarioEnsinoMedio("Funcionario 5", 6, "Escola basica 3", "Escola media 2");
        funcionarios[6] = new FuncionarioEnsinoMedio("Funcionario 6", 7, "Escola basica 2", "Escola media 3");
        funcionarios[7] = new FuncionarioEnsinoMedio("Funcionario 7", 8, "Escola basica 1", "Escola media 4");

        funcionarios[8] = new FuncionarioGraduacao("Funcionario 8", 9, "Escola basica 5", "Escola media 1", "Universidade 1");
        funcionarios[9] = new FuncionarioGraduacao("Funcionario 9", 10, "Escola basica 6", "Escola media 3", "Universidade 2");
        
        double salariosTotais = 0.0;
        double salariosTotaisEnsinoBasico = 0.0;
        double salariosTotaisEnsinoMedio = 0.0;
        double salariosTotaisGraduacao = 0.0;

        for (Funcionario funcionario : funcionarios) {
            double rendaFuncionario = funcionario.calculaRenda();
            salariosTotais += rendaFuncionario;
            if (funcionario.getClass().equals(FuncionarioEnsinoBasico.class)) {
                salariosTotaisEnsinoBasico += rendaFuncionario;
            }else if (funcionario.getClass().equals(FuncionarioEnsinoMedio.class)) {
                salariosTotaisEnsinoMedio += rendaFuncionario;
            } else if(funcionario.getClass().equals(FuncionarioGraduacao.class)){
                salariosTotaisGraduacao += rendaFuncionario;
            }
        }
        
        System.out.println("Salário total: " + salariosTotais);
        System.out.println("Salário total de funcionários com Ensino Básico completo: R$ " + salariosTotaisEnsinoBasico);
        System.out.println("Salário total de funcionários com Ensino Médio completo: R$ " + salariosTotaisEnsinoMedio);
        System.out.println("Salário total de funcionários com Universidade completo: R$ " +salariosTotaisGraduacao);
        System.out.println();
        
        Funcionario[] comissionados = new Funcionario[10];
        comissionados[0] = new Gerente("Gerente", 100);
        
        comissionados[1] = new Supervisor("Supervisor 1", 110);
        comissionados[2] = new Supervisor("Supervisor 2", 111);
        
        comissionados[3] = new Vendedor("Vendedor 1", 0);
        comissionados[4] = new Vendedor("Vendedor 2", 0);
        comissionados[5] = new Vendedor("Vendedor 3", 0);
        comissionados[6] = new Vendedor("Vendedor 4", 0);
        comissionados[7] = new Vendedor("Vendedor 5", 0);
        comissionados[8] = new Vendedor("Vendedor 6", 0);
        comissionados[9] = new Vendedor("Vendedor 7", 0);

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
        
        for (Funcionario comissionado : comissionados) {
            System.out.println(comissionado);
        }
    }
    
}
