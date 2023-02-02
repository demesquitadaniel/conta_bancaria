package service;

import model.Conta;
import org.junit.*;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.lang.annotation.Target;

public class ContaServiceTest {

    /**
     * Deve ser possível criar uma conta (ok)
     * Novas contas iniciam com saldo ZERO (ok)
     * Deve ser possível depositar (ok)
     * Casa haja saldo, deve ser possível sacar
     * Casa haja saldo, deve ser possível transferir entre contas
     * Contas com mesmo numero e mesma agencia sao iguais
     * <p>
     * Usar no mínimo:
     * 1 assertTrue
     * 1 assertFalse
     * 1 assertEquals
     * 1 assertEquals (comparação entre contas)
     * 1 assertNotEquals
     * 1 assertSame
     */

    ContaService contaService;
    Conta conta;

    @Before // Executa método antes de CADA teste
    public void setup() {
        // System.out.println("Before");
        contaService = new ContaService();
        conta = contaService.cadastrar("Teste");

    }

    @BeforeClass // Executa método antes de TODA A CLASSE
    public static void setup2() {
        // System.out.println("Before Class");
    }

    @After // Executa metodo depois de CADA teste
    public void tearDown() {
        // System.out.println("After");
    }

    @AfterClass // Executa método depois de TODA A CLASSE
    public static void tearDown2() {
        // System.out.println("After Class");
    }




    @Test
    public void deveSerPossivelCriarUmaConta() {
        // Dado (given)

        // Quando (when)

        // Então (then)
        Assert.assertTrue(1 == conta.getAgencia());
        Assert.assertTrue(1 == conta.getNumero());
        Assert.assertEquals("Teste", conta.getNomeDoCliente());
    }

    @Test
    public void novasContasDevemIniciarComSaldoZero() {
        // Dado (given)

        // Quando (when)

        // Então (then)
        Assert.assertTrue(conta.getSaldo() == 0);

    }

    @Test
    public void deveSerPossivelDepositar() {
        // Dado

        // Quando
        contaService.depositar(conta, 10.0);
        // Então
        Assert.assertFalse(conta.getSaldo() < 0);
        Assert.assertEquals((Double) 10.0, conta.getSaldo());
    }

    @Test
    public void deveSerPossivelSacar() {
        //Dado
        contaService.depositar(conta, 10.0);

        //Quando
        contaService.sacar(conta, 5.0);
        //Então
        Assert.assertEquals((Double) 5.0, conta.getSaldo());
    }

    @Test
    public void deveSerPossivelTransferirEntreContas() {
        // Dado
        Conta contaSamir = new Conta(conta.getNumero(), conta.getAgencia(), "Samir");
        Conta contaKassia = new Conta(conta.getNumero(), conta.getAgencia(), "Kassia");
        contaService.depositar(contaSamir, 100.0);

        // Quando
        contaService.transferir(contaSamir, contaKassia, 49.99);

        // Então
        Assert.assertEquals(contaSamir, contaSamir);
        Assert.assertSame(contaKassia, contaKassia);
        Assert.assertNotEquals(contaSamir.getSaldo(), contaKassia.getSaldo());

    }


/*
 * FimTestes
 */

    @Test
    public void assertsPossiveis() {
        Assert.assertTrue(true);
        Assert.assertFalse(false);

        // Nrs inteiros
        Assert.assertEquals(1, 1);
        Assert.assertEquals(1234567, 1234567);

        // Nrs Pontos Flutuantes
        Assert.assertEquals(0.5, 0.5, 0.1);
        Assert.assertEquals(0.51, 0.52, 0.1);
        // Assert.assertEquals(0.51, 0.52, 0.01); // Aqui a igualdade não vai até a segunda casa decimal

        // Dizimas Periodicas Infinitas
        Assert.assertEquals(3.1415, Math.PI, 0.001);

        // int (Integer), short (Short), long (Long), float (Float)...
        int intPrimitivo = 10; // tipo primitivo
        Integer integerWrapper = 10; // tipo Wrapper (memórias diferentes)
        Assert.assertEquals(Integer.valueOf(intPrimitivo), integerWrapper); //OU ...
        Assert.assertEquals((Integer) intPrimitivo, integerWrapper);
        Assert.assertEquals(intPrimitivo, integerWrapper.intValue());

        // Strings
        Assert.assertEquals("jose", "jose");
        Assert.assertTrue("maria".equalsIgnoreCase("Maria"));

        Assert.assertNotEquals(1, 2);

        Conta conta01 = new Conta(1, 1, "Marcos");
        Conta conta02 = new Conta(1, 1, "Marcos");

        // Object :: equals()
        // Conta :: equals()

        // Considera 1o o metodo equals
        Assert.assertEquals(conta01, conta02);

        // Valida se é da mesma instancia (endereco de memoria)
        // Assert.assertSame(conta01, conta02); // Não passa
        Assert.assertSame(conta01, conta01);
        Assert.assertNotSame(conta01, conta02);

        Assert.assertEquals("Mensagem de ERRO. Só vai aparecer se o teste NÃO passar", 1, 2);
    }

}
