package kr.or.bit;

public class Emp {
	private int Empno;
	private String Ename;
	public int getEmpno() {
		return Empno;
	}
	public void setEmpno(int empno) {
		Empno = empno;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	@Override
	public String toString() {
		return "Emp [Empno=" + Empno + ", Ename=" + Ename + "]";
	}
	

	
}
