package br.com.okfoodsapi.infrastructure.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.okfoodsapi.domain.models.Permission;
import br.com.okfoodsapi.domain.repositories.PermissionRepository;

@Repository
public class PermissionRepositoryImpl implements PermissionRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Permission> all() {	
		return manager.createQuery("from Permission", Permission.class)
				.getResultList();
	}

	@Override
	public Permission searchForId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Permission add(Permission permission) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Permission permission) {
		// TODO Auto-generated method stub
		
	}
}
