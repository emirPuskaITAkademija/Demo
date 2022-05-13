package org.celebration.demo.service.user;

import jakarta.ejb.Local;
import org.celebration.demo.entity.User;

import java.util.List;
// 2 session bean EJB -> local i remote
@Local
public interface UserServiceLocal {

    void create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();

    User findByUsername(String username);

//    User register(RegistrationModel registerModel);
//
//    User login(AuthenticationModel authenticationModel);
//
//    User update(RegistrationModel registrationModel);

}