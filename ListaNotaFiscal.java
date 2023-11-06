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

    NotaFiscal meio(NotaFiscal inicio, NotaFiscal fim){
        if(inicio == null) return null;

        NotaFiscal slow = inicio;
        NotaFiscal fast = inicio.proximo;

        while(fast != fim){
            fast = fast.proximo;
            if(fast != fim){
                slow = slow.proximo;
                fast = fast.proximo;
            }
        }
        return slow;
    }

    NotaFiscal busca(NotaFiscal ini, String valor){
        NotaFiscal start = ini;
        NotaFiscal finish = null;

        do{
            NotaFiscal meio = meio(start, finish);
            
            if(meio == null) return null;

            if(meio.getNumero().equals(valor)){
                return meio;
            } else if(meio.getNumero().compareTo(valor) > 0){
                finish = meio;
            } else{
                start = meio.proximo;
            }
        } while(finish != null || finish != start);

        return null;
    }

    NotaFiscal sort(NotaFiscal a, NotaFiscal b){
        NotaFiscal resultado = null;

        if(a == null) return b;
        if(b == null) return a;

        if(a.getNumero().compareTo(b.getNumero()) <= 0){
            resultado = a;
            resultado.proximo = sort(a.proximo, b);
        } else{
            resultado = b;
            resultado.proximo = sort(a, b.proximo);
        }
        return resultado;
    }

    NotaFiscal merge(NotaFiscal h){
        if(h == null || h.proximo == null) return h;

        NotaFiscal meio = getMeio(h);
        NotaFiscal meioProximo = meio.proximo;

        meio.proximo = null;

        NotaFiscal esquerda = merge(h);

        NotaFiscal direita = merge(meioProximo);

        NotaFiscal ordenada = sort(esquerda, direita);
        return ordenada;
    }

    NotaFiscal getMeio(NotaFiscal h){
        if(h == null) return h;

        NotaFiscal fast = h.proximo;
        NotaFiscal slow = h;

        while(fast != null){
            fast = fast.proximo;
            if(fast != null){
                slow = slow.proximo;
                fast = fast.proximo;
            }
        }
        return slow;
    }

    void ordenar(){
        inicio = merge(inicio);
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
        String str = "";
        for (int i = 0; i < quantidade; i++) {
            str += "Numero: " + inicio.getNumero() +
            " Valor total:" + inicio.getValorTotal() + "\n\n";
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
        ListaNotaFiscal comp = new ListaNotaFiscal();
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
        String str = "";

        for (int i = 0; i < this.quantidade; i++) {
            str += this.inicio;
            inicio = inicio.proximo;
        }

        return str;
    }
}
