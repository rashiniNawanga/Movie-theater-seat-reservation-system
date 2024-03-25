import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Theatre {
    static int[] Row_1 = new int[12];
    static int[] Row_2 = new int[16];
    static int[] Row_3 = new int[20];
    public static ArrayList<Ticket> ticketinfomation = new ArrayList<>();
    public static ArrayList<Person> customerInformationList = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("Welcome to the New Theatre");  //Task 1
        for (int i = 0; i < 12; i++) {
            Row_1[i] = 0;
        }
        for (int i = 0; i < 16; i++) {
            Row_2[i] = 0;
        }
        for (int i = 0; i < 20; i++) {
            Row_3[i] = 0;
        }
        Scanner input = new Scanner(System.in);
        int option;
        while (true) {

            System.out.println("----------------------------------------------------");  //Task 2
            System.out.println("Please select an option: ");
            System.out.println("1) Buy a ticket ");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket ");
            System.out.println("4) List available seats ");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file ");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price ");
            System.out.println("        0) Quit");
            System.out.println("----------------------------------------------------");
            System.out.println("Enter an option : ");




            if (input.hasNextInt()) {
                option = input.nextInt();

            } else {
                System.out.println("Enter a valid number. ");
                input.next();
                continue;
            }


            switch (option) {
                case 1:
                    buy_ticket();
                    break;
                case 2:
                    print_seating_area();
                    break;
                case 3:
                    cancel_ticket();
                    break;
                case 4:
                    show_available();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    load();
                    break;
                case 7:
                    show_tickets_info();
                    break;
                case 8:
                    sort_tickets(ticketinfomation);
                    break;
                case 0:
                    System.out.println("End program.");    // End the program
                    return;
                default:
                    System.out.println("Invalid option.Enter a valid option.");


            }
        }
    }


    static void buy_ticket() {        //buy ticket (Task 3)
        Scanner input = new Scanner(System.in);
        try {
            String name;
            String surname;
            String email;
            int price;
            int Row;
            int seat_num;
            System.out.println("Enter your Row number: ");  // Get Row Number from user
            Row = input.nextInt();

            while (Row < 1 || Row > 3) {
                System.out.println("Enter a valid Row number (1 to 3) : ");
                Row = input.nextInt();
            }

            int[] rowArr;
            if (Row == 1) {
                rowArr = Row_1;
            } else if (Row == 2) {
                rowArr = Row_2;
            } else {
                rowArr = Row_3;
            }

            while (true) {
                System.out.println("Enter your seat number: ");   // Get seat number from user
                seat_num = input.nextInt();

                if (seat_num < 1 || seat_num > rowArr.length) {
                    System.out.println("Enter a valid seat number (1 to " + rowArr.length + "): ");
                } else if (rowArr[seat_num - 1] == 1) {
                    System.out.println("Seat " + seat_num + " is already taken.Enter a seat number again.");

                } else {
                    if(rowArr[seat_num - 1] ==0){
                        System.out.println("Your seat is available."); //Tell the seat is available or not
                        rowArr[seat_num - 1] = 1;
                        break;
                    }
                    else{
                        System.out.println("Your seat is not available.");
                    }

                }
            }
            input.nextLine();
            System.out.println("Enter your name: ");
            name = input.nextLine();
            System.out.println("Enter your surname: ");
            surname = input.nextLine();
            System.out.println("Enter your email: ");
            email = input.nextLine();
            System.out.println("Enter the price: ");
            price = input.nextInt();

            Person person = new Person(name, surname, email);
            Ticket ticket = new Ticket(Row, seat_num, price, person);
            System.out.println(ticket);
            ticketinfomation.add(ticket);

        } catch (Exception e) {
            System.out.println("Enter an integer.");
            buy_ticket();
        }
    }


    public static void print_seating_area() {    //print seat area (Task 4)
        System.out.println("     ***********   ");
        System.out.println("     ");
        System.out.println("     *  STAGE  *");
        System.out.println("     ");
        System.out.println("     ***********   ");
        System.out.println("    ");
        System.out.print("    ");

        for (int i = 0; i < Row_1.length; i++) {
            if (Row_1[i] == 0) {
                System.out.print("0");
            } else {
                System.out.print("X");
            }
            if (i == 5) {
                System.out.print(" ");
            }

        }
        System.out.println("\n");
        System.out.print("  ");

        for (int i = 0; i < Row_2.length; i++) {
            if (Row_2[i] == 0) {
                System.out.print("0");
            } else {
                System.out.print("X");
            }
            if (i == 7) {
                System.out.print(" ");
            }
        }
        System.out.println("\n");

        for (int i = 0; i < Row_3.length; i++) {
            if (Row_3[i] == 0) {
                System.out.print("0");
            } else {
                System.out.print("X");
            }
            if (i == 9) {
                System.out.print(" ");

            }
        }
        System.out.println("\n");


    }

    public static void cancel_ticket() {    //cancel ticket (Task 5)
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your row number: ");    //Get row number from user to cancel the ticket
        int Row = input.nextInt();
        if (Row > 3) {
            System.out.println("Invalid Row Number");
            cancel_ticket();
        }


        if (Row == 1) {
            System.out.println("Enter your seat number: ");   //Get seat number from user to cancel the ticket
            int Seat_Num = input.nextInt();

            if (Seat_Num >= 1 && Seat_Num <= 12) {
                if (Row_1[Seat_Num - 1] == 1) {
                    System.out.println("Your seat is canceled");
                    Row_1[Seat_Num - 1] = 0;
                } else {
                    System.out.println("Your seat is not booked.Enter your seat number again.");
                }

            } else {
                System.out.println("Enter a valid seat number");
            }
        } else if (Row == 2) {
            System.out.println("Enter your seat number: ");   //Get seat number from user to cancel the ticket
            int Seat_Num = input.nextInt();

            if (Seat_Num >= 1 && Seat_Num <= 16) {
                if (Row_2[Seat_Num - 1] == 1) {
                    System.out.println("Your seat is canceled");
                    Row_2[Seat_Num - 1] = 0;
                } else {
                    System.out.println("Your seat is not booked.Enter your seat number again.");
                }
            } else {
                System.out.println("Enter a valid seat number");
            }
        } else if (Row == 3) {
            System.out.println("Enter your seat number: ");    //Get seat number from user to cancel the ticket
            int Seat_Num = input.nextInt();


            if (Seat_Num >= 1 && Seat_Num <= 20) {
                if (Row_3[Seat_Num - 1] == 1) {
                    System.out.println("Your seat is canceled.");
                    Row_3[Seat_Num - 1] = 0;
                } else {
                    System.out.println("Your seat is not booked.Enter your seat number again.");
                }
            } else {
                System.out.println("Enter a valid seat number");
            }
        } else {
            System.out.println("Enter a valid row number: ");
        }
    }


    static void show_available() {      //show available (Task 6)
        System.out.print("Seats available in Row 1: ");
        for (int i = 0; i < Row_1.length; i++) {
            if (Row_1[i] == 0) {
                System.out.print(i + 1 + ",");
            }
        }

        System.out.println("\n");

        System.out.print("Seats available in Row 2: ");
        for (int i = 0; i < Row_2.length; i++) {
            if (Row_2[i] == 0) {
                System.out.print(i + 1 + ",");
            }
        }
        System.out.println("\n");
        System.out.print("Seats available in Row3: ");


        for (int i = 0; i < Row_3.length; i++) {
            if (Row_3[i] == 0) {
                System.out.print(i + 1 + ",");
            }
        }
        System.out.println("\n");
    }


    public static void save() {   //save (Task 7)
        try {

            File array_file = new File("Array.details.txt");
            if (array_file.createNewFile()) {
                System.out.println("File created :" + array_file.getName());
            }


            FileWriter writer = new FileWriter("Array.details.txt");
            writer.write("Seats in Row 1 : ");
            for (int item : Row_1) {

                writer.write(+item + " ");
            }
            writer.write('\n');
            writer.write("Seats in Row 2 : ");
            for (int item : Row_2) {


                writer.write(+item + " ");
            }
            writer.write('\n');
            writer.write("Seats in Row 3 : ");
            for (int item : Row_3) {
                writer.write(+item + " ");

            }


            writer.close();


        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        System.out.println("Your details has been saved to a file");

    }

    public static void load() {      //load(Task 8)
        try {
            File object = new File("Array.details.txt");
            Scanner Reader = new Scanner(object);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                System.out.println(data);


            }
            Reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred ");
            e.printStackTrace();
        }


    }
    private static void sort_tickets(ArrayList<Ticket> ticketsInformationList) {       //Task 14
        int minIndex;
        Ticket temp;
        for (int start = 0; start < ticketsInformationList.size() - 1; start++) {
            minIndex = start;
            for (int i = start + 1; i <= ticketsInformationList.size() - 1; i++) {
                if  (ticketsInformationList.get(i).getPrice() < ticketsInformationList.get(minIndex).getPrice()) {
                    minIndex = i;
                }
            }
            temp = ticketsInformationList.get(start);
            ticketsInformationList.set(start, ticketsInformationList.get(minIndex));
            ticketsInformationList.set(minIndex,temp);
        }
        show_tickets_info();
    }
    private static void show_tickets_info() {          //Task 13
        int total = 0;
        for(Ticket ticket: ticketinfomation){
            ticket.print();
            System.out.println(ticket);
            total = total+ticket.getPrice();
        }
        System.out.println(total);
    }



}






