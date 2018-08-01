package com.examples;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class testclass {

    public static void main(String[] args) {
        Path[] inFiles = {Paths.get("file1.txt"), Paths.get("file2.txt"), Paths.get("file3.txt")};
        Path[] outFiles = {Paths.get("file1.out.txt"), Paths.get("file2.out.txt"), Paths.get("file3.out.txt")};

        //System.out.println(Paths.get("\\test\\resource\\file1.txt"));

        ExecutorService es=Executors.newFixedThreadPool(3);


        //Thread[] threads=new Thread[inFiles.length];

            for (int i = 0; i < inFiles.length; i++) {
                Adder adder = new Adder(inFiles[i], outFiles[i]);
                es.submit(adder);
                /*threads[i]=new Thread(adder);
                threads[i].start();*/
            }


        try {
            es.shutdown();
            es.awaitTermination(60,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*for (Thread thread:threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

    }
}
