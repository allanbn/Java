import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {
    public static void main(){
        ContaCorrente nova = new ContaCorrente("Allan", new BigDecimal(300));
        byte n = -1;
        while(n != 5){
            System.out.println("---Projeto Conta Corrente---");
            System.out.println("1. Saque");
            System.out.println("2. Deposito");
            System.out.println("3. Saldo na tela");
            System.out.println("4. Extrato na tela");
            System.out.println("5. SAIR");
            System.out.println("----------------------------");
            System.out.println("Digite uma opção:");
            Scanner in = new Scanner(System.in);
            byte n = in.nextByte();
            if(n == 1){
                Scanner valor = new Scanner(System.in);
                BigDecimal v = new BigDecimal(valor.nextBigInteger());
                nova.Saque(v);
            }
            else if(n == 2){
                Scanner valor = new Scanner(System.in);
                BigDecimal v = new BigDecimal(valor.nextBigInteger());
                nova.Deposito(v);
            }
            else if(n == 3){
                System.out.println("R$ " + nova.getBigDecSaldo());
            }
            else if(n == 4){
                System.out.println("Número: %d\nTitular: ", nova.getNumero(), "Saldo: R$: ",nova.getBigDecSaldo());
            }
            else{
                System.out.println("Digite um valor entre 1 e 5!!!");
            }

        }
        System.out.println("Até logo...");
        System.exit(0);
    }
}
