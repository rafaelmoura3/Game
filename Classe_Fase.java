public class Fase extends JPanel implements ActionListener {
	private Image fundo;
	private Nave nave;
	private Timer timer;
	private static int pontuacao;
	private int total = 60;
	public int getPontuacao() {
		return total - pontuacao;
	}
	private boolean game;
	private List<Inimigo> inimigos;
	private int[][] coordenadas = { { 2380, 29 }, { 2600, 59 }, { 1380, 89 },
			{ 780, 109 }, { 580, 139 }, { 880, 239 }, { 790, 259 },
			{ 760, 50 }, { 790, 150 }, { 1980, 209 }, { 560, 45 }, { 510, 70 },
			{ 930, 159 }, { 590, 80 }, { 530, 60 }, { 940, 59 }, { 990, 30 },
			{ 920, 200 }, { 900, 259 }, { 660, 50 }, { 540, 90 }, { 810, 220 },
			{ 860, 20 }, { 740, 180 }, { 820, 128 }, { 490, 170 }, { 700, 30 },
			{ 920, 300 }, { 856, 328 }, { 456, 320 },{ 2380, 29 }, { 2600, 259 }, { 1380, 289 },
			{ 780, 109 }, { 580, 239 }, { 880, 239 }, { 790, 259 },
			{ 760, 250 }, { 790, 250 }, { 1980, 209 }, { 560, 245 }, { 510, 270 },
			{ 930, 159 }, { 590, 290 }, { 530, 260 }, { 940, 259 }, { 990, 230 },
			{ 920, 200 }, { 900, 359 }, { 660, 250 }, { 540, 290 }, { 810, 220 },
			{ 860, 420 }, { 740, 420 }, { 820, 420 }, { 490, 420 }, { 700, 420 },
			{ 920, 400 }, { 856, 428 }, { 456, 420 }
	};	
	public Fase() {
		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new TecladoAdapter());
		ImageIcon referencia = new ImageIcon("res\\fundo.jpg");
		fundo = referencia.getImage();
		nave = new Nave();
		game = true;
		inicializaInimigos();
		timer = new Timer(5, this);
		timer.start();
	}
	public void inicializaInimigos() {
		inimigos = new ArrayList<Inimigo>();
		for (int i = 0; i < coordenadas.length; i++) {
			inimigos.add(new Inimigo(coordenadas[i][0], coordenadas[i][1]));
		}
	}	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);
		if (game) {
			graficos.drawImage(nave.getImagem(), nave.getX(), nave.getY(), this);
			List<Missel> misseis = nave.getMisseis();
			for (int i = 0; i < misseis.size(); i++) {
				Missel m = (Missel) misseis.get(i);
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
			}
			for (int i = 0; i < inimigos.size(); i++) {
				Inimigo in = inimigos.get(i);
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			}			
			int m = inimigos.size();
			this.pontuacao = m;
			graficos.setColor(Color.WHITE);
			graficos.drawString("MOSQUITOS: " +m , 5, 15);						
		} else {			
			ImageIcon fimJogo = new ImageIcon("res\\game over.jpg");
			graficos.drawImage(fimJogo.getImage(), 0, 0, null);	
		}		
		g.dispose();
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (inimigos.size() == 0) {
			game = false;
		}
		List<Missel> misseis = nave.getMisseis();
		for (int i = 0; i < misseis.size(); i++) {
			Missel m = (Missel) misseis.get(i);
			if (m.isVisivel()) {
				m.mexer();
			} else {
				misseis.remove(i);
			}
		}
		for (int i = 0; i < inimigos.size(); i++) {
			Inimigo in = inimigos.get(i);
			if (in.isVisivel()) {
				in.mexer();
			} else {
				inimigos.remove(i);
			}
		}
		nave.mexer();
		checarColisoes();
		repaint();
	}
	public void checarColisoes() {
		Rectangle formaNave = nave.getBounds();
		Rectangle formaInimigo;
		Rectangle formaMissel;
		for (int i = 0; i < inimigos.size(); i++) {
			Inimigo tempInimigo = inimigos.get(i);
			formaInimigo = tempInimigo.getBounds();
			if (formaNave.intersects(formaInimigo)) {
				nave.setVisivel(false);
				tempInimigo.setVisivel(false);
				game = false;
			}
		}
		List<Missel> misseis = nave.getMisseis();
		for (int i = 0; i < misseis.size(); i++) {
			Missel tempMissel = misseis.get(i);
			formaMissel = tempMissel.getBounds();
			for (int j = 0; j < inimigos.size(); j++) {
				Inimigo tempInimigo = inimigos.get(j);
				formaInimigo = tempInimigo.getBounds();
				if (formaMissel.intersects(formaInimigo)) {
					tempInimigo.setVisivel(false);
					tempMissel.setVisivel(false);
				}
			}
		}
	}
	private class TecladoAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				game = true;
				nave = new Nave();
				inicializaInimigos();
			}
			nave.keyPressed(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			nave.keyReleased(e);
		}
	}
}
}
