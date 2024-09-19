package com.example;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity(name = "Users")
@Table(name = "USERS")
public class User implements UserDetails {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "USERS_SEQ", allocationSize = 1)
    int id;
    @Column(name = "NAME", length = 100, nullable = false)
    String name;
    @Column(name = "UNAME", length = 100, nullable = false, unique = true)
    String uname;
    @Column(name = "PWORD", length = 150, nullable = false)
    String pword;
    @Column(name = "ROLE", length = 500, nullable = false)
    String role;
    @Column(name = "ACCOUNT_NON_LOCKED", length = 5, nullable = false)
    private boolean accountNonLocked;

    public User(int id, String name, String uname, String pword, String role, List<String> roles) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.pword = pword;
        this.role = role;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  Arrays.asList(new SimpleGrantedAuthority("read"));
    }

    @Override
    public String getPassword() {
        return this.pword;
    }

    @Override
    public String getUsername() {
        return this.uname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }
    public boolean getAccountNonLocked() {
        return accountNonLocked;
    }
}
