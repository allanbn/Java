import java.math.BigDecimal;

public class ContaCorrente{
    private static int proxID = 1;
    private int numero;
    private String titular;
    private BigDecimal bigDecSaldo;

    private void calculaCPMF(BigDecimal valorDeSaque){
        BigDecimal porcento = new BigDecimal(0.01);
        BigDecimal resultado = valorDeSaque.multiply(porcento);
        this.descontaCPMF(resultado);
    }
    private void descontaCPMF(BigDecimal valor){
        this.bigDecSaldo = this.bigDecSaldo.subtract(valor);
    }

    public ContaCorrente(String nome, BigDecimal valorInicial){
        this.numero = ContaCorrente.proxID;
        this.titular = nome;
        this.bigDecSaldo = valorInicial;
        proxID++;
    }

    public void setTitular(String titulo){
        this.titular = titulo;
    }

    public int getNumero(){
        return this.numero;
    }
    public String getTitular(){
        return this.titular;
    }
    public String getBigDecSaldo(){
        return this.bigDecSaldo.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }

    public void Saque(BigDecimal valor){
        if(valor.compareTo(this.bigDecSaldo) < 0){
            this.bigDecSaldo = this.bigDecSaldo.subtract(valor);
            this.calculaCPMF(valor);
        }
    }
    public void Deposito(BigDecimal valor){
        BigDecimal comparador = new BigDecimal(0);
        if(valor.compareTo(comparador) > 0 ){
            this.bigDecSaldo = this.bigDecSaldo.add(valor);
        }
    }

}