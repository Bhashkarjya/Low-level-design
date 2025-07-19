import main.java.concurrency.producerConsumer.ProducerConsumer;

public class ProducerConsumerClient {
    public static void main(String[] args) throws InterruptedException{
        ProducerConsumer pc = new ProducerConsumer(3,3);
        pc.startExecution();
    }
}
