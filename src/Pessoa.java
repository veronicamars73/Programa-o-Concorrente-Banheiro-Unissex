import java.lang.Thread;
import java.util.Random;

/**
 * Thread que representa a Pessoa e realiza o uso do banheiro
 *
 * @author <a href="mailto:lisandra.melo.095@ufrn.edu.br">Lisandra Melo</a> e <a href="mailto:jose.victor.ferreira.125@ufrn.edu.br">José Victor</a>
 */
public class Pessoa extends Thread {
    /** Gênero da pessoa, 0 -> homem e 1 -> mulher */
    public int genero;
    /** Referencia para o banheiro para aplicação do método de remoção de pessoa */
    public Banheiro banheiro;
    /** Número do índice do box ocupado */
    public int box;
    
    /**
	 * Construtor parametrizado com banheiro 
 	 * @param genero genero do objeto pessoa
     * @param banheiro referência para o banheiro
	 */
    public Pessoa(int genero, Banheiro banheiro){
        this.genero = genero;
        this.banheiro = banheiro;
    }
    
    /**
	 * Construtor parametrizado com gênero 
 	 * @param genero genero do objeto pessoa
	 */
    public Pessoa(int genero){
        this.genero = genero;
    }

    /**
	 * Muda o valor do atributo banheiro.
	 * @param b objeto banheiro a ser adicionado
	 */
    public void setBanheiro(Banheiro b){
        this.banheiro = b;
    }

    /**
	 * Muda o valor do atributo box.
	 * @param box inteiro que representa o índice do box ocupado
	 */
    public void setBox(int box){
        this.box = box;
    }

    /**
	 * Método de execução da thread do objeto.<br>
     * Representa o uso do banheiro usando o sleep e depois remove
     * a pessoa do banheiro.
	 */
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