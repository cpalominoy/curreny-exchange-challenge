package com.dev.currencyexchange.entity.security;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_USER")
public class UserEntity {

  @Id
  @Column(name = "USER_ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "USERNAME")
  private String username;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "FIRST_NAME")
  private String firstname;

  @Column(name = "LAST_NAME")
  private String lastname;

  /**
   * Roles are being eagerly loaded here because they are a fairly small collection of items for
   * this example.
   */
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "USER_ROLE", joinColumns
      = @JoinColumn(name = "USER_ID",
      referencedColumnName = "USER_ID"),
      inverseJoinColumns = @JoinColumn(name = "ROLE_ID",
          referencedColumnName = "ROLE_ID"))
  private List<RoleEntity> roles;

}
