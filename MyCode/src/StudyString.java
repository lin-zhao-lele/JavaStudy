import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudyString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(countInt(154875));

        testStringBuffer();

        // 判断一个string[] 是否包含某个string, 转化成List 再调用contains函数
        String[] testArray = new String[]{"test", "test2", "test3", "west3"};
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
                .collect(Collectors.toMap(s -> s, s -> s));

        Map<String, String> headerMap2 = Arrays.stream(str.split(","))
                .map(it -> it.split(":"))
                .collect(Collectors.toMap(s -> s[0], s -> s[1]));

		String strp =findPattern("sdw sdawd <xx> 23 sd3 sd3 sd3 </xx> sdwa dwd asdwd ", "xx");
		System.out.println("Find pattern :" + strp);

        // 提取子串 "id == '122431250082513672'"
        String filter = "id == '122431250082513672'";
        String id  = filter.split("'")[1];
        System.out.println(id);



        System.out.println("Done! *********************************************** ");
    }


    static int countInt(int arg) {
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



	// 按模式搜索字符串: <pattern>   </pattern>
    static String findPattern(String inputString, String sub) {
        String patternString = "<pattern>(.*?)</pattern>".replaceAll("pattern", sub);
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }
}
