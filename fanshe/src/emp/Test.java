package emp;
//把多个属性一块设置进去
public class Test {
    public static void main(String[] args) throws Exception {
        String str = "emp.name:guoxiaogang|emp.job:Coder";
        EmpAction empAction = new EmpAction();
        empAction.setEmpValue(str);
        System.out.println(empAction.getEmp());
    }
}
