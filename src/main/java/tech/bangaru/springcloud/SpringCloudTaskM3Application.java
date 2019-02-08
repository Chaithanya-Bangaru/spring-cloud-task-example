package tech.bangaru.springcloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringCloudTaskM3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskM3Application.class, args);
	}
	// subclass which is a short lived task
	
	public class TollProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... tollParams) throws Exception {
			// stationId, licensePlate, timestamp
			if(null != tollParams) {
				//System.out.println("----------------------------Within TollProcessingTask");
				System.out.println("---------------------------TollProcessingTask params lenght: "+tollParams.length);
				String param0 = tollParams[0];
				System.out.println("param 0 " +param0); // Spring uses this param 0 as spring.output.ansi.enabled=always, so we started to get 1 out of variable args array... tollParams
				String stationId = tollParams[1];
				String licensePlate = tollParams[2];
				String timestamp = tollParams[3];
				System.out.println("stationId is "+stationId + " ,passed licensePlate "+licensePlate+ " at timestamp "+timestamp);
			}
		}
	}
	// register the task bean as a function with spring 
	
	@Bean
	public TollProcessingTask tollProcessingTask() {
		return new TollProcessingTask();
	}

}

