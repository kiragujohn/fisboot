
package com.njoroge.fis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.njoroge.fis.service.user.FindUserInitialData;
import com.njoroge.fis.service.user.UserService;

/**
 * @author John Njoroge
 * @date 09/05/2019
 */
@RestController
@RequestMapping( "/fis/user" )
public class UserController {

    @Autowired
    UserService userService;

    /*
     * @GetMapping( "/findusers" ) public List<User> getUsers() {
     *
     * List<User> users = userService.retrieveUsers(); return users; }
     */


    @RequestMapping( value = "/findusers", method = RequestMethod.POST )
    public ResponseEntity<FindUserInitialData> findUsers() {

        FindUserInitialData findUserInitialData = userService.getAllUsers();

        return ResponseEntity.status( HttpStatus.OK ).body(
                findUserInitialData );
    }

}
