package springbootsample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import springbootsample.model.Role;
import springbootsample.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Modifying
    @Query("UPDATE Employee a SET a.role = :role WHERE a.id = :id")
    @Transactional(isolation = Isolation.READ_COMMITTED)
    void updateRecordType(@Param("id") long id, @Param("role") Role role);

    List<Employee> findByName(String name);

    //TODO implement those for to demonstrate
//from https://www.baeldung.com/spring-data-java-8
//    Optional<Employee> findById(String id);
//Page<Employee> findAll(Pageable pageable);
//Stream<Employee> findAllByName(String surname);

}
