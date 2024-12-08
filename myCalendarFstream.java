import java.io.File;
import java.io.FileWriter; // to connect and open a file path
import java.io.IOException; // IO
import java.util.Calendar;
import java.util.Scanner;



public class myCalendarFstream {
    public static void main(String[] args) {
        String inputfpath = ("calendar_input.txt"); // initialize input file path
        String outputfpath = ("calendar_output.txt"); // initialize output file path

        // create file path for user input
        try (FileWriter writer = new FileWriter(inputfpath)){
            writer.write("Enter year: \n"); // for year
            writer.write("Enter month: \n"); // for month
        } catch (IOException e) {
            System.err.println("Error in writing." + e.getMessage()); // for errors
            return;
        }

            // Guide the user on how and what should they input
            System.out.println("-------------------------------------------------------------------------------------------------");
            System.out.println("|The input file has been created. Please open 'calendar_input.txt' and enter the year and month.|");
            System.out.println("|Example format:                                                                                |");
            System.out.println("|Enter Year: 2024                                                                               |");
            System.out.println("|Enter Month: 5                                                                                 |");
            System.out.println("|Once you're done, re-run the program to process the calendar.                                  |");
            System.out.println("-------------------------------------------------------------------------------------------------");
            

        // Scanner for user to manually edit the file
        System.out.println("Press Enter when you have edited the file...");
            try (Scanner enterscanner = new Scanner(System.in)){
                    enterscanner.nextLine(); // wait for the user to enter
            } 

                // initialize the year and month
                    int year = 0;
                    int month = 0;
                
                // Read the user input
            try (Scanner sc = new Scanner(new File(inputfpath))) {
                while (sc.hasNextLine()) { 
                    String line = sc.nextLine().trim(); // read the user input
                
                if (line.isEmpty()) {
                    continue; // skip empty lines
                }
                    if (line.startsWith("Enter year:")) {
                        try {
                            year = Integer.parseInt(line.split(":")[1].trim()); // split the input in Enter year: into 2 for example "Enter year:" and "2024"
                                        // parseInt takes string into int
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid year format in input file.");
                            return;
                    }
                } else if (line.startsWith("Enter month:")) {
                    try {
                        month = Integer.parseInt(line.split(":")[1].trim()); // split the input in Enter month: into 2 for example "Enter month:" and "8"
                                    // parseInt takes string into int
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid month format in input file.");
                        return;
                      } 
                    }       
            }
        }   catch (IOException e) {
            System.err.println("Error reading from input file: " + e.getMessage());
            return;       
        }
             // Validate the year and month input
             if (year <= 0 || month < 1 || month > 12) {
                 System.out.println("Invalid year or month! Please check the input file.");
                     return;
             }
              // Generate Calendar
                String cal = getCalendar(year, month); // printing of calendar
                System.out.println(cal);

                // Writing the generated calendar to the output file
            try (FileWriter fileWriter = new FileWriter(outputfpath)) {
                fileWriter.write(cal); // Write calendar to the file
                System.out.println("\nCalendar saved to " + outputfpath + " successfully.");
        } catch (IOException e) {
             System.err.println("Error writing to the output file: " + e.getMessage());
                }

    }
                 public static String getCalendar(int year, int month){ // new method for calendar
                     StringBuilder sb = new StringBuilder(); // sb to append the Strings

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month -1, 1); // set the month starting to 1 and date too

        int dayinweek = calendar.get(Calendar.DAY_OF_WEEK); // get the days in a week 
        int dayinmonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // get the days in a month

        // Design the calendar appearance 

    sb.append("\n    ");
    sb.append(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, java.util.Locale.ENGLISH)); 
    // get the display name for the month with its longer version and in english language for example "JANUARY"
    sb.append(" ");
    sb.append(year);
    sb.append("\n");
    sb.append("Su Mo Tu We Th Fr Sa\n");

    for (int i = 1; i<dayinweek; i++) { // loop for 1 up to the day in week 
        sb.append("   "); // append spaces to align 
    }

    // Append the days of the month
    for (int day = 1; day <= dayinmonth; day++) {
        sb.append(String.format("%2d ", day)); // format the digits to align it 

        if ((day + dayinweek - 1) % 7 == 0) {
            sb.append("\n"); // break line every week
        }
    }
    sb.append("\n");
        return sb.toString();
           
    }
}













