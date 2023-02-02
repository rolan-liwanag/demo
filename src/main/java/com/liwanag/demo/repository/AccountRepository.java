package com.liwanag.demo.repository;

import com.liwanag.demo.model.Account;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    @Query(
            """
                SELECT * FROM Account account JOIN Role role ON account.id = role.account ORDER BY account.lastname 
            """
    )
    public List<Account> findAllOrderByLastname();
}
