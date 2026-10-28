package br.com.fiapride.model;

public class Passageiro {
    private String nome;
    private String cpf;
    private double saldo;

    public Passageiro(String nome, String cpf) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setSaldo(0);
    }

    // Aula 4: construtor sem parâmetros
    public Passageiro() {
    this("Não informado", "Não informado");
    }
    
    public double getSaldo() {
        return this.saldo;
    }

    private void setSaldo(double valor) {
        if (valor >= 0) {
            this.saldo = valor;
        } else {
            System.out.println("Erro de Segurança: Tentativa de definir saldo negativo bloqueada!");
        }
    }

    public String getNome() {
        return this.nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void adicionarSaldo(double valor) {
        if(valor > 0) {
            this.setSaldo(this.saldo + valor);
        }
    }

    public void pagarViagem(double valor) {
        if(valor > 0 && this.saldo >= valor) {
            this.setSaldo(this.saldo - valor);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }
}