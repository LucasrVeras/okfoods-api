package br.com.okfoodsapi.jpa.permission;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.okfoodsapi.OkfoodsApiApplication;
import br.com.okfoodsapi.domain.models.Permission;
import br.com.okfoodsapi.domain.repositories.PermissionRepository;

public class QueryPermissionMain{
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(OkfoodsApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		
		PermissionRepository permissionRepository = applicationContext
				.getBean(PermissionRepository.class);
	
		List<Permission> allPermission = permissionRepository.all();
		
		for (Permission permission : allPermission) {
			System.out.printf("%s\n", permission.getDescription());
		}
	}
}
