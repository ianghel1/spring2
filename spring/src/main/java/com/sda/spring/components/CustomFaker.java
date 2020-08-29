package com.sda.spring.components;

import com.github.javafaker.Faker;
import com.sda.spring.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class CustomFaker {

    public List<Employee> createDummyEmployeeList(){

        Faker faker = new Faker();
        List<Employee> dummyEmployee = new ArrayList<Employee>();

        for (int i = 0; i < 100; i++){
            Employee employee = new Employee();
            employee.setFirstName(faker.name().firstName());
            employee.setLastName(faker.name().lastName());
            employee.setAddress(faker.address().fullAddress());
            employee.setPhoneNumber(faker.phoneNumber().phoneNumber());
            employee.setEmail(faker.bothify("????##@gmail.com"));
            employee.setPersonalNumericCode(faker.number().randomNumber(13, true));
            employee.setHired(faker.bool().bool());
            dummyEmployee.add(employee);
        }

        return dummyEmployee;
    }

}
