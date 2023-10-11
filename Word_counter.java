import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Word_counter {
    public static void main(String[]args)throws Exception {
        String stored_data,entered_data;
        String[] words;
        int count, choice,ans ;
        Scanner scan = new Scanner(System.in);
        do{
        choice= Integer.parseInt(JOptionPane.showInputDialog("Welcome to Word Counter .\n\n1. Enter your own text\n2. Enter a text file\nChoose from the given options(1 or 2)"));
        if (choice == 1) {
            count=0;
            entered_data=JOptionPane.showInputDialog("Enter your text to Count the number of words Present.");

            words = entered_data.split(" ");
            count += words.length;
            JOptionPane.showMessageDialog(null,"number of words present in the text entered: " + count);
        }
        else if (choice == 2) {
            count=0;
            String file_name =JOptionPane.showInputDialog("Enter the name of the text file to Count the number of words Present.");

            FileReader file = new FileReader(file_name + ".txt");
            BufferedReader buffer = new BufferedReader(file);
            while ((stored_data = buffer.readLine()) != null) {
                words = stored_data.split(" ");
                count += words.length;
            }
            JOptionPane.showMessageDialog(null,"number of words present in the text file provided: " + count);
            buffer.close();
            file.close();
        }
        else {
            JOptionPane.showMessageDialog(null,"Wrong choice!(choice can be made only between 1 and 2.)");
        }
        scan.close();
            ans= JOptionPane.showConfirmDialog(null,"do you want to continue?");
            }

    while (ans==0);
    }
}

