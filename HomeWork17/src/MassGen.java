
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class MassGen implements Callable<String> {
private String name;

    public MassGen(String name) {
        this.name = name;

    }

    @Override
    public String call() throws Exception {
        Thread.currentThread().setName(name);
        List<Integer> arrays=new ArrayList<>();
        addNumber(arrays);
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName());

       int summ= calculateSumm(arrays);

        return Integer.toString(summ);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private void addNumber(List<Integer> arrays){
        for(int i=0;i<10;i++){
            arrays.add((int) (Math.random()*10));
        }
    }
    private Integer calculateSumm(List<Integer> arrays){
        int summ=0;
        for (Integer i:arrays) {
            summ+=i;
        }
        return summ;
    }

}
