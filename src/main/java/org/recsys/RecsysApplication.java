package org.recsys;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.recsys.infrastucture.entities.Category;
import org.recsys.infrastucture.entities.Product;
import org.recsys.repositories.CategoryRepository;
import org.recsys.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStreamReader;

@SpringBootApplication
public class RecsysApplication {

	@Autowired
	private CategoryRepository categoryRepository;
/*
	@Autowired
	private ProductRepository productRepository;
*/



	public static void main(String[] args) {
		SpringApplication.run(RecsysApplication.class, args);
	}

/*	@PostConstruct
	public void onApplicationStartup() throws Exception {
		var resource = new ClassPathResource("Amazon-Products.csv");
		CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(new InputStreamReader(resource.getInputStream()));

		int index = 0;
		int batch = 0;

		for (CSVRecord record : parser)
		{
			try {
				if(index % 50 == 0)
				{
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
					batch++;

					if(batch % 200 == 0)
					{
						System.out.println("Batch " + batch + " completed and index is " + index);
						System.out.flush();
						commitTransaction();
					}
				}

				index++;
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

			commitTransaction();
		}


	}

	@Transactional
	public void commitTransaction() {
		// do nothing
	}*/
}
