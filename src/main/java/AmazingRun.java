import ro.bad.Amazing;

public class AmazingRun {
    public static void main(String[] args) {
        Amazing amaze = new Amazing(0);
        String result = amaze.doit(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        System.out.println(result);
    }
}
