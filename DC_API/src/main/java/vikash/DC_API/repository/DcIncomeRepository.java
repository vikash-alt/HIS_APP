package vikash.DC_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vikash.DC_API.entity.DcIncomeEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface DcIncomeRepository extends JpaRepository<DcIncomeEntity, Serializable> {

    Optional<DcIncomeEntity> findByCaseNum(Long caseNum);
}
