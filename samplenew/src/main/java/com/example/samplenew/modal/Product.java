package com.example.samplenew.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor

@Getter
@Setter
@Entity(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int Product_id ;
    private  String name ;
    private  int price ;
    private  String description ;
    private  String  image ;
    private  int quality ;
    private  int weight ;
    private  int category_id ;

    public Product( int Product_id,String name , int price,String description,String image,int quality,int weight,int category_id) {
        this.Product_id = Product_id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.quality = quality;
        this.weight = weight;
        this.category_id = category_id;
    }

    
}
