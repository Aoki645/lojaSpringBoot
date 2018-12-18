package br.com.maoki.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.com.maoki.loja.dao.ClientRepository;
import br.com.maoki.loja.dao.ProductRepository;
import br.com.maoki.loja.entity.Client;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class LojaApplication {

	@Autowired
	private ProductRepository productRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);		 
		
	}
	
	
	@Component
	class BookingCommandLineRunner implements CommandLineRunner{

		@Override
		public void run(String... args) throws Exception {
			for(int i = 1 ; i <= 10; i++) {
				clientRepository.save(new Client(i));
			}
			
		}
		
		@Autowired
		ClientRepository clientRepository;
		
	}

}

