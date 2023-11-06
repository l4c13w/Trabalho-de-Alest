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

    public NotaFiscal consultar(String x) {
        NotaFiscal encontrado = this.inicio;
        int start = 0;
        int meio = 0;
        int end = quantidade;

        while (start <= end) {
            meio = (end + start) / 2;

            for (int i = 0; i < meio; i++) {
                encontrado = encontrado.proximo;
                if (encontrado.getNumero().compareTo(x) > 0) {
                    start = meio + 1;
                } else if(encontrado.getNumero().compareTo(x) < 0){
                    end = meio - 1;
                } else{
                    return encontrado;
                }
            }
        }
        return null;
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
