package service;

import model.Conta;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;

public class ContaServiceTestExceptions {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deveLancaExceptionQuandoValorDoSaqueForNegativo() throws Exception {
        // Dado|Given|Cenário
        ContaService contaService = new ContaService();
        Conta c1 = contaService.cadastrar("Marcela");

        // Expect
        expectedException.expect(Exception.class);
        expectedException.expectMessage("O valor do saque não pode ser negativo");

        // Quando|When|Ação
        contaService.sacar(c1, -10.0);
    }

    @Test(expected = Exception.class)
    public void deveLancaExceptionQuandoValorDoSaqueForNegativo_2() throws Exception {
        // Dado|Given|Cenário
        ContaService contaService = new ContaService();
        Conta c1 = contaService.cadastrar("Marcela");

        // Quando|When|Ação
        contaService.sacar(c1, -10.0);
    }

    @Test
    public void deveLancaExceptionQuandoValorDoSaqueForNegativo_3() {
        // Dado|Given|Cenário
        ContaService contaService = new ContaService();
        Conta c1 = contaService.cadastrar("Marcela");

        // Quando|When|Ação
        try { // tentar
            contaService.sacar(c1, -10.0);
            Assert.fail();
        } catch (Exception e) { // capturar exception
            Assert.assertThat(e.getMessage(), is("O valor do saque não pode ser negativo"));
        }

    }


}