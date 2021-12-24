package com.javaoldman.view;

import com.javaoldman.controller.EmpController;
import com.javaoldman.entity.Emp;

import java.util.List;
import java.util.Scanner;

public class EmpView {
    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        EmpController controller = new EmpController();

        Emp emp = new Emp();
        int option = 0;

        int empno;
        String ename;
        String job;
        int mgr;
        double sal;
        double comm;
        int deptno;


        System.out.println("功能菜单");
        System.out.println("1 列出EMP表的所有记录");
        System.out.println("2 删除EMP表中指定EMPNO的记录，并列出删除后的所有记录");
        System.out.println("3 查询指定EMPNO的记录");
        System.out.println("4 添加新的记录，并列出添加后的所有记录");
        System.out.println("5 修改指定EMPNO的记录的字段信息，显示修改后的该记录");
        System.out.println("6 退出");


        while(true){
            System.out.println("请输入菜单前面的数字，将执行相应的功能：");
            try {
                option = scanner.nextInt();
            }catch (Exception e){  //如果输入的不是数字，提示重新输入
                System.out.println("只能输入数字，请重新输入！");
                continue;
            }
            switch (option){
                case 1:
                    break;
                case 2:
                    System.out.println("请输入要查询的雇员编号，要求是整数");
                    empno = scanner.nextInt();  //获得雇员编号

                    emp.setEmpno(empno);  //将empno值包装到emp对象中
                    break;
                case 3:
                    System.out.println("请输入要删除的雇员编号，要求是整数");
                    empno = scanner.nextInt();  //获得雇员编号

                    emp.setEmpno(empno);  //将empno值包装到emp对象中
                    break;
                case 4:
                    System.out.println("请输入要添加的雇员编号，要求是整数");
                    empno = scanner.nextInt();  //获得雇员编号
                    System.out.println("请输入要添加的雇员名称");
                    ename = scanner.next();
                    System.out.println("请输入要添加的雇员工作");
                    job = scanner.next();
                    System.out.println("请输入要添加的雇员的领导的编号，要求是整数");
                    mgr = scanner.nextInt();
                    System.out.println("请输入要添加的雇员工资，要求是数字");
                    sal = scanner.nextDouble();
                    System.out.println("请输入要添加的雇员资金，要求是数字");
                    comm = scanner.nextDouble();
                    System.out.println("请输入要添加的雇员部门编号，要求只能是10，20，30，40中的一个");
                    deptno = scanner.nextInt();

                    emp.setEmpno(empno);  //将empno值包装到emp对象中
                    emp.setEname(ename);
                    emp.setJob(job);
                    emp.setMgr(mgr);
                    emp.setSal(sal);
                    emp.setComm(comm);
                    emp.setDeptno(deptno);

                    break;
                case 5:
                    System.out.println("请输入要更新的雇员编号，要求是整数");
                    empno = scanner.nextInt();  //获得雇员编号
                    System.out.println("请输入要更新的雇员名称");
                    ename = scanner.next();
                    System.out.println("请输入要更新的雇员工作");
                    job = scanner.next();
                    System.out.println("请输入要更新的雇员的领导的编号，要求是整数");
                    mgr = scanner.nextInt();
                    System.out.println("请输入要更新的雇员工资，要求是数字");
                    sal = scanner.nextDouble();
                    System.out.println("请输入要更新的雇员资金，要求是数字");
                    comm = scanner.nextDouble();
                    System.out.println("请输入要更新的雇员部门编号，要求只能是10，20，30，40中的一个");
                    deptno = scanner.nextInt();

                    emp.setEmpno(empno);  //将empno值包装到emp对象中
                    emp.setEname(ename);
                    emp.setJob(job);
                    emp.setMgr(mgr);
                    emp.setSal(sal);
                    emp.setComm(comm);
                    emp.setDeptno(deptno);
                    break;
                case 6:
                    return; //如果是选择6，则退出程序

            }
            controller.setEmp(emp);  //值emp对象给Controller类
            List<Emp> empList =  controller.doByOption(option);
            for(Emp emp1:empList){
                System.out.println(emp1);
            }
        }
    }
}
