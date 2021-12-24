package com.javaoldman.dao.impl;

import com.javaoldman.dao.EmpDao;
import com.javaoldman.entity.Emp;
import com.javaoldman.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {

    @Override
    public List<Emp> selectAllEmp() {
        Connection connection = JDBCUtil.getConn(); //通过工具类直接得到Connection对象
        String sql = "select * from emp";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Emp> empList = new ArrayList<>();
        try {
             preparedStatement = connection.prepareStatement(sql);
             resultSet = preparedStatement.executeQuery();
             while (resultSet.next()){
                 Emp emp = new Emp();
                 emp.setEmpno(resultSet.getInt("empno"));
                 emp.setEname(resultSet.getString("ename"));
                 emp.setJob(resultSet.getString("job"));
                 emp.setMgr(resultSet.getInt("mgr"));
                 emp.setSal(resultSet.getDouble("sal"));
                 emp.setComm(resultSet.getDouble("comm"));
                 emp.setDeptno(resultSet.getInt("deptno")); //组装emp对象
                 empList.add(emp); //组装emp集合
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection,preparedStatement,resultSet); //释放数据库资源
        }
        return empList;  //返回emp集合
    }

    @Override
    public Emp selectEmpByEmpno(int empno) {
        Connection connection = JDBCUtil.getConn(); //通过工具类直接得到Connection对象
        String sql = "select * from emp where empno = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Emp> empList = new ArrayList<>();
        Emp emp = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,empno);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                emp = new Emp();
                emp.setEmpno(resultSet.getInt("empno"));
                emp.setEname(resultSet.getString("ename"));
                emp.setJob(resultSet.getString("job"));
                emp.setMgr(resultSet.getInt("mgr"));
                emp.setSal(resultSet.getDouble("sal"));
                emp.setComm(resultSet.getDouble("comm"));
                emp.setDeptno(resultSet.getInt("deptno")); //组装emp对象
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection,preparedStatement,resultSet); //释放数据库资源
        }
        return emp;  //如果有记录，就返回emp，否则返回null
    }

    @Override
    public int deleteEmpByEmpno(int empno) {
        Connection connection = JDBCUtil.getConn(); //通过工具类直接得到Connection对象
        String sql = "delete from emp where empno = ?";
        PreparedStatement preparedStatement = null;
        int num = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,empno);
            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection,preparedStatement,null); //释放数据库资源，因为没有记录集对象，所以，用null
        }
        return num;  //返回受影响的行数
    }

    @Override
    public int insertEmp(Emp emp) {
        Connection connection = JDBCUtil.getConn(); //通过工具类直接得到Connection对象
        int empno;
        String ename;
        String job;
        int mgr;
        double sal;
        double comm;
        int deptno;

        empno = emp.getEmpno();
        ename = emp.getEname();
        job = emp.getJob();
        mgr = emp.getMgr();
        sal = emp.getSal();
        comm = emp.getComm();
        deptno = emp.getDeptno();

        String sql = "insert into emp(empno,ename,job,mgr,sal,comm,deptno) values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        int num = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,empno);
            preparedStatement.setString(2,ename);
            preparedStatement.setString(3,job);
            preparedStatement.setInt(4,mgr);
            preparedStatement.setDouble(5,sal);
            preparedStatement.setDouble(6,comm);
            preparedStatement.setInt(7,deptno);

            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection,preparedStatement,null); //释放数据库资源，因为没有记录集对象，所以，用null
        }
        return num;  //返回受影响的行数
    }

    @Override
    public int updateEmp(Emp emp) {
        Connection connection = JDBCUtil.getConn(); //通过工具类直接得到Connection对象
        int empno;
        String ename;
        String job;
        int mgr;
        double sal;
        double comm;
        int deptno;

        empno = emp.getEmpno();
        ename = emp.getEname();
        job = emp.getJob();
        mgr = emp.getMgr();
        sal = emp.getSal();
        comm = emp.getComm();
        deptno = emp.getDeptno();

        String sql = "update emp set ename=?,job=?,mgr=?,sal=?,comm=?,deptno=? where empno=?";
        PreparedStatement preparedStatement = null;
        int num = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,ename);
            preparedStatement.setString(2,job);
            preparedStatement.setInt(3,mgr);
            preparedStatement.setDouble(4,sal);
            preparedStatement.setDouble(5,comm);
            preparedStatement.setInt(6,deptno);
            preparedStatement.setInt(7,empno);

            num = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection,preparedStatement,null); //释放数据库资源，因为没有记录集对象，所以，用null
        }
        return num;  //返回受影响的行数
    }
}
