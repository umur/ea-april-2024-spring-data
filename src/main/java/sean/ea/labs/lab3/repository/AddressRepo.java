package sean.ea.labs.lab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sean.ea.labs.lab3.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
}
