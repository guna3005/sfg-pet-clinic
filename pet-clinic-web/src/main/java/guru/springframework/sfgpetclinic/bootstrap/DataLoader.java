package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    public final OwnerService ownerService;
    public final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();

        owner1.setId(1L);
        owner1.setFirstName("guna");
        owner1.setLastName("pra");

        ownerService.save(owner1);

        Vet vet1 = new Vet();

        vet1.setId(1L);

        vet1.setFirstName("jessie");
        vet1.setLastName("pinkman");

        vetService.save(vet1);

        System.out.println("vet and owner logged in ...");

    }
}
