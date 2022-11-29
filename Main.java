
import java.util.Random;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main
{
	public static void main(String[] args) {  
        
        int tamanhoFila = 5;
        int capacidade = 10;
        
        Random randomGenerator = new Random();
        
        Queue<Pessoa> pessoas = new LinkedList<Pessoa>();
        for(int i = 0; i < tamanhoFila; i++){
            if(randomGenerator.nextInt(2)==0){
                //homem
                pessoas.add(new Pessoa(0));
            }else{
                //mulher
                pessoas.add(new Pessoa(1));
            }
        }
        Banheiro banheiro = new Banheiro(pessoas, capacidade);

        Iterator<Pessoa> itr = pessoas.iterator();
 
        while (itr.hasNext()){
             itr.next().setBanheiro(banheiro);
         }

       banheiro.run();

        try {
			banheiro.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

    }
}
