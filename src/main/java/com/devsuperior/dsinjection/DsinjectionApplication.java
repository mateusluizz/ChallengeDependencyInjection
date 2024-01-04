package com.devsuperior.dsinjection;

import com.devsuperior.dsinjection.entities.Order;
import com.devsuperior.dsinjection.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.devsuperior.dsinjection"})
public class DsinjectionApplication implements CommandLineRunner {

	@Autowired
	OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DsinjectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Code: ");
		Integer idCod = sc.nextInt();
		System.out.print("Total Order: ");
		Double totalValue = sc.nextDouble();
		System.out.print("Discount: ");
		Double discount = sc.nextDouble();

		Order order = new Order(idCod, totalValue, discount);

		order.setBasic(orderService.total(order));
		System.out.println(order);

		sc.close();

	}
}
