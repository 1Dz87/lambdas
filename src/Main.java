import java.io.*;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IOException {
        Integer v = 5;
        Optional<Integer> valueNotNull = Optional.of(v);

        Optional<Integer> valueOpt = Optional.ofNullable(getValue());
        valueOpt.ifPresent(value -> System.out.println("***- " + value + " -***"));
        valueOpt.ifPresentOrElse(
                value -> System.out.println("***- " + value + " -***"),
                () -> new RuntimeException());
        String result = valueOpt
                .filter(i -> i > 0)
                .map(i -> "***- " + i + " -***")
                .orElseThrow(() -> new RuntimeException("Число меньше 0"));
        System.out.println(result);
    }

    public static Integer getValue() {
        Integer i = new RandomNumbersGenerator()
                .getRandomGenerator(100)
                .produce();
        System.out.println(i);
        return i;
    }

    private static void allAtOnce() throws IOException {
        MyPredicate predicate = x -> x > 0;
        System.out.println(predicate.test(6));

        MyProducer producer = new RandomNumbersGenerator().getRandomGenerator(100);
        MyConverterInterface function = i -> "********** " +
                String.valueOf(i) + " **********";
        MyConsumer consumer = (arg) -> System.out.println(arg);
        consumer.consume(function.convert(producer.produce()));
    }

    private static void somef(){
        MyProducer m = () -> 1 + 5;
        RandomNumbersGenerator f = new RandomNumbersGenerator();
        System.out.println(f.getRandomGenerator(6).produce());
        System.out.println(f.getOneProducer().produce());
        System.out.println(m.produce());
    }

    private static MyConsumer fileWriter() {
        return arg -> {
            File file = new File("D:\\lambda.txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("*************");
                writer.write(System.lineSeparator());
                writer.write(arg);
                writer.write(System.lineSeparator());
                writer.write("*************");
            }
        };
    }
    public static void consumeLambda() throws IOException {
        IOService ioService = new IOService();
        DataSourceService dataSourceService = new DataSourceService("Hello world");
        dataSourceService.getString(ioService.print());
        dataSourceService.getString(arg -> System.out.println(arg));
        dataSourceService.getString(fileWriter());
    }
}
