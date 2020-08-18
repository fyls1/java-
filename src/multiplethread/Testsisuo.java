package multiplethread;

import charactor.Heroc;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Testsisuo {

    public static void main(String[] args) {
//        final Heroc weizhi = new Heroc();
//        weizhi.name = "adc";
//        final Heroc weizhi1 = new Heroc();
//        weizhi1.name = "中单";
//        final Heroc weizhi2 = new Heroc();
//        weizhi2.name = "打野";
        Lock lock_adc =new ReentrantLock();
        Lock lock_zhongdan=new ReentrantLock();
        Lock lock_daye=new ReentrantLock();

        Condition condition_adc = lock_adc.newCondition();
        Condition condition_zhongdan = lock_zhongdan.newCondition();
        Condition condition_daye = lock_daye.newCondition();
        Thread t1 = new Thread(){
            public void run(){
                //占有adc
                boolean adcLocked = false;
                boolean zhongdanlocked = false;
                    try {
                        //停顿1000毫秒，另一个线程有足够的时间占有
                        adcLocked = lock_adc.tryLock(10, TimeUnit.SECONDS);
                        if(adcLocked){
                            System.out.println("t1 已占有adc");
                            Thread.sleep(1000);
                            System.out.println("t1 试图占有中单");
                            zhongdanlocked = lock_zhongdan.tryLock(5, TimeUnit.SECONDS);
                            while(!zhongdanlocked){
                                condition_adc.await();
                                zhongdanlocked = lock_zhongdan.tryLock(5, TimeUnit.SECONDS);
                            }
                            condition_zhongdan.signalAll();
                        }else{
                            System.out.println("t1 占有adc失败");
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }finally {
                        if(adcLocked) {
                            lock_adc.unlock();
                        }
                        if(zhongdanlocked) {
                            lock_zhongdan.unlock();
                        }
                    }
//
//                    System.out.println("t1 试图占有中单");
//                    System.out.println("t1 等待中 。。。。");
//                    synchronized (weizhi1) {
//                        System.out.println("do something");
//                    }

            }
        };
        t1.start();
        Thread t2 = new Thread(){
            public void run(){
                //占有中单
//                synchronized (weizhi1) {
                boolean dayeLocked = false;
                boolean zhongdanlocked = false;

                    try {
                         zhongdanlocked = lock_zhongdan.tryLock(10,TimeUnit.SECONDS);
                        //停顿1000毫秒，另一个线程有足够的时间占有暂用
                        if (zhongdanlocked){
                            System.out.println("t2 已占有中单");
                            Thread.sleep(1000);
                            System.out.println("t2 试图占有打野");
                            dayeLocked = lock_daye.tryLock(5,TimeUnit.SECONDS);
                            while (!dayeLocked){
                                condition_zhongdan.await();
                                dayeLocked = lock_daye.tryLock(5,TimeUnit.SECONDS);
                            }
                            condition_daye.signalAll();
                        }else{
                            System.out.println("t2 占有中单失败");
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }finally {
                        if(dayeLocked) {
                            lock_daye.unlock();
                        }
                        if(zhongdanlocked) {
                            lock_zhongdan.unlock();
                        }
                    }
//                    System.out.println("t2 试图占有打野");
//                    System.out.println("t2 等待中 。。。。");
//                    synchronized (weizhi2) {
//                        System.out.println("do something");
//                    }

            }
        };
        t2.start();
        Thread t3 = new Thread(){
            public void run(){
                //占有打野
                boolean dayeLocked = false;
                boolean adcLocked = false;
//                synchronized (weizhi2) {

                    try {
                        dayeLocked = lock_daye.tryLock(10,TimeUnit.SECONDS);
                        if(dayeLocked){
                            //停顿1000毫秒，另一个线程有足够的时间占有
                            System.out.println("t3 已占有打野");
                            Thread.sleep(1000);
                            System.out.println("t3 试图占有adc");
                            adcLocked = lock_adc.tryLock(5,TimeUnit.SECONDS);
                            while (!adcLocked){
                                condition_daye.await();
                                adcLocked = lock_adc.tryLock(5,TimeUnit.SECONDS);
                            }
                            condition_adc.signalAll();
                        }else{
                            System.out.println("t3 占有打野失败");
                        }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }finally {
                        if(dayeLocked) {
                            lock_daye.unlock();
                        }
                        if(adcLocked) {
                            lock_adc.unlock();
                        }
                    }
//                    System.out.println("t3 试图占有adc");
//                    System.out.println("t3 等待中 。。。。");
//                    synchronized (weizhi) {
//                        System.out.println("do something");
//                    }
                }


        };
        t3.start();
    }

}