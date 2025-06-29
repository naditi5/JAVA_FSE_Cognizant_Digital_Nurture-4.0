package teardownMethods;

public class BankAccountApp {
	private int balance;

    public BankAccountApp(int initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
