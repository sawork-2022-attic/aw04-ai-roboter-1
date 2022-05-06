package com.example.webpos.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "main_cat")
    private String mainCat;

    @Lob
    @Column(name = "category")
    private String category;

    @Lob
    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "imageURLHighRes")
    private String imageURLHighRes;

    @Column(name = "asin", nullable = false, length = 32)
    private String asin;

    @Column(name = "price")
    private Double price;

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getImageURLHighRes() {
        return imageURLHighRes;
    }

    public void setImageURLHighRes(String imageURLHighRes) {
        this.imageURLHighRes = imageURLHighRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMainCat() {
        return mainCat;
    }

    public void setMainCat(String mainCat) {
        this.mainCat = mainCat;
    }

    public String getImage() {
        String[] images = getImageURLHighRes().split(",");
        if (images.length >= 1)
            return images[0];
        return "";
    }


}
