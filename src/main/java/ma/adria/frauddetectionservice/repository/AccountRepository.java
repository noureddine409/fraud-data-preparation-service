package ma.adria.frauddetectionservice.repository;

import ma.adria.frauddetectionservice.model.Account;

import java.util.Optional;

public interface AccountRepository extends GenericRepository<Account> {
    Optional<Account> findByAccountNumber(String accountNumber);

}
