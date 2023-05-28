package org.recsys.DTOs;


import lombok.Data;
import org.recsys.infrastucture.entities.Product;

@Data
public class SingleProductDto {
    private Integer id;
    private String name;

    private String image;

    private String link;

    private Double ratings;

    private Integer numberOfRatings;

    private Double discountPrice;

    private Double actualPrice;

    private String category;

    public SingleProductDto(Product product)
    {
        this.id = product.getId();
        this.name = product.getName();
        this.image = product.getImage();
        this.link = product.getLink();
        this.ratings = product.getRatings();
        this.numberOfRatings = product.getNumberOfRatings();
        this.discountPrice = product.getDiscountPrice();
        this.actualPrice = product.getActualPrice();
        this.category = product.getCategory().getName();
    }
}
