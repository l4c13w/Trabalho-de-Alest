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
            System.out.println(listaNotas.imprimirLista());

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
        listaNotas = new ListaNotaFiscal();
        itens = new ListaItemNotaFiscal();
        NotaFiscal nf = new NotaFiscal(colunas[0], Date.valueOf(colunas[1]), colunas[2], colunas[3], colunas[4], colunas[5], colunas[6]);
        while (linha != null) {
            colunas = linha.split("[|]");
            notaAtual = colunas[0];
            if(!notaAnterior.equals(notaAtual)) {
                nf.setItens(itens);
                listaNotas.adicionar(nf);
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
    }
}

