package cz.gopas.eshopweb.repository;

import cz.gopas.eshopweb.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @EntityGraph(Item.GRAPH_ITEM_CATEGORY)
    @Override
    List<Item> findAll();

    @EntityGraph(Item.GRAPH_ITEM_CATEGORY)
    @Override
    List<Item> findAll(Sort sort);

    @EntityGraph(Item.GRAPH_ITEM_CATEGORY)
    @Override
    Page<Item> findAll(Pageable pageable);

    @EntityGraph(Item.GRAPH_ITEM_CATEGORY)
    @Override
    Optional<Item> findById(Integer integer);

    // 1. metody, u kterych nepiseme select a vysledek zalezi na nazvu metody!!!
    List<Item> findByName(String name);
    List<Item> findByName(String name, Sort sort);
    List<Item> findByName(String name, Pageable pageable);

    // 2. metody s anotaci @Query, do ktere se dava HQL (Hibernate Query Language)
    @Transactional(readOnly = true)
    @Query("select i from Item i left join fetch i.category")
    List<Item> findAllFetchCategory();

    @Transactional(readOnly = true)
    @Query("select i from Item i left join fetch i.category where i.id = ?1")
    Optional<Item> findByIdFetchCategory(int id);

    @Transactional(readOnly = true)
    @Query(nativeQuery = true, value = "select count(*) from item")
    long countItems();

}
