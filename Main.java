package readability;

public class Main {
    public static void main(String[] args) {
        //String path = "E:\\important folder\\Data Structure and Algorithms\\Readability Score\\Readability Score\\task\\src\\readability\\test.txt";
        Engine runnable = new Engine(args[0]);
        runnable.run();
    }
}
