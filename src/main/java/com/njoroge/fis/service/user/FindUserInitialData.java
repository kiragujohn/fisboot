
package com.njoroge.fis.service.user;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
public class FindUserInitialData {

    public UserTransfer[] users;


    public FindUserInitialData() {

        super();
    }


    public FindUserInitialData( UserTransfer[] users ) {

        this.users = users;
    }


    public UserTransfer[] getUsers() {

        return users;
    }


    public void setUsers( UserTransfer[] users ) {

        this.users = users;
    }
}