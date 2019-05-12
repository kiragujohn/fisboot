
package com.njoroge.fis.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njoroge.fis.domain.User;
import com.njoroge.fis.repository.UserRepository;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    private UserTransfer[] getUserTransfers( List<User> users ) {

        List<UserTransfer> userTransfers = new ArrayList<>();

        for ( User user : users ) {
            UserTransfer userTransfer = new UserTransfer();
            userTransfer.id = user.getId();
            userTransfer.firstName = user.getFirstName();
            userTransfer.lastName = user.getLastName();
            userTransfer.email = user.getEmail();
            userTransfer.password = user.getPassword();
            userTransfers.add( userTransfer );
        }

        return userTransfers.toArray( new UserTransfer[userTransfers.size()] );
    }


    @Override
    public FindUserInitialData getAllUsers() {

        FindUserInitialData findUserInitialData = new FindUserInitialData();

        List<User> users = userRepository.findAll();

        findUserInitialData.users = getUserTransfers( users );

        return findUserInitialData;
    }

    @Override
    public String getEmailAddressById( Long UserID ) {

        return userRepository.findOne( UserID ).getEmail();
    }


    @Override
    public Boolean doesUserExist( Long userId ) {

        return userRepository.exists( userId );
    }


    @Override
    public User getById( Long userId ) {

        return userRepository.findOne( userId );
    }


    @Override
    public List<User> retrieveUsers() {

        List<User> users = userRepository.findAll();
        return users;
    }
}
