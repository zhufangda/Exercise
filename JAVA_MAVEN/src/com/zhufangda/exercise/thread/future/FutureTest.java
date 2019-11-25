package com.zhufangda.exercise.thread.future;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class FutureTest {
    static volatile boolean isFinished = false;
    static AtomicLong compter = new AtomicLong();
    static volatile long startTime = 0;
    static volatile long endTime = 0;
    static volatile double cnt = 0;

    public static void main(String[] args) {

        try(Scanner in = new Scanner(System.in)){
            System.out.print("Enter base directory:");
            String directory = in.nextLine();
            if(directory.equals("")){
                directory = "E:\\github\\Exercise\\JAVA";
            }
            File root = new File(directory);




            /** Multithread method **/
            BlockingQueue<File> blockingQueue = new LinkedBlockingQueue<>();
            compter.set(0);

            startTime = System.nanoTime();

            Runnable producer = () -> {

                isFinished = false;
                System.out.printf("Start to go through directory:%s\n", root.getAbsolutePath());

                findFile(root, blockingQueue);

                isFinished = true;
                endTime = System.nanoTime();
                System.out.printf("Number of file found: %d duration:%f s\n"
                        , compter.get()
                        , ( endTime - startTime)*10e-9);
            };

            new Thread(producer).start();

            Callable<Double> customer = new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    double sum = 0;
                    long nbMission = 0;
                    while(!blockingQueue.isEmpty() || !isFinished){
                        File file = blockingQueue.poll();
                        if(file==null){
                            continue;
                        }
                        nbMission++;
                        sum += file.length()/(1024*1024.0);

                    }
                    //
                    // System.out.printf("%s is finished with %d missions\n", Thread.currentThread(), nbMission);
                    return sum;
                }
            };


            List<Future<Double>> results = new ArrayList<>();

            for(int i=0;i<4;i++){
                FutureTask<Double> task = new FutureTask<>(customer);
                results.add(task);
                new Thread(task).start();
            }

            cnt = 0;
            for(Future<Double> task: results){
                while(!task.isDone()){
                    continue;
                }

                cnt += task.get();
            }

            endTime = System.nanoTime();
            System.out.printf("Mission Complete with %f s: \n\tNumber of file:\t%d \n\tTotal size:\t%f M\n"
                    , (endTime - startTime)*10e-9
                    ,compter.get()
                    ,cnt) ;





            System.out.printf("Start to go through directory:%s\n", root.getAbsolutePath());
            /** Get file lists */

            startTime = System.nanoTime();

            Queue<File> queue = new LinkedList<>();
            findFile(root, queue);

            System.out.printf("Number of file found: %d duration:%f s\n"
                    , queue.size()
                    , (System.nanoTime() - startTime)*10e-9);


            cnt = 0;
            for(File file: queue){
                cnt += file.length()/(1024*1024.0);
            }
            endTime = System.nanoTime();
            System.out.printf("Mission Complete with %f s: \n\tNumber of file:\t%d \n\t Total size:\t%f MB\n"
                    , (endTime - startTime)*10e-9
                    , queue.size()
                    , cnt);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }





    static public void findFile(File root, Queue<File> queue){
        for(File file: root.listFiles()){
            if(file.isDirectory()){
                findFile(file, queue);
            }else{
                queue.offer(file);
                compter.incrementAndGet();
            }
        }
    }


    static public int countLineNumber(File file){
        int nbLine = 0;

        try(Scanner in = new Scanner(file, "UTF-8")){
            while(in.hasNextLine()){
                nbLine ++;
                in.nextLine();
            }
            return nbLine;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return nbLine;
    }
}
