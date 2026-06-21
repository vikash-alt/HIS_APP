package vikash.DC_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vikash.DC_API.entity.DcCaseEntity;
import java.io.Serializable;

@Repository
public interface DcCaseRepository extends JpaRepository<DcCaseEntity, Serializable > {
    DcCaseEntity findByAppId(Integer appId);
}
