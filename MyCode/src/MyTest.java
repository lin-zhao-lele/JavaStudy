import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyTest
{
	public static void main(String... args)
	{
		//
		System.out.println("Java Examples! *********************************************** ");

		final ExampleModule examples = new ExampleModule();

		examples.sum(1,2);


		System.out.println("实例化内部类");
//		System.out.println("实例化内部类");
		List<StudyStream.User> users = new ArrayList<StudyStream.User>();

		users.add(new StudyStream.User("张三", 35));
		users.add(new StudyStream.User("李三", 45));
		users.stream().map(it -> it.getName() + " " +  it.getAge()).forEach(System.out::println);


		//
		System.out.println("Done! *********************************************** ");

		String[] marketParticipants = new String[]{"ALL0", "ALL1", "ALL2" };

		String str = "All0:0,All1:1,All2:2";
		Map<String, String> headerMap = Arrays.stream(str.split(","))
				.collect(Collectors.toMap(s->s,s->s));

		Map<String, String> headerMap2 = Arrays.stream(str.split(","))
				.map(it -> it.split(":"))
				.collect(Collectors.toMap(s->s[0],s->s[1]));

		// TODO test

		// fixme


		System.out.println("Test from Mac monterey! *********************************************** ");
	}
}
