package br.com.okfoodsapi.domain.models;

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

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
@Table(name = "tab_group")
public class Group {
    
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    
    @Column(name = "col_name")
    private String name;
    
    @ManyToMany
    @JoinTable(name = "tab_group_permission",
            joinColumns = @JoinColumn(name = "col_group_id"),
            inverseJoinColumns = @JoinColumn(name = "col_permission_id"))
    private List<Permission> permissions = new ArrayList<>();
}
