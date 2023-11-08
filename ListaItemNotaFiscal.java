public class ListaItemNotaFiscal {
    private ItemNotaFiscal inicio;
    private ItemNotaFiscal fim;
    private double ValorTotal;
    private int quantidade;

    public ListaItemNotaFiscal(){
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
    }

    public void adicionar(ItemNotaFiscal item) {
        if (quantidade == 0) {
            inicio = item;
            fim = item;
        } else {
            fim.setProximo(item);
            fim = item;
        }
        ValorTotal = ValorTotal + item.getValorUnitario();
        quantidade++;
    }

    public double getValorTotal(){
        return ValorTotal;
    }

    public int getQuantidade() {
        return quantidade;
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
}
