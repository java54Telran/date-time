package telran.time.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class DateTimeTest {

	@Test
	void introductionTest() {
		LocalDate birthDateAS = LocalDate.parse("1799-06-06");
		System.out.printf("birthdate of ASP in standard format is %s\n",birthDateAS);
		System.out.printf("birthdate of ASP in <Month>, <year> <day> <day of week>,  is %s\n",
				birthDateAS.format(DateTimeFormatter.ofPattern("MMMM,d yyyy EEEE"
						,Locale.forLanguageTag("ru"))
						));
	}

}
