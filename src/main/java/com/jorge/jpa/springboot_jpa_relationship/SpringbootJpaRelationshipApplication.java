package com.jorge.jpa.springboot_jpa_relationship;

import com.jorge.jpa.springboot_jpa_relationship.entities.Client;
import com.jorge.jpa.springboot_jpa_relationship.entities.Invoice;
import com.jorge.jpa.springboot_jpa_relationship.repositories.ClientRepository;
import com.jorge.jpa.springboot_jpa_relationship.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		manyToOne();
	}

	public void manyToOne() {
		Client client = new Client("John", "Doe");
		clientRepository.save(client);

		Invoice invoice = new Invoice("Compras de oficina", 2000L);
		invoice.setClient(client);
		Invoice invoiceDB =  invoiceRepository.save(invoice);
		System.out.println(invoiceDB);
	}
}
