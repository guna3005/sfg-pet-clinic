package guru.springframework.sfgpetclinic.model;

public class Speciality extends BaseEntity{
    public String descreption;

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }
}
