package telran.time.application;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

record MonthYear(int month, int year) {
	
}
public class PrintCalendar {

	private static final int TITLE_OFFSET = 5;
	private static DayOfWeek[] weekDays = DayOfWeek.values();
	public static void main(String[] args)  {
		try {
			MonthYear monthYear = getMonthYear(args);
			printCalendar(monthYear);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static  MonthYear getMonthYear(String[] args) throws Exception{
		// TODO Auto-generated method stub
		return new MonthYear(5, 2024);
	}

	private static void printCalendar(MonthYear monthYear) {
		printTitle(monthYear);
		printWeekDays();
		printDates(monthYear);
		
		
	}

	private static void printDates(MonthYear monthYear) {
		// TODO Auto-generated method stub
		
	}

	private static void printWeekDays() {
		for(DayOfWeek weekday: weekDays) {
			System.out.printf("%4s",weekday.getDisplayName(TextStyle.SHORT,
					Locale.forLanguageTag("en")));
			
		}
		System.out.println();
		
	}

	private static void printTitle(MonthYear monthYear) {
		String monthName = Month.of(monthYear.month())
				.getDisplayName(TextStyle.FULL, Locale.getDefault());
		System.out.printf("%s%s %d\n"," ".repeat(TITLE_OFFSET), monthName, monthYear.year());
		
		
	}

}
