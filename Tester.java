//Демонстрація роботи синхронізації з використанням synchronized
public class CounterTester {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
       
        // Створюємо і запускаємо 200 потоків
        for (int i = 0; i < 200; i++) {
            CounterThread ct = new CounterThread(counter);
            ct.start();
        }
       
        // Даємо час всім потокам завершити роботу
        Thread.sleep(1000);
       
        System.out.println("Counter:" + counter.getCounter());
    }
}


//Лічильник з синхронізованим методом
class Counter {
    private long counter = 0L;
    public synchronized void increaseCounter() {
        counter++;
    }
   
    public long getCounter() {
        return counter;
    }
}


//Потік для роботи з лічильником
class CounterThread extends Thread {
    private final Counter counter;
   
    public CounterThread(Counter counter) {
        this.counter = counter;
    }
   
    @Override
    public void run() {
        //Кожен потік збільшує лічильник 1000 разів
        for (int i = 0; i < 1000; i++) {
            counter.increaseCounter();
        }
    }
}
