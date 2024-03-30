package com.example.taskClearEyes.service;

import com.example.taskClearEyes.model.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private Task task;

    public Task getTask(Task taskNew) {

        double i = taskNew.getB() * (double) taskNew.getB();
        double i1 = (double) 4 * taskNew.getA() * taskNew.getC();
        if (i - i1 <= 0) taskNew.setError("Отрицательное значение при вычислении основания квадратного корня");
        double sqrt = Math.sqrt(i - i1);

        taskNew.setResultOne(roundingValue(sqrt));
        taskNew.setResultX(roundingValue((taskNew.getB() + roundingValue(sqrt)) / (2 * taskNew.getA())));
        return taskNew;
    }

    public Task getMainPage() {

        if (task == null) {
            task = new Task();
            task.setA(0);
            task.setB(0);
            task.setC(0);
            task.setResultOne(0D);
            task.setResultX(0D);
        }

        return task;
    }

    public Double roundingValue(Double value){

        long round = Math.round(value * 10);

        return (double) round / 10;
    }
}
