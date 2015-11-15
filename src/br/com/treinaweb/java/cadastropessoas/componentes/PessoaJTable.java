package br.com.treinaweb.java.cadastropessoas.componentes;

import java.util.List;

import javax.swing.JTable;

import br.com.treinaweb.java.cadastropessoas.model.Pessoa;

public class PessoaJTable extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6873134176249070237L;

	private PessoaTableModel tableModel;

	public PessoaJTable() {
		this.tableModel = new PessoaTableModel();
		setModel(this.tableModel);
	}

	public void load(List<Pessoa> pessoas){
		this.tableModel.load(pessoas);
	}
	
	public Pessoa getPessoaSelecionada(){
		int index = getSelectedRow();
		return this.tableModel.getPessoaAt(index);
	}
}
