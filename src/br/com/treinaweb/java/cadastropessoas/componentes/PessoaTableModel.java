package br.com.treinaweb.java.cadastropessoas.componentes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.treinaweb.java.cadastropessoas.model.Pessoa;

public class PessoaTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1904909455414815721L;

	private List<Pessoa> pessoas = new ArrayList<Pessoa>();

	private String[] collumnNames = { "id", "Nome", "Idade" };
	private Class<?>[] collumnTypes = { Integer.class, String.class, Integer.class };

	public void load(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
		fireTableDataChanged();
		// os dados da tabela vão ser alteradas...refresh
	}

	public Pessoa getPessoaAt(int index) {
		if (this.pessoas.size() <= 0) {
			return null;
		}
		return this.pessoas.get(index);
	}

	@Override
	public int getColumnCount() {
		return collumnNames.length;
	}

	@Override
	public int getRowCount() {
		return this.pessoas.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if (this.pessoas.size() <= 0) {
			return null;
		}
		Pessoa p = this.pessoas.get(arg0); // linha
		switch (arg1) { // coluna
		case 0:
			return p.getId();
		case 1:
			return p.getNome();
		case 2:
			return p.getIdade();
		}
		return null;
	}

	public Class<?>[] getCollumnTypes() {
		return collumnTypes;
	}

	public void setCollumnTypes(Class<?>[] collumnTypes) {
		this.collumnTypes = collumnTypes;
	}

}
