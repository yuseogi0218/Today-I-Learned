package example.cashcard;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

interface CashCardRepository extends CrudRepository<CashCard, Long>, PagingAndSortingRepository<CashCard, Long> {
    // filter by owner when finding a single CashCard
    CashCard findByIdAndOwner(Long id, String owner);

    // filter by owner when finding a list of CashCards
    Page<CashCard> findByOwner(String owner, PageRequest pageRequest);

    // check whether the Cash Card ID in the request actually exists in the database.
    boolean existsByIdAndOwner(Long id, String owner);
}
