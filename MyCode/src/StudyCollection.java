import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class StudyCollection
{
	public static void main(String... args)
	{
		Collection exampleCollection = new ArrayList(); //list可以放不同类型的对象！！！！
		exampleCollection.add("Hello");
		exampleCollection.add(2000);
		exampleCollection.add(2.089);
		int[] x = {12,3,4,5,6};
		exampleCollection.add(x);
		System.out.println("ArrayList");
		System.out.println(exampleCollection);

		Collection c = new HashSet();
		//Set可以放不同类型的对象！！！！
		c.add("Hello");
		c.add(2000);
		c.add(2.089);
		c.add(10000);
		System.out.println("HashSet");
		System.out.println(c);
	}
}
