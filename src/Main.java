import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            PersistenciaLivro persistencia = new PersistenciaLivro();

            // Cria e salva livros
            Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 1899, "Livraria Garnier", 1234567890);
            persistencia.salvarLivro(livro1);

            Livro livro2 = new Livro("Código Limpo", "Robert C. Martin", 2008, "ALTA BOOKS", 1234563490);
            persistencia.salvarLivro(livro2);

            // Recupera todos os livros salvos
            List<Livro> livros = persistencia.recuperarLivro();
            for (Livro l : livros) {
                System.out.println(l.toString());
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao executar o programa:");
            e.printStackTrace();
        }
    }
}