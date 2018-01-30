package TimetableTests;
import static org.junit.Assert.*;
import org.junit.Test;

import TimetableGenerator.Timetable;


public class CheckTimetableInputParses {

	Timetable t = new Timetable();

	@Test
	public void test1() {
		String data = "Math: Monday 10:30-12:30 \nLiterature: Monday 10:30-12:30 \n";
		String answer ="1, 630: Math 10:30-12:30\n1, 630: Literature 10:30-12:30\n";
		String output = t.DoWork(data);
		assertEquals(output,answer);
	}

	@Test
	public void test2() {
		String data = "Math: Monday  \nLiterature: Monday 10:30-12:30 \n";
		String answer ="1, 630: Literature 10:30-12:30\n";
		String output = t.DoWork(data);
		assertEquals(output,answer);
	}

	@Test
	public void test3() {
		String data = ": Monday  \nLiterature: Monday 10:30-12:30 \n";
		String answer ="1, 630: Literature 10:30-12:30\n";
		String output = t.DoWork(data);
		assertEquals(output,answer);
	}

	@Test
	public void test4() {
		String data = "Monday 10:30-12:30  \nLiterature: Monday 10:30-12:30 \n";
		String answer ="1, 630: Literature 10:30-12:30\n";
		String output = t.DoWork(data);
		assertEquals(output,answer);
	}

	@Test
	public void test5() {
		String data = " :Monday :30-12:30  \nLiterature: Monday 10:30-12:30 \n";
		String answer ="1, 630: Literature 10:30-12:30\n";
		String output = t.DoWork(data);
		assertEquals(output,answer);
	}

	@Test
	public void test6() {
		String data = "Math: Monday 10:30-12:30 \nLiterature: tuesday 10:30-12:30 \n";
		String answer ="1, 630: Math 10:30-12:30\n2, 630: Literature 10:30-12:30\n";
		String output = t.DoWork(data);
		assertEquals(output,answer);
	}

	@Test
	public void test7() {
		String data = "Math: Monday 10:30-12:30 \nLiterature:  y 10:30-12:30 \n";
		String answer ="1, 630: Math 10:30-12:30\n";
		String output = t.DoWork(data);
		assertEquals(output,answer);
	}

	@Test
	public void test8() {
		String data = "Math: Saturday 3:30-12:30 \nLiterature: Monday 22:30-12:30 \n";
		data += "English: Sunday 20:30-12:30 \nHistory: Tuesday 10:30-12:30 \n";
		data += "Kazakh: Sunday 22:30-12:30 \nRussian: Tuesday 12:30-12:30 \n";
		data += "Physics: Sunday 00:30-12:30 \nChemistry: Tuesday 12:30-12:30 \n";
		String answer ="1, 1350: Literature 22:30-12:30\n2, 630: History 10:30-12:30\n2, 750: Russian 12:30-12:30\n";
				answer+="2, 750: Chemistry 12:30-12:30\n6, 210: Math 3:30-12:30\n7, 30: Physics 00:30-12:30\n";
				answer+="7, 1230: English 20:30-12:30\n7, 1350: Kazakh 22:30-12:30\n";
		String output = t.DoWork(data);
		assertEquals(output,answer);
	}
}
