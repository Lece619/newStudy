package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//멀티쓰레딩에 관한 학습을 위한 클래스
public class example_01 {
    ExecutorService service = Executors.newFixedThreadPool(8);
    CountDownLatch latch = new CountDownLatch(15);

}
