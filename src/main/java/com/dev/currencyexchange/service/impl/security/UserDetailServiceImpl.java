package com.dev.currencyexchange.service.impl.security;

import com.dev.currencyexchange.entity.security.UserEntity;
import com.dev.currencyexchange.respository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<UserEntity> userEntityOpt = userRepository.findByUsername(username);

    if (userEntityOpt.isPresent()) {
      List<GrantedAuthority> authorities = new ArrayList<>();
      UserEntity userEntity = userEntityOpt.get();

      userEntity.getRoles().forEach(
          roleEntity -> authorities.add(new SimpleGrantedAuthority(roleEntity.getRoleName()))
      );

      return new User(userEntity.getUsername(), userEntity.getPassword(), authorities);

    } else {
      throw new UsernameNotFoundException(
          String.format("The username %s does not exist", username));
    }


  }
}
