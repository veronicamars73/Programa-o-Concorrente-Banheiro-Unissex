
import java.util.Random;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Thread main que realiza a execução da thread banheiro e inicializa objetos.
 *
 * @author <a href="mailto:lisandra.melo.095@ufrn.edu.br">Lisandra Melo</a> e <a href="mailto:jose.victor.ferreira.125@ufrn.edu.br">José Victor</a>
 */
public class Main
{
	/**
	 * Método main para execução do programa
     * @param args argumentos de linha de comando (não utilizados)
	 */
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
