package edu.ntu.bykov.lr3.model;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends OrganizationalUnit {
    private final List<Department> departments = new ArrayList<>();

    public Faculty(String name, Human head) {
        super(name, head);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }
}
