package com.jbk.Product.Utility;

import java.util.Scanner;
import com.jbk.Product.entity.Product;

public class ProductUtility {
	
	 public static Product PrepareProductDate(Scanner scanner){
		
		System.out.println("Enter Product ID");
		int ProductId =scanner.nextInt();
		
		System.out.println("Enter Product Name");
		String ProductName=scanner.next();
		
		System.out.println("Enter PRoduct Price");
		int ProductPrice=scanner.nextInt();
		
		System.out.println("Enter Manufacturing Date");
		String productMfg= scanner.next();
		
		System.out.println("Enter Product Category");
		String ProductCategory=scanner.next();
		
		Product product=new Product(ProductId, ProductName, ProductPrice, productMfg, ProductCategory); 
		return product;
		
	}
//	 public static int DeleteProductData(Scanner scanner) {
//		 int ProductId=scanner.nextInt();
//		return ProductId;
		 
//	 }

}
