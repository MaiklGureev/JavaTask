package com.company;

import java.util.Random;

public class Product implements Prototype,Cloneable{
    private String productName;
    private Detail[] details;
    private int detailSize;

    public Product(String productName, int detailSize) {
        this.productName = productName;
        this.detailSize = detailSize;
        details = new Detail[detailSize];
        Random r = new Random();
        String name = "";
        int id = 0;
        for (int a = 0; a < this.detailSize; a++) {
            id = Math.abs(r.nextInt());
            details[a] = new Detail(id,name);
        }
    }

    public int getDetailSize() {
        return detailSize;
    }

    public String getProductName() {
        return productName;
    }

    public Detail[] getDetails() {
        return details;
    }

    public void editDetailName(String oldDetailName, String newDetailName){
        for(int a = 0;a<detailSize;a++){
            if(details[a].getDetailName().equals(oldDetailName)){
                details[a].setDetailName(newDetailName);
                break;
            }
        }
    }

    public void editDetailName(int id,String newDetailName){
                details[id].setDetailName(newDetailName);
    }

    public void editDetailId(String detailName, int newId){
        for(int a =0;a<detailSize;a++){
            if(details[a].getId()==newId){
                details[a].setDetailName(detailName);
                break;
            }
        }
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public Object clone() {
        try {
            Product product = (Product)super.clone();
            for(int a=0;a<detailSize;a++){
                product.details[a] = new Detail(details[a].getId(),details[a].getDetailName());
            }
            return product;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public class Detail {
        private int id;
        private String detailName;

        public Detail(int id, String detailName) {
            this.id = id;
            this.detailName = detailName;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setDetailName(String detailName) {
            this.detailName = detailName;
        }

        public int getId() {
            return id;
        }

        public String getDetailName() {
            return detailName;
        }

        @Override
        public String toString() {
            return "Detail{" +
                    "id=" + id +
                    ", detailName='" + detailName + '\'' +
                    '}';
        }
    }
}
