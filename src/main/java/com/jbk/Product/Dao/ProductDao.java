package com.jbk.Product.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.jbk.Product.configuration.HibernateUtility;
import com.jbk.Product.entity.Product;


public class ProductDao {
	Scanner scanner=new Scanner(System.in);

	private SessionFactory sessionFactory;
	public ProductDao() {	
	 sessionFactory = HibernateUtility.getSessionFactory();
	}
    
	public String saveProduct(Product product) {
		Session session=null;
		boolean isAdded=false;

		try {
			session= sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.save(product);
			transaction.commit();
			isAdded=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		if(isAdded) {
			return "Saved";
		}else {
			return "Not Saved";
		}
	}

        public List<Product> getAllProduct() {
        	List<Product> list=null;
        	Session session=null;
        	
        	try {
        		 session =sessionFactory.openSession();
        		Criteria criteria=session.createCriteria(Product.class);
        		
        		list=criteria.list();
        		
				
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
        	finally {
        		if(session!=null) {
    				session.close();
    			}
        	}
			return list;
		
    }
        public List<Product> ProductByName(String ProductByName) {
        	List<Product> list=null;
        	Session session=null;
        	
        	try {
        		 session =sessionFactory.openSession();
        		Criteria criteria=session.createCriteria(Product.class);
        		Criterion criterion=Restrictions.eq("prodcuctName",ProductByName);
        		criteria.add(criterion);
//        		criteria.add(Restrictions.eq("prodcuctName","Speaker"));
        		
        		list=criteria.list();
        		
				
			} catch (Exception e) {
				e.printStackTrace();
			}
        	
        	finally {
        		if(session!=null) {
    				session.close();
    			}
        	}
			return list;
		
    }
        
        	public void deleteProduct(int ProductID) {
        		Session session=null;
        		String msg=null;
        	
        	try {
        	session =sessionFactory.openSession();
            Transaction transaction= session.beginTransaction();
        	Product product=session.get(Product.class,ProductID);
        	if(product!=null) {
        		session.delete(product);
        		   transaction.commit();
        		msg="Deleted";
        	}else {
        		System.out.println("Product Deleted With ID" +ProductID);
        	}
         

        	} catch (Exception e) {
        	e.printStackTrace();
        	} finally {
        		if(session!=null) {
    				session.close();
    			}
        	}
        	}
        	
        public Product GetProductByID(int productId) {
        	Session session=null;
        	Product product=null;
        	try {
        	session=sessionFactory.openSession();
			product=session.get(Product.class,productId);	
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			return product;
        }
        public String UpdateProduct(Product product) {
        	Session session=null;
        	boolean isUpdated=false;
        	try {
				session=sessionFactory.openSession();
				Transaction transaction=session.beginTransaction(); 
				Product dbProduct=session.get(Product.class, product.getId());
				if(dbProduct!=null) {
					session.evict(dbProduct);
					session.update(product);
					transaction.commit();
					isUpdated=true;
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
   	          finally {
				if(session!=null) {
					session.close();
				}
			}
        	if(isUpdated) {
        		return "product Updated";
        	}else {
        		return "Product not present with ProductId you entered";
        	}
        }
	public List<Product> ProductPriceMoreThan500() {
			
		List<Product> list=null;
    	Session session=null;
    	
    	try {
    		 session =sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Product.class);
    		criteria.add(Restrictions.gt("productPrice",500));
    		list=criteria.list();
    		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		if(session!=null) {
				session.close();
			}
    	}
		return list;
		}

	public List<Product> ProductLessThanThan2000() {
	
		List<Product> list=null;
    	Session session=null;
    	
    	try {
    		 session =sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Product.class);
    		criteria.add(Restrictions.lt("productPrice",2000));
    		list=criteria.list();
    		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		if(session!=null) {
				session.close();
			}
    	}
		return list;
	}
//	To get records having fistName starting with P

	public List<Product> ProductStartWithLetter_P() {

		
		List<Product> list=null;
    	Session session=null;
    	
    	try {
    		 session =sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Product.class);
    		criteria.add(Restrictions.like("prodcuctName", "P%"));
    		list=criteria.list();
    		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		if(session!=null) {
				session.close();
			}
    	}
		return list;
	
		
		
	}

	public List<Product> ProductPriceBetween(int FirstPrice,int SecondPrice) {

		List<Product> list=null;
    	Session session=null;
    	
    	try {
    		 session =sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Product.class);
    		criteria.add(Restrictions.between("productPrice",FirstPrice,SecondPrice));
    		list=criteria.list();
    		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		if(session!=null) {
				session.close();
			}
    	}
		return list;
	
		
		
	}

	public List<Product> RecordWithAndCondition(String ProductName, int ProductPrice) {

		List<Product> list=null;
    	Session session=null;
    	
    	try {
    		 session =sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Product.class);
//    		Map<String,Object>map=new HashMap<>();
//    		map.put("prodcuctName", "Pen");
//    		map.put("productPrice", 50);
//    		Restrictions.allEq(map);
    		Criterion ProductName1=Restrictions.eq("prodcuctName",ProductName);
    		Criterion productPrice=Restrictions.eq("productPrice",ProductPrice);
    		criteria.add(Restrictions.and(ProductName1,productPrice));
    		list=criteria.list();
    		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		if(session!=null) {
				session.close();
			}
    	}
		return list;
		
	}

