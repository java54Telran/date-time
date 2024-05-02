package telran.time.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.junit.jupiter.api.Test;

class DateTimeTest {

	@Test
	void introductionTest() {
		LocalDateTime d1 = LocalDateTime.parse("1990-01-30T00:00:00");
		LocalDateTime d2 = LocalDateTime.parse("2000-10-20T00:00:00");
		ChronoUnit unit = ChronoUnit.SECONDS;
		System.out.printf("difference between %s and %s in %s is %d",
				d2, d1, unit, unit.between(d2, d1));
	}
	

}
