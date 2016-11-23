package JoiceCazanoskiGomesAndersonCossulTrabGB;

public class Teste {
	public static void main(String[] args){
		//for para todos os dias úteis do mês
	//	for(int i = 1; i <= 22; i++){ 
		
		int numSenha = 1;
		
			//gera o número de pessoas
			int pessoas = 600 + (int)(Math.random()*200);
			
			//calcula 20%
			int prior = (pessoas*20)/100;
			
			Queue<Cidadao> filaGeral = new ArrayQueue<Cidadao>(pessoas);
			
			//adiciona TODOS na fila geral
			for(int x = 0; x < pessoas; x++){
				if(prior > 0 && isPrimo(x)){
					prior--;					
					Cidadao a = new Cidadao(geradorDeServico(), true);							
					a.setSenha(geradorDeSenhas(a, numSenha));
					numSenha++;
					filaGeral.enqueue(a);
					//System.out.println("\n" + a.toString());
				}
				
				else if((prior > 0 && !isPrimo(x)) || prior == 0){
					Cidadao a = new Cidadao(geradorDeServico(), false);							
					a.setSenha(geradorDeSenhas(a, numSenha));
					numSenha++;				
					filaGeral.enqueue(a);	
					//System.out.println("\n" + a.toString());
				}									
			}
			
			NodeQueue<Cidadao> iptuNormal = new NodeQueue<>();  int iA = 5;
			NodeQueue<Cidadao> iptuPr = new NodeQueue<>();	    int iV = 3;
			
			NodeQueue<Cidadao> protNormal = new NodeQueue<>();  int pA = 5;
			NodeQueue<Cidadao> protPr = new NodeQueue<>();      int pV = 3;
			
			NodeQueue<Cidadao> saudeNormal = new NodeQueue<>(); int sA = 5;
			NodeQueue<Cidadao> saudePr = new NodeQueue<>();     int sV = 3;
			
			
			while(iA > 0 || iV > 0 || pA >0 || pV > 0 || sA > 0 || sV > 0){
				Cidadao p = filaGeral.dequeue();
				if(p.getServ().equalsIgnoreCase("IPTU") && !p.isPr() && iA > 0){
					iptuNormal.enqueue(p);
					iA--;
				}
				
				else if(p.getServ().equalsIgnoreCase("IPTU") && p.isPr() && iV > 0){
					iptuPr.enqueue(p);
					iV--;
				}
				
				else if(p.getServ().equalsIgnoreCase("protocolo") && !p.isPr() && pA > 0){
					protNormal.enqueue(p);
					pA--;
				}
				
				else if(p.getServ().equalsIgnoreCase("protocolo") && p.isPr() && pV > 0){
					protPr.enqueue(p);
					pV--;
				}
				
				else if(p.getServ().equalsIgnoreCase("saúde") && !p.isPr() && sA > 0){
					saudeNormal.enqueue(p);
					sA--;
				}
				
				else if(p.getServ().equalsIgnoreCase("saúde") && p.isPr() && sV > 0){
					saudePr.enqueue(p);
					sV--;
				}
			}
			
			while(!iptuNormal.isEmpty())
				System.out.println(iptuNormal.dequeue().toString() + "\n");
			
			while(!iptuPr.isEmpty())
				System.out.println(iptuPr.dequeue().toString() + "\n");
			
			while(!protNormal.isEmpty())
				System.out.println(protNormal.dequeue().toString() + "\n");
			
			while(!protPr.isEmpty())
				System.out.println(protPr.dequeue().toString() + "\n");
			
			while(!saudeNormal.isEmpty())
				System.out.println(saudeNormal.dequeue().toString() + "\n");
			
			while(!saudePr.isEmpty())
				System.out.println(saudePr.dequeue().toString() + "\n");
			
		}


	
	public static String geradorDeSenhas(Cidadao c, int num){
		String senha = "";
		if(c.getServ().equalsIgnoreCase("IPTU"))
			senha+="A";
		else if(c.getServ().equalsIgnoreCase("protocolo"))
			senha+="B";
		else if(c.getServ().equalsIgnoreCase("saúde"))
			senha+="C";
		
		senha+=num;
		
		if(c.isPr()) senha+="pr";
		else senha += "npr";
				
		return senha;
		
	}
	
	public static String geradorDeServico(){
		String serv = "";
		int s =  1 + (int)(Math.random()*3);
		
		switch(s){
		case 1:
			serv = "IPTU";
			break;
			
		case 2:
			serv = "protocolo";
			break;
		
		case 3:
			serv = "saúde";
			break;
		}
		
		return serv;
		
				
	}
	
	public static boolean isPrimo(int n){
		if(n == 0 || n == 1 || n == 2)
			return false;
		
		else
			for(int i = 2; i <= Math.sqrt(n); i++){
				if(n % i == 0)
					return false;
			}	
		return true;
	}
}
