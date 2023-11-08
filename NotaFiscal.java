import java.text.DecimalFormat;
import java.util.Date;

public class NotaFiscal {
    private String numero;
    private Date data;
    private String cliente;
    private String cnpjCpf;
    private String endereco;
    private String cidade;
    private String estado;
    private ListaItemNotaFiscal itens;
    public NotaFiscal proximo;
    public NotaFiscal anterior;
    public double valorTotal;

    public NotaFiscal(String numero, Date data, String cliente, String cnpjCpf, String endereco, String cidade, String estado) {
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.cnpjCpf = cnpjCpf;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public void setItens(ListaItemNotaFiscal itens) {
        this.valorTotal = itens.getValorTotal();
        this.itens = itens;
    }

    public String getNumero() {
        return numero;
    }


    public Date getData() {
        return data;
    }


    public String getCliente() {
        return cliente;
    }


    public String getCnpjCpf() {
        return cnpjCpf;
    }


    public String getEndereco() {
        return endereco;
    }


    public String getCidade() {
        return cidade;
    }


    public String getEstado() {
        return estado;
    }

    public ListaItemNotaFiscal getItens() {
        return itens;
    }

    public double getValorTotal(){
        return valorTotal;
    }

    public NotaFiscal getProximo(){
        return this.proximo;
    }

    public NotaFiscal getAnterior(){
        return this.anterior;
    }

    public void setProximo(NotaFiscal proximo){
        this.proximo = proximo;
    }

    public void setAnterior(NotaFiscal anterior){
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("R$#,###.00");
        return "NotaFiscal{" +
                "Numero='" + numero + '\'' +
                ", Data=" + data +
                ", Cliente='" + cliente + '\'' +
                ", CNPJ/CPF='" + cnpjCpf + '\'' + ",\n" +
                "Endereco='" + endereco + '\'' +
                ", Cidade='" + cidade + '\'' +
                ", Estado='" + estado + '\'' +
                " Valor Total=" + df.format(valorTotal) +
                "} \n" +
                "Itens: \n" + '{' + itens + '}';
    }
}