import java.util.Collection;
import java.util.HashSet;

public class StudySet
{
	public static void main(String[] args)
	{
		// Set 相关
		System.out.println("Java Set! *********************************************** ");
		Collection c = new HashSet();
		//Set可以放不同类型的对象！！！！
		c.add("Hello");
		c.add(2000);
		c.add(2.089);
		c.add(10000);
		System.out.println(c);
		c.remove(10000);
		System.out.println("After remove");
		System.out.println(c);

		//
		System.out.println("Done! *********************************************** ");
	}
}
