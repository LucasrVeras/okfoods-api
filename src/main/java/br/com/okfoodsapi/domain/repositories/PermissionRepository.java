package br.com.okfoodsapi.domain.repositories;

import java.util.List;

import br.com.okfoodsapi.domain.models.Permission;

public interface PermissionRepository {
	
	List<Permission> all();
	Permission searchForId(Long id);
	Permission add(Permission permission);
	void remove(Permission permission);
}
