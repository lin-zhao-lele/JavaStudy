import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.Data;

//import com.fasterxml.jackson.annotation.JsonProperty;

public class StudyLombok
{
	public static void main(String... args)
	{
		System.out.println("Demo Lombok!");

		final Exercise exercise = Exercise.builder().name("Tester").value(12).NOname("ok").isPeak(true).build();

//		final Exercise exercise2 = Exercise.builder().name("Tester").value(12).NOname(null).build();

		System.out.println("End Demo Lombok!");
	}

	@Data
	@Builder
	public static class Exercise {

		@NonNull
		private String NOname;

		private String name;

		private int value;

//		@JsonProperty("isPeak") 生成的Json 对象中属性名保持为isPeak 需要额外定义 getter
		private boolean isPeak;
	}

}
