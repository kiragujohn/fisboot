
package com.njoroge.fis.service.user;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
public class UserDeleteRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;


    public UserDeleteRequest( String firstName, String lastName, String email,
            String password ) {

        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
        this.password = password;
    }


    public String getFirstname() {

        return firstname;
    }


    public void setFirstname( String firstname ) {

        this.firstname = firstname;
    }


    public String getLastname() {

        return lastname;
    }


    public void setLastname( String lastname ) {

        this.lastname = lastname;
    }


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

}
