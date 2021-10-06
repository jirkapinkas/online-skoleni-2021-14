package cz.gopas.eshopweb.repository;

import cz.gopas.eshopweb.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
