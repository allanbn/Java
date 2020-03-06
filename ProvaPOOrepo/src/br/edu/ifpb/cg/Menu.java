package br.edu.ifpb.cg;

import br.edu.ifpb.cg.Midias.BluRay;
import br.edu.ifpb.cg.Midias.CD;
import br.edu.ifpb.cg.Midias.DVD;
import br.edu.ifpb.cg.Midias.Midia;
import br.edu.ifpb.cg.Pessoas.Cliente;
import br.edu.ifpb.cg.Pessoas.Funcionario;

import br.edu.ifpb.cg.domain.Locacao;
import br.edu.ifpb.cg.domain.Locadora;
import br.edu.ifpb.cg.domain.Periodo;

import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Menu {

    private Locadora loc;
    private Scanner sc;
    private static final String LS = System.lineSeparator();


    public Menu(Locadora loc, Scanner sc) {
        this.loc = loc;
        this.sc = sc;
    }

    private Long obterCPF() {
        Long op = null;
        while (op == null) {
            System.out.println("Digite um CPF (11 digitos sem símbolos): ");
            String cpf = sc.nextLine();
            if (cpf.length() == 11){
                try {
                    op = Long.parseLong(sc.nextLine());
                }
                catch (NumberFormatException e) {
                    System.out.println("Uma entrada válida!");
                }
            }
            else {
                System.out.println("Quantidade de caractes inválido!");
            }
        }
        return op;
    }

    private Date obteData() {
        Date op = null;
        while (op == null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("Informe uma data no formato \"dd/MM/yyy\": ");
                String data = sc.nextLine();
                op = sdf.parse(data);
            }
            catch (ParseException e) {
                System.out.println("Uma entrada válida!");
            }
        }
        return op;
    }

    private Double obterDouble() {
        Double op = null;
        while (op == null) {
            try {
                op = Double.parseDouble(sc.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Uma entrada válida!");
            }
        }
        return op;
    }

    private Integer obterInteger() {
        Integer op = null;
        while (op == null) {
            try {
                op = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Uma entrada válida!");
            }
        }
        return op;
    }

    private Long obterID() {
        Long op = null;
        while (op == null) {
            try {
                op = Long.parseLong(sc.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Uma entrada válida!");
            }
        }
        return op;
    }

    private boolean pegaOpcao() {
        System.out.println("Selecione uma das opções: ");
        int op = this.obterInteger();
        switch (op) {
            case 1:
                this.listarClientes();
                this.exibirMenu();
            case 2:
                this.listarFuncionarios();
                this.exibirMenu();
            case 3:
                this.listarMidias();
                this.exibirMenu();
            case 4:
                this.listarLocacoes();
                this.exibirMenu();
            case 5:
                this.addDVD();
                this.exibirMenu();
            case 6:
                this.addBluray();
                this.exibirMenu();
            case 7:
                this.addCD();
                this.exibirMenu();
            case 8:
                this.addCliente();
                this.exibirMenu();
            case 9:
                this.addFunc();
                this.exibirMenu();
            case 10:
                this.alugarMidia();
                this.exibirMenu();
            case 11:
                this.devolverMidia();
                this.exibirMenu();
            case 12:
                this.removerCliente();
                this.exibirMenu();
            case 13:
                this.removerFunc();
                this.exibirMenu();
            case 14:
                this.removerMidia();
                this.exibirMenu();
            case 15:
                this.removerLocacao();
                this.exibirMenu();
            case 16:
                this.relatorio();
                this.exibirMenu();
            case 17:
                return false;
            default:
                System.out.println("Digite um número válido de opção!");
        }
        return true;
    }

    private boolean relatorio() {
        Double valor = 0D;
        for (Locacao i: loc.getLocacoes()) {
            if (i.isPago()) {
                valor += i.getValorAluguel();
                valor += i.getValorMulta();
            }
        }
        System.out.println("Valor de receita: ");
        System.out.println("R$: " + valor);
        return true;
    }

    private boolean removerLocacao() {
        this.listarLocacoes();
        System.out.println("Informe o ID da locação a ser removida: ");
        Long ID = this.obterID();
        Locacao lcc = this.buscarLocacao(ID);
        if (lcc == null) {
            System.out.println("Locação não encontrado!");
        }
        else {
            loc.removeLocacao(lcc);
        }
        return true;
    }

    private boolean removerMidia() {
        this.listarMidias();
        Long ID = this.obterID();
        System.out.println("Informe o ID da mídia a ser removida: ");
        Midia mda = this.buscaMidia(ID);
        if (mda == null) {
            System.out.println("Mídia não encontrado!");
        }
        else {
            boolean semLoc = true;
            for (Locacao i: loc.getLocacoes()) {
                if (i.getMidia().equals(mda)) {
                    semLoc = false;
                }
            }
            if (semLoc) {
                loc.removeMidia(mda);
            }
            else {
                System.out.println("Mídia não pode ser removido pois está associado a uma locação!");
            }
        }
        return true;
    }

    private boolean removerCliente() {
        this.listarClientes();
        System.out.println("Informe o ID do cliente a ser removido: ");
        Long ID = this.obterID();
        Cliente clt = this.buscaCliente(ID);
        if (clt == null) {
            System.out.println("Cliente não encontrado!");
        }
        else {
            boolean semLoc = true;
            for (Locacao i: loc.getLocacoes()) {
                if (i.getCliente().equals(clt)) {
                    semLoc = false;
                }
            }
            if (semLoc) {
                loc.removeCliente(clt);
            }
            else {
                System.out.println("Cliente não pode ser removido pois está associado a uma locação!");
            }
        }
        return true;
    }

    private boolean removerFunc() {
        this.listarFuncionarios();
        System.out.println("Informe o ID do funcionário a ser removido: ");
        Long ID = this.obterID();
        Funcionario fun = this.buscaFuncionario(ID);
        if (fun == null) {
            System.out.println("Funcionário não encontrado!");
        }
        else {
            boolean semLoc = true;
            for (Locacao i: loc.getLocacoes()) {
                if (i.getFuncionario().equals(fun)) {
                    semLoc = false;
                }
            }
            if (semLoc) {
                loc.removeFuncionario(fun);
            }
            else {
                System.out.println("Funcionário não pode ser removido pois está associado a uma locação!");
            }
        }
        return true;
    }

    private boolean devolverMidia() {
        this.listarLocacoes();
        System.out.println("Infome o ID da locação a ser atualizada: ");
        Long ID = this.obterID();
        Locacao locacao = this.buscarLocacao(ID);
        if (locacao == null) {
            System.out.println("Locação não encontrada. Reinicie a operação!");
        }
        else if (locacao.isPago()) {
            System.out.println("Mídia já devolvida!");
        }
        else {
            System.out.println("Informe o valor da multa (caso não for aplicada digite 0): ");
            Double multa = this.obterDouble();
            locacao.setValorMulta(multa);
            System.out.println("O cliente gostou da mídia? (sim ou não) ");
            String gostou = sc.nextLine();
            if (gostou.equals("Sim") || gostou.equals("sim")) {
                locacao.setGostou(true);
            }
            locacao.setPago(true);
        }
        return true;
    }

    private Locacao buscarLocacao(Long ID) {
        Locacao loca = null;
        for (Locacao i: loc.getLocacoes()) {
            if (i.getID().equals(ID)) {
                loca = i;
            }
        }
        return loca;
    }

    private boolean alugarMidia() {
        if (loc.getClientes().size() == 0) {
            System.out.println("Sem clientes cadastrados!");
        }
        else {
            this.listarClientes();
            System.out.println("Informe o ID do cliente que está locando uma mídia: ");
            Long ID = this.obterID();
            Cliente clt = this.buscaCliente(ID);
            if (clt == null) {
                System.out.println("Cliente não encontrado. Reinicie a operação!");
            }
            else {
                if (loc.getFuncionarios().size() == 0) {
                    System.out.println("Sem funcionários cadastrados!");
                }
                else {
                    this.listarFuncionarios();
                    System.out.println("Informe o ID do funcionario que está realizando a locação: ");
                    ID = this.obterID();
                    Funcionario fun = this.buscaFuncionario(ID);
                    if (fun == null) {
                        System.out.println("Funcionário não encontrado. Reinicie a operação!");
                    }
                    else {
                        if (loc.getMidias().size() == 0) {
                            System.out.println("Sem mídias cadastradas!");
                        }
                        else {
                            this.listarMidias();
                            System.out.println("Informe o ID da mídia que está sendo locada: ");
                            ID = this.obterID();
                            Midia mda = this.buscaMidia(ID);
                            if (mda == null) {
                                System.out.println("Mídia inexistente. Reinicie a operação!");
                            }
                            else {
                                Double valorAluguel = this.obterDouble();
                                Date locadoEm = this.obteData();
                                Date devolverEm = this.obteData();
                                Periodo p = new Periodo(locadoEm, devolverEm);
                                Locacao L = this.buscaLocMidia(mda);
                                if (L == null) {
                                    Locacao locacao = new Locacao(clt, fun, mda, valorAluguel, p);
                                    loc.addLocacoes(locacao);
                                }
                                else {
                                    if (p.getDataInicial().after(L.getPeriodo().getDataInicial()) && p.getDataFinal().before(L.getPeriodo().getDataFinal())) {
                                        System.out.println("Mídia já locada neste período. Reinicie o processo!");
                                    }
                                    else if (p.getDataInicial().before(L.getPeriodo().getDataInicial()) && p.getDataFinal().before(L.getPeriodo().getDataFinal())) {
                                        System.out.println("Mídia já locada neste período. Reinicie o processo!");
                                    }
                                    else if (p.getDataInicial().after(L.getPeriodo().getDataInicial()) && p.getDataFinal().after(L.getPeriodo().getDataFinal())) {
                                        System.out.println("Mídia já locada neste período. Reinicie o processo!");
                                    }
                                    else {
                                        Locacao locacao = new Locacao(clt, fun, mda, valorAluguel, p);
                                        loc.addLocacoes(locacao);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private Locacao buscaLocMidia(Midia mda) {
        Locacao L = null;
        for (Locacao i: loc.getLocacoes()) {
            if (i.getMidia().equals(mda)) {
                L = i;
            }
        }
        return L;
    }

    private Midia buscaMidia(Long ID) {
        Midia mda = null;
        for (Midia i: loc.getMidias()) {
            if (i.getID().equals(ID)) {
                mda = i;
            }
        }
        return mda;
    }

    private Funcionario buscaFuncionario(Long ID) {
        Funcionario fun = null;
        for (Funcionario i: loc.getFuncionarios()) {
            if (i.getID().equals(ID)) {
                fun = i;
            }
        }
        return fun;
    }

    private Cliente buscaCliente(Long ID) {
        Cliente clt = null;
        for (Cliente i: loc.getClientes()) {
            if (i.getID().equals(ID)) {
                clt = i;
            }
        }
        return clt;
    }

    private boolean addFunc() {
        System.out.println("Informe o nome do funcionário a ser cadastrado: ");
        String nome = sc.nextLine();
        System.out.println("Informe o CPF do funcionário a ser cadastrado: ");
        Long CPF = this.obterCPF();
        System.out.println("Informe o salário do funcionário a ser cadastrado: ");
        Double salario = this.obterDouble();
        Funcionario lFUN = new Funcionario(nome, CPF, salario);
        loc.addFuncionarios(lFUN);
        return true;
    }

    private boolean addCliente() {
        System.out.println("Informe o nome do cliente a ser cadastrado: ");
        String nome = sc.nextLine();
        System.out.println("Informe o CPF do cliente a ser cadastrado: ");
        Long CPF = this.obterCPF();
        System.out.println("Informe o endereço do cliente a ser cadastrado: ");
        String end = sc.nextLine();
        Cliente lCLI = new Cliente(nome, CPF, end);
        loc.addClientes(lCLI);
        return true;
    }

    private boolean addCD() {
        System.out.println("Informe o título do CD: ");
        String t = sc.nextLine();
        System.out.println("Informe a duração do CD em minutos: ");
        Integer duracao = this.obterInteger();
        System.out.println("Informe o ano que o CD foi lançado: ");
        Integer anoLanc = this.obterInteger();
        System.out.println("Informe a quantidade de faixas que o CD contém: ");
        Integer qntdFaixas = this.obterInteger();
        Midia mCD = new CD(t, duracao, anoLanc, qntdFaixas);
        loc.addMidia(mCD);
        return true;
    }

    private boolean addBluray() {
        System.out.println("Informe do título do Bluray: ");
        String t = sc.nextLine();
        System.out.println("Informe a duração do Bluray em minutos: ");
        Integer duracao = this.obterInteger();
        System.out.println("Informe o ano de lançamento do Bluray: ");
        Integer anoLanc = this.obterInteger();
        System.out.println("Informe se o Bluray tem conteúdo extra (sim ou não): ");
        String temExtra = sc.nextLine();
        boolean tem = false;
        if (temExtra.equals("Sim") || temExtra.equals("sim")) {
            tem = true;
        }
        System.out.println("Informe se a mídia é 3D (sim ou não): ");
        String eh3d = sc.nextLine();
        boolean eh = false;
        if (eh3d.equals("Sim") || eh3d.equals("sim")) {
            eh = true;
        }
        Midia mBLU = new BluRay(t, duracao, anoLanc, tem, eh);
        loc.addMidia(mBLU);
        return true;
    }

    private boolean addDVD() {
        System.out.println("Informe o título do DVD: ");
        String t = sc.nextLine();
        System.out.println("Informe a duração do DVD em minutos: ");
        Integer duracao = this.obterInteger();
        System.out.println("Informe o ano de lançamento do DVD: ");
        Integer anoLanc = this.obterInteger();
        System.out.println("Informe se o DVD tem conteúdo extra (sim ou não): ");
        String temExtra = sc.nextLine();
        boolean tem = false;
        if (temExtra.equals("Sim") || temExtra.equals("sim")) {
            tem = true;
        }
        Midia mDVD = new DVD(t, duracao, anoLanc, tem);
        loc.addMidia(mDVD);
        return true;
    }

    private boolean listarLocacoes() {
        if (loc.getLocacoes().size() == 0) {
            System.out.println("Nenhum locação cadastrada.");
        }
        else {
            for (Locacao i: loc.getLocacoes()) {
                System.out.println(i);
            }
        }
        return true;
    }

    private boolean listarMidias() {
        if (loc.getMidias().size() == 0) {
            System.out.println("Nenhuma mídia cadastrada.");
        }
        else {
            for (Midia i: loc.getMidias()) {
                System.out.println(i);
            }
        }
        return true;
    }

    private boolean listarFuncionarios() {
        if (loc.getFuncionarios().size() == 0) {
            System.out.println("Nenhum funcionário cadastrado.");
        }
        else {
            for (Funcionario i: loc.getFuncionarios()) {
                System.out.println(i);
            }
        }
        return true;
    }

    private boolean listarClientes() {
        if (loc.getClientes().size() == 0) {
            System.out.println("Nenhum cliente cadastrado.");
        }
        else {
            for (Cliente i: loc.getClientes()) {
                System.out.println(i);
            }
        }
        return true;
    }

    private void exibirMenu() {
        System.out.println();
        String menu = "";
        int op = 0;
        menu += ++op + ". Listar clientes;" + LS;
        menu += ++op + ". Listar funcionarios;" + LS;
        menu += ++op + ". Listar mídias;" + LS;
        menu += ++op + ". Listar locações;" + LS;
        menu += ++op + ". Adicionar DVD de filme;" + LS;
        menu += ++op + ". Adicionar Bluray de filme;" + LS;
        menu += ++op + ". Adicionar CD de música;" + LS;
        menu += ++op + ". Adicionar cliente;" + LS;
        menu += ++op + ". Adicionar funcionário;" + LS;
        menu += ++op + ". Alugar mídia;" + LS;
        menu += ++op + ". Devolver mídia;" + LS;
        menu += ++op + ". Remover cliente;" + LS;
        menu += ++op + ". Remover funcionário;" + LS;
        menu += ++op + ". Remover mídia;" + LS;
        menu += ++op + ". Remover locação;" + LS;
        menu += ++op + ". Relatório de receita da Locadora;" + LS;
        menu += ++op + ". Sair." + LS;
        System.out.println(menu);
        this.pegaOpcao();
    }

    public void apresentação() {
        String s = "";
        s += "=======================================" + LS;
        s += "===== LOCADORA XPTO - BEM VINDO! ======" + LS;
        s += "=======================================" + LS;
        System.out.println(s);
        this.exibirMenu();
    }

}
