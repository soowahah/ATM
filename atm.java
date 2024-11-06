//write a java program that stimulates a simple ATM system
//Ask for 4 digit pin, validate it (1 or 2)
//Ask for withdrawal, deposit, balance inquiry

import java.util.Scanner; 
public class atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your pin number: ");
        String pin = sc.nextLine();

        if(pin.charAt(0) == '1' || pin.charAt(0) == '2'){
            if(pin.length() ==4){
                System.out.println("Choose your transaction(enter the first letter of your choice): ");
        System.out.println("Withdrawal");
        System.out.println("Deposit");
        System.out.println("Balance Inquiry");
        System.out.print("Your choice: ");
        char trans = sc.next().charAt(0);

        switch (trans) {
            case 'W':
                System.out.println("You choose withdrawal.");
                System.out.print("Enter the amount you want to withdraw: ");
                double withdraw = sc.nextDouble();
                System.out.println("You withdraw = "+withdraw);
                break;
            case 'D':
                System.out.println("You choose deposit.");
                System.out.print("Enter the amount you want to deposit: ");
                double deposit = sc.nextDouble();
                System.out.println("You withdraw = "+deposit);
                break;
            case 'B':
                System.out.println("You choose balance inquiry");
                System.out.println("Your balance is ---");
                break;
            default:
            System.out.println("Error.");
            }
        }else{
            System.out.println("Wrong pin!");
        }
        }else{
            System.out.println("INCORRECT PIN!");
        }
    }
}
