package com.jbk.Product.service;

import java.util.List;

import com.jbk.Product.Dao.ProductDao;
import com.jbk.Product.entity.Product;

public class ProductService {
	
	private ProductDao dao= new ProductDao();
	public String saveProduct(Product product) {
		
		String msg = dao.saveProduct(product);
		return msg;
	}
	
	public List<Product> GetAllProduct() {
		return dao.getAllProduct();
	}
	
	public List<Product>ProductByName(String ProductByName){
		List<Product> productByName = dao.ProductByName(ProductByName);
		return productByName;
	}
	
	public void deleteProduct(int ProductID) {
		dao.deleteProduct(ProductID);
	}
	
	public Product getProductById(int productID) {
		return dao.GetProductByID(productID);
	}
	public String UpdateProduct(Product product) {
		return dao.UpdateProduct(product);
	}

	public List<Product> ProductPriceMoreThan500() {
		return dao.ProductPriceMoreThan500();
	
	}

	public List<Product> ProductPriceLessThan2000() {
		
		return dao.ProductLessThanThan2000();
	}

	public List<Product> ProductStartWithLetter_P() {
		return dao.ProductStartWithLetter_P();
		
	}

	public List<Product> ProductPriceBetween(int FirstPrice,int SecondPrice) {
		
		return dao.ProductPriceBetween(FirstPrice, SecondPrice);
	}

	public List<Product> RecordWithAndCondition(String ProductName, int ProductPrice) {
		
		return dao.RecordWithAndCondition(ProductName, ProductPrice);
	}

	public List<Product> RecordWithORCondition(String productName, int productPrice) {
		
		return dao.recordWithOrCondition(productName, productPrice);
	}

	public List<Product> RecordWithDescendingOrder() {
		
		return dao.RecordWithDescendingOrder();
	}

	public List<Product> RecordWithAscendingOrder() {
		
		return dao.RecordWithAscendingOrder();
	}

	public List<Product> TotalRowCount() {
		
		return dao.TotalRowCount();
	}

	public List<Product> AverageOfPRoductPrice() {
		
		return dao.AverageOfPRoductPrice();
	}

	public List<Product> SumOfProductPrice() {
		
		return dao.SumOfProductPrice();
	}

	public List<Product> MaxOfProductPrice() {
		// TODO Auto-generated method stub
		return dao.MaxOfProductPrice();
	}

	public List<Product> MinOfProductPrice() {
		// TODO Auto-generated method stub
		return dao.MinOfProductPrice();
	}

	public List<Product> RestrictionsWithIn(int value1,int value2,int value3) {
		
		return dao.RestrictionsWithIn(value1,value2,value3);
	}

	
	
}
