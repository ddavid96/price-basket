package com.example.priceBasket;

import com.example.priceBasket.model.Basket;
import com.example.priceBasket.model.Product;
import com.example.priceBasket.service.impl.BasketService;
import com.example.priceBasket.service.impl.BillPrinter;
import com.example.priceBasket.service.impl.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PriceBasketApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private BasketService basketService;

	@Autowired
	private BillPrinter billPrinter;

	public static void main(String[] args) {
		SpringApplication.run(PriceBasketApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		if (args == null || args.length == 0) {
			System.out.println("Please provide the products to be added to basket");
			System.exit(0);
		}
		Basket basket = new Basket();
		for (String productName : args) {
			Product product = productService.getProduct(productName);
			if (product == null)
				continue;
			basket.addProduct(product);
		}
		if (basket.getProducts().isEmpty()) {
			System.out.println("Please provide the products to be added to basket");
			System.exit(0);
		}

		billPrinter.printBill(basketService.getBill(basket));
	}
}
