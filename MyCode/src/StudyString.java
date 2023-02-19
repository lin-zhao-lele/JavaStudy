import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudyString
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(countInt(154875));

		testStringBuffer() ;

		// 判断一个string[] 是否包含某个string, 转化成List 再调用contains函数
		String[] testArray = new String[]{"test","test2","test3","west3"};
		boolean contain = Arrays.asList(testArray).contains("test");
		System.out.println(contain);


		final List<Boolean> testFlag = Arrays.stream(testArray).map(it -> it.equalsIgnoreCase("test")).collect(Collectors.toList());

		final String[] testsFliterArray = Arrays.stream(testArray).filter(it -> it.contains("test")).toArray(String[]::new);

		final List<String> testFliterList = Arrays.stream(testArray).filter(it -> it.contains("test")).collect(Collectors.toList());

		final long testCount = Arrays.stream(testArray).filter(it -> it.contains("test")).count();

		final boolean testExist = Arrays.stream(testArray).filter(it -> it.contains("test")).findAny().isPresent();

		// 将string 变成 map
		String str = "All0:0,All1:1,All2:2";
		Map<String, String> headerMap = Arrays.stream(str.split(","))
				.collect(Collectors.toMap(s->s,s->s));

		Map<String, String> headerMap2 = Arrays.stream(str.split(","))
				.map(it -> it.split(":"))
				.collect(Collectors.toMap(s->s[0],s->s[1]));


		System.out.println("Done! *********************************************** ");
	}


	static int countInt (int arg) {
		// 计算一个整数的位数
		String temp = String.valueOf(arg);
		return temp.length();
	}


	static void testStringBuffer() {
		String a = "I am ";
		String b = "teacher";
		StringBuffer c = new StringBuffer(a);
		c.append(b);
		System.out.println(c);

	}
}
