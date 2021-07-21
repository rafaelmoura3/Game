public class Nave {
	private int x, y;
	private int dx, dy;
	private int altura, largura;
	private boolean isVisivel;
	private Image imagem;	
	private List<Missel> misseis;	
	public Nave(){		
		ImageIcon referencia = new ImageIcon("res\\detetizador1.png");
		imagem = referencia.getImage();		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);		
		misseis = new ArrayList<Missel>();
		this.x = 100;
		this.y = 100;		
	}
	public void mexer(){
		x += dx;
		y += dy;
		if(this.x < 1){
			x = 1;
		}
		if(this.x > 700){
			x = 700;
		}		
		if(this.y < 1){
			y = 1;
		}
		if(this.y > 408){
			y = 408;
		}		
	}	
	public List<Missel> getMisseis() {
		return misseis;
	}
	public int getX() {
		return x;
	}	
	public int getY() {	
		return y;
	}	
	public Image getImagem() {
		return imagem;
	}
	public boolean isVisivel() {
		return isVisivel;
	}	
	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	public void atira(){
		this.misseis.add(new Missel(x+largura, y + altura/2 ));
	}
	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}
	public void keyPressed(KeyEvent tecla){		
		int codigo = tecla.getKeyCode();		
		if(codigo == KeyEvent.VK_SPACE){			atira();
		}
		if(codigo == KeyEvent.VK_UP){
			dy = -1;
		}		
		if(codigo == KeyEvent.VK_DOWN){
			dy = 1;
		}		
		if(codigo == KeyEvent.VK_LEFT){
			dx = -1;
		}		
		if(codigo == KeyEvent.VK_RIGHT){
			dx = 1;
		}		
	}	
	public void keyReleased(KeyEvent tecla){		
		int codigo = tecla.getKeyCode();		
		if(codigo == KeyEvent.VK_UP){
			dy = 0;
		}
		if(codigo == KeyEvent.VK_DOWN){
			dy = 0;
		}		
		if(codigo == KeyEvent.VK_LEFT){
			dx = 0;
		}		
		if(codigo == KeyEvent.VK_RIGHT){
			dx = 0;
		}		
	}		
