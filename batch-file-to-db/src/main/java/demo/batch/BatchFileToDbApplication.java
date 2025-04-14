package demo.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This is an example of Java Spring Batch processing that
 * reads data from a CSV file,
 * processes it,
 * and writes it to a database.
 */
@SpringBootApplication
public class BatchFileToDbApplication {

	public static void main(String[] args) {

		//System.exit(SpringApplication.exit(SpringApplication.run(BatchFileToDbApplication.class, args)));
		SpringApplication.run(BatchFileToDbApplication.class, args);
	}

}
