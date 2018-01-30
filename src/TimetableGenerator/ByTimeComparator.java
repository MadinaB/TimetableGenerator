package TimetableGenerator;

import java.util.Comparator;

import javafx.util.Pair;

public class ByTimeComparator implements Comparator<Pair<Integer, Pair<Integer,Pair<String , String>>>>{

	@Override
	public int compare(Pair<Integer, Pair<Integer, Pair<String, String>>> o1,
			Pair<Integer, Pair<Integer, Pair<String, String>>> o2) {

		return (o1.getValue().getKey()-o2.getValue().getKey());
	}

}
