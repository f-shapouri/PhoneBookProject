import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> phoneBookNumber = new ArrayList<>();
        ArrayList<String> phoneBookNames = new ArrayList<>();
        while (true) {
            System.out.println("------------Menu------------");
            System.out.println("1.Add new number\n2.Print all contacts\n3.Exit");
            String userInput = scanner.nextLine();
            if (userInput.equals("1")) {
                System.out.println("Enter name");
                String userName = scanner.nextLine();
                phoneBookNames.add(userName);
                System.out.println("Enter Number");
                String userNum = scanner.nextLine();
                phoneBookNumber.add(userNum);
            } else if (userInput.equals("2")) {
                System.out.println("------------All Contacts------------");
                for (int i = 0; i < phoneBookNames.size(); i++) {
                    System.out.print(STR."Name:\{phoneBookNames.get(i)}");
                    System.out.println(STR."\t Number:\{phoneBookNumber.get(i)}");
                }
            } else {
                System.out.println("---------End of Application--------");
                System.exit(0);
            }
        }

    }
}
