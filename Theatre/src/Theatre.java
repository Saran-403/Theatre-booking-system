/*I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
Any code taken from other sources is referenced within my code solution.*/
//Student ID:  IIT :20210883,  westminster :- w1953877
// Date: 23/03/2023







import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

//Create class theatre
public class Theatre {
    // Create 2D ArrayList to store ticket information
    private static ArrayList<Ticket> tickets = new ArrayList<>();

    //Create 2D Array to store seats
    private static int[][] seats = new int[][]{
            new int[12],
            new int[16],
            new int[20]
    };

    public Theatre() {
        for (int[] seat : seats) {
            Arrays.fill(seat, 0);// initialize all seats as available
        }
    }


    public static void main(String[] args) {
        // Initialize Scanner and program loop
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        int choice;
        while (!quit) {
            // Welcome message
            System.out.println("    *~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
            System.out.println("            Welcome to the New Theatre");
            System.out.println("    *~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
            System.out.println();
            // Print menu options
            String dash= "=";
            System.out.println(dash.repeat(50));
            System.out.println("|------T H E  M E N U------|>>>>>>>>>>>>>>>>>>>>>:");
            System.out.println("|                          |>>>>>>>>>>>>>>>>>>>>>:");
            System.out.println("| 1) Buy a ticket          |>>>>>>>>>>>>>>>>>>>>>:");
            System.out.println("| 2) Print seating area    |>>>>>>>>>>>>>>>>>>>>>:");
            System.out.println("| 3) Cancel ticket         |>>>>>>>>>>>>>>>>>>>>>:");
            System.out.println("| 4) List available seats  |>>>>>>>>>>>>>>>>>>>>>:");
            System.out.println("| 5) Save to file          |>>>>>>>>>>>>>>>>>>>>>:");
            System.out.println("| 6) Load from file        |>>>>>>>>>>>>>>>>>>>>>:");
            System.out.println("| 7) Print ticket info     |>>>>>>>>>>>>>>>>>>>>>:");
            System.out.println("| 8) Sort tickets by price |>>>>>>>>>>>>>>>>>>>>>:");
            System.out.println("| 0) Quit                  |>>>>>>>>>>>>>>>>>>>>>:");
            System.out.println(dash.repeat(50));

            // Prompt for user input
            System.out.print("Select an option(0-8):");
            // Validate input as integer
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer");
                System.out.print("Select an option((0-8):");
                input.next();
            }

            // Read input and execute corresponding action
            choice = input.nextInt();


            switch (choice) {
                case 0:
                    // Exit program
                    System.out.println("Thank you for using the Theatre program");
                    quit = true;
                    break;
                case 1:
                    // Buy ticket
                    buy_ticket();
                    break;
                case 2:
                    // Print seating area
                    print_seating_area();
                    break;
                case 3:
                    // Cancel ticket
                    cancel_Ticket();
                    break;
                case 4:
                    // List available seats
                    list_available_seats();
                    break;
                case 5:
                    // Save data to file
                    save_to_file();
                    break;
                case 6:
                    // Load data from file
                    load_from_file();
                    break;
                case 7:
                    // Show ticket information
                    show_tickets_info();
                    break;
                case 8:
                    // Sort tickets by price
                    sort_tickets_by_price(tickets);
                    break;
                default:
                    // Invalid input
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }
    }
    // Method to buy a ticket
    public static void buy_ticket() {
        // Create a Scanner object to read user input from console
        Scanner input = new Scanner(System.in);
        // Declare variables for storing user input
        int row;
        String name, surname, email;
        // Prompt the user to enter person's name
        System.out.print("Enter Your name: ");
        // Use a while loop to ensure that the user enters a valid name
        while(true){
            while (!input.hasNext("[a-zA-Z]+")) {
                System.out.println("Invalid input. Please enter a valid string.");
                System.out.print("Enter person's name: ");
                input.next();
            }
            // If the input is valid, store it in the name variable and break out of the loop
            name = input.next();

            // Use a while loop to ensure that the user enters a valid surname
            System.out.print("Enter Your surname: ");
            while (!input.hasNext("[a-zA-Z]+")) {
                System.out.println("Invalid input. Please enter a valid string.");
                System.out.print("Enter person's surname: ");
                input.next();
            }
            // If the input is valid, store it in the surname variable and break out of the loop
            surname = input.next();

            // Prompt the user to enter person's name
            System.out.print("Enter your email: ");
            // Use a while loop to ensure that the user enters a valid email address
            while (!input.hasNext("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
                System.out.println("Invalid input. Please enter a valid email.");
                System.out.print("Enter your email: ");
                input.next();
            }
            // If the input is valid, store it in the email variable and break out of the loop
            email = input.next();

            break;
        }
        /* This block of code prompts the user to enter a row number (between 1 and 3) and
        a seat number (between 1 and the length of the selected row).*/
        while (true) {
            // Ask user for row number
            System.out.print("Enter row number (1-3): ");
            // Validate user input for row number
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer");
                System.out.print("Enter row number (1-3): ");
                input.next();
            }

            // Convert user input to 0-based indexing and check if row number is valid
            row = input.nextInt() - 1;
            if (row < 0 || row > 2) {
                System.out.println("Invalid row number, please try again");
                continue;
            }

            // Ask user for seat number
            System.out.print("Enter seat number (1-" + seats[row].length + "):");
            // Validate user input for seat number
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                System.out.print("Enter seat number (1-" + seats[row].length + "):");
                input.next(); // discard invalid input
            }

            // Convert user input to 0-based indexing and check if seat number is valid and available
            int seat = input.nextInt() - 1;
            if (seat < 0 || seat >= seats[row].length) {
                System.out.println("Invalid seat number, please try again");
                continue;
            }
            if (seats[row][seat] == 1) {
                System.out.println("This seat is already taken, please try again");
                continue;
            }

            seats[row][seat] = 1; // mark seat as occupied
            System.out.println("Ticket purchased for row " + (row + 1) + ", seat " + (seat + 1));

            // Ask user for ticket price
            System.out.print("Enter price £: ");

            // Validate user input for ticket price
            while (!input.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.print("Enter price £: ");
                input.next(); // discard invalid input
            }

            // Convert user input to double and check if price is valid
            double price = input.nextDouble();
            if (price <= 0) {
                System.out.println("Invalid price.");
                return;
            }
            // Create a new Person object with user input for name, surname, and email
            Person person = new Person(name, surname, email);
            // Create a new Ticket object with row number, seat number, ticket price, and Person object
            Ticket ticket = new Ticket(row, seat, price, person);

            // Mark the seat as taken and add the Ticket object to the list of purchased tickets
            seats[row][seat] = 1; // mark seat as taken
            tickets.add(ticket);

            // Notify the user that the ticket purchase was successful
            System.out.println("Ticket bought successfully.");

            // Ask the user if they want to book another seat
            while (true) {
                System.out.print("Do you want to book another seat? (y/n): ");
                String answer = input.next();
                // If the user wants to book another seat
                if (answer.equalsIgnoreCase("y")) {
                    // Ask for the row number
                    System.out.print("Enter row number (1-3): ");
                    // Validate user input for row number
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter an integer");
                        System.out.print("Enter row number (1-3): ");
                        input.next();
                    }

                    // Convert user input to 0-based indexing and check if row number is valid
                    row = input.nextInt() - 1; //
                    if (row < 0 || row > 2) {
                        System.out.println("Invalid row number, please try again");
                        continue;
                    }

                    // Ask user for seat number
                    System.out.print("Enter seat number (1-" + seats[row].length + "):");
                    // Validate user input for seat number
                    while (!input.hasNextInt()) {
                        System.out.println("Invalid input. Please enter an integer.");
                        System.out.print("Enter seat number (1-" + seats[row].length + "):");
                        input.next(); // discard invalid input
                    }

                    // Convert user input to 0-based indexing and check if seat number is valid and available
                     seat = input.nextInt() - 1;
                    if (seat < 0 || seat >= seats[row].length) {
                        System.out.println("Invalid seat number, please try again");
                        continue;
                    }
                    if (seats[row][seat] == 1) {
                        System.out.println("This seat is already taken, please try again");
                        continue;
                    }

                    seats[row][seat] = 1; // mark seat as occupied
                    System.out.println("Ticket purchased for row " + (row + 1) + ", seat " + (seat + 1));

                    // Ask user for ticket price
                    System.out.print("Enter price £: ");
                    // Validate user input for ticket price
                    while (!input.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a number.");
                        System.out.print("Enter price £: ");
                        input.next(); // discard invalid input
                    }
                    // Convert user input to double and check if price is valid
                    price = input.nextDouble();
                    if (price <= 0) {
                        System.out.println("Invalid price.");
                        return;
                    }
                    // Create a new Person object with user input for name, surname, and email
                    person = new Person(name, surname, email);
                    // Create a new Ticket object with row number, seat number, ticket price, and Person object
                    ticket = new Ticket(row, seat, price, person);

                    // Mark the seat as taken and add the Ticket object to the list of purchased tickets
                    seats[row][seat] = 1; // mark seat as taken
                    tickets.add(ticket);

                    // Notify the user that the ticket purchase was successful
                    System.out.println("Ticket bought successfully.");

                }
                // If the user does not want to book another seat, exit the loop
                else if (answer.equalsIgnoreCase("n")) {
                    System.out.println();
                    return;
                }
                // If the user enters an invalid answer, prompt them to enter 'y' or 'n'
                else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'");
                }
            }

        }
    }


    // Method to print seating area
    public static void print_seating_area() {
        // Print screen area header
        System.out.println("         ************\n" +
                           "         *  Screen  *\n" +
                           "         ************");

        // Loop through rows and seats
        for (int i = 0; i < seats.length; i++) {
            // Print indentation based on row number
            if (i == 0) {
                System.out.print("         ");
            } else if (i == 1) {
                System.out.print("       ");
            } else {
                System.out.print("     ");
            }
            // Print seat status (O for available, X for taken)
            for (int j = 0; j < seats[i].length; j++) {
                if (seats[i][j] == 0) {
                    System.out.print("O");
                } else {
                    System.out.print("X");
                }
                // Add space between middle seats (if row has even number of seats)
                if (seats[i].length % 2 == 0 && j == (seats[i].length / 2) - 1) {
                    System.out.print(" ");
                }
            }
            // Print new line after each row
            System.out.println();
        }
        // Add message to prompt user to press Enter to continue in menu
        System.out.print("\nPress enter to return to the main menu......");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    // Method to list available seats
    public static void list_available_seats() {
        // Loop through each row in the seats array
        for (int i = 0; i < seats.length; i++) {
            // Print out the row number and a message indicating seats available
            System.out.print("Seats available in row " + (i + 1) + ": ");

            // Loop through each seat in the current row
            for (int j = 0; j < seats[i].length; j++) {
                // Check if the current seat is available (represented by 0)
                if (seats[i][j] == 0) {
                    // Print out the seat number
                    System.out.print((j + 1) + ", ");
                }
            }
            // After checking all seats in the row, print a newline character to move to the next row
            System.out.println();
        }
        // Add message to prompt user to press Enter to continue in menu
        System.out.print("\nPress enter to return to the main menu......");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    // Method to cancel a ticket
    public static void cancel_Ticket() {
        // Create a Scanner object to read input from the console
        Scanner input = new Scanner(System.in);
        while (true) {
            // Prompt the user to enter the row number of the seat they want to cancel
            System.out.print("Please enter the row number of the seat you want to cancel (1-3): ");
            // Loop until the user enters a valid integer
            while (!input.hasNextInt()) {
                // If the user enters an invalid input, print an error message and prompt them again
                System.out.println("Invalid input. Please enter an integer");
                System.out.println("Please enter the row number of the seat you want to cancel (1-3): ");
                input.next();
            }
            // Read the user's input as an integer
            int row = input.nextInt() - 1;
            // Check if the row number is within the valid range
            if (row < 0 || row > 2) {
                System.out.println("Invalid row number, please try again");
                continue;
            }

            // Prompt the user to enter the seat number of the seat they want to cancel
            System.out.print("Please enter the seat number of the seat you want to cancel(1-" + seats[row].length + "):");
            // Loop until the user enters a valid integer
            while (!input.hasNextInt()) {
                // If the user enters an invalid input, print an error message and prompt them again
                System.out.println("Invalid input. Please enter an integer");
                System.out.println("Please enter the seat number of the seat you want to cancel (1-" + seats[row].length + "):");
                input.next();
            }
            // Read the user's input as an integer
            int seat = input.nextInt() - 1;
            // Check if the seat number is within the valid range for the selected row
            if (seat < 0 || seat >= seats[row].length) {
                System.out.println("Invalid seat number, please try again");
                continue;
            }


            // Initialize a variable to hold the ticket to remove, initially set to null
            Ticket ticketToRemove = null;
            // Loop through all the tickets to find the one matching the specified row and seat numbers
            for (Ticket ticket : tickets) {
                if (ticket.getRow() == row && ticket.getSeat() == seat) {
                    // If a matching ticket is found, set ticketToRemove to that ticket
                    ticketToRemove = ticket;
                }
            }
            // Check if a matching ticket was found
            if (ticketToRemove != null) {
                /*If a matching ticket was found, remove it from the list of tickets
                 and mark the corresponding seat as available*/
                tickets.remove(ticketToRemove);
                seats[row][seat] = 0;
                System.out.println("Ticket cancelled successfully");
                System.out.println();
            }
            else if (seats[row][seat] == 0){
                // If no matching ticket was found but the seat is already available, print an error message
                System.out.println("Ticket not found");
                System.out.println("This seat is already available!");
                System.out.println();
            }

            while (true) {
                // Ask the user if they want to cancel another seat
                System.out.print("Do you want to cancel another seat? (y/n): ");
                String answer = input.next();
                // Check if the user wants to cancel another seat
                if (answer.equalsIgnoreCase("y")) {
                    /* If the user wants to cancel another seat, call the cancel_Ticket()
                    method to process the cancellation*/
                    cancel_Ticket();
                } else if (answer.equalsIgnoreCase("n")) {
                    // If the user doesn't want to cancel another seat, break out of the loop
                    System.out.println();
                    break;
                } else {
                    // If the user enters an invalid response, print an error message and ask again
                    System.out.println("Invalid input. Please enter 'y' or 'n'");
                }
            }
            break;
        }
    }

    // Method to save data to file
    public static void save_to_file() {
        try {
            // Create a FileWriter to write data to a file
            FileWriter t_writer = new FileWriter("seatingData.txt");

            // Write the seat data to the file, row by row
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {
                    t_writer.write(seats[i][j] + ",");
                }
                t_writer.write("\n");
            }

            // Write the availability data for each row
            t_writer.write("\n");
            t_writer.write("Seats available in row 1: ");
            for (int j = 0; j < seats[0].length; j++) {
                if (seats[0][j] == 0) {
                    t_writer.write((j + 1) + ",");
                }
            }
            t_writer.write("\nSeats available in row 2: ");
            for (int j = 0; j < seats[1].length; j++) {
                if (seats[1][j] == 0) {
                    t_writer.write((j + 1) + ",");
                }
            }
            t_writer.write("\nSeats available in row 3: ");
            for (int j = 0; j < seats[2].length; j++) {
                if (seats[2][j] == 0) {
                    t_writer.write((j + 1) + ",");
                }
            }
            // Close the FileWriter
            t_writer.close();
            // Print a message to confirm that the seats were saved successfully
            System.out.println("Seats saved to seating.txt document");
        }
        catch (IOException e) {
            // If an error occurs, print an error message and the error details
            System.out.println("An error occurred while saving the data.");
            e.getMessage();
        }
        // Add message to prompt user to press Enter to continue in menu
        System.out.print("\nPress enter to return to the main menu......");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println();
    }

    // Method to load save data to file
    public static void load_from_file() {
        try {
            //The file must be named "seatingData.txt" and be located in the same directory as the program.
            File file = new File("seatingData.txt");
            // Create a FileReader to read data on file
            Scanner file_reader = new Scanner(file);

            // This loop reads each line of the file and prints it to the console
            while (file_reader.hasNextLine()) {
                String text = file_reader.nextLine();
                System.out.println(text);
            }
            // Close the FileReader
            file_reader.close();
        } catch (FileNotFoundException e) {
            //If the file is not found, an error message is printed to the console.
            System.out.println("File not found: ");
            e.getMessage();
        }
        // Add message to prompt user to press Enter to continue in menu
        System.out.print("\nPress enter to return to the main menu......");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println();
    }

    // Method to print ticket information
    public static void show_tickets_info() {
        //initialize variable
        double totalPrice = 0;
        System.out.println("Ticket Information:");
        System.out.println();
        //loop through all tickets and print ticket information using ticket.print() method
        for (Ticket ticket : tickets) {
            ticket.print();
            totalPrice += ticket.getPrice();
        }
        // print total price of all tickets
        System.out.println("Total price of all tickets: £" + totalPrice);
        System.out.println();
        // Add message to prompt user to press Enter to continue in menu
        System.out.print("\nPress enter to return to the main menu......");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println();
    }

    // Method to sort ticket price in ascending order and print with person's information
    public static void sort_tickets_by_price(ArrayList<Ticket> tickets_list) {
        // Convert the ArrayList to an array
        Ticket[] tickets = tickets_list.toArray(new Ticket[0]);
        int size= tickets.length;
        // Bubble sort algorithm to sort tickets by price
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size-i-1; j++) {
                if (tickets[j].getPrice() > tickets[j+1].getPrice()) {
                    Ticket temp = tickets[j];
                    tickets[j] = tickets[j+1];
                    tickets[j+1] = temp;
                }
            }
        }
        // Print the sorted tickets
        for (Ticket ticket : tickets) {
            ticket.print();
        }
        // Add message to prompt user to press Enter to continue in menu
        System.out.print("\nPress enter to return to the main menu......");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println();
    }
}










//REFERENCES
//https://www.geeksforgeeks.org/arraylist-array-conversion-java-toarray-methods/
//https://www.geeksforgeeks.org/check-email-address-valid-not-java/
//https://www.geeksforgeeks.org/arrays-fill-java-examples/
