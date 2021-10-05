package cz.gopas.eshopweb.controller;

import cz.gopas.eshopweb.entity.Item;
import cz.gopas.eshopweb.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    // http://localhost:8080/item
    @GetMapping
    public List<Item> items() {
        return itemService.findAll();
    }

    // http://localhost:8080/item/1
    @GetMapping("/{id}")
    public Optional<Item> item(@PathVariable int id) {
        return itemService.findById(id);
    }

}
