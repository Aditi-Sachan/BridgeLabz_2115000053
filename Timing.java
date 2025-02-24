import java.lang.reflect.Method;

class ExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName, Class<?>[] paramTypes, Object... args) throws Exception {
        Method method = obj.getClass().getMethod(methodName, paramTypes);
        long startTime = System.nanoTime();
        method.invoke(obj, args);
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");
    }
}

class Task {
    public void perform() {
        for (int i = 0; i < 1000000; i++);
    }
}

class Timing {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        ExecutionTimer.measureExecutionTime(task, "perform", new Class<?>[]{});
    }
}
