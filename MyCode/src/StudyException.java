import java.util.HashMap;
import java.util.Map;

public class StudyException {
    public static void main(String... args) throws Exception {
        loopTryCatchTest();
    }

    // for 循环异常抛出后继续执行
    public static void loopTryCatchTest () throws Exception {
        Map<String, Object> a = new HashMap();
        a.put("a", "I");
        a.put("b", null);
        a.put("c", "3");
        for (Map.Entry<String, Object> moEntry : a.entrySet()) {
            try {
                boolean flag = moEntry.getValue().equals("I");
                System.out.println(moEntry.getKey() + "," + moEntry.getValue() + "," + flag);
            } catch (Exception e) {
                System.out.println("异常跳出" + e);
            }
        }
    }
}
