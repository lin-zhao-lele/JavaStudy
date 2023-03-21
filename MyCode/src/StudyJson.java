import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Value;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudyJson {


    public static void main(String... args) throws JsonProcessingException {
        RequestBody requestBody = RequestBody.builder().grantType("Type").grantID("ID").build();;

        // 要将一个Java对象转换成字符串，通常需要使用序列化（serialization）或者JSON格式化。
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBodyJson = objectMapper.writeValueAsString(requestBody);

        System.out.println(requestBodyJson);
    }


    @Data
    @Builder
    @Value
    private static class  RequestBody
    {
        @NonNull
        @JsonProperty("grant_type")
        private String grantType;
        @NonNull
        @JsonProperty("grant_id")
        private String grantID;
    }
}
