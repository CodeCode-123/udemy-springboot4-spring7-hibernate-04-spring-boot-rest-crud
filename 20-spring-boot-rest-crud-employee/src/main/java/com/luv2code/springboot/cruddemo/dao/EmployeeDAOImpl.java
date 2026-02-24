package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    // define field for entityManager
    private EntityManager entityManager;
    // set up the constructor for injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
        // return the results
        return theQuery.getResultList();
    }
    @Override
    public Employee findById(int theId) {
        // return the retrieved employee by id
        return entityManager.find(Employee.class, theId);
    }
    @Override
    public Employee save(Employee theEmployee) {
        // save the updated employee
        return entityManager.merge(theEmployee);
    }
    @Override
    public void deleteById(int theId) {
        // retrieve the employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);
        // remove the employee
        entityManager.remove(theEmployee);
    }
}
