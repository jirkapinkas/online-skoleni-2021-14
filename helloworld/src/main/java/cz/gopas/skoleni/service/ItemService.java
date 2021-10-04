package cz.gopas.skoleni.service;

import cz.gopas.skoleni.repository.DummyItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private DummyItemRepository itemRepository;

    public String getItemCount() {
        return "count = " + itemRepository.count();
    }

}
