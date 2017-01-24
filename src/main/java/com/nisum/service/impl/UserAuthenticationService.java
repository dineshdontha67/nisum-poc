package com.nisum.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nisum.domain.User;
import com.nisum.domain.UserRoles;
import com.nisum.repository.UserRepository;

@Service
public class UserAuthenticationService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		if(user == null)
			throw new UsernameNotFoundException(username+">>Not Found");
		
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getUserAuthorities(user));
		
	}
	
	private Set<GrantedAuthority> getUserAuthorities(User user){
		
		Set<GrantedAuthority> userAuthorities = new HashSet<GrantedAuthority>();
		//userAuthorities.addAll((Collection<? extends GrantedAuthority>) user.getRoles());
		
		for(UserRoles userRole : user.getRoles()){
			userAuthorities.add(new SimpleGrantedAuthority("ROLE_"+userRole.getRoleName()));
		}
		
		return userAuthorities;
		
	}
	
	//from bharath as reference
	/*private List<GrantedAuthority> getGrantedAuthorities(UserBO userBO){
	      List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	      authorities.add(new SimpleGrantedAuthority("ROLE_"+userBO.getRole()));
	      System.out.print("authorities :"+authorities);
	      return authorities;
	  }
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Load user");
		UserBO userBO = userRepository.findByUsername(username);
		System.out.println(username);
		if(userBO == null){
		throw new UsernameNotFoundException("No user present with username: "+username);
		} 
		return new org.springframework.security.core.userdetails.User(userBO.getUsername(), userBO.getPassword(), 
		                getGrantedAuthorities(userBO));

		}
*/
}
