package com.iscastillo.api.person.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class PersonDto implements Serializable {
    //DTO = manera de la clase sea anonima con
    //relacion a la tabla en la base de datos
    private static Long serialVersionUID = 1200L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    //sirve para no mostrar esa informacion
    @JsonIgnore
    private int idPerson;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "surname", nullable = false, length = 45)
    private String surname;

    @Column(name = "second_surname", nullable = false, length = 45)
    private String secondSurname;

    @Column(name = "registration_date")
    private String registrationDate;

    @Column(name = "sex")
    private String sex;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "date_birth")
    private String dateBirth;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    //sirve para no mostrar esa informacion
    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "iduser"), inverseJoinColumns = @JoinColumn(name = "idrole"))
    private Set<Role> roles = new HashSet<>();

    public PersonDto(int idPerson, String firstName, String secondName, String surname, String secondSurname, String registrationDate, String sex, String phoneNumber, String address, String nationality, String dateBirth, String email, String password) {
        this.idPerson = idPerson;
        this.firstName = firstName;
        this.secondName = secondName;
        this.surname = surname;
        this.secondSurname = secondSurname;
        this.registrationDate = registrationDate;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.nationality = nationality;
        this.dateBirth = dateBirth;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "idPerson=" + idPerson +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", surname='" + surname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dateBirth='" + dateBirth + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
