public class LogicalAndExample{
    public static void main(String[]args){
        int age=25;
        boolean haslicense=true;
        if(age>18&& haslicense){
            System.out.println("Eligible to drive :");
        }else{
            System.out.println("not eligible to drive .");
        }
    }
}