import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


// https://www.bilibili.com/video/BV1gX4y1b776/?spm_id_from=333.1007.tianma.25-1-95.click&vd_source=71cb2fbd3dc5f883bc8e66ad445bb034
public class StudyLambda {

    public static void main(String... args) {
        // 新建一个数组
        List<String> exampleList = Arrays.asList("Test3", "Test1", "Test2", "Lin");

        // 循环
        System.out.println("循环输出 **********************");
        exampleList.forEach(s->System.out.println(s));
        exampleList.forEach(System.out::println);

        // 排序
        System.out.println("排序输出 **********************");
        Collections.sort(exampleList, (o1,o2) -> o1.compareTo(o2));
        Collections.sort(exampleList, (o1,o2) -> { return o1.compareTo(o2);});
        exampleList.forEach(System.out::println);

        // 过滤
        System.out.println("过滤输出 **********************");
        List<String> exampleList2 = exampleList.stream().filter(s -> s.startsWith("Test")).collect(Collectors.toList());
        exampleList2.forEach(System.out::println);

        // map
        List<Integer> lengthList = exampleList.stream().map(it -> it.length()).collect(Collectors.toList());
        lengthList.forEach(System.out::println);


    }

}
