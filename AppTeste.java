import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Scanner;

public class AppTeste {
    private BufferedReader br;
    private ListaItemNotaFiscal itens;
    private ListaNotaFiscal listaNotas;
    public AppTeste(){
            try {
                Path path = Paths.get("notas_fiscais_00500.csv");
                br = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));
            }
            catch (IOException e) {
                System.err.format("Erro de E/S: %s%n", e);
            }
    }

    public void executa() {
        try {
            lerArquivo();
            menu();
        }catch(IOException e){
            System.out.println("Erro de E/S");
        }
    }

    public void menu(){
        System.out.println("1 - Consultar dados de uma NF");
        System.out.println("2 - Exibir o número da NF de maior valor");
        System.out.println("3 - Exibir o número da NF de menor valor");
        System.out.println("4 - Exibir o numero da NF com mais itens");
        System.out.printf("5 - Listar todas as NFs");

        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();
        sc.nextLine();
        switch(opcao){
            case 1:
                String find = sc.nextLine();
                System.out.println(listaNotas.consultar(find));
                break;
            case 2:
                System.out.println(listaNotas.maiorValor().getNumero());
                break;
            case 3:
                System.out.println(listaNotas.menorValor().getNumero());
                break;
            case 4:
                System.out.println(listaNotas.maisItens().getNumero());
                break;
            case 5:
                System.out.println(listaNotas.imprimirLista());
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    public void lerArquivo() throws IOException{
        br.readLine();
        String linha = br.readLine();
        String[] colunas = linha.split("[|]");
        String notaAtual = colunas[0];
        String notaAnterior = notaAtual;
        listaNotas = new ListaNotaFiscal();
        itens = new ListaItemNotaFiscal();
        NotaFiscal nf = new NotaFiscal(colunas[0], Date.valueOf(colunas[1]), colunas[2], colunas[3], colunas[4], colunas[5], colunas[6]);
        while (linha != null) {
            colunas = linha.split("[|]");
            notaAtual = colunas[0];
            if(!notaAnterior.equals(notaAtual)) {
                listaNotas.adicionar(nf);
                nf.setItens(itens);
                itens = new ListaItemNotaFiscal();
                nf = new NotaFiscal(colunas[0], Date.valueOf(colunas[1]), colunas[2], colunas[3], colunas[4], colunas[5], colunas[6]);
            }
            ItemNotaFiscal item = new ItemNotaFiscal(colunas[7], colunas[8], Integer.parseInt(colunas[9]), Double.parseDouble(colunas[10]));
            itens.adicionar(item);
            notaAnterior = notaAtual;
            linha = br.readLine();
        }
        nf.setItens(itens);
        listaNotas.adicionar(nf);
        //listaNotas = listaNotas.ordena();
    }
}

