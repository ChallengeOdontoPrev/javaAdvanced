package com.odontoprev.challenge.domain.dto;


import com.odontoprev.challenge.domain.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO extends RepresentationModel<AddressDTO> {
    private Long id;
    @NotBlank(message = "Rua é obrigatória")
    private String street;
    @NotBlank(message = "Número é obrigatório")
    private String number;
    @NotBlank(message = "Cidade é obrigatória")
    private String city;
    @NotBlank(message = "Estado é obrigatório")
    private String state;
    @NotBlank(message = "CEP é obrigatório")
    private String zipCode;

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.number = address.getNum();
        this.city = address.getCity();
        this.state = address.getState();
        this.zipCode = address.getZipCode();
    }
}
