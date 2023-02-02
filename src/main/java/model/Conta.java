package model;

// Object :: equals() -> comparacao de endereco de memoria
// Conta :: equals() X

import java.util.Objects;

public class Conta {
    private Integer numero;
    private Integer agencia;
    private String nomeDoCliente;

    private Double saldo;
    // Para valores monetaris sempre utilizar BigDecimal (imutaveis)
    // Para fins didáticos, usaremos Double


    public Conta(Integer numero, Integer agencia, String nomeDoCliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = 0.0;
        this.nomeDoCliente = nomeDoCliente;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
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
    public boolean equals(Object o) { // compara agencia e numero de dois objetos do tipo conta
        if (this == o) return true;
        if (!(o instanceof Conta)) return false;
        Conta conta = (Conta) o;
        return numero.equals(conta.numero) && agencia.equals(conta.agencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, agencia);
    }
}
