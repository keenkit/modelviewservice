package com.inno.modelview.controller;

import com.inno.modelview.model.Contributor;
import com.inno.modelview.model.Popularity;
import com.inno.modelview.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    final static Logger logger = LogManager.getLogger(UserController.class.getName());

    @Autowired
    IUserService iUserService;

    /**
     * The response is to POST the create username and last modified username.
     */
    @RequestMapping(value="/contributor", method= RequestMethod.POST)
    public ResponseEntity saveContributor(@RequestBody Contributor contributor){
        try {
            iUserService.saveContributor(contributor);
        } catch (Exception ex) {
            logger.error("saveContributor", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * The response is to POST the entity columns.
     */
    @RequestMapping(value="/popularity", method= RequestMethod.POST)
    public ResponseEntity savePopularity(@RequestBody Popularity popularity){
        try {
            iUserService.savePopularity(popularity);
        } catch (Exception ex) {
            logger.error("savePopularity", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

