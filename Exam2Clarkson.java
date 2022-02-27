import java.util.Scanner; //Scanner for getting user input

public class Exam2Clarkson 
{
    public static void main(String[] args)
    {
        // Declare constants for unchanged values
        final int MASK = 1;
        final int FACS_SHIELD =2;
        final int GLOVE = 3;
        final int N95_RESP = 4;
        final double MASK_COST = 0.25;
        final double FACE_SHIELD_COST = 4.99;
        final double GLOVE_COST  = 0.15;
        final double N95_RESP_COST = 1.49;
        final double DISCOUNT_LESS = 0.9;
        final double DISCOUNT_MORE = 0.8;
        final int MIN_ORDER = 100;

        // Declare variables 
        int choicePPE = 0, units = 0;
        double cost = 0.0, total = 0.0;
        char another;
        Scanner keyboard = new Scanner(System.in);

        do
        {
            // Get user input
            System.out.println("What type of PPE do you need to purchase? "); 
            System.out.println("\t1. Mask");
            System.out.println("\t2. Face Shield");
            System.out.println("\t3. Glove");
            System.out.println("\t4. N95 Respirator");
            System.out.print("Please select the type of PPE from the menu: ");
            choicePPE = keyboard.nextInt();

            // Validate input
            while (choicePPE < 1 || choicePPE > 4)
            {
                System.out.println("Invalid menu selction.");
                System.out.print("Please select the type of PPE from the menu: ");
                choicePPE = keyboard.nextInt();
            }

            // Prompt user for number of units they wish to purchaase
            System.out.print("How many units do you wish to purchase? ");
            units = keyboard.nextInt();

            // Validate input
            while (units < 100)
            {
                System.out.println("There is a minimum order of 100 units required.");
                System.out.print("How many units do you wish to purchase? ");
                units = keyboard.nextInt();
            }

            // Calculate the cost
            if(choicePPE == MASK)
            {
                cost = units * MASK_COST;
            }
            else if(choicePPE == FACS_SHIELD)
            {
                cost = units * FACE_SHIELD_COST;
            }
            else if(choicePPE == GLOVE)
            {
                cost = units * GLOVE_COST;
            }
            else
            {
                cost = units * N95_RESP_COST;
            }

            // Adjust cost with discounts
            if (units >= 1000 && units <= 4000)
            {
                cost = cost * DISCOUNT_LESS;
            }
            else if (units > 4000)
            {
                cost = cost * DISCOUNT_MORE;
            }
        
            total = total + cost;

            // Display the cost of the purchase
            System.out.printf("The cost of the purchase is: $%,.2f", cost);
            
            // Clear buffer
            keyboard.nextLine();

            // Ask if user wants to purchase another type of PPE
            System.out.print("\nWould you like to purchase another type of PPE (Y/N)? ");
            another = keyboard.nextLine().toUpperCase().charAt(0);
            System.out.println();
            

        }while (another == 'Y');

        // Display the total cost of all purchases
        System.out.printf("The total cost of all PPE purchases is: $%,.2f", total);
    }
}
