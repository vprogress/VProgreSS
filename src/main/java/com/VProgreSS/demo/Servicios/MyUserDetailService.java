package com.VProgreSS.demo.Servicios;

import com.VProgreSS.demo.Entidades.MyUserApplicationDetail;
import com.VProgreSS.demo.Entidades.UsersApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    ServiceInterfaceUser UserInterface;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UsersApplication UserX = UserInterface.getOnlyOneUsersApplication(username);
            return new MyUserApplicationDetail(UserX);
        } catch (Exception e) {

            throw new UsernameNotFoundException(e.getMessage());
        }

    }
}
