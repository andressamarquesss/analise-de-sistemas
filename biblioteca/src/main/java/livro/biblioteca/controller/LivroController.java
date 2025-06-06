package livro.biblioteca.controller;

import org.springframework.web.bind.annotation.*;
import livro.biblioteca.domain.Livro;
import livro.biblioteca.repository.LivroRepository;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Livro> getLivros(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String autor) {
        
        if (titulo != null && !titulo.isEmpty()) {
            return repository.buscarPorTitulo(titulo);
        }
        
        if (autor != null && !autor.isEmpty()) {
            return repository.buscarPorAutor(autor);
        }
        
        return repository.buscarTodos();
    }

    @GetMapping("/{isbn}")
    public Livro getLivroByIsbn(@PathVariable String isbn) {
        Livro livro = repository.buscarPorIsbn(isbn);
        if (livro == null) {
            throw new RuntimeException("Não existe esse isbn informado: " + isbn);
        }
        return livro;
    }

    @PostMapping
    public Livro adicionarLivro(@RequestBody Livro novoLivro) {
        repository.adicionar(novoLivro);
        return novoLivro;
    }
}