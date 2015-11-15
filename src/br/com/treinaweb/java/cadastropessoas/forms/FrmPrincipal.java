package br.com.treinaweb.java.cadastropessoas.forms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.treinaweb.java.cadastropessoas.componentes.PessoaJTable;
import br.com.treinaweb.java.cadastropessoas.dao.PessoaDao;
import br.com.treinaweb.java.cadastropessoas.model.Pessoa;

public class FrmPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7728015808368381107L;

	public FrmPrincipal() {
		this.setSize(600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(300, 150); // localização na tela ao abrir
		this.setTitle("TreinaWeb - Cadastro de Pessoas");

		JPanel panel = new JPanel();
		panel.setLayout(null);

		// lblId
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 10, 50, 20);
		panel.add(lblId);

		// txtId
		JTextField txtId = new JTextField("");
		txtId.setBounds(55, 10, 515, 20);
		txtId.setEnabled(false);
		panel.add(txtId);

		// lblNome
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 35, 50, 20);
		panel.add(lblNome);

		// txtNome
		JTextField txtNome = new JTextField("");
		txtNome.setBounds(55, 35, 515, 20);
		txtNome.setEnabled(true);
		panel.add(txtNome);

		// lblIdade
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 60, 50, 20);
		panel.add(lblIdade);

		// txtIdade
		JTextField txtIdade = new JTextField("");
		txtIdade.setBounds(55, 60, 515, 20);
		txtIdade.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char tecla = e.getKeyChar();
				if (Character.isAlphabetic(tecla)) {
					e.consume();
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panel.add(txtIdade);

		// tblPessoas
		PessoaJTable tblPessoas = new PessoaJTable();
		tblPessoas.setBounds(10, 110, 550, 280);
		carregarTabela(tblPessoas);
		tblPessoas.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2) {
					Pessoa pessoaSelecionada = tblPessoas.getPessoaSelecionada();
					txtId.setText(String.valueOf(pessoaSelecionada.getId()));
					txtNome.setText(pessoaSelecionada.getNome());
					txtIdade.setText(String.valueOf(pessoaSelecionada.getIdade()));
				}

			}
		});
		panel.add(tblPessoas);

		// btnAdcionnar
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(55, 85, 100, 20);
		btnAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Pessoa novaPessoa = new Pessoa();
				novaPessoa.setNome(txtNome.getText());
				novaPessoa.setIdade(Integer.parseInt(txtIdade.getText()));
				try {
					new PessoaDao().insert(novaPessoa);
					carregarTabela(tblPessoas);
					JOptionPane.showMessageDialog(null, "Pessoa Inserida com Sucesso");
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Houve um Erro ao inserir a Pessoa");
				}
			}
		});
		panel.add(btnAdicionar);

		// btnAlterar
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(160, 85, 100, 20);
		btnAlterar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Pessoa pessoaAlterada = new Pessoa();
				pessoaAlterada.setId(Integer.parseInt(txtId.getText()));
				pessoaAlterada.setNome(txtNome.getText());
				pessoaAlterada.setIdade(Integer.parseInt(txtIdade.getText()));
				try {
					new PessoaDao().update(pessoaAlterada);
					JOptionPane.showMessageDialog(null, "Pessoa Alterada com Sucesso");
					carregarTabela(tblPessoas);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a tabela");
				}
			}
		});
		panel.add(btnAlterar);

		// btnExcluir
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(265, 85, 100, 20);
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Pessoa pessoaExcluida = new Pessoa();
				pessoaExcluida.setId(Integer.parseInt(txtId.getText()));
				try {
					new PessoaDao().delete(pessoaExcluida);
					JOptionPane.showMessageDialog(null, "Pessoa Excluida com Sucesso");
					carregarTabela(tblPessoas);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao tenta excluir uma pessoa");
				}
			}
		});
		panel.add(btnExcluir);

		this.add(panel);

		this.setVisible(true);
	}

	private void carregarTabela(PessoaJTable tabela) {
		try {
			tabela.load(new PessoaDao().all());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Houve um erro ao carregar as pessoas do Banco de Dados");
		}
	}
}
