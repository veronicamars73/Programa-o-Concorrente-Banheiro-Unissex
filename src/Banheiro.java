import java.lang.Thread;
import java.util.Queue;

public class Banheiro extends Thread {
	
	int type;
	public Queue<Pessoa> filaGeral;
	public Pessoa pessoasNoBanheiro[];
	public int capacidade;
	public int generoAtual;
	
	
	Banheiro(Queue<Pessoa> fila, int capacidade) {
		this.filaGeral = fila;
		this.capacidade = capacidade;
		pessoasNoBanheiro = new Pessoa[capacidade];
	}

	public int findBox(){
		for (int i=0; i<capacidade; i++){
			if(pessoasNoBanheiro[i]==null){
				return i;
			}
		}
		return -1;
	}

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