package ke.co.ngonyoku.keroma.Keroma.service;

import jakarta.persistence.EntityNotFoundException;
import ke.co.ngonyoku.keroma.Keroma.model.Rider;
import ke.co.ngonyoku.keroma.Keroma.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderService {

    private final RiderRepository riderRepository;

    @Autowired
    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    public Rider getRiderById(Long id) {
        return riderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rider not found with ID: " + id));
    }

    public List<Rider> getAllRiders() {
        return riderRepository.findAll();
    }

    public Rider createRider(Rider rider) {
        return riderRepository.save(rider);
    }

    public Rider updateRider(Long id, Rider rider) {
        Rider existingRider = getRiderById(id);
        existingRider.setName(rider.getName());
        existingRider.setEmail(rider.getEmail());
        return riderRepository.save(existingRider);
    }

    public void deleteRider(Long id) {
        Rider existingRider = getRiderById(id);
        riderRepository.delete(existingRider);
    }
}
