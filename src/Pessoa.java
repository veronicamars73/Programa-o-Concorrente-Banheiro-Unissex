import java.lang.Thread;
import java.util.Random;

public class Pessoa extends Thread {
    public int genero;
    public Banheiro banheiro;
    public int box;
    
    public Pessoa(int genero, Banheiro banheiro){
        this.genero = genero;
        this.banheiro = banheiro;
    }

    public Pessoa(int genero){
        this.genero = genero;
    }

    public void setBanheiro(Banheiro b){
        this.banheiro = b;
    }

    public void setBox(int box){
        this.box = box;
    }
    
    @Override	
    public void run() {
        Random randomGenerator = new Random();
        int tempoBanheiro = randomGenerator.nextInt(5) + 1;
        try{
            Thread.sleep(tempoBanheiro);
            System.out.println("Tempo de banheiro: " + tempoBanheiro);
            
        }catch(Exception e){
            System.out.println("An error occurred");
        }
        banheiro.removePessoa(box);
        System.out.println("Removeu do box " + box);
    }
}