package org.recsys.controllers;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.recsys.infrastucture.entities.Category;
import org.recsys.infrastucture.entities.Product;
import org.recsys.repositories.CategoryRepository;
import org.recsys.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class CsvController {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public CsvController(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }


    /**
     * DO NOT CALL THIS METHOD
     * @return
     * @throws IOException
     */
    /*@GetMapping("/upload-categories")
    public ResponseEntity<List<String>> readCsv() throws IOException {
        Set<String> categories = new HashSet<>();

        var resource = new ClassPathResource("Amazon-Products.csv");
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new InputStreamReader(resource.getInputStream()));

        for (CSVRecord record : parser) {
            String category = record.get("main_category");
            categories.add(category);
        }

        for(String category : categories) {
            Category categoryEntity = new Category();
            categoryEntity.setName(category);

            categoryRepository.save(categoryEntity);
        }

        return ResponseEntity.ok(new ArrayList<>(categories));
    }*/

    /**
     * DO NOT CALL THIS METHOD
     */
    /*@GetMapping("/upload-products")
    public ResponseEntity<Boolean> readCsv() throws IOException {
        var resource = new ClassPathResource("Amazon-Products.csv");
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new InputStreamReader(resource.getInputStream()));

        for (CSVRecord record : parser)
        {
            try {
                String productName = record.get("name");
                String category = record.get("main_category");
                String image = record.get("image");
                String link = record.get("link");
                String ratings = record.get("ratings");

                String numberOfRatings = record.get("no_of_ratings");
                numberOfRatings = numberOfRatings.replaceAll(",", "");

                String discountPrice = record.get("discount_price");
                discountPrice = discountPrice.replaceAll("₹", "");
                discountPrice = discountPrice.replaceAll(",", "");

                String actualPrice = record.get("actual_price");
                actualPrice = actualPrice.replaceAll("₹", "");
                actualPrice = actualPrice.replaceAll(",", "");

                Category categoryEntity = categoryRepository.findByName(category);
                Product product = new Product();
                product.setName(productName);
                product.setCategory(categoryEntity);
                product.setImage(image);
                product.setLink(link);

                if(!ratings.equals(""))
                {
                    product.setRatings(Double.parseDouble(ratings));
                }

                if(!numberOfRatings.equals(""))
                {
                    product.setNumberOfRatings(Integer.parseInt(numberOfRatings));
                }

                if(!discountPrice.equals(""))
                {
                    product.setDiscountPrice(Double.parseDouble(discountPrice));
                }

                if(!actualPrice.equals(""))
                {
                    product.setActualPrice(Double.parseDouble(actualPrice));
                }

                productRepository.save(product);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return ResponseEntity.ok(true);
    }*/
}
