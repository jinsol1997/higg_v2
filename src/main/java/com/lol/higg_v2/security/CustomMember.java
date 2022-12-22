package com.lol.higg_v2.security;

import com.lol.higg_v2.entity.HiggMember;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
@ToString
public class CustomMember extends User {

    private HiggMember higgMember;

    public CustomMember(String username, String password, Collection<? extends GrantedAuthority> authorities, HiggMember higgMember) {
        super(username, password, authorities);
        this.higgMember = higgMember;
    }

    public CustomMember(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, HiggMember higgMember) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.higgMember =higgMember;
    }


}
