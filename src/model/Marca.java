//package model;
//
//public class Marca {
//	private String nome;
//	private String pais;
//	
//	public Marca() {}
//	
//	public Marca (String nome, String pais) {
//		this.nome = nome;
//		this.pais = pais;
//	}
//	
//	public String getNome () {
//		return nome;
//		
//	}
//	
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//	public String getPais() {
//		return pais;
//	}
//	
//	public void setPais(String pais) {
//		this.pais = pais;
//	}
//	
//	public void mostrarDados() {
//		System.out.println("Marca: " + nome);
//		System.out.println("País: " + pais);
//	}
//	
//
//}


package model;
import java.util.ArrayList;

public class Marca {
	private String nome;
	private String pais;
	private ArrayList<Modelo> modelos;
	
	public Marca() {
			modelos = new ArrayList<>();
	}
	
	public Marca (String nome, String pais) {
		this.nome = nome;
		this.pais = pais;
	}
		
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPais() {
		return pais;
			}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public ArrayList<Modelo> getModelos() {
		return modelos;
	}
	public void adicionarModelo(Modelo modelo) {
		modelos.add(modelo);
	}
	public void mostrarModelos() {
		System.out.println("Modelos da marca " + getNome());
		for (Modelo m : getModelos()) {
		System.out.println(m.getNome());
		}
	}
	
	
	
	
}