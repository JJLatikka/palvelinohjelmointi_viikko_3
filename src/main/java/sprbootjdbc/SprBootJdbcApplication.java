package sprbootjdbc;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sprbootjdbc.domain.Customer;
import sprbootjdbc.domain.CustomerDAO;

@SpringBootApplication
public class SprBootJdbcApplication {

	private static final Logger log = LoggerFactory.getLogger(SprBootJdbcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SprBootJdbcApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerDAO customerDAO) {

		return (args) -> {

			log.info("save a few customers of Ollivanders'");

			Arrays.asList(new String[] { "Tom Valedro", "Rubeus Hagrid", "Severus Snape", "Lily Evans", "James Potter",
					"Sirius Black", "Remus Lupin", "Harry Potter", "Hermione Granger", "Ron Weasley" }).stream()
					.forEach((s) -> {
						Customer c = new Customer(s);
						log.info(c.toString());
						customerDAO.saveCustomer(c);
					});

		};

	}

}
