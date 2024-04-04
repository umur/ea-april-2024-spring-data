    package miu.ea.springdata.repository;

    import miu.ea.springdata.entity.Address;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface AddressRepository extends CrudRepository<Address,Long> {
    }
