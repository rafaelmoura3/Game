public class janela extends JFrame{
	private static Fase f = new Fase();
	public janela(){
		JMenuBar barraMenu = new JMenuBar();
		JMenu menu = new JMenu("OP��ES E SAVE GAME");
		JMenuItem sobre = new JMenuItem("SOBRE");
		sobre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "OBRIGADO POR JOGAR!", "AGRADECIMENTOS", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		JMenuItem score = new JMenuItem("PONTUA��O");
		score.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null,+ f.getPontuacao(), "PONTUA��O", JOptionPane.INFORMATION_MESSAGE);
				try {
					new form_Login().setVisible(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		menu.add(sobre);
		menu.add(new JSeparator());
		menu.add(score);
		barraMenu.add(menu);
		setJMenuBar(barraMenu);
		add(new Fase());
		setTitle("Joguinho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,550);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) throws ClassNotFoundException {
		new janela();
	}
}
