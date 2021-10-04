package cz.gopas.skoleni.service;

import cz.gopas.skoleni.repository.DummyItemRepository;
import cz.gopas.skoleni.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

//    public ItemService(DummyItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }

    public String getItemCount() {
        return "count = " + itemRepository.count();
    }

}
