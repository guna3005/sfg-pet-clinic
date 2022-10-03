package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepositories;
import guru.springframework.sfgpetclinic.repositories.PetRepositories;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDataJpa")
public class OwnerJSDJService implements OwnerService {

    private final OwnerRepositories ownerRepositories;
    private final PetRepositories petRepositories;
    private final PetTypeRepository petTypeRepository;

    public OwnerJSDJService(OwnerRepositories ownerRepositories, PetRepositories petRepositories,
                            PetTypeRepository petTypeRepository) {
        this.ownerRepositories = ownerRepositories;
        this.petRepositories = petRepositories;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepositories.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepositories.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepositories.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepositories.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
            ownerRepositories.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepositories.findByLastName(lastName);
    }
}
