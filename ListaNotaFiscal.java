package Apoio_T2;

public class ListaNotaFiscal {
    private NotaFiscal inicio;
    private NotaFiscal fim;
    private int quantidade;

    public ListaNotaFiscal(){
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
    }
    public void adicionar(NotaFiscal notaFiscal) {
        if(quantidade==0) {
            inicio = notaFiscal;
            fim = notaFiscal;
        }
        else {
            fim.proximo = notaFiscal;
            fim = notaFiscal;
        }
        quantidade++;
    }

    @Override
    public String toString() {
        String s = "";
        NotaFiscal aux = inicio;
        while (aux!=null) {
            s = s + aux + "\n";
            aux = aux.proximo;
        }
        return s;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String imprimirLista() {
        String str = "";
        for (int i = 0; i < quantidade; i++) {
            str += inicio.getItens().imprimirLista() + "\n";
            inicio = inicio.proximo;
        }
        return str;
    }
}
