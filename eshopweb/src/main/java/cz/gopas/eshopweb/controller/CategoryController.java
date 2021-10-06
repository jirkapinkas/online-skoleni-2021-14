package cz.gopas.eshopweb.controller;

import cz.gopas.eshopweb.dto.CategoryWithItemsDto;
import cz.gopas.eshopweb.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public Optional<CategoryWithItemsDto> category(@PathVariable int id) {
        return categoryService.findById(id);
    }

}
