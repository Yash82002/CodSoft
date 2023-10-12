import java.util.Scanner;

public class AtmInterface {

    UserDetails userDetails = new UserDetails();
    public void showBalance(){
        System.out.println("Your account balance is:" +userDetails.accBalance+" INR");
    }
    public void withdraw(double withdrawAmount){
        if(withdrawAmount<=userDetails.accBalance) {
            if (withdrawAmount % 100 != 0) {
                System.out.println("Money can be only withdrawn in multiples of 100 ");
            } else {
                System.out.println("sum of INR " + withdrawAmount + " withdrawn successfully\nPlease collect your cash.");
                userDetails.accBalance -= withdrawAmount;
            }
        }
        else System.out.println("Insufficient balance in your account !");
    }
    public void deposit(double depositAmount){
        if(depositAmount%100!=0){
            System.out.println("Money can be only deposited in multiples of 100 ");

        }
        else{
        System.out.println("sum of INR " + depositAmount+ " deposited successfully");
        userDetails.accBalance+=depositAmount;
        }

    }
    public void greetings(){
        System.out.println("Thank you for you using our ATM machine. Have a nice day !");
    }


    public static void main(String [] args ){
        UserDetails acHolder = new UserDetails();
        AtmInterface account = new AtmInterface();
        char ans;
        Scanner scan = new Scanner(System.in);
        do {
            int pin = 0;

            System.out.println("Welcome to the ATM.");


            System.out.println("--------------------------------\n1.Check your account balance\n2.Withdraw amount\n3.Deposit amount\n-------------------------------- ");
            System.out.println("Press 1 2 or 3 to continue.");
            int option = scan.nextInt();
            System.out.println("You have chosen option " + option + "\nEnter the following details to continue:\n Account number:");
            int number = scan.nextInt();
            if (number != acHolder.accNo) {
                System.out.println("No such account number found in records!");
            } else {
                System.out.println("Enter your account pin:");
                pin = scan.nextInt();
            }

            if (pin == acHolder.accPin) {
                switch (option) {
                    case 1 -> {
                        account.showBalance();
                        account.greetings();
                    }
                    case 2 -> {
                        System.out.println("Money Withdrawal!\nEnter the amount you want to withdraw:");
                        double withdrawAmount = scan.nextDouble();
                        account.withdraw(withdrawAmount);
                        account.showBalance();
                        account.greetings();

                    }
                    case 3 -> {
                        System.out.println("Money Deposit!\nEnter the amount you want to Deposit:");
                        double depositAmount = scan.nextDouble();
                        account.deposit(depositAmount);
                        account.showBalance();
                        account.greetings();

                    }
                    default -> System.out.println("Wrong choice entered!");
                }


            }
            else System.out.println("Wrong pin entered for the mentioned account!");
            System.out.println("Do you want to continue ?(y/n)");
            ans = scan.next().charAt(0);
        }
        while(ans =='y'||ans=='Y');
        scan.close();
    }
}
