package Q13_08_Lambda_Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyAnsQuestion {
	public static Random random = new Random();

	
 	public static void main(String... args) {	
 		List<Integer> list = new ArrayList<Integer>();
 		list.add(1);
 		list.add(2);
 		list.add(3);
 		list.add(4);
 		List<Integer> subset = getRandomSubset(list);
 		System.out.println(subset.toString());
 	}

 	static Predicate<Object> filter1= O->{
 		return new Random().nextBoolean();
 	};

 	private static List<Integer> getRandomSubset(List<Integer> list) {
		Random ran = new Random(); 
		//return list.stream().filter(x -> {return ran.nextBoolean();}).collect(Collectors.toList());
		return list.stream().filter(filter1).collect(Collectors.toList());
	}

}