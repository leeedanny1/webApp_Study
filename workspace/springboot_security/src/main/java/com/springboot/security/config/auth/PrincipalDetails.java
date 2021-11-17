package com.springboot.security.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.springboot.security.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User {
	
	private static final long serialVersionUID = 1L;
	
	private User user;
	private Map<String, Object> attributes;
	
	// 일반 로그인
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	// OAuth2 로그인
	public PrincipalDetails(User user, Map<String, Object> attributes) {
		this.user = user;
		this.attributes = attributes;
	}

	
	@Override	//권한, 권한은 하나가 아닐 수 있기 때문에 return이 Collection이다.
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();
		
		collection.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				return user.getRole();
			}
		});
		
		return collection;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;	// 계정이 만료되었는지 여부(T: 만료안됨, F: 만료됨)
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;	// 계정이 잠겼는지 여부(T: 안잠김, F: 잠김)
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;	// 일정기간이상 계정을 사용하지 않으면 휴먼계정(T: 잠기지 않음, F: 사용할 수 없음)
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;	// 임시탈퇴
	}

	
	
	// OAuth2User
	
	// 프로필 정보
	@Override
	public Map<String, Object> getAttributes() {
		return attributes;	
	}

	// 아이디 받아옴
	@Override
	public String getName() {
		return (String)attributes.get("name");	
	}

}
