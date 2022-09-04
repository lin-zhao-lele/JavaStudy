import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.stream.Stream;

public class StudyStream {
	public static void main(String args[]){

		System.out.println("map方法");
		// java 8之前
		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<String> strList = new ArrayList<>();
		for (int num : numList) {
			strList.add(Integer.toString(num) + '!');
		}
		System.out.println(strList);
		// java 8
		List<String> strListinJava8 = numList.stream()
				.map(it -> Integer.toString(it) + '!')
				.map(it -> it + "ok")
				.collect(Collectors.toList());
		System.out.println(strListinJava8);

		List<String> stringList = Arrays.asList("test1|in","test2|in","test3|in","test5|out", "test4|out" );
		//      在对象list上调用方法 stream() 返回一个常规对象Stream。
		List<String> outList = stringList.stream()
				.map(str -> str.split("\\|"))
				.map(it -> it[0])
				.collect(Collectors.toList()); //Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。
		System.out.println(outList);

		outList = stringList.stream()
				.filter(it -> it.contains("out"))
				.map(str -> str.split("\\|"))
				.map(it -> it[0])
				.map(String::toUpperCase)
				.sorted()
				.collect(Collectors.toList());
		System.out.println(outList);

		//使用 Stream.of() 从一堆对象引用中创建一个Stream。
		System.out.println("*********************************************** 使用 Stream.of() 从一堆对象引用中创建一个Stream! *********************************************** ");
		Stream.of("a1", "a2", "a3")
				.map(s -> s.substring(1))
				.mapToInt(Integer::parseInt)
				.max()
				.ifPresent(System.out::println);  // 3

		Stream.of(1.0, 2.0, 3.0)
				.mapToInt(Double::intValue)
				.mapToObj(i -> "a" + i)
				.forEach(System.out::println);

		String [] ss = {"a", "b","c"};
		Stream.of(ss).forEach(System.out::println);


		// Stream的统计过滤应用
		System.out.println("*********************************************** Stream的统计过滤应用! *********************************************** ");
		List<StudyStream.User> users = new ArrayList<StudyStream.User>();
		users.add(new StudyStream.User("张三", 35));
		users.add(new StudyStream.User("张三", 25));
		users.add(new StudyStream.User("张三", 15));
		users.add(new StudyStream.User(null, 25));
		users.add(new StudyStream.User("李三", null));
		users.add(new StudyStream.User("李三", 20));
		users.add(new StudyStream.User("李三", 30));
		users.add(new StudyStream.User("李三", 40));
		users.add(new StudyStream.User("李四李三", 55));


		// 找到名字最长的 输出长度
		final OptionalInt max = users.stream()
				.map(rec -> rec.getName())
				.filter(Objects::nonNull)   // 过滤null
				.mapToInt(String::length)
				.max();

		System.out.println("名字最长 " + max.getAsInt());

		// 非null的age 汇总
		final Integer ageSum = users.stream()
				.filter(it -> it.getName() != null)
				.filter(it -> it.getAge() != null)
				.collect(Collectors.summingInt(User::getAge));

		System.out.println("非空age总和 " + ageSum);

		// 生成非空List
		final List<User> noneNullCollection = users.stream()
				.filter(it -> it.getName() != null)
				.filter(it -> it.getAge() != null)
				.sorted(Comparator.comparing(User::getAge))   // 对List的元素排序 使用Comparator 来排序一个list 自然排序不需要参数 sorted() 或者 sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());

		// 对List进行分组
		final Map<String, List<User>> groupedCollection = noneNullCollection.stream()
				.collect(Collectors.groupingBy(User::getName));   // 使用 groupingBy 对List进行分组，返回一个map
		System.out.println("使用 groupingBy 对List进行分组 ");
		System.out.println(groupedCollection);

		// flatMap 合并数组
		System.out.println("*********************************************** flatMap 合并数组! *********************************************** ");
		String[]  energyViewFields = new String[] {"ok", "thank"};
		String[]  virtualHierarchyViewFields = new String[] {"virl"};
		String[]  physicalViewFields = new String[] {"youtube"};
		String[] combinedString = new String[] {};
		Object[] combinedObject = new Object[] {};

		combinedString = Stream.of(energyViewFields, physicalViewFields, virtualHierarchyViewFields)
				.flatMap(Stream::of)
				.toArray(String[]::new); // .toArray(String[]::new)) 转化为 字符数组

		combinedObject = Stream.of(energyViewFields, physicalViewFields, virtualHierarchyViewFields)
				.flatMap(Stream::of)
				.toArray();   // .toArray() 转化为对象数组

		List<String> results = Arrays.stream(combinedObject).map(item -> (String) item).collect(Collectors.toList());

		Stream.of(combinedString).forEach(System.out::println);
		Stream.of(results).forEach(System.out::println);

		// flatMap 合并List
		List<String> stringList1 = Arrays.asList("test1|in","test2|in","test3|in","test5|out", "test4|out" );
		List<String> stringList2 = Arrays.asList("test2|ok","test2|ok","test3|ok","test5|ok", "test4|ok" );
		List<String> stringList3 = Arrays.asList("test1|st","test2|st","test3|st","test5|st", "test4|st" );
		final List<String> collect = Stream.of(stringList1, stringList2, stringList3)
				.flatMap(Collection::stream)
				.distinct()
				.collect(Collectors.toList());

		// Stream的合并Map应用
		System.out.println("*********************************************** Stream的合并Map应用! *********************************************** ");
		Map<String, String> exampleMap =  new HashMap<String, String>();  //使用泛型定义
		exampleMap.put("Test11", "1");
		exampleMap.put("Test21", "2");
		exampleMap.put("Test31", "3");

		Map<String, String> exampleMap2 = new TreeMap<String, String>();
		exampleMap2.put("Test1", "Susan");
		exampleMap2.put("Test2", "Lele");
		exampleMap2.put("Test3", "Lin");
		exampleMap2.put("Test31", "Lin");

		// 简单合并
		final Map<String, String> collectexampleMap = Stream.of(exampleMap, exampleMap2)
				.flatMap(aMap -> aMap.entrySet().stream())
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(v1,v2) -> "Error"    // 通过 (v1,v2) 来解决key重复
				));

		System.out.println(collectexampleMap);

		// Stream.concat 合并
		final Map<String, String> collectexampleMap2 = Stream.concat(exampleMap.entrySet().stream(), exampleMap2.entrySet().stream())
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(v1,v2) -> "Repeated"
				));

		System.out.println(collectexampleMap2);

		// 过滤后合并
		final Map<String, String> collectexampleMap3 = Stream.of(exampleMap, exampleMap2)
				.flatMap(aMap -> aMap.entrySet().stream())
				.filter(it -> it.getKey().length() < 6)
				.filter(it -> it.getValue()!= "Lin")
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(v1,v2) -> "Repeated"
				));

		System.out.println(collectexampleMap3);

		//
		System.out.println("Done! *********************************************** ");
	}







	static class User
	{
		public User(String name, Integer age)
		{
			this.age = age;
			this.name = name;
		}

		Integer age = 0;
		String name = "";

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
