//import java.util.*;

import java.util.ArrayList;
import java.util.List;


public class ExampleModule
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








	public void sum(int a, int b){
		System.out.println("calling ExampleModule::sum ");
	}

	// 定义内部类
	static class User
	{
		public User(String name, Integer age)
		{
			this.age = age;
			this.name = name;
		}

		Integer age;
		String name;

		public Integer getAge()
		{
			return age;
		}

		public String getName()
		{
			return name;
		}
	}
}
