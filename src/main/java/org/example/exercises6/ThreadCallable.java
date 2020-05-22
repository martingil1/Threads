package org.example.exercises6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ThreadCallable implements Callable<Integer>{


    @Override
    public Integer call() throws Exception {

        Integer count = 0;

        for (Integer i = 0; i <= 100; i++) {
            count += i;
        }
        return count;
    }
}
