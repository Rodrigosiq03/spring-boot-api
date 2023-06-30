package med.voli.api.doctor;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import med.voli.api.address.Address;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class EntityDoctor {

    public EntityDoctor(DataCreationDoctor data) {
        this.nome = data.nome();
        this.address = new Address(data.dataAddress());
        this.crm = data.crm();
        this.email = data.email();
        this.speciality = data.speciality();
        this.cellphone = data.cellphone();
        
    }
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cellphone;
    private String crm;
    
    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @Embedded
    private Address address;

    public void updateInfo(DataUpdateDoctor data) {
        if (data.nome() != null) {
            this.nome = data.nome();
        }
        if (data.cellphone() != null) {
            this.cellphone = data.cellphone();
        }
        if (data.address() != null) {
            this.address.updateInfo(data.address());
        }
    }


}
