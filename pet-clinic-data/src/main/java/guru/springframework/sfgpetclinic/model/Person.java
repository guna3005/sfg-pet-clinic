package guru.springframework.sfgpetclinic.model;


import lombok.*;

import javax.persistence.MappedSuperclass;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@MappedSuperclass
public class Person extends BaseEntity{
    private String firstName;
    private String lastName;

}
