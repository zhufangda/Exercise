public class Interview_2{
    public int k;

    static{
        System.out.println("Static Bloc");
        k = k+1;
    }

    public Interview_2(){
        k++;
    }


    public static void main(String[] args) {
        Interview a = new Interview();
        
        System.out.println(a.k);
        
    }
}