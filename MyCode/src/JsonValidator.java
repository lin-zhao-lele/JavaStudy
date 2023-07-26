import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;
import lombok.NonNull;
import lombok.Value;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonValidator {
    public static boolean isValidJson(String jsonString) {
        try {
            JsonParser parser = new JsonParser();
            parser.parse(jsonString);
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        }
    }

    public static JsonObject jsonStringToJsonObject(String jsonString) {
        JsonParser parser = new JsonParser();
        return parser.parse(jsonString).getAsJsonObject();
    }

    public static void main(String[] args) {
        // 判断是否为有效的Json
        String jsonString = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
        boolean isValid = isValidJson(jsonString);
        System.out.println("Is valid JSON: " + isValid);

        String jsonString2 = "\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
        boolean isValid2 = isValidJson(jsonString2);
        System.out.println("Is valid JSON: " + isValid2);

        // 将json字符串 转化成JSON对象
        String jsonString3 = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
        JsonObject jsonObject = jsonStringToJsonObject(jsonString3);
        System.out.println("JSON Object: " + jsonObject);

        // 将json字符串 转化成java对象
        Gson gson = new Gson();
        Person person = gson.fromJson(jsonString, Person.class);

        System.out.println(person);
    }

    @Value
    private static class  Person
    {
        @NonNull
        @JsonProperty("name")
        private String name;

        @NonNull
        @JsonProperty("city")
        private String city;

        @NonNull
        @JsonProperty("age")
        private int age;
    }
}
