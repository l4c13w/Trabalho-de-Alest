public class ListaNotaFiscal {
    private NotaFiscal inicio;
    private NotaFiscal fim;
    private int quantidade;

    public ListaNotaFiscal(){
        inicio = null;
        fim = null;
        quantidade = 0;
    }
    
    public void adicionar(NotaFiscal notaFiscal) {
        if(quantidade==0) {
            inicio = notaFiscal;
            inicio.proximo = fim;
            fim = notaFiscal;
            fim.anterior = inicio;
        }
        else {
            NotaFiscal aux = inicio;
            if(notaFiscal.getNumero().compareTo(inicio.getNumero()) < 0){
                notaFiscal.setProximo(inicio);
                inicio.setAnterior(notaFiscal);
                inicio = notaFiscal;
            } else if(notaFiscal.getNumero().compareTo(fim.getNumero()) > 0){
                fim.setProximo(notaFiscal);
                notaFiscal.setAnterior(fim);
                fim = notaFiscal;
            } else{
                while (notaFiscal.getNumero().compareTo(aux.getNumero()) >= 0) {
                    aux = aux.getProximo();
                }
                notaFiscal.setProximo(aux);
                aux.getAnterior().setProximo(notaFiscal);
                notaFiscal.setAnterior(aux.getAnterior());
                aux.setAnterior(notaFiscal);
            }
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
            str += aux + "\n\n";
            aux = aux.proximo;
        }
        return str;
    }
}
