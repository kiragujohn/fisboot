
package com.njoroge.fis.service.user;

import java.util.List;

import com.njoroge.fis.domain.User;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
public interface UserService {

    FindUserInitialData getAllUsers();

    String getEmailAddressById( Long userId );


    Boolean doesUserExist( Long userId );


    User getById( Long userId );


    List<User> retrieveUsers();
}
