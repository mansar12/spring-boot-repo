package com.cg.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Shipwreck;
import com.cg.repository.ShipwreckRepository;


@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {
@Autowired
public ShipwreckRepository shipwreckkRepository;
@SuppressWarnings("unchecked")
@RequestMapping(value="shipwrecks", method=RequestMethod.GET)
public List<Shipwreck> list(){
return shipwreckkRepository.loadAllValue();
}
@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
public Shipwreck create(@RequestBody Shipwreck shipwreck) {
return shipwreckkRepository.saveAndFlush(shipwreck);
}

@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
public Shipwreck get(@PathVariable Long id) {
return shipwreckkRepository.findOne(id);
}

@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
Shipwreck existingShipwreck = shipwreckkRepository.findOne(id);
BeanUtils.copyProperties(shipwreck, existingShipwreck);
return shipwreckkRepository.saveAndFlush(existingShipwreck);
}

@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
public Shipwreck delete(@PathVariable Long id) {
Shipwreck existingShipwreck = shipwreckkRepository.findOne(id);
shipwreckkRepository.delete(existingShipwreck);
return existingShipwreck;
}


}
