package com.javaoldman.controller;

import com.javaoldman.entity.Emp;
import com.javaoldman.service.EmpService;
import com.javaoldman.service.impl.EmpServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class EmpController {

    EmpService service = new EmpServiceImpl();

    Emp emp = null;

    public EmpController(){

    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public List<Emp> doByOption(int option){
        switch (option){
            case 1:
                return service.getAllEmps();
            case 2:
                Emp emp2 = service.getEmpByEmpno(emp.getEmpno());
                List<Emp> empList = new ArrayList<>();
                empList.add(emp2);
                return empList;
            case 3:
                service.deleteEmpByEmpno(emp.getEmpno());
                return service.getAllEmps();
            case 4:
                service.addEmp(emp);
                return service.getAllEmps();
            case 5:
                service.updateEmp(emp);
                return service.getAllEmps();
            default:
                return null;
        }
    }
}
