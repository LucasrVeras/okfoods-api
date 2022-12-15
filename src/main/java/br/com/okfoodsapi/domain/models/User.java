package br.com.okfoodsapi.domain.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tab_user")
public class User {

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "col_name")
    private String name;
    
    @CreationTimestamp
    @Column(name = "col_date_registration")
    private LocalDateTime dateRegistration;
    
    @ManyToMany
    @JoinTable(name = "tab_user_group",
      joinColumns = @JoinColumn(name = "col_user_id"),
        inverseJoinColumns = @JoinColumn(name = "col_group_id"))
    private List<Group> groups = new ArrayList<>();

}
