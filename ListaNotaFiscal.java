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
            inicio.proximo = fim;
            fim.anterior = inicio;
        }
        else {
            NotaFiscal aux = inicio;
            if(notaFiscal.getNumero().compareTo(inicio.getNumero()) < 0){
                notaFiscal.proximo = inicio;
                inicio.anterior = notaFiscal;
                inicio = notaFiscal;
            } else if(notaFiscal.getNumero().compareTo(fim.getNumero()) > 0){
                fim.proximo = notaFiscal;
                notaFiscal.anterior = fim;
                fim = notaFiscal;
            }
            while(notaFiscal.getNumero().compareTo(aux.getNumero()) <= 0){
                aux = aux.proximo;
            }
            notaFiscal.proximo = aux.proximo;
            aux.proximo = notaFiscal;
            notaFiscal.proximo.anterior = notaFiscal;
            notaFiscal.anterior = aux;
        }
        quantidade++;
    }

    public NotaFiscal busca(String numero){
        NotaFiscal aux = inicio;
        for (int i = 0; i < quantidade; i++) {
            if(aux.getNumero().equals(numero)){
                return aux;
            }
            aux = aux.proximo;
        }
        return null;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public NotaFiscal getInicio(){
        return inicio;
    }

    public NotaFiscal getFim(){
        return fim;
    }

    public String imprimirLista() {
        NotaFiscal aux = inicio;
        String str = "";
        for (int i = 0; i < quantidade; i++) {
            str += "Numero: " + aux.getNumero() +
            " Valor total:" + aux.getValorTotal() + "\n";
            aux = aux.proximo;
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

    @Override
    public String toString() {
        NotaFiscal aux = inicio;
        String str = "";
        for (int i = 0; i < this.quantidade; i++) {
            str += aux;
            aux = aux.proximo;
        }
        return str;
    }
}
