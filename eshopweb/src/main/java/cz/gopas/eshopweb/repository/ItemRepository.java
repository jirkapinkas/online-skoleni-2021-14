package cz.gopas.eshopweb.repository;

import cz.gopas.eshopweb.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
