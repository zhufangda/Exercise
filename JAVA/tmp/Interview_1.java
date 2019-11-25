public class Interview{
    public static int k;

    static{
        System.out.println("Static Bloc");
        k = k+1;
        System.out.println(k);
    }{
        System.out.println("No static bloc");
        k=k+1;
        System.out.println(k);
    }

    public Interview(){
        k++;
        System.out.println("Constructor:");
        System.out.println(k);
    }


    public static void main(String[] args) {
        Interview a = new Interview();
        Interview b = new Interview();

        System.out.println(a.k);
        System.out.println(b.k);
    }
}