package br.edu.servico;

import br.edu.modelo.Usuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Autenticador {

    
    private static final int MAX_TENTATIVAS = 3;
    private static final String ARQUIVO_USUARIOS = "usuarios.txt";

    private int tentativas;
    private Usuario usuarioLogado;

    
    public Autenticador() {
        this.tentativas = 0;
        this.usuarioLogado = null;
    }

    

   
    public boolean validarLogin(String nome, String senha) {
        String hashDigitado = gerarHash(senha);

        for (Usuario u : carregarUsuarios()) {
            if (u.getNome().equals(nome) && u.getSenhaHash().equals(hashDigitado)) {
                usuarioLogado = u;
                return true;
            }
        }

        tentativas++;
        return false;
    }

    public boolean limiteAtingido() {
        return tentativas >= MAX_TENTATIVAS;
    }

    public int getTentativas() {
        return tentativas;
    }

    public int getMaxTentativas() {
        return MAX_TENTATIVAS;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    private List<Usuario> carregarUsuarios() {
        File arquivo = new File(ARQUIVO_USUARIOS);
        if (!arquivo.exists()) {
            criarArquivoPadrao();
        }

        List<Usuario> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 2) {
                    lista.add(new Usuario(partes[0], partes[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de usuários: " + e.getMessage());
        }

        return lista;
    }

 
    private String gerarHash(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(senha.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 não disponível", e);
        }
    }


    private void criarArquivoPadrao() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO_USUARIOS))) {
            pw.println("admin;" + gerarHash("1234"));
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo de usuários: " + e.getMessage());
        }
    }
}
