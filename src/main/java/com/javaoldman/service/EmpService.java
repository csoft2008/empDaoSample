package com.javaoldman.service;

import com.javaoldman.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> getAllEmps();
    Emp getEmpByEmpno(int empno);
    int deleteEmpByEmpno(int empno);
    int addEmp(Emp emp);  //如果empno的记录已存在，返回-1，其他，返回添加成功的数量
    int updateEmp(Emp emp); //如果empno的记录不存在，返回-1，其他，返回更新成功的数量
}
