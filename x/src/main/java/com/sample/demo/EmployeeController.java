package com.sample.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
  @Autowired
  private EmployeeRepository repo;
  
  @RequestMapping(method = RequestMethod.GET)
  public List<Employee> findItems() {
    return repo.findAll();
  }
  
  @RequestMapping(value = "/{id}",method = RequestMethod.GET)
  public Employee findone(@PathVariable Integer id) {
    return  repo.findOne(id);
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Employee addItem(@RequestBody Employee item) {
    item.setId(null);
    return repo.saveAndFlush(item);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.POST)
  public Employee updateItem(@RequestBody Employee updatedItem, @PathVariable Integer id) {
    updatedItem.setId(id);
    return repo.saveAndFlush(updatedItem);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteItem(@PathVariable Integer id) {
    repo.delete(id);
  }
}