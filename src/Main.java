
import java.util.Scanner;

public class Main {

    /**
     * Main method that runs the program.
     * Prints welcome message and prompts user for array size.
     * If array size is greater than 0, calls the runArrayBuilder method to build the array.
     * Finally, prints a goodbye message.
     * Project #1
     * @author Giovani Martins
     * @date 3/11/2023
     */
    public static void main(String[] args)
    {
        // print the welcome message
        printWelcomeMessage();

        String arraySizePromptText = "How many elements would you like the array to have?\n" +
                "Enter an integer from zero (0) to 20 (0-20, inclusive)";
        // get the array size from the user
        int arraySize = runSafeNonNegIntegerPrompt(arraySizePromptText, 20);
        // report the established array size to the user
        System.out.println("\n **** The array will have " + arraySize + " elements. ****\n");

        if (arraySize > 0)
        {
            // start the array building process
            runArrayBuilder(arraySize);
        }

        System.out.println("\n\t===== SAFE ARRAY ASSIGN ENDED - GOODBYE! =====\n");
    }

    /**
     * Prints the welcome message to the console.
     */
    private static void printWelcomeMessage()
    {
        System.out.println("================================================= **** INPUT ERROR PROOF INT[] ARRAY BUILDER ****");
        System.out.println("Let's build an int[] array (safely). =================================================");
    }

    /**
     * Prompts the user for a non-negative integer input then Returns the valid integer input.
     * @param userPromptText the prompt text to display to the user.
     * @param upperBound the upper bound of the integer input, optional.
     * @return the valid integer input.
     */
    private static int runSafeNonNegIntegerPrompt(String userPromptText, int upperBound)
    {
        boolean valid;
        String inputString;
        Scanner kbScanner = new Scanner(System.in);

        do {
            System.out.println(userPromptText);
            System.out.print(">> ");
            inputString = kbScanner.nextLine();
            valid = nonNegIntSafePromptHelper(inputString, upperBound);
        } while (!valid);

        int validArraySizeInt = Integer.parseInt(inputString);
        return validArraySizeInt;
    }

    /**
     * Helper method for the runSafeNonNegIntegerPrompt method.
     * Validates the user input as a non-negative integer, with an optional upper bound.
     * @param inputString the user input to validate.
     * @param upperBound the max amount of the integer input.
     */
    private static boolean nonNegIntSafePromptHelper(String inputString, int upperBound)
    {
        if (!stringIsNonNegInt(inputString))
        {
            System.out.println("ERROR: You entered an invalid input!");
            return false;
        }
        else
        {
            int testInt = Integer.parseInt(inputString);
            if (testInt > upperBound)
            {
                System.out.println("ERROR: You entered a value that is out of range!!");
                return false;
            }
            return true;
        }
    }

    /**
     *Checks if inputString is a non-negative int. It returns false if inputString is negative or not a number
     * @param inputString the user input to validate.
     * @return
     */
    private static boolean stringIsNonNegInt(String inputString)
    {
        if (inputString.length() == 0)
        {
            return false;
        }
        for (int i = 0; i < inputString.length(); i++)
        {
            char c = inputString.charAt(i);
            if (c <= 47 || c >= 58)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * This is the main method that runs other methods necessary to make
     * the array building and visualization possible.
     * @param arrayLength the array that gets passed into the other methods as "newIntArray" in order to get displayed
     */
    private static void runArrayBuilder(int arrayLength)
    {
        int[] newIntArray = new int[arrayLength];
        System.out.println("=================================================");
        System.out.println("Let's start filling the array with values from zero to 50 (0- 50, inclusive)...");

        buildArray(newIntArray);

        System.out.println("=================================================");
        System.out.println("Here is a visual display of the array values you entered:");

        visualizeArrayContent(newIntArray);

        System.out.println("\n=================================================\n");
    }

    /**
     *In charge of running the part of code that lets user input numbers to build arrays
     * @param intArray
     */
    private static void buildArray(int[] intArray)
    {
        String elementPromptText = ("Enter an integer between zero and 50 (0- 50, inclusive) to fill element at index ");

        for (int index = 0; index < intArray.length; index++)
        {
            intArray[index] = runSafeNonNegIntegerPrompt(elementPromptText + index, 50);
            System.out.println("Element " + index + " set to " + intArray[index]);
            System.out.print("Current Array Values: ");
            printArrayElements(intArray);
            System.out.println();
        }
    }

    /**
     *Takes an integer array as input and prints each element of the array to
     * the console, separated by spaces.
     * @param arrayToBePrinted the integer array to be printed
     */
    public static void printArrayElements(int[] arrayToBePrinted)
    {
        for (int i = 0; i < arrayToBePrinted.length; i++)
        {
            System.out.print(arrayToBePrinted[i] + " ");
        }
        System.out.println();
    }

    /**
     * *The visualizeArrayContent method takes an integer array as input and prints a horizontal bar graph
     * to the console, where each element in the array is represented by a series of asterisks. The length of
     * each bar corresponds to the value of the corresponding element in the array. The method uses a nested for
     * loop to iterate over each index in the array, and for each index, it prints the value of the element at
     * that index and then prints a series of asterisks to represent the element's value.
     * @param arrayToBeDisplayed the integer array to be visualized
     */
    public static void visualizeArrayContent(int[] arrayToBeDisplayed)
    {
        for (int i = 0; i < arrayToBeDisplayed.length; i++)
        {
            System.out.print("Value at index " + i + " (" + arrayToBeDisplayed[i] + ")\t-> ");
            for (int j = 0; j < arrayToBeDisplayed[i]; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}