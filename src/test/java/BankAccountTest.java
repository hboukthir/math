import static org.junit.jupiter.api.Assertions.*;

import org.example.BankAccount;
import org.example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount(); // Initialiser un nouveau compte avant chaque test
    }

    @Test
    public void testdeposit() {
        account.deposit(100);
        assertEquals(100, account.getBalance(), "la balance doit être au moins de 100");
    }

    @Test
    public void testwithdraw() {
        // Tester que le retrait provoque une exception si le montant est supérieur au solde
        account.deposit(100);
        account.withdraw(50);
        assertEquals(50, account.getBalance(), "la balance doit être au moins de 50");
    }

    @Test
    public void testWithdrawAvecException() {
        account.deposit(50); // Déposer 50
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100); // Essayer de retirer 100, ce qui dépasse le solde
        });
        assertEquals("Insufficient funds or invalid amount", exception.getMessage()); // Vérifiez le message d'exception
    }


    @Test
    public void testGetBalance() {
        // s'assurer que cette methode renvioi le solde ok

        // Vérifier le solde initial
        assertEquals(0, account.getBalance(), "Initial =0");

        // Effectuer un dépôt
        account.deposit(150);
        assertEquals(150, account.getBalance(), "Balance = 150");

        // Effectuer un retrait
        account.withdraw(50);
        assertEquals(100, account.getBalance(), "Balance = 100 =");

        // Vérifier après un retrait qui laisse le solde à zéro
        account.withdraw(100);
        assertEquals(0, account.getBalance(), "Balance = 0");
    }
}
