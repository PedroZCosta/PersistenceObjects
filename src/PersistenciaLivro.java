import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaLivro {
    private final File arquivo = new File("LIVROS.dat");

    public void salvarLivro(Livro livro) {
        List<Livro> listaLivros = recuperarLivro();
        listaLivros.add(livro);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(listaLivros);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar livro", e);
        }
    }

    public List<Livro> recuperarLivro() {
        if (!arquivo.exists() || arquivo.length() == 0) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Livro>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Erro ao recuperar livros", e);
        }
    }
}