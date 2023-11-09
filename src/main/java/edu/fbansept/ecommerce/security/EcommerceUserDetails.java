package edu.fbansept.ecommerce.security;

import edu.fbansept.ecommerce.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class EcommerceUserDetails implements UserDetails {

    private User user;
    private boolean isCustomer;
    private boolean isSeller;

    public EcommerceUserDetails(User user, boolean isCustomer, boolean isSeller){
        this.user = user;
        this.isCustomer = isCustomer;
        this.isSeller = isSeller;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        ArrayList<GrantedAuthority> roleList = new ArrayList<>();

        if(isCustomer) {
            roleList.add(new SimpleGrantedAuthority("CUSTOMER"));
        }

        if(isSeller) {
            roleList.add(new SimpleGrantedAuthority("SELLER"));
        }

        return roleList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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
}
