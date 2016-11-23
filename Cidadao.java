package JoiceCazanoskiGomesAndersonCossulTrabGB;

public class Cidadao {
	private String serv;
	private boolean pr;
	private String senha;
	
	public Cidadao(){
		serv = null;
		senha = null;
		pr = false;
	}
	
	public Cidadao(String serv, boolean pr){
		this.serv = serv;
		//this.senha = senha;
		this.pr = pr;
	}
	
	public String getServ() {
		return serv;
	}
	
	public void setServ(String serv) {
		this.serv = serv;
	}
	
	public boolean isPr() {
		return pr;
	}
	
	public void setPr(boolean pr) {
		this.pr = pr;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String toString(){
		return "Serviço: " + getServ()
		+ "\nSenha: " + getSenha()
		+ "\nPrioritário: " + isPr();
	}
			
}
