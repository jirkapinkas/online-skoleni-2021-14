package cz.gopas.eshopweb.controller;

import cz.gopas.eshopweb.dto.ItemWithCategoryDto;
import cz.gopas.eshopweb.exception.NotFoundException;
import cz.gopas.eshopweb.pojo.Message;
import cz.gopas.eshopweb.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
//@PreAuthorize("hasRole('USER')")
public class ItemController {

    private final ItemService itemService;

    // http://localhost:8080/item
    @GetMapping
    public List<ItemWithCategoryDto> items() {
        return itemService.findAll();
    }

    // http://localhost:8080/item/1
    @GetMapping("/{id}")
    public Optional<ItemWithCategoryDto> item(@PathVariable int id) {
        return itemService.findById(id);
    }

    // http://localhost:8080/item/updateName?id=1&newName=Neco
    @PostMapping("/updateName")
    public void updateName(@RequestParam int id, @RequestParam String newName) {
        itemService.updateName(id, newName);
    }

}
