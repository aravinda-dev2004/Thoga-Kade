package model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {

    private String customerID;

    private String customerTitle;

    private String customerName;

    private LocalDate dateOfBirth;

    private double salary;

    private String customerAddress;

    private String city;

    private String province;

    private String postalCode;

}
