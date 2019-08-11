package Fanshe;
interface IComputer{
    void buyComputer();
}
class Macbook implements IComputer{
    public void buyComputer(){
        System.out.println("买一台苹果电脑");
    }
}
class Surfacebook implements IComputer{
    public void buyComputer(){
        System.out.println("买一台微软电脑");
    }
}
class Lenovo implements IComputer{
    public void buyComputer(){
        System.out.println("买一台联想电脑");
    }
}
class Computerfactory {
    public static IComputer getInstance(String type) {//快捷键Alt + enter
        try {
            Class cls = Class.forName(type);
            try {
                IComputer computer = (IComputer) cls.newInstance();
                return computer;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
           return null;
     /*   IComputer computer = null;
        if(type.equals("macbook")){
            computer = new Macbook();
        }else if(type.equals("surface")){
            computer = new Surfacebook();
        }
        return computer;*/
    }
}
public class gongchang{
    public static void main(String[] args)throws Exception {
        IComputer computer = Computerfactory.getInstance("Fanshe.Lenovo");
        computer.buyComputer();
    }
}
//传进来的类名称合法，然后取得Class对象，进而产生实例