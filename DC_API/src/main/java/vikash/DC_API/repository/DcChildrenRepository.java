package vikash.DC_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vikash.DC_API.entity.DcChildrenEntity;

import java.io.Serializable;
import java.util.List;

@Repository
public interface DcChildrenRepository extends JpaRepository<DcChildrenEntity, Serializable> {
    List<DcChildrenEntity> findByCaseNum(Long caseNum);
}
