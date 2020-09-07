package com.sda.spring.mapper;

import com.sda.spring.dto.EmployeeSummaryDto;
import com.sda.spring.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public static List<EmployeeSummaryDto> toEmployeeSummaryDtoList(List<Employee> employeeList) {
        List<EmployeeSummaryDto> employeeSummaryDtos = new ArrayList<>();

        employeeList.stream()
                .map(entity -> employeeSummaryDtos.add(entityToEmployeeSummaryDto(entity)))
                .collect(Collectors.toList());

        return employeeSummaryDtos;
    }

    public static EmployeeSummaryDto entityToEmployeeSummaryDto(Employee employee) {
        EmployeeSummaryDto employeeSummaryDto = new EmployeeSummaryDto();
        employeeSummaryDto.setId(employee.getId());
        employeeSummaryDto.setFirstName(employee.getFirstName());
        employeeSummaryDto.setLastName(employee.getLastName());
        employeeSummaryDto.setPersonalNumericCode(employee.getPersonalNumericCode());
        employeeSummaryDto.setPhoneNumber(employee.getPhoneNumber());

        return employeeSummaryDto;
    }

}
