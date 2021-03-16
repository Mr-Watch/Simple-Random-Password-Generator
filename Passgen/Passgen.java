import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.io.*;
public class Passgen {
    public static void main(String[] args) throws IOException {
		
        Scanner input = new Scanner(System.in);
        char chooise = 'n';
        int array_length = 0;
        char[] selections = new char[4];
        char[] pass_word;
        boolean exp = false;
        do {
            System.out.println("Enter the length of the password (Maximum length is 256)");
            do {
                try {
                    array_length = input.nextInt();
                    if (array_length < 8)
                        System.out.println("Minimum length is 8");
                    if (array_length > 256)
                        System.out.println("Maximum length is 256");
                    exp = false;
                } catch (InputMismatchException ex) {
                    System.out.println("The number entered is either too long or not an integer\n" +
                        "Make sure the number is an integer");
                    input.nextLine();
                    exp = true;
                }
            } while (array_length < 8 || array_length > 256 || exp);
            System.out.println("Selected length : " + array_length);
            System.out.println("Select the characters you want in the password\n\n '1' for numbers\n '2' for lower case letters\n '3' for upper case letters\n '4' for symbols\n\nYou can include more than 1 option");
            selections = Methods.selections();
            char[] passarray = Methods.pass_array(array_length);
            pass_word = Methods.fill_pass_array(passarray, selections);

            System.out.print("Password : ");
            System.out.print(pass_word);
            System.out.println("\n");
            System.out.println("Would you like to generate another password ?" + "\n" +
                "\nYou can answer with 'y / 1' for yes and 'n / 0' for no");
            do {
                chooise = input.next().charAt(0);
                if ((chooise != 'y' && chooise != '1') && (chooise != 'n' && chooise != '0'))
                    System.out.println("Invalid character");
            } while ((chooise != 'y' && chooise != '1') && (chooise != 'n' && chooise != '0'));
        } while (chooise == 'y' || chooise == '1');
        if (chooise == 'n' || chooise == '0')
			System.out.println("You can also find the password in the newly created Password.txt file");
            System.out.println("Thank you for using Passgen v1.0");
            
            File Password = new File("Password.txt");
            PrintWriter output = new PrintWriter(Password);
            output.println("This is the generated password :");
            output.println("");
            output.println(pass_word);
            output.println("");
            output.println("Thank you for using Passgen v1.0");
            output.close();
            
            
    }
}
 
