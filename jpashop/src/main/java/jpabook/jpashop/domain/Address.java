package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import org.thymeleaf.spring5.processor.SpringUErrorsTagProcessor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    protected Address() {}
}
