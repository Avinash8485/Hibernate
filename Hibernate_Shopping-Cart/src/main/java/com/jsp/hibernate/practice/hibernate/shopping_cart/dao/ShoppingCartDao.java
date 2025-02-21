package com.jsp.hibernate.practice.hibernate.shopping_cart.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.jsp.hibernate.practice.hibernate.shopping_cart.entity.Cart;
import com.jsp.hibernate.practice.hibernate.shopping_cart.entity.Product;
import com.jsp.hibernate.practice.hibernate.shopping_cart.entity.User;

public class ShoppingCartDao {

		static Scanner input = new Scanner(System.in);

	public static Session getSession() {

		Configuration cfg = new Configuration().configure()
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(Cart.class)
				.addAnnotatedClass(Product.class);

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		return session;

	}

	public void addProduct() {

		Product product = new Product();

		System.out.println("Enter product id : ");
		product.setProductId(input.nextInt());

		System.out.println("Enter product Name : ");
		product.setProductName(input.next());

		System.out.println("Enter product Brand : ");
		product.setProductBrand(input.nextLine());

		System.out.println("Enter product Price : ");
		product.setProductPrice(input.nextInt());
		Session session = getSession();

		Transaction trans = session.beginTransaction();




		session.save(product);

		trans.commit();

		session.close();
	}

	public void addUserWithCart() {

		Cart cart = new Cart();

		System.out.println("Enter Cart Id : ");
		cart.setCartId(input.nextInt());

		User user = new User();

		System.out.println("Enter User Name");
		user.setUserName(input.nextLine());

		System.out.println("Enter User Email");
		user.setUserEmail(input.nextLine());

		System.out.println("Enter User Age");
		user.setUserAge(input.nextInt());

		System.out.println("Enter User City");
		user.setUserCity(input.nextLine());

		user.setCart(cart);


		Session session = getSession();

		Transaction trans = session.beginTransaction();

		session.save(user);
		session.save(cart);

		trans.commit();

		session.close();                                                                                                                    


	}

	public void addProductToCart() {

		Session session = getSession();

		Transaction trans = session.beginTransaction();

		System.out.println("Enter the Product Id : ");

		Product existingProduct = session.get(Product.class, input.nextInt());

		if(existingProduct != null) {
			System.out.println("Enter the User  Id : ");
			User existingUser = session.get(User.class, input.nextInt());
			if(existingUser != null) {
				Cart cart =  existingUser.getCart();
				List<Product> pList = cart.getProducts();
				pList.add(existingProduct);
				session.update(cart);
			}
			else {
				System.out.println("User Not Found");
			}
		}
		else {
			System.out.println("Product Not Found");
		}	

		trans.commit();
		session.clear();

	}

	public void removeProductFromCart() {

		Session session = getSession();

		Transaction trans = session.beginTransaction();

		System.out.println("Enter the prioduct Id : ");

		Product existingProduct = session.get(Product.class, input.nextInt());

		if(existingProduct != null) {
			System.out.println("Enter the user id : ");
			User existingUser = session.get(User.class,input.nextInt());
			if(existingUser != null) {
				Cart cart = existingUser.getCart();
				List<Product> plist = cart.getProducts();
				plist.remove(existingProduct);
				session.update(cart);

			}else {
				System.out.println("User not Found ");
			}
		}else {
			System.out.println("Product Id is not found");
		}

		trans.commit();
		session.clear();

	}

	public void findAllProductFromCart() {

		Session session = getSession();

		Transaction trans = session.beginTransaction();

		System.out.println("Enter User Id");
		User user = session.get(User.class, input.nextInt());

		if(user != null) {
			Cart cart = user.getCart();
			List<Product> plist = cart.getProducts();
			session.load(cart, cart.getCartId());
		}else {
			System.out.println("User Not Found");
		}

		trans.commit();
		session.clear();

	}

}
