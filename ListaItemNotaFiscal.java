package Apoio_T2;

public class ListaItemNotaFiscal {
    private ItemNotaFiscal inicio;
    private ItemNotaFiscal fim;
    private int quantidade;

    public void adicionar(ItemNotaFiscal item) {
        if (quantidade == 0) {
            inicio = item;
            fim = item;
        } else {
            fim.setProximo(item);
            fim = item;
        }
        quantidade++;
    }

    public ListaItemNotaFiscal ordena() {
        ListaItemNotaFiscal ordenada = new ListaItemNotaFiscal();
        bubbleSort();
        for (int i = 0; i < quantidade; i++) {
            ordenada.adicionar(inicio);
            inicio = inicio.proximo;
        }
        return ordenada;
    }

    public void troca(double x, double y) {
        // Nothing to do if x and y are the same
        if (x == y) {
            return;
        }

        // Search for x (keep track of prevX and currX)
        ItemNotaFiscal prevX = null, currX = inicio;
        while (currX != null && currX.getValorUnitario() != x) {
            prevX = currX;
            currX = currX.proximo;
        }

        // Search for y (keep track of prevY and currY)
        ItemNotaFiscal prevY = null, currY = inicio;
        while (currY != null && currY.getValorUnitario() != y) {
            prevY = currY;
            currY = currY.proximo;
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null) {
            return;
        }

        // If x is not head of linked list
        if (prevX != null) {
            prevX.proximo = currY;
        } else {
            // Else make y as new head
            inicio = currY;
        }

        // If y is not head of linked list
        if (prevY != null) {
            prevY.proximo = currX;
        } else {
            // Else make x as new head
            inicio = currX;
        }

        // Swap next pointers
        ItemNotaFiscal temp = currX.proximo;
        currX.proximo = currY.proximo;
        currY.proximo = temp;
    }

    public void bubbleSort() {
        if (inicio == null) {
            return;
        }

        int count = 0;
        ItemNotaFiscal start = inicio;
        while (start != null) {
            count++;
            start = start.proximo;
        }

        // Traverse through all nodes of linked list
        for (int i = 0; i < count; i++) {
            // Last i elements are already in place
            ItemNotaFiscal curr = inicio;
            while (curr != null && curr.proximo != null) {
                // Swap adjacent nodes
                if (curr.getValorUnitario() > curr.proximo.getValorUnitario()) {
                    troca(curr.getValorUnitario(), curr.proximo.getValorUnitario());
                }
                curr = curr.proximo;
            }
        }
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
