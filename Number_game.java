import java.util.Scanner;

public class Number_game {
    public static void main(String[] args) {
        System.out.println("Welcome to number guessing game.\nThe system will generate a number from 1 to 100. you have to guess the number in least number of tries.\nYou will only have 10 attempts ");

        int min = 1,max = 100;
        int generated_num, count, guessed_num=0 ,round_score=0, no_of_rounds=0;
        char ans;
        Scanner scan = new Scanner(System.in);
        do{
            no_of_rounds++;
            count = 1;
            generated_num = (int) (Math.random() * ((max - min + 1) + min));
            System.out.println("System has generated a number. Guess the generated number!");

            while (guessed_num != generated_num) {
                guessed_num = scan.nextInt();
                if (count >= 10) {
                    System.out.println("Out of chances !\nYou lose");
                    break;
                }
                if (guessed_num < generated_num - 5) {
                    System.out.println("Too low :( \nGuess again."+(10-count)+" chances left");
                    count++;

                } else if (guessed_num > generated_num + 5) {
                    System.out.println("Too high :( \nGuess again."+(10-count)+" chances left");
                    count++;

                } else if (guessed_num >= generated_num - 5 && guessed_num < generated_num || guessed_num <= generated_num + 5 && guessed_num > generated_num) {
                    System.out.println("Very close. \nGuess again."+(10-count)+" chances left");
                    count++;

                }
            }
            if (guessed_num == generated_num){
                System.out.println("You guessed the generated number!\nYou win\nScore:" + count + " guesses");
                round_score++;
            }
            System.out.println("Your final Score :"+round_score+"/"+no_of_rounds);
            System.out.println("Do you want to play again ?(y/n)");
            ans = scan.next().charAt(0);
        }
        while(ans =='y'||ans=='Y');
        scan.close();
    }
}

