package br.edu.visao;

import br.edu.servico.Autenticador;

import java.util.Scanner;



public class TelaLogin {

  
    private Autenticador autenticador;
    private Scanner sc;

    
    public TelaLogin() {
        this.autenticador = new Autenticador();
        this.sc = new Scanner(System.in);
    }

    
    public void iniciar() {
        while (!autenticador.limiteAtingido()) {
            System.out.print("Usuário: ");
            String usuario = sc.nextLine().trim();

            System.out.print("Senha: ");
            String senha = sc.nextLine();

            if (usuario.isEmpty() || senha.isEmpty()) {
                System.out.println("Preencha usuário e senha.");
                continue;
            }

            if (autenticador.validarLogin(usuario, senha)) {
                abrirMenuPrincipal();
                sc.close();
                return;
            }

            System.out.println("Usuário ou senha incorretos. Tentativa "
                    + autenticador.getTentativas() + " de "
                    + autenticador.getMaxTentativas() + ".");
        }

        bloquearAcesso();
        sc.close();
    }


    private void abrirMenuPrincipal() {
        System.out.println("\nLogin realizado com sucesso! Bem-vindo(a), "
                + autenticador.getUsuarioLogado().getNome() + ".");

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Agenda de Contatos");
            System.out.println("2 - PassGuardians");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    System.out.println("(Agenda de Contatos ainda não conectada)");
                    break;
                case 2:
                   
                    System.out.println("(PassGuardians ainda não conectado)");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

 
    private void bloquearAcesso() {
        System.out.println("\nNúmero máximo de tentativas atingido. Acesso bloqueado.");
        System.exit(0);
    }
}
