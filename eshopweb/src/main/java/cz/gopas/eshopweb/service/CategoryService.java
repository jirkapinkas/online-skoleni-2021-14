package cz.gopas.eshopweb.service;

import cz.gopas.eshopweb.dto.CategoryWithItemsDto;
import cz.gopas.eshopweb.mapper.CategoryMapper;
import cz.gopas.eshopweb.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryMapper categoryMapper;

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public Optional<CategoryWithItemsDto> findById(int id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toDto);
    }


}
