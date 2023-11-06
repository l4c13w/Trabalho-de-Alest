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
                if (encontrado.getNumero().compareTo(x) > 0) {
                    start = meio + 1;
                } else if(encontrado.getNumero().compareTo(x) < 0){
                    end = meio - 1;
                } else{
                    return encontrado;
                }
                encontrado = encontrado.proximo;
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
            str += "Numero: " + inicio.getNumero() +
            "Valor total:" + inicio.getValorTotal() + "\n\n";
            inicio = inicio.proximo;
        }
        return str;
    }

    public NotaFiscal maiorValor(){
        NotaFiscal a = this.inicio;
        NotaFiscal aux = a;
        for (int i = 0; i < this.quantidade; i++) {
            if(a.getValorTotal() < aux.getValorTotal()){
                a = aux;
            }
            aux = aux.proximo;
        }
        return a;
    }

    public NotaFiscal menorValor(){
        NotaFiscal a = this.inicio;
        NotaFiscal aux = a;
        for (int i = 0; i < this.quantidade; i++) {
            if(a.getValorTotal() > aux.getValorTotal()){
                a = aux;
            }
            aux = aux.proximo;
        }
        return a;
    }

    public NotaFiscal maisItens(){
        NotaFiscal a = this.inicio;
        NotaFiscal aux = a;
        for (int i = 0; i < this.quantidade; i++) {
            if(a.getItens().getQuantidade() < aux.getItens().getQuantidade()){
                a = aux;
            }
            aux = aux.proximo;
        }
        return a;
    }
}
