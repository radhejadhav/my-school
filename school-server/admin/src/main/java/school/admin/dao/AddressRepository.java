package school.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import school.admin.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Transactional
    @Modifying
    @Query("update Address u set u.city = ?2, u.state = ?3, u.pinCode = ?4 where u.id=?1")
    void updateAddressById(Long id, String city, String state, int pinCode);
}
