package ke.co.ngonyoku.keroma.Keroma.repository;

import ke.co.ngonyoku.keroma.Keroma.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
}
