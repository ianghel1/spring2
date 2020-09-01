package com.sda.spring.components;

import com.github.javafaker.Faker;
import com.sda.spring.model.Company;
import com.sda.spring.model.Employee;
import com.sda.spring.model.Project;
import com.sda.spring.model.Salary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomFaker {

    public List<Employee> createDummyEmployeeList() {

        Faker faker = new Faker();
        List<Employee> dummyEmployee = new ArrayList<Employee>();

        for (int i = 0; i < 100; i++) {
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

    public List<Company> createDummyCompanyList() {
        Faker faker = new Faker();
        List<Company> dummyCompany = new ArrayList<Company>();

        for (int i = 0; i < 100; i++) {
            Company company = new Company();
            company.setName(faker.company().name());
            company.setAddress(faker.address().fullAddress());
            company.setEmail(faker.bothify("??????#?#@gmail.com"));
            company.setPhoneNumber(faker.phoneNumber().phoneNumber());
            company.setRegistrationNumber(faker.number().randomNumber(8, true));
            dummyCompany.add(company);

        }
        return dummyCompany;
    }

    public List<Salary> createDummySalaryList() {
        Faker faker = new Faker();
        List<Salary> dummySalary = new ArrayList<Salary>();

        for (int i = 0; i < 100; i++){
            Salary salary = new Salary();
            salary.setValue(faker.number().randomDouble(2, 500, 2000));
            salary.setCurrency(faker.currency().name());
            dummySalary.add(salary);
        }
        return dummySalary;
    }

    public List<Project> createDummyProjectList(){
        Faker faker = new Faker();
        List<Project> dummyProject = new ArrayList<Project>();

        for (int i = 0; i<100; i++){
            Project project = new Project();
            project.setProjectName(faker.app().name());
            dummyProject.add(project);
        }
        return dummyProject;
    }

}
