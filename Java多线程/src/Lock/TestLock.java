package Lock;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class NewBLock implements Lock{
    private  Sync sync = new Sync();
    static class Sync extends AbstractQueuedSynchronizer {

        @Override
        //规定同步状态为1
        protected boolean tryAcquire(int arg) {
            if(arg != 1){
                throw new RuntimeException("arg不为1");
            }
            //CAS
            if(compareAndSetState(0,1)){
                //当前线程成功获取到锁
                 setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            //获取当前线程状态
            if(getState() == 0){
                throw  new IllegalArgumentException();//线程状态异常
            }
            //获取锁线程至null
            setExclusiveOwnerThread(null);
            setState(0);
            return super.tryRelease(arg);
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;//表示拿到锁了
        }
    }
    //Lock接口方法
    //----------------------------------------------------------------
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
         sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,time);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
    //----------------------------------------------------------------
}
class  Mythread implements Runnable{
    Lock lock = new NewBLock();
    @Override
    public void run() {
        try {
            lock.lock();
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }
    }
}
public class TestLock {
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
          for(int i = 0; i < 10; i++){
              Thread thread = new Thread(mythread);
          }
    }
}
