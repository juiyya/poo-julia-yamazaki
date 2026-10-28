
package br.com.fiapride.main;

import br.com.fiapride.model.Carro;
import br.com.fiapride.model.CarroEletrico;
import br.com.fiapride.model.Celular;
import br.com.fiapride.model.Moto;
import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Recarregavel;
import br.com.fiapride.model.Veiculo;
import br.com.fiapride.model.Viagem;

public class SistemaPrincipal {
    public static void main(String[] args) {

        System.out.println("=== FIAPRIDE: Sistema de Mobilidade Urbana ===");

        // AULA 4 - CONSTRUTORES
        System.out.println("\n=== Aula 4: Construtores ===");
        // Construtor sem parâmetros
        Passageiro visitante = new Passageiro();
        // Construtor com parâmetros
        Passageiro passageiro = new Passageiro("Ana", "12345678900");

        System.out.println("Passageiro padrão: " + visitante.getNome());
        System.out.println("Passageiro cadastrado: " + passageiro.getNome());

        // AULA 5 - ASSOCIAÇÃO
        System.out.println("\n=== Aula 5: Associação ===");
        // Criamos um veículo
        Carro carro = new Carro("ABC-1234", "Fiat Uno", 4);
        // Viagem possui associação com Passageiro e Veiculo
        Viagem viagem = new Viagem("FIAP", passageiro, carro);
        // Teste da associação
        viagem.exibirResumo();

        // AULA 7 - POLIMORFISMO
        System.out.println("\n=== Aula 7: Polimorfismo ===");
        // Criamos objetos de subclasses diferentes
        Moto moto = new Moto("MOT-1234", "Honda CG", false);

        carro.abastecer(20);
        moto.abastecer(10);
        // Polimorfismo: ambos são tratados como Veiculo
        Veiculo[] frota = {carro, moto};

        for (Veiculo veiculo : frota) {
            veiculo.exibirTipo();
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println(veiculo.calcularAutonomia());
            System.out.println("---");
        }

        // AULA 9 - INTERFACES
        System.out.println("\n=== Aula 9: Teste de Interfaces ===");
        // Criamos objetos de classes diferentes
        CarroEletrico tesla = new CarroEletrico(
                "TES-9999", "Tesla Model 3"
        );
        Celular iphone = new Celular("iPhone 15");
        // Polimorfismo de interface:
        // Ambos podem ser tratados como Recarregavel
        Recarregavel[] recarregaveis = {
                tesla,
                iphone
        };

        System.out.println("\n=== Recarregando Tudo ===");

        for (Recarregavel r : recarregaveis) {
            r.recarregar(85);
            System.out.println("---");
        }

        System.out.println("\n=== Múltiplos Tipos ===");
        // CarroEletrico é Veiculo e Recarregavel
        System.out.println(
                "Tesla é um Veiculo? " + (tesla instanceof Veiculo)
        );
        System.out.println(
                "Tesla é Recarregavel? " + (tesla instanceof Recarregavel)
        );
        // Celular não é Veiculo, mas é Recarregavel
        System.out.println(
                "Celular é um Veiculo? " + Veiculo.class.isInstance(iphone)
        );
        System.out.println(
                "Celular é Recarregavel? " + (iphone instanceof Recarregavel)
        );

        System.out.println("\n=== Autonomia do Carro Elétrico ===");
        System.out.println(tesla.calcularAutonomia());

        System.out.println("\n=== Bateria do Celular ===");
        System.out.println(iphone.getNivelBateria());

        System.out.println("\n=== Fim dos Testes ===");
    }
}
