package com.javaoldman.service.impl;

import com.javaoldman.dao.EmpDao;
import com.javaoldman.dao.impl.EmpDaoImpl;
import com.javaoldman.entity.Emp;
import com.javaoldman.service.EmpService;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    EmpDao dao = new EmpDaoImpl();  //实例化EmpDao的实现类对象
    //下面，利用dao的方法来实现service的业务逻辑
    @Override
    public List<Emp> getAllEmps() {
        return dao.selectAllEmp();
    }

    @Override
    public Emp getEmpByEmpno(int empno) {
        return dao.selectEmpByEmpno(empno);
    }

    @Override
    public int deleteEmpByEmpno(int empno) {
        return dao.deleteEmpByEmpno(empno);
    }

    @Override
    public int addEmp(Emp emp) {
        //为了演示service与Dao之间的区别。这里假设，在添加业务中，需要先判断这个empno的记录是否存在，如果存在就不添加，返回-1。
        int empno;
        empno = emp.getEmpno();
        Emp emp2 = dao.selectEmpByEmpno(empno);
        if(emp2!=null){  //如果已存在empno值的记录，就返回-1
            return -1;
        }
        return dao.insertEmp(emp);
    }

    @Override
    public int updateEmp(Emp emp) {
        //为了演示service与Dao之间的区别。这里假设，在更新业务中，需要先判断这个empno的记录是否存在，如果不存在就不更新，返回-1。
        int empno;
        empno = emp.getEmpno();
        Emp emp2 = dao.selectEmpByEmpno(empno);
        if(emp2==null){  //如果不存在empno值的记录，就返回-1
            return -1;
        }
        return dao.updateEmp(emp);
    }
}
