package med.voli.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    public Address(DataAddress data) {
        this.street = data.street();
        this.neighbourhood = data.neighbourhood();
        this.postal_code = data.postal_code();
        this.city = data.city();
        this.uf = data.uf();
        this.numero = data.numero();
        this.complement = data.complement();
    }

    private String street;
    private String neighbourhood;
    private String postal_code;
    private String city;
    private String uf;
    private String numero;
    private String complement;

    public void updateInfo(DataAddress data) {
        if (data.street() != null) {
            this.street = data.street();
        }
        if (data.neighbourhood() != null) {
            this.neighbourhood = data.neighbourhood();
        }
        if (data.postal_code() != null) {
            this.postal_code = data.postal_code();
        }
        if (data.city() != null) {
            this.city = data.city();
        }
        if (data.uf() != null) {
            this.uf = data.uf();
        }
        if (data.numero() != null) {
            this.numero = data.numero();
        }
        if (data.complement() != null) {
            this.complement = data.complement();
        }
    }
}
