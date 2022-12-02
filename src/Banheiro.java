import java.lang.Thread;
import java.util.Queue;

/**
 * Thread que representa o banheiro e que possui o buffer compartilhado pelas pessoas
 *
 * @author <a href="mailto:lisandra.melo.095@ufrn.edu.br">Lisandra Melo</a> e <a href="mailto:jose.victor.ferreira.125@ufrn.edu.br">José Victor</a>
 */
public class Banheiro extends Thread {
	/** Fila das pessoas na ordem em que foram adicionadas */
	public Queue<Pessoa> filaGeral;
	/** Lista que representa os boxes do banheiro*/
	public Pessoa pessoasNoBanheiro[];
	/** Representa o número de boxes no banheiro */
	public int capacidade;
	/** Gênero das pessoas atualmente no banheiro */
	public int generoAtual;
	
	/**
	 * Construtor parametrizado do banheiro
 	 * @param fila fila de pessoas para o uso do banheiro
     * @param capacidade número de boxes do banheiro
	 */
	Banheiro(Queue<Pessoa> fila, int capacidade) {
		this.filaGeral = fila;
		this.capacidade = capacidade;
		pessoasNoBanheiro = new Pessoa[capacidade];
	}

	/**
	 * Método que retorna o índice do primeiro box disponível, retorna -1 se lotado
	 * @return retorna o índice do box mais próximo disponível, retorna -1 se lotado
	 */
	public int findBox(){
		for (int i=0; i<capacidade; i++){
			if(pessoasNoBanheiro[i]==null){
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método para adição de pessoa no banheiro
 	 * @param p objeto pessoa a ser adicionado no banheiro
	 */
	public synchronized void adicionaPessoa(Pessoa p){
		while (findBox()==-1){
			System.out.println("Banheiro Lotado");
			System.out.println(Thread.currentThread().getName() + " esperando.");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int box_disp = findBox();
		p.setBox(box_disp);
		pessoasNoBanheiro[box_disp] = p;
		p.start();
		filaGeral.remove(p);
		System.out.println(Thread.currentThread().getName() + " adicionou a pessoa do sexo " + ((p.genero == 0) ? "masculino" : "feminino") + " no box " + p.box);
		notify();
	}

	/**
	 * Método para remoção de pessoa no banheiro
 	 * @param box índice do box em que a pessoa a ser removida se encontra
	 */
	public synchronized void removePessoa(int box) {
		while (capacidade == 0) {
			System.out.print("Não há ninguém no banheiro ");
			System.out.print(Thread.currentThread().getName() + " suspensa.\n");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		pessoasNoBanheiro[box]=null;
		System.out.println(Thread.currentThread().getName() + " removeu pessoa no box " + box);
		notify();
	}
	
	/**
	 * Método de execução da thread do objeto banheiro.<br>
     * Realiza o consumo da fila de pessoas realizando adições se essas seguem
	 * as regras do banheiro.
	 */
    @Override
	public void run() {
	    
		while(true){
			if(filaGeral.size() > 0){
				if(findBox()==0){
					generoAtual = filaGeral.peek().genero;
					adicionaPessoa(filaGeral.peek());
					//capacidade+=1;
				}
				else if(capacidade > 0 && findBox()!=-1 && filaGeral.peek().genero == generoAtual){
					adicionaPessoa(filaGeral.peek());
					//capacidade+=1;
				}
			}else{
			    break;
			}
		}

	}
}