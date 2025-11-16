public class AndExample{
    public static void main(String[]args){
        int a=12;
        int b=10;
        int result=a&b;
        int result1=a|b;
        int result2=a^b;
        int result3=~a;
        System.out.println("~a = "+result3);
        System.out.println("a^b = "+result2);
        System.out.println("a&b ="+result);
        System.out.println("a|b ="+result1);
    }
}