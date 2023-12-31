import java.text.DecimalFormat;

public class ItemNotaFiscal {
    private String itemNumero;
    private String descricao;
    private int quantidade;
    private double valorUnitario;
    public ItemNotaFiscal proximo;
    public ItemNotaFiscal(String itemNumero, String descricao, int quantidade, double valorUnitario) {
        this.itemNumero = itemNumero;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }
    public String getItemNumero() {
        return itemNumero;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setProximo(ItemNotaFiscal proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("R$#,###.00");
        return "itemNumero='" + itemNumero + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + df.format(valorUnitario);
    }
}
