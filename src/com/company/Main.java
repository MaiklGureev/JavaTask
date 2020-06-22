package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Product product = new Product("my_product", 5);
        product.setProductName("new_my_product");
        product.editDetailName(1,"detail_101");
        product.editDetailName("detail_101","detail_111");
        product.editDetailId("detail_111",111);

        Product prototype = (Product) product.clone();

        System.out.println("product " + product.getProductName() + " " + product.getDetailSize());
        System.out.println(Arrays.toString(product.getDetails()));
        System.out.println("prototype " + prototype.getProductName() + " " + prototype.getDetailSize());
        System.out.println(Arrays.toString(prototype.getDetails()));

    }
}