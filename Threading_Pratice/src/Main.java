import com.worker.single.TestRunnable;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TestRunnable tr=new TestRunnable();
        Thread thread1=new Thread(tr);
        thread1.start();
    }
}