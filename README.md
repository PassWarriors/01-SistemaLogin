# 🔐 Sistema de Login

Projeto desenvolvido na disciplina de **Programação Orientada a Objetos (POO)**.

O objetivo do sistema de login é identificar o usuário, levando o mesmo para uma tela de seleção. Onde ele pode selecionar entre a **Agenda de Contatos** ou o **PassGuardians**.

## 🔑 Autenticação

O acesso é feito com **usuário e senha**. As senhas não ficam em texto puro: são guardadas como **hash SHA-256** no arquivo `usuarios.txt`, que é criado automaticamente na primeira execução (na pasta raiz do projeto) e **não é enviado ao GitHub**.

Existem dois tipos de usuário:

| Tipo | O que pode fazer |
|---|---|
| Comum | Acessar a Agenda de Contatos e o PassGuardians |
| Admin | Tudo do usuário comum + cadastrar novos usuários |

Usuário de teste, criado automaticamente:

| Usuário | Senha | Tipo |
|---|---|---|
| `admin` | `1234` | Admin |

Após **3 tentativas** de login incorretas, o acesso é bloqueado.

## 🧱 Estrutura do projeto

| Pacote | Classes | Função |
|---|---|---|
| `br.edu.principal` | `Main` | Ponto de entrada do programa |
| `br.edu.modelo` | `Usuario`, `UsuarioComum`, `UsuarioAdmin` | Representam os usuários |
| `br.edu.repositorio` | `RepositorioUsuarios`, `UsuarioRepositorioArquivo` | Guardam e buscam os usuários |
| `br.edu.servico` | `Autenticador` | Regras do login e do cadastro |
| `br.edu.visao` | `TelaLogin` | Interação com o usuário |


## ▶️ Como executar

1. Baixe ou clone este repositório.
2. Abra no **Eclipse** (ou crie um projeto Java e copie a pasta `src`).
3. Use **Java 8** ou superior.
4. Execute a classe `br.edu.principal.Main` (botão direito → *Run As* → *Java Application*).
5. Entre com `admin` / `1234`.

A versão atual funciona pelo console. A interface gráfica com Java Swing está em desenvolvimento.

## 🛠️ Tecnologias

- Java
- Java Swing (em desenvolvimento)
- Eclipse IDE
- Git e GitHub

## Projeto desenvolvido pela equipe PassWarriors.

### Integrantes

- João Marcos
- Júlio César
- John Keyrrison
- Luana de Sousa
- Arthur Trindade

## 📚 Disciplina

**Programação Orientada a Objetos — POO**
Instituto Federal de Educação, Ciência e Tecnologia do Ceará — IFCE
2026.2
