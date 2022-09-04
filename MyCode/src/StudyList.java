import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudyList
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// 新建一个数组
		List<String> exampleList = Arrays.asList("Test1", "Test2", "Test3");  //这样定义的list只能装String对象 List的大小是固定的
		List<String> exampleList2 = new ArrayList<>(); //List的大小不是固定的
		exampleList2.add("Test4");
		exampleList2.add("Test5");
		// 数组转化成List
		String[] arrayString = exampleList.toArray(new String[3]);
		List<String> exampleList3 = Arrays.asList(arrayString);

		System.out.println(exampleList);
		System.out.println(exampleList2);

		Collection exampleCollection = new ArrayList(); //list可以放不同类型的对象！！！！
		exampleCollection.add("Hello");
		exampleCollection.add(2000);
		exampleCollection.add(2.089);
		int[] x = {12,3,4,5,6};
		exampleCollection.add(x);
		System.out.println("exampleCollection");
		System.out.println(exampleCollection);



		// 判断一个string[] 是否包含某个string, 转化成List 再调用contains函数
		String[] xx = new String[] { "test", "test2" };
		boolean contain = Arrays.asList(xx).contains("test");
		System.out.println(contain);

		// 使用类的成员函数比较
		List<User> list = new ArrayList<User>();
		list.add(new User("张三", 35));
		list.add(new User("张四", 25));
		list.add(new User("李三", 15));
		list.add(new User("李四", 55));
		// List 这一行代码即可完成排序
		list.sort(Comparator.comparing(User::getAge));
		list.stream().map(it->it.getName()).forEach(System.out::println);

		// 循环处理 String[]
		String[] baseAttributes = new String[]{"ok","AB","CD","ty","EF"};
		Arrays.stream(baseAttributes).map(it -> it+"!").forEach(System.out::println);
		//  String[] 排序， 转化成List 然后排序
		List<String> baseAttributesList = Arrays.asList(baseAttributes);
		Collections.sort(baseAttributesList);
		System.out.println(baseAttributesList);

		// List 转换成数组
		String[] newbaseAttributes = (String[]) baseAttributesList.toArray();
		String[] newbaseAttributes2 = baseAttributesList.toArray(new String[baseAttributesList.size()]);

		//
		System.out.println("Done! *********************************************** ");

	}

	static class User
	{
		public User(String name, int age)
		{
			this.age = age;
			this.name = name;
		}

		int age = 0;
		String name = "";

		public int getAge()
		{
			return age;
		}

		public String getName()
		{
			return name;
		}
	}

}
