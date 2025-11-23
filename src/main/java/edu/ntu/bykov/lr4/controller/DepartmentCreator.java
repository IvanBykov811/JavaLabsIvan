package edu.ntu.bykov.lr4.controller;

import edu.ntu.bykov.lr4.model.Department;
import edu.ntu.bykov.lr4.model.Faculty;
import edu.ntu.bykov.lr4.model.Group;
import edu.ntu.bykov.lr4.model.Human;

public class DepartmentCreator {

    private final GroupCreator groupCreator = new GroupCreator();

    public Department createDepartment(String name, Human head) {
        return new Department(name, head);
    }

    public Department createDepartmentInFaculty(Faculty faculty,
                                                String name,
                                                Human head) {
        Department department = createDepartment(name, head);
        faculty.addDepartment(department);
        return department;
    }

    public Group createGroupInDepartment(Department department,
                                         String name,
                                         Human head) {
        Group group = groupCreator.createGroup(name, head);
        department.addGroup(group);
        return group;
    }

    public GroupCreator getGroupCreator() {
        return groupCreator;
    }
}
