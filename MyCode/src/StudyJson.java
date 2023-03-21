import lombok.NonNull;
import lombok.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudyJson {

    //要将一个Java对象转换成字符串，通常需要使用序列化（serialization）或者JSON格式化。
    public static void main(String... args) throws JsonProcessingException {
        RequestBody requestBody = new RequestBody("password");

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBodyJson = objectMapper.writeValueAsString(requestBody);

        System.out.println(requestBodyJson);
    }


    @Value
    private static class  RequestBody
    {
        @NonNull
        @JsonProperty("grant_type")
        private String grantType;
    }
}
