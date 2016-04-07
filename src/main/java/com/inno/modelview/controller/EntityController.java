package com.inno.modelview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.inno.modelview.model.MEntity;
import com.inno.modelview.service.EntityService;
import com.inno.modelview.viewmodel.EntityViewModel;

@Controller  
@RequestMapping("/entity")  
public class EntityController {
	
	@Autowired
	@Qualifier("entityService")
	EntityService entityService;
	
	@RequestMapping(value="/c", method=RequestMethod.POST)  
    public String createEntity(@ModelAttribute("entity") MEntity entity) { 		
		entityService.saveEntity(entity);
		return "sucess";
    } 
	
	@RequestMapping(value="/r/{name}", method=RequestMethod.GET)  
    public @ResponseBody Object queryEntity(@PathVariable String name) { 		
		MEntity entity = entityService.findEntityByName("");
		return new EntityViewModel(entity, null);
    } 

}