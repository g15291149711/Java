package emp;

/**
 * 操作Emp的类，提供给用户使用
 */
public class EmpAction {
    private Emp emp = new Emp();
    public void setEmpValue(String str)throws Exception{
        BeanUtil.setBeanValue(this,str);
    }
    public Emp getEmp(){
        return this.emp;
    }
}
