import java.util.Random;

public class RandomNumbersGenerator {
    Random random = new Random();

    public MyProducer getRandomGenerator(int upperLimit) {
        return () -> random.nextInt(upperLimit) * (random.nextBoolean() ? -1 : 1);
    }

    public MyProducer getOneProducer() {
        return () -> 1;
    }
}
