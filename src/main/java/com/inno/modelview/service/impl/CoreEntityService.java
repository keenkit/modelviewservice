package com.inno.modelview.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.inno.modelview.model.DTO.EntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inno.modelview.dao.ICoreEntityDao;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.service.ICoreEntityService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CoreEntityService implements ICoreEntityService {

	@Autowired
	@Qualifier("OutMemory")
	private ICoreEntityDao coreEntityDao;

	@Transactional
	public List<EntityDTO> getAllEntities(){
		return coreEntityDao.getEnties();
	}

	@Transactional(readOnly = false)
	public Integer saveCoreEntity(CoreEntity coreEntity) {
		return coreEntityDao.saveCoreEntity(coreEntity);
	}

	@Transactional
	public CoreEntity getCoreEntityById(int id){
		return coreEntityDao.getCoreEntityById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public CoreEntity getCoreEntityByName(String name) {
		return coreEntityDao.getCoreEntityByName(name);
	}

	public List<CoreEntity> getAllParentEntites(CoreEntity coreEntity){
		List<CoreEntity> parentEntites = new ArrayList<>();
		CoreEntity currentEntity = coreEntity;
		while(true){
			if(currentEntity.getParentEntity() == null){
				break;
			}
			CoreEntity parentEntity = coreEntityDao.getParentEntity(currentEntity);
			currentEntity = parentEntity;
			parentEntites.add(currentEntity);
		}
		return parentEntites;
	}
}