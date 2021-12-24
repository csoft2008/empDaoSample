package com.javaoldman.dao;

import com.javaoldman.entity.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> selectAllEmp();
    Emp selectEmpByEmpno(int empno);
    int deleteEmpByEmpno(int empno);
    int insertEmp(Emp emp);
    int updateEmp(Emp emp);
}
