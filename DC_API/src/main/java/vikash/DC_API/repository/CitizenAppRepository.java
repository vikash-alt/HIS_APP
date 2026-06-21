package vikash.DC_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vikash.DC_API.entity.CitizenAppsEntity;
import java.io.Serializable;

@Repository
public interface CitizenAppRepository extends JpaRepository<CitizenAppsEntity, Serializable> {
}
