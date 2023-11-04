package Apoio_T2;

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
            ListaItemNotaFiscal lista;

        }catch(IOException e){
            System.out.println("Erro de E/S");
        }
    }

    public void lerArquivo() throws IOException{
        br.readLine();
        String linha = br.readLine();
        String[] colunas = linha.split("[|]");
        String notaAtual = colunas[0];
        String notaAnterior = notaAtual;
        NotaFiscal nf;
        while (linha != null) {
            colunas = linha.split("[|]");
            if(notaAnterior.equals(notaAtual)) {
                nf = new NotaFiscal(colunas[0], Date.valueOf(colunas[1]), colunas[2], colunas[3], colunas[4], colunas[5], colunas[6]);
                itens = new ListaItemNotaFiscal();
                ItemNotaFiscal item = new ItemNotaFiscal(colunas[7], colunas[8], Integer.parseInt(colunas[9]), Double.parseDouble(colunas[10]));
                itens.adicionar(item);
                nf.setItens(itens);
                notaAnterior = notaAtual;
                System.out.println(nf.getItens().imprimirLista());
            }
            linha = br.readLine();
        }
    }

/*    public static void lerArquivoa() throws IOException {
        String linha;
        String arquivo = "C:\\TEMP\\notas_fiscais_00500.csv";
        BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
        try {
            System.out.println(leitor.readLine()); //pula a primeira linha do cabecalho
            linha = leitor.readLine();
            String[] colunas = linha.split("[|]");
            String notaAtual = colunas[0];
            String notaAnterior = notaAtual;
            NotaFiscal nf = new NotaFiscal();
            nf.setNumero(colunas[0]);
            nf.setData(Date.valueOf(colunas[1]));
            nf.setCliente(colunas[2]);
            ListaItemNotaFiscal items = new ListaItemNotaFiscal();
            nf.setItens(items);
            while ((linha = leitor.readLine()) != null) {
                colunas = linha.split("[|]");
                notaAtual = colunas[0];
                if(!notaAnterior.equals(notaAtual)) {
                    nf = new NotaFiscal();
                    nf.setNumero(colunas[0]);
                    nf.setData(Date.valueOf(colunas[1]));
                    nf.setCliente(colunas[2]);
                    items = new ListaItemNotaFiscal();
                    nf.setItens(items);
                    notaAnterior = notaAtual;
                }
                ItemNotaFiscal item = new ItemNotaFiscal(colunas[7], colunas[8], Integer.parseInt(colunas[9]), Double.parseDouble(colunas[10]));
                items.adicionar(item);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //lista.imprimirLista();
    }

