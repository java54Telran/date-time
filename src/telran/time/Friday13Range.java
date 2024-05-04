package telran.time;

import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Friday13Range implements Iterable<Temporal> {
    Temporal from;
    Temporal to;
   private  Friday13Range(Temporal from, Temporal to) {
		this.from = from;
		this.to = to;
	}
	public static Friday13Range getRange(Temporal from, Temporal to) {
    	
    	if (compare(from, to) >= 0) {
    		throw new IllegalArgumentException("from Temporal must be less than to Temporal");
    	}
    	return new Friday13Range(from, to);
    }
	@Override
	public Iterator<Temporal> iterator() {
		
		return new FridayIterator();
	}
	private static int compare(Temporal t1, Temporal t2) {
		int [] dateArr1 = toYearMonthDayArray(t1);
		int [] dateArr2 = toYearMonthDayArray(t2);
		return compareDateArray(dateArr1, dateArr2);
		
	}
	private static int[] toYearMonthDayArray(Temporal temporal) {
		int year = temporal.get(ChronoField.YEAR);
		int month = temporal.get(ChronoField.MONTH_OF_YEAR);
		int day = temporal.get(ChronoField.DAY_OF_MONTH);
		int [] result = {year, month, day};
		return result;
	}
	private static int compareDateArray(int[] dateArr1, int [] dateArr2) {
		int res = 0;
		int index = 0;
		while(index < 3 && dateArr1[index] == dateArr2[index]) {
			index++;
		}
		if (index < 3) {
			res = dateArr1[index] - dateArr2[index];
		}
		return res;
	}
	private class FridayIterator implements Iterator<Temporal> {
		NextFriday13 nextFriday13Adjuster = new NextFriday13();
		Temporal currentFriday13 = from.with(nextFriday13Adjuster);
		@Override
		public boolean hasNext() {
			
			return compare(currentFriday13, to) <= 0;
		}

		@Override
		public Temporal next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			Temporal res = currentFriday13;
			currentFriday13 = currentFriday13.with(nextFriday13Adjuster);
			return res;
		}
		
	}

}
