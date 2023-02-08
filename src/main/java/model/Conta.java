package model;

import java.util.Objects;

public class Conta {
    private Integer agencia;
    private Integer numero;
    private String nomeDoCliente;

    // Para valores monetarios sempre utilizar o BigDecimal (imutaveis)
    // Para fins didaticos vamos utilizar o double
    private Double saldo;

    public Conta(Integer agencia, Integer numero, String nomeDoCliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0.0;
        this.nomeDoCliente = nomeDoCliente;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    @Override
    public boolean equals(Object o) { // Compara agencia e numero de dois objetos do tipo conta
        if (this == o) return true;
        if (!(o instanceof Conta)) return false;
        Conta conta = (Conta) o;
        return agencia.equals(conta.agencia) && numero.equals(conta.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agencia, numero);
    }
}