public class IOService {

    public MyConsumer print() {
        return arg -> {
            System.out.println("*************");
            System.out.println("|" + arg + "|");
            System.out.println("*************");
        };
    }
}
