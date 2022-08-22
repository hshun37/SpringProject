package com.springboot.hello.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    private String name;
    private String email;
    private String organization;

    @Override
    public String toString() {
        return  "{" +
                "name='" + name + "\n" +
                ", email='" + email + "\n" +
                ", organization='" + organization + "\n" +
                '}';
    }
}
