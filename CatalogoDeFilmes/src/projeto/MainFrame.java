package projeto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame {

    //    ao criar algo no mainFrame, ele aparece aqui
    private final Catalogo catalogo = new Catalogo();
    private JButton botaoCadastrarFilme;
    private JButton botaoCadastrarAtor;
    private JButton botaoCadastrarDiretor;
    private JButton botaoAssociar;
    private JButton botaoPesquisarFilme;
    private JPanel mainPanel;
    private JLabel dialogoBox;
    private JButton botaoListarFilmes;


    public MainFrame() {

//      Informações sobre o mainFrame
        JFrame jFrame = new JFrame();
        setContentPane(mainPanel);
        setTitle("Santander Filmes");
        setSize(450, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        dialogoBox.setText("Olá, " + System.getProperty("user.name") + "!");

        botaoCadastrarFilme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

//                exemplo de código para editar informações no mainFrame caso o botão seja alterado
//                input.setText("teste");
//                dialogoBox.setText("Digite o nome do filme:");
//                String nome2 = input.getText();

//              captar informações do ussuário


                String nome = JOptionPane.showInputDialog(jFrame, "Digite o nome do filme");
                if (nome == null) {
                    return;
                }
                String descricao = JOptionPane.showInputDialog(jFrame, "Digite a descrição do filme:");
                if (descricao == null) {
                    return;
                }
                String dataLancamento = JOptionPane.showInputDialog(jFrame, "Digite a data de lançamento do filme:");
                if (dataLancamento == null) {
                    return;
                }
                String orcamento = JOptionPane.showInputDialog(jFrame, "Digite o orçamento do filme:");
                if (orcamento == null) {
                    return;
                }
                String nomeDiretor = JOptionPane.showInputDialog(jFrame, "Digite o nome do diretor do filme:");
                if (nomeDiretor == null) {
                    return;
                }
                Diretor diretor = catalogo.buscarDiretorPorNome(nomeDiretor);

                Filme filme = new Filme(nome, dataLancamento, orcamento, descricao, diretor);
                catalogo.cadastrarFilme(filme);

                JOptionPane.showMessageDialog(MainFrame.this, "Filme cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        botaoCadastrarAtor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = JOptionPane.showInputDialog(jFrame, "Digite o nome do ator:");
                if (nome == null) {
                    return;
                }
                String idade = JOptionPane.showInputDialog(jFrame, "Digite a idade do ator:");
                if (idade == null) {
                    return;
                }

                Ator ator = new Ator(nome, idade);
                catalogo.cadastrarAtor(ator);
                JOptionPane.showMessageDialog(MainFrame.this, "Ator cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        botaoCadastrarDiretor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = JOptionPane.showInputDialog(jFrame, "Digite o nome do diretor:");
                if (nome == null) {
                    return;
                }
                String idade = JOptionPane.showInputDialog(jFrame, "Digite a idade do diretor:");
                if (idade == null) {
                    return;
                }
                Diretor diretor = new Diretor(nome, idade);
                catalogo.cadastrarDiretor(diretor);
                JOptionPane.showMessageDialog(MainFrame.this, "Diretor(a) cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        botaoAssociar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do {
                    String nomeFilme = JOptionPane.showInputDialog(jFrame, "Digite o nome do filme ao qual deseja associar atores e diretor:");
                    if (nomeFilme == null) {
                        break; // Usuário cancelou a operação
                    }

                    Filme filme = catalogo.buscarFilmePorNome(nomeFilme);
                    if (filme == null) {
                        JOptionPane.showMessageDialog(jFrame, "Filme não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                        continue; // Tenta novamente
                    }

                    String nomeDiretor = JOptionPane.showInputDialog(jFrame, "Digite o nome do diretor do filme:");
                    if (nomeDiretor == null) {
                        break; // Usuário cancelou a operação
                    }

                    Diretor diretor = catalogo.buscarDiretorPorNome(nomeDiretor);
                    if (diretor == null) {
                        JOptionPane.showMessageDialog(jFrame, "Diretor não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                        continue; // Tenta novamente
                    }

                    filme.setDiretor(diretor);

                    String numAtoresStr = JOptionPane.showInputDialog(jFrame, "Digite o número de atores que deseja associar ao filme:");
                    if (numAtoresStr == null) {
                        break; // Usuário cancelou a operação
                    }

                    try {
                        int numAtores = Integer.parseInt(numAtoresStr);
                        for (int i = 0; i < numAtores; i++) {
                            String nomeAtor = JOptionPane.showInputDialog(jFrame, "Digite o nome do ator:");
                            if (nomeAtor == null) {
                                break; // Usuário cancelou a operação
                            }

                            Ator ator = catalogo.buscarAtorPorNome(nomeAtor);
                            if (ator == null) {
                                JOptionPane.showMessageDialog(jFrame, "Ator não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                                continue; // Tenta novamente
                            }
                            filme.adicionarAtor(ator);
                        }
                        JOptionPane.showMessageDialog(MainFrame.this, "Filme associado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        break; // Sai do loop
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(jFrame, "Número de atores inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                        // Tenta novamente
                    }
                } while (true);
            }
        });
        botaoPesquisarFilme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeFilme = JOptionPane.showInputDialog(jFrame, "Digite o nome do filme que deseja pesquisar:");
                if (nomeFilme == null) {
                    return;
                }
                Filme filme = catalogo.buscarFilmePorNome(nomeFilme);

                if (filme == null) {
                    JOptionPane.showMessageDialog(jFrame, "Filme não encontrado.");
                } else {
                    StringBuilder infoFilme = new StringBuilder();
                    infoFilme.append("Nome: ").append(filme.getNome()).append("\n");
                    infoFilme.append("Descrição: ").append(filme.getDescricao()).append("\n");
                    infoFilme.append("Data de Lançamento: ").append(filme.getDataLancamento()).append("\n");

                    Diretor diretor = filme.getDiretor();
                    if (diretor != null) {
                        infoFilme.append("Diretor: ").append(diretor.getNome()).append(" (Idade: ").append(diretor.getIdade()).append(")\n");
                    } else {
                        infoFilme.append("Diretor não associado a este filme.\n");
                    }

                    List<Ator> atores = filme.getAtores();
                    if (!atores.isEmpty()) {
                        infoFilme.append("Atores associados:\n");
                        for (Ator ator : atores) {
                            infoFilme.append("- ").append(ator.getNome()).append(" (Idade: ").append(ator.getIdade()).append(")\n");
                        }
                    } else {
                        infoFilme.append("Nenhum ator associado a este filme.\n");
                    }

                    infoFilme.append("Orçamento: ").append(filme.getOrcamento()).append("\n");
                    JOptionPane.showMessageDialog(jFrame, infoFilme.toString());
                }
            }
        });

        botaoListarFilmes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Filme> filmesCadastrados = catalogo.getFilmes();

                if (filmesCadastrados.isEmpty()) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Nenhum filme cadastrado.", "Filmes cadastrados", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    StringBuilder listaFilmes = new StringBuilder("Filmes cadastrados:\n");
                    for (Filme filme : filmesCadastrados) {
                        listaFilmes.append("- ").append(filme.getNome()).append("\n");
                    }
                    JOptionPane.showMessageDialog(MainFrame.this, listaFilmes.toString(), "Lista de Filmes", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
    }
}
