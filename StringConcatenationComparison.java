class StringConcatenationComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        
        for (int size : sizes) {
            long startTime, elapsedTime;
            
            startTime = System.nanoTime();
            concatenateUsingString(size);
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("String Concatenation Time for " + size + " operations: " + elapsedTime / 1_000_000.0 + " ms");
            
            startTime = System.nanoTime();
            concatenateUsingStringBuilder(size);
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("StringBuilder Concatenation Time for " + size + " operations: " + elapsedTime / 1_000_000.0 + " ms");
            
            startTime = System.nanoTime();
            concatenateUsingStringBuffer(size);
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("StringBuffer Concatenation Time for " + size + " operations: " + elapsedTime / 1_000_000.0 + " ms");
            
            System.out.println();
        }
    }
    
    static void concatenateUsingString(int size) {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += "a";
        }
    }
    
    static void concatenateUsingStringBuilder(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("a");
        }
    }
    
    static void concatenateUsingStringBuffer(int size) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sb.append("a");
        }
    }
}


