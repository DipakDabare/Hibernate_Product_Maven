package com.jbk.Product;

import java.util.List;
import java.util.Scanner;
import com.jbk.Product.Utility.ProductUtility;
import com.jbk.Product.entity.Product;
import com.jbk.Product.service.ProductService;

public class test {
	
	public static void main(String[] args) {
		
	Scanner scanner=new Scanner(System.in);
	ProductService productservice= new ProductService();
	  int choice;
	  char ch;
    
		do {
			System.out.println("*************Cnotroller***********");
			System.out.println("Press 1 to save the Product");
			System.out.println("Press 2 to get All the Product");
			System.out.println("Press 3 to delete the Product");
			System.out.println("Press 4 to get Product by ID");
			System.out.println("Press 5 to Update The Product");
			System.out.println("Press 6 to get Product By Name");
			System.out.println("Press 7 to get records having ProductPrice more than 500");
			System.out.println("Press 8 to get records having ProductPrice less than 2000");
			System.out.println("press 9 to get Product Name starts With letter 'P' ");
			System.out.println("Press 10 to get records having Product Price in between user Want");
			System.out.println("Press 11 to get record of ProductName 'And' ProdcutPrice");
			System.out.println("Press 12 to get Record with ProductName 'OR' ProdcutPrice ");
			System.out.println("Press 13 to get Record in 'Descending Order' ");
			System.out.println("Press 14 to get Records in 'Ascending Order' ");
			System.out.println("Press 15 to get Total of  Row Count ");
			System.out.println("Press 16 to get Average of ProductPrice");
			System.out.println("Press 17 to get sum of ProductPrice");
			System.out.println("Press 18 to get max of ProductPrice");
			System.out.println("Press 19 to get min of ProductPrice");
			System.out.println("Press 20 to get Record of Product on the basis of ProductPrice you Entered (In Operator)");
			 choice=scanner.nextInt();
			 
			 switch (choice) {
			case 1:
				Product product=ProductUtility.PrepareProductDate(scanner);
				String msg=productservice.saveProduct(product);
				System.out.println(msg);
				break;

            case 2:
            	List<Product>list=productservice.GetAllProduct();
            	if(!list.isEmpty()) {
            		for (Product product2 : list) {
            			System.out.println(product2);		
					}
            	}else {
            		System.out.println("Product is not exists ");
            	}
				break;
            case 3:
            	System.out.println("enter Product ID For Delete the Product");
            	int ProdcutID=scanner.nextInt();
            	productservice.deleteProduct(ProdcutID);
	            break;
	            
            case 4:
            	System.out.println("Enter Product ID for getting Product Details");
            	int productID=scanner.nextInt();
				Product productById = productservice.getProductById(productID);
            	if(productById!=null) {
            		System.out.println(productById);	
            	}else {
            		System.out.println("Product Not Found");
            	}
            	break;
            	
            case 5:
            	Product product1=ProductUtility.PrepareProductDate(scanner);
               String msg1=productservice.UpdateProduct(product1);
               System.out.println(msg1);
            	break;
            	
            case 6:
            	System.out.println("Enter Product Name You want ");
            	String ProductByName=scanner.next();
            	List<Product> list2 =productservice.ProductByName(ProductByName);
            	if(!list2.isEmpty()) {
            		for (Product product2 : list2) {
            			System.out.println(product2);		
					}
            	}else {
            		System.out.println("Product is not exists ");
            	}
            	break;
            case 7:
            	List<Product> list3=productservice.ProductPriceMoreThan500();
            	if(!list3.isEmpty()) {
            		for (Product product2 : list3) {
						System.out.println(product2);
					}
            	}else {
            		System.out.println("Product does not exists with PoductPrice more than 500");
            	}
            	break;
           case 8: 
        	   List<Product>list4=productservice.ProductPriceLessThan2000();
        	   if(!list4.isEmpty()) {
        		   for (Product product2 : list4) {
					System.out.println(product2);
				}
        	   }else {
        		   System.out.println("Product does not exists with Product Price Less Than 2000");
        	   }
            	break;
           case 9:
        	   List<Product>list5=productservice.ProductStartWithLetter_P();
        	   if(!list5.isEmpty()) {
        		   for (Product product2 : list5) {
					System.out.println(product2);
				}
        	   }else {
        		   System.out.println("Product does not exists with Product Name Starts With 'P' ");
        	   }
            	break;
            	
           case 10 :
        	   System.out.println("Enter Product Price from which you want Prodcut");
        	   int FirstPrice=scanner.nextInt();
        	   System.out.println("Enter Product Price until you want Prodcut");
        	   int SecondPrice=scanner.nextInt();
        	  List<Product>list6=productservice.ProductPriceBetween(FirstPrice,SecondPrice);
        	  if(!list6.isEmpty()) {
        		  for (Product product2 : list6) {
					System.out.println(product2);
				}
        	  }else {
        		  System.out.println("prodcut does not starts with Product Price"+FirstPrice+"  to  "+SecondPrice);
        	  }
        	   break;   	   
           case 11:
        	   System.out.println("Enter Product Name");
        	   String ProductName=scanner.next();
        	   System.out.println("Enter Product Price");
        	   int ProductPrice=scanner.nextInt();
				List<Product>list7=productservice.RecordWithAndCondition(ProductName, ProductPrice);
				if(!list7.isEmpty()) {
					for (Product product2 : list7) {
						System.out.println(product2);
					}
				}else {
					System.out.println("Product Does not Exists");
				}
				break;
				
           case 12:
        	   System.out.println("Enter Product Name");
        	   String ProductName2=scanner.next();
        	   System.out.println("Enter Product Price");
        	   int ProductPrice2=scanner.nextInt();
				List<Product>list8=productservice.RecordWithORCondition(ProductName2, ProductPrice2);
				if(!list8.isEmpty()) {
					for (Product product2 : list8) {
						System.out.println(product2);
					}
				}else {
					System.out.println("Product Does not Exists");
				}
				break;
           case 13:
   			List<Product>list9=productservice.RecordWithDescendingOrder();
   			if(!list9.isEmpty()) {
   				for (Product product2 : list9) {
   					System.out.println(product2);
   				}
   			}else {
   					System.out.println("Product Does not Exists");
   			}
        	   
        	   break;
           case 14:
        		List<Product>list10=productservice.RecordWithAscendingOrder();
       			if(!list10.isEmpty()) {
       				for (Product product2 : list10) {
       					System.out.println(product2);
       				}
       			}else {
       					System.out.println("Product Does not Exists");
       			}
        	   
        	   
        	   break;
           case 15:
        	   List<Product>list11=productservice.TotalRowCount();
        	   System.out.println("Total Row Count is  =>>  "+list11);
        	   break;
        	   
           case 16:
        	   List<Product>list12=productservice.AverageOfPRoductPrice();
        	   System.out.println("Average OF Product Price is  =>>  "+list12);
        	   break;
        	   
           case 17:
        	   List<Product>list13=productservice.SumOfProductPrice();
        	   System.out.println("Sum OF Product Price is  =>>  "+list13);
        	   break;
        	   
           case 18:
        	   List<Product>list14=productservice.MaxOfProductPrice();
        	   System.out.println("Max OF Product Price is  =>>  "+list14);
        	   break;
        	   
           case 19:
        	   List<Product>list15=productservice.MinOfProductPrice();
        	   System.out.println("Min OF Product Price is  =>>  "+list15);
        	   break;
           case  20:
        	   System.out.println("Enter 1st ProductPrice of Prodcut you want");
        	   int value1=scanner.nextInt();
        	   System.out.println("Enter 2st ProductPrice of Prodcut you want");
        	   int value2=scanner.nextInt();
        	   System.out.println("Enter 3st ProductPrice of Prodcut you want");
        	   int value3=scanner.nextInt();
        	   List<Product>list16=productservice.RestrictionsWithIn(value1,value2,value3);
        	   if(!list16.isEmpty()) {
        		   for (Product product2 : list16) {
					System.out.println(product2);
				}
        	   }else {
        		 System.out.println("Product Does not exists with Prodocut Price you Entered");
        	   }
        	   break;
			default:
				System.out.println("Invalid Input");
				break;
			}
			 
			 System.out.println("Do you want to continue y/n");
			 
			 ch=scanner.next().charAt(0);
		   }
		
		
		while (ch=='y'|| ch=='Y');
		System.out.println("Application Terminated");
	}

}
