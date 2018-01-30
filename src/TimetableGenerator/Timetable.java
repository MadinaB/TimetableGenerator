package TimetableGenerator;
import java.util.ArrayList;
import javafx.util.Pair;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Timetable {

	//private String data = "Math: Monday 10:30-12:30 \n Literature: Monday 10:30-12:30 \n";


	public String DoWork(String data){
		return printData(prepareData(data));
	}

	private String printData(ArrayList< Pair<Integer, Pair<Integer,Pair<String , String>>>> data){
		StringBuilder record = new StringBuilder();
		for(int i = 0; i<data.size(); i++){
			record.append(data.get(i).getKey());
			record.append(", ");
			record.append(data.get(i).getValue().getKey());
			record.append(": ");
			record.append(data.get(i).getValue().getValue().getKey());
			record.append(" ");
			record.append(data.get(i).getValue().getValue().getValue());
			record.append("\n");
		}
		return record.toString();
	}

	private ArrayList< Pair<Integer, Pair<Integer,Pair<String , String>>>> prepareData(String input){

		ArrayList<Pair<Integer, Pair<Integer,Pair<String , String>>>> answer = new ArrayList<>();// <day,< starttime, <str plan, str time> >

		String delim1 = "[\n]";												// extract lines
        String[] lines = input.split(delim1);

        for(int l = 0; l<lines.length; l++){								// if there are lines
        	String delim2 = "[:]";
        	String[] inputPlanTime = (lines[l]).split(delim2,2);			// divide to name and time by splitting by :
        	if(inputPlanTime.length==2){									// if can be divided
        		String plan = inputPlanTime[0];
        		String timeRecord = inputPlanTime[1];						// timeRecord in format "Monday 10:30 - 12:30   " thus delete whitespaces
        		String time="";
        		String day="";
        		StringBuilder record = new StringBuilder();					// delete whitespaces in timeRecord
                String records[] = timeRecord.split("[ ]+");
                for(int i=0;i< records.length;i++){
                    record.append(records[i]);
                }
                timeRecord = record.toString();								// delete whitespaces in timeRecord

                if(timeRecord.length()>9) {									//extract time and day from timeRecord
                    Pattern pattern = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]-([01]?[0-9]|2[0-3]):[0-5][0-9]");
                    Matcher matcher = pattern.matcher(record);
                    if (matcher.find()) {
                        time = matcher.group();
                        day = timeRecord.substring(0, timeRecord.length() - time.length());
                    }														//extract time and day from timeRecord
                }

                if(time.length()>0&& day.length()>0){
                	int minutes = getMinutes(time);
                	int dayOfWeek = getDayIndex(day);
                	if(dayOfWeek!=0){
                		answer.add(new Pair(dayOfWeek,new Pair(minutes,new Pair(plan, time))));
                	}
                }


        	}
        }
		return  answer;
	}

	private int getDayIndex(String str){
		int answer = 0;
		switch(str){
			case "MONDAY":
			case "Monday":
			case "monday":
			case "MON":
			case "Mon":
			case "mon":
				answer = 1;
				break;
			case "TUESDAY":
			case "Tuesday":
			case "tuesday":
			case "TUE":
			case "Tue":
			case "tue":
				answer = 2;
				break;
			case "WEDNESDAY":
			case "Wednesday":
			case "wednesday":
			case "WED":
			case "Wed":
			case "wed":
				answer = 3;
				break;
			case "THURSDAY":
			case "Thursday":
			case "thursday":
			case "THU":
			case "Thu":
			case "thu":
				answer = 4;
				break;
			case "FRIDAY":
			case "Friday":
			case "friday":
			case "FRI":
			case "Fri":
			case "fri":
				answer = 5;
				break;
			case "SATURDAY":
			case "Saturday":
			case "saturday":
			case "SAT":
			case "Sat":
			case "sat":
				answer = 6;
				break;
			case "SUNDAY":
			case "Sunday":
			case "sunday":
			case "SUN":
			case "Sun":
			case "sun":
				answer = 7;
				break;
		}
		return answer;
	}

	private int getMinutes(String str){
		String delims = "[ :-]+";
        String[] tokens = str.split(delims);
        int startTime = getMinutes(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]));
        int endTime = getMinutes(Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]));
        return startTime;
	}

	private int getMinutes(int hour, int minutes){
		return (hour*60 + minutes);
	}

}