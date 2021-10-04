package cz.gopas.skoleni.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DummyItemRepository {

    public long count() {
        return 123;
    }

}
