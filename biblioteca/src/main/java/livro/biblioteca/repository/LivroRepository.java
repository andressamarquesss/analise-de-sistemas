package livro.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import livro.biblioteca.domain.Livro;

@Repository
public class LivroRepository {

    private final List<Livro> livros = new ArrayList<>();
    
    public LivroRepository() {
        // Dados iniciais para teste
        livros.add(new Livro(2024, "Jennifer Lynn", "Academia dos Casos arquivados", "234098"));
        livros.add(new Livro(2019, "Colleen Hoover", "Verity ", "890456"));
        livros.add(new Livro(2015, "Colleen Hoove", "Novembro, 9", "898202"));
    }

    public List<Livro> buscarTodos() {
        return new ArrayList<>(livros); 
    }
    
    public List<Livro> buscarPorTitulo(String titulo) {
        return livros.stream()
                   .filter(livro -> livro.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                   .collect(Collectors.toList());
    }
    
    public List<Livro> buscarPorAutor(String autor) {
        return livros.stream()
                   .filter(livro -> livro.getAutor().toLowerCase().contains(autor.toLowerCase()))
                   .collect(Collectors.toList());
    }
    
    public Livro buscarPorIsbn(String isbn) {
        return livros.stream()
                   .filter(livro -> livro.getIsbn().equals(isbn))
                   .findFirst()
                   .orElse(null);
    }
    
    public void adicionar(Livro livro) {
        livros.add(livro);
    }
}