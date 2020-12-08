package home.lab.metrics.metricsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class MetricsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetricsDemoApplication.class, args);
	}

	private SomeService service;

	public MetricsDemoApplication(SomeService service){
		this.service = service;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void increment() throws InterruptedException {
		service.initCounter();
		while (true) {
			TimeUnit.SECONDS.sleep(1);
			service.startIncrementing();
		}
	}

}
