package springData.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springData.example.demo.domain.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {
}
