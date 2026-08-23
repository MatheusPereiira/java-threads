public class contagem_thread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Contagem: " + i);
        }
    }

    public static void main(String[] args) {
        contagem_thread thread = new contagem_thread();
        thread.start();
    }
}
