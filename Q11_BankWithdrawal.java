import java.util.Scanner;

class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class Q11_BankWithdrawal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter account balance: ");
            double balance = Double.parseDouble(sc.nextLine());

            System.out.print("Enter withdrawal amount: ");
            double withdrawal = Double.parseDouble(sc.nextLine());

            if (withdrawal < 0) {
                throw new IllegalArgumentException(
                        "Withdrawal amount cannot be negative."
                );
            }

            if (withdrawal > balance) {
                throw new InsufficientBalanceException(
                        "Insufficient balance."
                );
            }

            balance = balance - withdrawal;

            System.out.println("Withdrawal successful.");
            System.out.println("Remaining balance = " + balance);

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid numeric values.");

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Bank transaction completed.");
        }

        sc.close();
    }
}
