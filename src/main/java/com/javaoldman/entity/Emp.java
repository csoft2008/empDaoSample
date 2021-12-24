package com.javaoldman.entity;


public class Emp {

  private int empno;
  private String ename;
  private String job;
  private int mgr;
  private double sal;
  private double comm;
  private int deptno;

  public int getEmpno() {
    return empno;
  }

  public String getEname() {
    return ename;
  }

  public String getJob() {
    return job;
  }

  public int getMgr() {
    return mgr;
  }

  public double getSal() {
    return sal;
  }

  public double getComm() {
    return comm;
  }

  public int getDeptno() {
    return deptno;
  }

  public void setEmpno(int empno) {
    this.empno = empno;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public void setMgr(int mgr) {
    this.mgr = mgr;
  }

  public void setSal(double sal) {
    this.sal = sal;
  }

  public void setComm(double comm) {
    this.comm = comm;
  }

  public void setDeptno(int deptno) {
    this.deptno = deptno;
  }

  @Override
  public String toString() {
    return "Emp{" +
            "empno=" + empno +
            ", ename='" + ename + '\'' +
            ", job='" + job + '\'' +
            ", mgr=" + mgr +
            ", sal=" + sal +
            ", comm=" + comm +
            ", deptno=" + deptno +
            '}';
  }
}
