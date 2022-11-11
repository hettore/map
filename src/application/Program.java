package application;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
		
		Map<String, Double> carrosPopulares = new HashMap<>() {{
			put("gol", 14.4);
			put("uno", 15.6);
			put("mobi", 16.1);
			put("hb20", 14.5);
			put("kwid", 15.6);
			
		}};
		
		System.out.println(carrosPopulares);

		System.out.println("Substitua o consumo do gol por 15.2 km/l: ");
		
		carrosPopulares.put("gol", 15.2);
		System.out.println(carrosPopulares);
		
		System.out.println("Confira se o modelo tcson esta no dicionário: " + carrosPopulares.containsKey("uno"));
		
		System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));
		
		System.out.println("Exiba o terceiro modelo adicionado: ");
		//Como no Set não existe uma forma de saber o indice
		
		System.out.println("Exiba os modelos: ");
		
		Set<String> modelos = carrosPopulares.keySet();
		System.out.println(modelos);
		
		System.out.println("Exiba os consumos dos carros: ");
		Collection<Double> consumos =carrosPopulares.values();
		System.out.println(consumos);
		
		System.out.println("Exiba o modelo mais econômico e seu consumo: ");
		
		Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
		Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
		String modeloMaisEficiente = "";
		
		for (Map.Entry<String, Double> entry : entries) {
			if (entry.getValue().equals(consumoMaisEficiente)) {
				modeloMaisEficiente = entry.getKey();
				System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
			}
		}
		
		
		System.out.println("Exiba o modelo menos econômico e seu consumo: ");
		
		Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
		Set<Map.Entry<String, Double>> entries2 = carrosPopulares.entrySet();
		String modeloMenosEficiente = "";
		
		for (Map.Entry<String, Double> entry : entries2) {
			if (entry.getValue().equals(consumoMenosEficiente)) {
				modeloMenosEficiente = entry.getKey();
				System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
			}
		}
		Iterator<Double> iterator = carrosPopulares.values().iterator();
		Double soma = 0.0;
		
		while (iterator.hasNext()) {
			soma += iterator.next();
		}
		System.out.println("Exiba a soma dos consumos: " + soma);
		
		System.out.println("Exiba a média dos consumos deste dicionário de carros: " + soma / carrosPopulares.size());
		
		System.out.println("Remova os modelos com o consumo igual a 15,6 km/l: ");
		
		Iterator<Double> iterator1 = carrosPopulares.values().iterator();
		while(iterator1.hasNext()) {
			if (iterator1.next().equals(15.6)) {
				iterator1.remove();
			}
		}
		System.out.println(carrosPopulares);
		
		System.out.println("Exiba todos os carros na ordem em que foram informados: ");
		
		Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
			put("gol", 14.4);
			put("uno", 15.6);
			put("mobi", 16.1);
			put("hb20", 14.5);
			put("kwid", 15.6);
		}};
		System.out.println(carrosPopulares1);
		
		System.out.println("Exiba o dicionário ordenado pelo modelo: ");
		
		Map<String, Double> carrosPopulares2 = new TreeMap<>() {{
			put("gol", 14.4);
			put("uno", 15.6);
			put("mobi", 16.1);
			put("hb20", 14.5);
			put("kwid", 15.6);
		}};
		System.out.println(carrosPopulares2);
		
		System.out.println("Apague o dicionário de carros: ");
		
		carrosPopulares.clear();
		
		System.out.println("Confira se a lista está vazia: " + carrosPopulares.isEmpty());
		
		System.out.println("-----------------------------------------------");
		System.out.println();
		// Ordenação Map
		
		/*Dadas as seguintes informações sobre meus livros favoritos e seus autores, 
		 * crie um dicionário e ordene este dicionário:
		 * exibindo (Nome Autor - Nome Livro);
		 * 
		 * Autor = Hawking, Stephen - Livro = nome: Uma breve História do Tempo, páginas: 256
		 * Autor = Duhigg, Charles - Livro = nome: O Poder do Hábito, páginas: 408
		 * Autor = Harari, Yuval Noah - Livro = 21 Lições Para o Século 21, páginas: 432
		 */
		
		System.out.println("-- Ordem aleatória");
		
		Map<String, Livro> meusLivros = new HashMap<>() {{
			put("Hawking, Stephen", new Livro("Uma breve História do Tempo", 256));
			put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
			put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
		}};
		
		for (Map.Entry<String, Livro> livro : meusLivros.entrySet()) {
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
		}
		
		
		
		System.out.println("-- Ordem inserção");
		
		Map<String, Livro> meusLivros2 = new LinkedHashMap<>() {{
			put("Hawking, Stephen", new Livro("Uma breve História do Tempo", 256));
			put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
			put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
		}};
		
		for (Map.Entry<String, Livro> livro1 : meusLivros2.entrySet()) {
			System.out.println(livro1.getKey() + " - " + livro1.getValue().getNome());
		}
		
		
		
		System.out.println("-- Ordem alfabética autores");
		
		Map<String, Livro> meusLivros3 = new TreeMap<>(meusLivros2);
		
		for (Map.Entry<String, Livro> livro2 : meusLivros3.entrySet()) {
			System.out.println(livro2.getKey() + " - " + livro2.getValue().getNome());
		}
		
		System.out.println("-- Ordem alfabética nomes dos Livros");
		
		Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
		meusLivros4.addAll(meusLivros.entrySet());
		
		for (Map.Entry<String, Livro> livro2 : meusLivros4) {
			System.out.println(livro2.getKey() + " - " + livro2.getValue().getNome());
		}
		
		System.out.println("-- Ordenar por número de páginas");
		
		Set<Map.Entry<String, Livro>> meusLivros5 = new TreeSet<>(new ComparatorPag());
		meusLivros5.addAll(meusLivros.entrySet());
		
		for (Map.Entry<String, Livro> livro2 : meusLivros5) {
			System.out.println(livro2.getKey() + " - " + livro2.getValue().getNome() + " - " + livro2.getValue().getPaginas() );
		}
		
		
		
}
	
}

class Livro {
	private String nome;
	private Integer paginas;
	
	public Livro(String nome, Integer paginas) {
		super();
		this.nome = nome;
		this.paginas = paginas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, paginas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(paginas, other.paginas);
	}

	@Override
	public String toString() {
		return "livro [nome=" + nome + ", paginas=" + paginas + "]";
	}
	
	
	
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

	@Override
	public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
		// TODO Auto-generated method stub
		return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
	}
	
}

class ComparatorPag implements Comparator<Map.Entry<String, Livro>> {

	@Override
	public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
		// TODO Auto-generated method stub
		return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
	}
	
}



