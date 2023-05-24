package org.recsys.repositories;

import org.recsys.infrastucture.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String category);
}
