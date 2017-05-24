/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Person;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;


/**
 *
 * @author Son Vu
 */
@Service
public class SecurityShop {
    
    @Autowired
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
    
    public void RegisterNewCustomer(Person p,String password){
        List<GrantedAuthority> authorities = new ArrayList<>();
        UserDetails user = new User(p.getEmail(),password,authorities);
        inMemoryUserDetailsManager.createUser(user);
    }
}
