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
}
