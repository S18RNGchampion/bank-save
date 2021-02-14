import java.util.Scanner;
class numberError extends Exception{
    private String error;
    numberError(String error){
        this.error=error;
    }
    public String getMessage(){
        return this.error;
    }
}
public class Main{
    public static double balance=5000;
    public static int a=0;
    public static void main(String []args) throws numberError {
        while (a != 3) {
            System.out.println("----欢迎来到世平银行,当前你拥有" + balance + "元!----");
            System.out.println("-----------------1.存钱--------------");
            System.out.println("-----------------2.取钱--------------");
            System.out.println("-----------------3.退出--------------");

            Scanner input = new Scanner(System.in);
            try {
                a = Integer.parseInt(input.next());
                testNumber(a);

            } catch (NumberFormatException e) {
                System.out.println("请输入整数而不是其他任意字符!");
            } catch (numberError e) {
                System.out.println(e.getMessage());
            }
            switch (a) {
                case 1:
                    cunqian();
                    break;
                case 2:
                    quqian();
                    break;
                case 3:
                    System.out.println("感谢使用!");
            }
        }
    }
    static int testNumber(int number) throws numberError{
        if(number==1){
            return number;
        }
        if(number==2){
            return number;
        }
        if(number==3){
            return number;
        }
        else{
            throw new numberError("请输入1,2,3而不是其他整数!");
        }
    }
    static void cunqian() throws numberError{
        double cun=0;
        System.out.print("请输入存多少钱:");
        Scanner input=new Scanner(System.in);
        try {
            cun = Double.parseDouble(input.next());
            testNumber01(cun);
            balance=cun+balance;
        } catch (NumberFormatException e){
            System.out.println("请输入数字而不是其他任意字符!");
        }catch (numberError e){
            System.out.println(e.getMessage());
        }
    }
    static void testNumber01(double cun) throws numberError{
        if(cun<0){
            throw new numberError("数字必须大于0!");
        }
    }
    static void testNumber02(double qu) throws numberError{
        if(qu>balance)
            throw new numberError("取钱数大于当前存款!");
    }
    static void quqian()throws numberError{
        double qu=0;
        System.out.print("请输入取多少钱:");
        Scanner input=new Scanner(System.in);
        try {
            qu = Double.parseDouble(input.next());
            testNumber01(qu);
            testNumber02(qu);
            balance=balance-qu;
        }catch(NumberFormatException e){
            System.out.println("请输入数字而不是其他任意字符!");
        }catch(numberError e){
            System.out.println(e.getMessage());
        }
    }
}