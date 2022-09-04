import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StudyMap
{
	public static void main(String[] args)
	{
		// Map 相关
		System.out.println("Java Map! *********************************************** ");
		Map<String, Integer> exampleMap =  new HashMap<String, Integer>();  //使用泛型定义
		exampleMap.put("Test1", 1);
		exampleMap.put("Test2", 2);
		exampleMap.put("Test3", 3);

		Map<String, Integer> exampleMap2 = new TreeMap<String, Integer>();
		exampleMap2.put("A", 300);
		exampleMap2.put("B", 400);

		System.out.println(exampleMap);
		System.out.println(exampleMap2);

		//
		System.out.println("Done! *********************************************** ");
	}
}