	public List<Product> recordWithOrCondition(String ProductName, int ProductPrice) {

		List<Product> list=null;
    	Session session=null;
    	
    	try {
    		 session =sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Product.class);
    		Criterion ProductName1=Restrictions.eq("prodcuctName",ProductName);
    		Criterion productPrice=Restrictions.eq("productPrice",ProductPrice);
//    		criteria.add(Restrictions.or(ProductName1, productPrice));
    		criteria.add(Restrictions.or(ProductName1, productPrice));
    		list=criteria.list();
    		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		if(session!=null) {
				session.close();
			}
    	}
		return list;
	}

	public List<Product> RecordWithDescendingOrder() {

		List<Product> list=null;
    	Session session=null;
    	
    	try {
    		 session =sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Product.class);
    	
    		criteria.addOrder(Order.desc("productPrice"));
    		list=criteria.list();
    		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		if(session!=null) {
				session.close();
			}
    	}
		return list;

	}

	public List<Product> RecordWithAscendingOrder() {

		List<Product> list=null;
    	Session session=null;
    	
    	try {
    		 session =sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Product.class);
    	
    		criteria.addOrder(Order.asc("productPrice"));
    		list=criteria.list();
    		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		if(session!=null) {
				session.close();
			}
    	}
		return list;

	}

	public List<Product> TotalRowCount() {

		List<Product> list=null;
    	Session session=null;
    	
    	try {
    		 session =sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Product.class);
    	
    		 criteria.setProjection(Projections.rowCount());
    		list=criteria.list();
    		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		if(session!=null) {
				session.close();
			}
    	}
		return list;

	}

	public List<Product> AverageOfPRoductPrice() {

		List<Product> list=null;
    	Session session=null;
    	
    	try {
    		 session =sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Product.class);
    	
    		 criteria.setProjection(Projections.avg("productPrice"));
    		list=criteria.list();
    		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		if(session!=null) {
				session.close();
			}
    	}
		return list;

	}

	public List<Product> SumOfProductPrice() {

		List<Product> list=null;
    	Session session=null;
    	
    	try {
    		 session =sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Product.class);
    	
    		 criteria.setProjection(Projections.sum("productPrice"));
    		list=criteria.list();
    		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		if(session!=null) {
				session.close();
			}
    	}
		return list;

	}

	public List<Product> MaxOfProductPrice() {

		List<Product> list=null;
    	Session session=null;
    	
    	try {
    		 session =sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Product.class);
    	
    		 criteria.setProjection(Projections.max("productPrice"));
    		list=criteria.list();
    		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		if(session!=null) {
				session.close();
			}
    	}
		return list;

	}

	public List<Product> MinOfProductPrice() {

		List<Product> list=null;
    	Session session=null;
    	
    	try {
    		 session =sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Product.class);
    	
    		 criteria.setProjection(Projections.min("productPrice"));
    		list=criteria.list();
    		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		if(session!=null) {
				session.close();
			}
    	}
		return list;

	}

	public List<Product> RestrictionsWithIn(int value1,int value2,int value3) {


		List<Product> list=null;
    	Session session=null;
    	
    	try {
    		 session =sessionFactory.openSession();
    		Criteria criteria=session.createCriteria(Product.class);
    		Criterion ProductName1=Restrictions.in("productPrice",value1,value2,value3);
    		criteria.add(ProductName1);
    	
    		list=criteria.list();
    		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	finally {
    		if(session!=null) {
				session.close();
			}
    	}
		return list;
	}
        	
}       	
        	
        	
//        	  public void deleteProduct() {
//              	Session session= sessionFactory.openSession();
//      			Transaction tx= session.beginTransaction();
//      			Query q2=session.createQuery("delete from Product s where s.id=:c");
//      			q2.setParameter("c", "101");
//      			q2.setParameter(101, q2);
//      			int r=q2.executeUpdate();
//      			System.out.println(r +" objects Deleted");
//      			tx.commit();

        
//        public void deleteProduct() {
//    		System.out.println("Enter ID to delete the Product");
//    		int ProductId=scanner.nextInt();
////    	Session session = HibernateUtility.getSessionFactory().openSession();
//    	Session session =sessionFactory.openSession();
//    	Transaction tx= session.beginTransaction();
//    	try {
//    	String hql = "delete from Product s where s.id=:c";
//    	Query query = session.createQuery(hql);       	
//    	query.setParameter("c", ProductId);
//    	int rowCount = query.executeUpdate();
//    	if (rowCount == 0) {
//    	System.out.println("No data found to delete");
//    	} else {
//    	System.out.println("Your record is deleted");
//    	}
//    	tx.commit();
//
//    	} catch (Exception e) {
//    	e.printStackTrace();
//    	} finally {
//    	session.close();
//    	}
//    	}
//System.out.println("Enter Name to Update ProductName");
//String Name=scanner.next();
//product.setProdcuctName(Name);
//
//System.out.println("Enter Price to Update ProductPrice");
//int Price=scanner.nextInt();
//product.setProductPrice(Price);
//
//System.out.println("Enter MFG to Update ProductMFG");
//String MFG=scanner.next();
//product.setProductMfg(MFG);
//
//System.out.println("Enter Category to Update ProductCategory");
//String Category=scanner.next();
//product.setProductCategory(Category);

//Transaction transaction=session.beginTransaction();

//session.update(product);
//System.out.println("-------Updated Product--------");
//System.out.println(product);
//transaction.commit();
//isUpdated=true;
//session.getTransaction().commit();

