package cz.gopas.eshopweb.service;

import cz.gopas.eshopweb.dto.ItemWithCategoryDto;
import cz.gopas.eshopweb.entity.Item;
import cz.gopas.eshopweb.exception.NotFoundException;
import cz.gopas.eshopweb.mapper.ItemMapper;
import cz.gopas.eshopweb.pojo.Message;
import cz.gopas.eshopweb.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

    // Funguje, ALE: v databazi budou 2 transakce!!!
//    public void updateName(int id, String newName) {
//        Optional<Item> optional = itemRepository.findById(id);
//        if(optional.isPresent()) {
//            optional.get().setName(newName);
//            itemRepository.save(optional.get());
//        }
//    }

    // 1 transakce + nemusime volat operaci save(),
    // protoze je entita v Managed stavu!!!
    @Transactional
    public void updateName(int id, String newName) {
        Optional<Item> optional = itemRepository.findById(id);
        Item item = optional.orElseThrow(() -> new NotFoundException("Item with id: " + id + " does not exist!"));
        item.setName(newName);
//        optional.ifPresent(item -> item.setName(newName));
    }
}
