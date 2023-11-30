package edu.fbansept.ecommerce.security;

import edu.fbansept.ecommerce.models.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public class EcommerceUserDetails implements UserDetails {

    private User user;
    private boolean isCustomer;
    private boolean isSeller;
    private boolean isAdmin;

    public EcommerceUserDetails(User user, boolean isCustomer, boolean isSeller, boolean isAdmin){
        this.user = user;
        this.isCustomer = isCustomer;
        this.isSeller = isSeller;
        this.isAdmin = isAdmin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        ArrayList<GrantedAuthority> roleList = new ArrayList<>();

        if(isCustomer) {
            roleList.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
        }

        if(isSeller) {
            roleList.add(new SimpleGrantedAuthority("ROLE_SELLER"));
        }

        if(isAdmin) {
            roleList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
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
