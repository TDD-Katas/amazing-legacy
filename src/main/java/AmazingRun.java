import ro.bad.Amazing;

public class AmazingRun {
    public static void main(String[] args) {
        Amazing.doit(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        System.out.println(Amazing.result);
    }
}
