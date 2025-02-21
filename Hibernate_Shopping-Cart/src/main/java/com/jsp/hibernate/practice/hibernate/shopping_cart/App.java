package com.jsp.hibernate.practice.hibernate.shopping_cart;

import java.util.Scanner;

import com.jsp.hibernate.practice.hibernate.shopping_cart.dao.ShoppingCartDao;

public class App 
{
    public static void main( String[] args )
    {
    	ShoppingCartDao scd = new ShoppingCartDao();
    	
    	System.out.println("enter ur choice");
    	Scanner input = new Scanner(System.in);
    	int choice = input.nextInt();
    	
       switch(choice) {
       case 1 :
    	   scd.addProduct();
    	   break;
       case 2 :
    	   scd.addUserWithCart();
    	   break;
       case 3 : 
    	   scd.addProductToCart();
    	   break;
       case 4 :
    	   scd.removeProductFromCart();
    	   break;
       case 5 :
    	   scd.findAllProductFromCart();
    	   break;
      }
    }
}
