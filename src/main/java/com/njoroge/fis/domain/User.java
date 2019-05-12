
package com.njoroge.fis.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
@Entity
@Table( name = "APP_USER" )
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( name = "email", nullable = false, unique = true, length = 255 )
    private String email;

    @Column( name = "password", nullable = false, unique = false, length = 256 )
    @JsonIgnore
    private String password;

    @Column( name = "FIRST_NAME", nullable = false, unique = false,
            length = 100 )
    private String firstName;

    @Column( name = "LAST_NAME", nullable = false, unique = false,
            length = 100 )
    private String lastName;

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "CREATED_DATE", updatable = true, nullable = false )
    private Calendar createdDate;

    public String getEmail() {

        return email;
    }


    public void setEmail( String email ) {

        this.email = email;
    }


    public String getPassword() {

        return password;
    }


    public void setPassword( String password ) {

        this.password = password;
    }


    public String getFirstName() {

        return firstName;
    }


    public void setFirstName( String firstName ) {

        this.firstName = firstName;
    }


    public String getLastName() {

        return lastName;
    }


    public void setLastName( String lastName ) {

        this.lastName = lastName;
    }


    public Calendar getCreatedDate() {

        return createdDate;
    }


    public void setCreatedDate( Calendar createdDate ) {

        this.createdDate = createdDate;
    }

    @Override
    public int hashCode() {

        return super.hashCode();
    }


    public Long getId() {

        return id;
    }


    public void setId( Long id ) {

        this.id = id;
    }


    @Override
    public boolean equals( Object obj ) {

        return super.equals( obj );
    }


    @Override
    public String toString() {

        return "User [email=" + email + ", password=" + password
                + ", firstName=" + firstName + ", lastName=" + lastName
                + ", createdDate=" + createdDate + ", toString()="
                + super.toString() + "]";
    }
}
