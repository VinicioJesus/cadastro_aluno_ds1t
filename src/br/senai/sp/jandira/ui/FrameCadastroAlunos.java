package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;
import br.senai.sp.jandira.repository.AlunoRepository;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNome;
	
	private int posicao;

	public FrameCadastroAlunos() {
		
		String[] dias = {
				"Domingo",
				"Segund",
				"Terça"
		};
		
		setTitle("Cadastro de Alunos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matr\u00EDcula:");
		lblNewLabel.setBounds(10, 34, 74, 14);
		contentPane.add(lblNewLabel);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(94, 31, 95, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(94, 59, 138, 20);
		contentPane.add(txtNome);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 62, 74, 14);
		contentPane.add(lblNome);
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo:");
		lblPerodo.setBounds(10, 87, 74, 14);
		contentPane.add(lblPerodo);
		
		JComboBox comboPeriodo = new JComboBox();
		
		DefaultComboBoxModel<String> modelPeriodo = 
				new DefaultComboBoxModel<String>();
		
		for(Periodo p : Periodo.values()) {
			modelPeriodo.addElement(p.getDescricao());	
		}
		
		comboPeriodo.setModel(modelPeriodo);
		
		comboPeriodo.setBounds(94, 90, 95, 22);
		contentPane.add(comboPeriodo);
		
		JButton btnSalvar = new JButton("Salvar Aluno");
		btnSalvar.setBounds(94, 137, 138, 50);
		contentPane.add(btnSalvar);
		
		JLabel lblNewLabel_1 = new JLabel("Lista de Alunos:");
		lblNewLabel_1.setBounds(260, 31, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(260, 59, 164, 191);
		contentPane.add(scrollPane);
		
		JList listAlunos = new JList();
		
		DefaultListModel<String> listaModel = new DefaultListModel<String>();
		
		listAlunos.setModel(listaModel);
		
		scrollPane.setViewportView(listAlunos);
		
		JButton btnMostrarAlunos = new JButton("Exibir Alunos");
		btnMostrarAlunos.setBounds(100, 212, 132, 23);
		contentPane.add(btnMostrarAlunos);
		
		AlunoRepository turma = new AlunoRepository(3);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Aluno aluno = new Aluno();
				aluno.setMatricula(txtMatricula.getText());
				aluno.setNome(txtNome.getText());
				
				turma.gravar(aluno, posicao);
				
				posicao++;
				
				// Adicionar o nome do aluno ao model da lista
				listaModel.addElement(aluno.getNome());
				
			}
		});
		
		btnMostrarAlunos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (Aluno aluno : turma.listarTodos()) {
					System.out.println(aluno.getMatricula());
					System.out.println(aluno.getNome());
					System.out.println("------------------------");
				}
				
			}
		});
		
	}
}
