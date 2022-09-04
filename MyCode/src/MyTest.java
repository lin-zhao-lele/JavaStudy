import java.util.ArrayList;
import java.util.List;

public class MyTest
{
	public static void main(String... args)
	{
		//
		System.out.println("Java Examples! *********************************************** ");

		final ExampleModule examples = new ExampleModule();
		examples.sum(1,2);


		System.out.println("实例化内部类");
		List<StudyStream.User> users = new ArrayList<StudyStream.User>();
		users.add(new StudyStream.User("张三", 35));
		users.add(new StudyStream.User("李三", 45));
		users.stream().map(it -> it.getName() + " " +  it.getAge()).forEach(System.out::println);

		//
		System.out.println("Done! *********************************************** ");
	}
}
