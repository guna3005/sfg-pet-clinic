package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialitiesServices;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    private final SpecialitiesServices specialitiesServices;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesServices specialitiesServices) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesServices = specialitiesServices;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0){
        loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");

        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");

        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescreption("Radiology");
        Speciality savedradio = specialitiesServices.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescreption("Surgery");
        Speciality savedsurgery = specialitiesServices.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescreption("Dentistry");
        Speciality saveddentistry = specialitiesServices.save(dentistry);


        Owner owner1 = new Owner();

        owner1.setFirstName("mike");
        owner1.setLastName("hannigan");
        owner1.setAddress("123 albequirke");
        owner1.setCity("albequirke");
        owner1.setTelephone("789023");

        Pet mikespPet = new Pet();
        mikespPet.setPetType(saveDogPetType);
        mikespPet.setOwner(owner1);
        mikespPet.setBirthDate(LocalDate.now());
        mikespPet.setName("julie");
        owner1.getPets().add(mikespPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("lewis");
        owner2.setLastName("hamilton");
        owner2.setAddress("123 silverstone");
        owner2.setCity("silverstone");
        owner2.setTelephone("480329809");

        Pet lewisPet = new Pet();
        lewisPet.setPetType(saveCatPetType);
        lewisPet.setOwner(owner2);
        lewisPet.setBirthDate(LocalDate.now());
        lewisPet.setName("romeo");
        owner2.getPets().add(lewisPet);


        ownerService.save(owner2);

        Vet vet1 = new Vet();


        vet1.setFirstName("jessie");
        vet1.setLastName("pinkman");
        vet1.getSpecialities().add(savedradio);

        vetService.save(vet1);

        Vet vet2 = new Vet();


        vet2.setFirstName("walter");
        vet2.setLastName("white");
        vet2.getSpecialities().add(saveddentistry);

        vetService.save(vet2);

        System.out.println("vet and owner logged in ...");
    }
}
