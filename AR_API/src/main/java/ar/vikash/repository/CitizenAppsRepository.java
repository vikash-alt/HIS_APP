package ar.vikash.repository;

import ar.vikash.entity.CitizenAppsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository
public interface CitizenAppsRepository extends JpaRepository<CitizenAppsEntity, Serializable> {

}
