package TimetableTests;
import TimetableGenerator.DrawTimetable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CheckDrawTimetable {
	DrawTimetable t = new DrawTimetable();

	@Test
	public void test1() {
		String path = "out.png";
		String data = "Lesson1Lesson1Lesson1: Monday 3:30 \nLesson2Lesson1L: Monday 22:30-12:30 \n";
        data += "Lesson3: Monday 3:30 \nLesson4: Monday 22:30-12:30 \n";
        data += "Lesson5Lesson1Lesson1Lesson1: Monday 3:30 \nLesson6: Monday 22:30-12:30 \n";
        data += "Lesson7: Monday 3:30 \nLesson8: Monday 22:30-12:30 \n";
        data += "Lesson9: Monday 3:30 \nLesson10: Monday 22:30-12:30 \n";
        data += "Lesson11: Monday 3:30 \nLesson12: Monday 22:30-12:30 \n";
        data += "Lesson13: Monday 3:30 \nLesson14: Monday 22:30-12:30 \n";
        data += "Lesson3: Tuesday 3:30 \nLesson4: Tuesday 22:30-12:30 \n";
        data += "Lesson5Lesson1Lesson1Lesson1: Tuesday 3:30 \nLesson6: Tuesday 22:30-12:30 \n";
        data += "Lesson7: Tuesday 3:30 \nLesson8: Tuesday 22:30-12:30 \n";
        data += "Lesson9: Tuesday 3:30 \nLesson10: Tuesday 22:30-12:30 \n";
        data += "Lesson11: Tuesday 3:30 \nLesson12: Tuesday 22:30-12:30 \n";
        data += "Lesson13: Tuesday 3:30 \nLesson14: Tuesday 22:30-12:30 \n";
        data += "Lesson3: Wednesday 3:30 \nLesson4: Wednesday 22:30-12:30 \n";
        data += "Lesson5Lesson1Lesson1Lesson1: Wednesday 3:30 \nLesson6: Wednesday 22:30-12:30 \n";
        data += "Lesson7: Wednesday 3:30 \nLesson8: Wednesday 22:30-12:30 \n";
        data += "Lesson9: Wednesday 3:30 \nLesson10: Wednesday 22:30-12:30 \n";
        data += "Lesson11: Wednesday 3:30 \nLesson12: Wednesday 22:30-12:30 \n";
        data += "Lesson13: Wednesday 3:30 \nLesson14: Wednesday 22:30-12:30 \n";
        data += "Lesson3: Thursday 3:30 \nLesson4: Thursday 22:30-12:30 \n";
        data += "Lesson5Lesson1Lesson1Lesson1: Thursday 3:30 \nLesson6: Thursday 22:30-12:30 \n";
        data += "Lesson7: Thursday 3:30 \nLesson8: Thursday 22:30-12:30 \n";
        data += "Lesson9: Thursday 3:30 \nLesson10: Thursday 22:30-12:30 \n";
        data += "Lesson11: Thursday 3:30 \nLesson12: Thursday 22:30-12:30 \n";
        data += "Lesson13: Thursday 3:30 \nLesson14: Thursday 22:30-12:30 \n";
        data += "Lesson3: Friday 3:30 \nLesson4: Friday 22:30-12:30 \n";
        data += "Lesson5Lesson1Lesson1Lesson1: Friday 3:30 \nLesson6: Friday 22:30-12:30 \n";
        data += "Lesson7: Friday 3:30 \nLesson8: Friday 22:30-12:30 \n";
        data += "Lesson9: Friday 3:30 \nLesson10: Friday 22:30-12:30 \n";
        data += "Lesson11: Friday 3:30 \nLesson12: Friday 22:30-12:30 \n";
        data += "Lesson13: Friday 3:30 \nLesson14: Friday 22:30-12:30 \n";
        data += "Lesson3: Saturday 3:30 \nLesson4: Saturday 22:30-12:30 \n";
        data += "Lesson5Lesson1Lesson1Lesson1: Saturday 3:30 \nLesson6: Saturday 22:30-12:30 \n";
        data += "Lesson7: Saturday 3:30 \nLesson8: Saturday 22:30-12:30 \n";
        data += "Lesson9: Saturday 3:30 \nLesson10: Saturday 22:30-12:30 \n";
        data += "Lesson11: Saturday 3:30 \nLesson12: Saturday 22:30-12:30 \n";
        data += "Lesson13: Saturday 3:30 \nLesson14: Saturday 22:30-12:30 \n";
        data += "Lesson3: Sunday 3:30 \nLesson4: Sunday 22:30-12:30 \n";
        data += "Lesson5Lesson1Lesson1Lesson1: Sunday 3:30 \nLesson6: Sunday 22:30-12:30 \n";
        data += "Lesson7: Sunday 3:30 \nLesson8: Sunday 22:30-12:30 \n";
        data += "Lesson9: Sunday 3:30 \nLesson10: Sunday 22:30-12:30 \n";
        data += "Lesson11: Sunday 3:30 \nLesson12: Sunday 22:30-12:30 \n";
        data += "Lesson13: Sunday 3:30 \nLesson14: Sunday 22:30-12:30 \n";
		boolean output = t.createTimetableForPhone(data,path);
		assertEquals(output,true);
	}
}
