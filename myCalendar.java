// Calendar Using Scanner only
import java.util.Calendar; // for java calendar package
import java.util.Scanner; // for user input
public class myCalendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Getting user input
            System.out.print("Enter Year(Example: 2024): "); // user input for the year
            int year = sc.nextInt();
            System.out.print("Enter Month(1-12): "); // user input for the month
            int month = sc.nextInt();
                sc.close();
        if (month < 1 || month > 12) { // if user input a number less than 1 and greater than 12 it will be invalid
            System.out.println("Invalid! Please enter a number between 1-12 only.");
            return;
        }

        // Calendar
                String cal = getCalendar(year, month); // printing of calendar
                System.out.println(cal);
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
