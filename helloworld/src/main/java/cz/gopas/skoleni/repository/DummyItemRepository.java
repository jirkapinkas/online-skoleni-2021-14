package cz.gopas.skoleni.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DummyItemRepository implements ItemRepository {

    public long count() {
        return 123;
    }

}
