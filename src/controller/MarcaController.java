package controller;
import java.util.List;
import model.BancoDados;
import model.Marca;

public class MarcaController {
	public void salvarMarca(String nome, String pais) {
		Marca marca = new Marca();
		marca.setNome(nome);
		marca.setPais(pais);
		
		BancoDados.marcas.add(marca);								
	}
	public void excluirMarca(int index) {
		BancoDados.marcas.remove(index);
	}
	public Marca buscarMarca (int index) {
		return BancoDados.marcas.get(index);
	}
	public List<Marca> listarMarcas() {
		return BancoDados.marcas;
	}

	
}
