package br.com.okfoodsapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.okfoodsapi.domain.models.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
	
}
