package vikash.DC_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vikash.DC_API.entity.DcChildrenEntity;
import vikash.DC_API.entity.DcEducationEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface DcEducationRepository extends JpaRepository<DcEducationEntity, Serializable> {
    Optional<DcEducationEntity> findByCaseNum(Long caseNum);
}
