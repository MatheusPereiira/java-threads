public class numeros_pares implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i += 2) {
            System.out.println("Par: " + i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new numeros_pares());
        thread.start();
    }
}
