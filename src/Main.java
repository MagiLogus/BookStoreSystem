import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livro> listaLivro = new ArrayList<>();
        Livro novoLivro = new Livro();
        novoLivro.autor = new Autor();

        System.out.println("Bem vindo ao sistema de cadastro de Livros");

        Scanner leitor = new Scanner(System.in);

        String opcao;

        do {

            System.out.println("Escolha uma opção: 1 - Cadastrar Livro / 2 - Listar Livros / 0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao) {
                case "1":

                    System.out.println("Digite o nome do autor:");
                    novoLivro.autor.nome = leitor.nextLine();

                    System.out.println("Digite o local de nascimento do autor:");
                    novoLivro.autor.localNasc = leitor.nextLine();

                    System.out.println("Digite o titulo do livro:");
                    novoLivro.titulo = leitor.nextLine();

                    System.out.println("Digite o Preço do livro:");
                    novoLivro.preco = leitor.nextFloat();

                    System.out.println("Digite a data de lançamento: (dd/mm/aaaa)");
                    novoLivro.dataLancamento = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    leitor.nextLine();

                    Period lancamento = Period.between(novoLivro.dataLancamento, LocalDate.now());

                    if (lancamento.getYears() >= 5) {
                        System.out.println("Data de lançamento valida!");
                        listaLivro.add(novoLivro);
                        System.out.println("Cadastro realizado com sucesso !");
                    } else {
                        System.out.println("data de lançamento invalida!");
                        break;
                    }
                    break;

                case "2":

                    if (listaLivro.size() > 0) {

                        for (Livro cadaLivro : listaLivro) {
                            System.out.println("Nome do autor:" + cadaLivro.autor.nome);
                            System.out.println("Local Nascimento:" + cadaLivro.autor.localNasc);
                            System.out.println("Titulo do livro:" + cadaLivro.titulo);
                            System.out.println("Preço do livro:" + cadaLivro.preco);
                            System.out.println("Data de lançamento:" + cadaLivro.dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println();
                            System.out.println("Aperte ENTER para continuar");
                            leitor.nextLine();
                        }

                    } else {
                        System.out.println("Lista vazia !");
                    }
                    break;

                case "0":
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }
        } while (!opcao.equals("0"));
    }
}