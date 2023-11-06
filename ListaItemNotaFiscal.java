package Apoio_T2;

public class ListaItemNotaFiscal {
    private ItemNotaFiscal inicio;
    private ItemNotaFiscal fim;
    private int quantidade;
    public void adicionar(ItemNotaFiscal item) {
        if(quantidade==0) {
            inicio = item;
            fim = item;
        }
        else {
            fim.setProximo(item);
            fim = item;
        }
        quantidade++;
    }
    @Override
    public String toString() {
        String s = "";
        ItemNotaFiscal aux = inicio;
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
            str += inicio.toString() + "\n";
            inicio = inicio.proximo;
        }
        return str;
    }
}
