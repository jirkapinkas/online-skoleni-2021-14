package cz.gopas.skoleni.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("dummy")
@Repository
public class DummyItemRepository implements ItemRepository {

    public long count() {
        return 123;
    }

}
