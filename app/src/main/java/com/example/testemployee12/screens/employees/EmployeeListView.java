package com.example.testemployee12.screens.employees;

import com.example.testemployee12.pojo.Employee;

import java.util.List;

public interface EmployeeListView {
    public void showData(List<Employee> employees);
    public void showError();
}
