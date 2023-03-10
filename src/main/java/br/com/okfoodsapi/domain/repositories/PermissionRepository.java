package br.com.okfoodsapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.okfoodsapi.domain.models.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
	
}
