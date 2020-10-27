package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<Product>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i=0 ; i<n ; i++) {
			System.out.println("Product #" + (i+1) + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char op = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.next();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			switch(op) {
			case 'u':
				System.out.print("Manufacture date: ");
				sc.nextLine();
				String date = sc.nextLine();
				Date manufactureDate = sdf.parse(date);
				Product up = new UsedProduct(name, price, manufactureDate);	
				products.add(up);
				break;
			case 'i':
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				Product ip = new ImportedProduct(name, price, customsFee);
				products.add(ip);
				break;
			default:
				Product p = new Product(name, price);
				products.add(p);
				break;
			}
		
		}
		System.out.println("\nPRICE TAGS\n");
		
		for (Product product : products) {
			System.out.println(product.priceTag());
		}
		
		
		sc.close();
	}

}
