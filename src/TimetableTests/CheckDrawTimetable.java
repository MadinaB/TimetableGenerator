package TimetableTests;
import TimetableGenerator.DrawTimetable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckDrawTimetable {
	DrawTimetable t = new DrawTimetable();

	@Test
	public void test1() {
		String path = "out.png";
		String data = "Math: monday 3:30-12:30 \nLiterature: Monday 22:30-12:30 \n";
		data += "English: MON 20:30-12:30 \nHistory: Monday 10:30-12:30 \n";
		data += "Kazakh: Monday 22:30-12:30 \nRussian: Monday 12:30-12:30 \n";
		data += "Physics: Monday 00:30-12:30 \nChemistry: Monday 12:30-12:30 \n";
		data += "English11: MON 20:30-12:30 \nHistory11: Monday 10:30-12:30 \n";
		data += "Kazakh11: Monday 22:30-12:30 \nRussian11: Monday 12:30-12:30 \n";
		data += "Physics11: Monday 00:30-12:30 \nChemistry11: Monday 12:30-12:30 \n";
		boolean output = t.createTimetableForPhone(data,path);
		assertEquals(output,true);
	}
}
