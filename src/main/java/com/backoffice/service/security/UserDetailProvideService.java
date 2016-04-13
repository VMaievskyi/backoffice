package com.backoffice.service.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backoffice.dao.UserDao;
import com.backoffice.dao.models.UserModel;
import com.backoffice.dao.models.UserRoleModel;
import com.google.common.collect.Lists;

@Service("userDetailsService")
public class UserDetailProvideService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
		final UserModel user = userDao.findOne(userName);
		return user == null ? buildAnonUser() : getUserWithRoles(user);
	}

	private User buildAnonUser() {
		return new User("anonym", null, Boolean.TRUE, true, true, true, Lists.newArrayList());
	}

	private User getUserWithRoles(final UserModel user) {
		final Set<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

		final User userForAuthentication = buildUserForAuthentication(user, authorities);
		return userForAuthentication;
	}

	private User buildUserForAuthentication(final UserModel userModel, final Set<GrantedAuthority> authorities) {

		return new User(userModel.getUserName(), userModel.getPassword(), userModel.isEnabled(), true, true, true,
				authorities);
	}

	private Set<GrantedAuthority> buildUserAuthority(final Set<UserRoleModel> userRoles) {

		return userRoles.parallelStream().map(role -> new SimpleGrantedAuthority(role.getRole()))
				.collect(Collectors.toSet());
	}

}
