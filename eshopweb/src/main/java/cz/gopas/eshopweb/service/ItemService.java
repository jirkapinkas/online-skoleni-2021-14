package cz.gopas.eshopweb.service;

import cz.gopas.eshopweb.dto.ItemWithCategoryDto;
import cz.gopas.eshopweb.mapper.ItemMapper;
import cz.gopas.eshopweb.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    public List<ItemWithCategoryDto> findAll() {
        return itemMapper.toDto(itemRepository.findAll());
    }

    public Optional<ItemWithCategoryDto> findById(int id) {
        return itemRepository.findById(id)
                .map(itemMapper::toDto);
    }

}
