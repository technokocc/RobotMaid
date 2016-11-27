package geometrie;

public class Vecteur {

	private double x , y ;

	public Vecteur(double x, double y){

		super();
		this.x = x;
		this.y = y;
	}

	public Vecteur(Vecteur current, Vecteur s) {

			x = s.x - current.x ;
			y = s.y - current.y ;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String toString() {
		return "Vecteur [x=" + x + ", y=" + y + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vecteur other = (Vecteur) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	
	public Vecteur clone(){	
		
		Vecteur res = new Vecteur(0,0);
		res.x = this.x ;
		res.y = this.y ;
		
		return res;
	}

	public double norme(){

		double res = 0;
		double x2 = (this.x * this.x) ;
		double y2 = (this.y * this.y) ;

		res = Math.sqrt(x2 + y2 );
		return res ;

	}

	public Vecteur additionNewVect(Vecteur v){

		Vecteur res = new Vecteur(0,0);

		res.x = v.x + this.x ;
		res.y = v.y + this.y ;

		return res;

	}

	public void additionCour(Vecteur v){

		this.x += v.x ;
		this.y += v.y ;
	}

	public Vecteur soustractionNewVect(Vecteur v){

		Vecteur res = new Vecteur(0,0);

		res.x = this.x - v.x ;
		res.y = this.y - v.y ;

		return res ;

	}
	
	public void soustractionCour(Vecteur v){

		this.x -= v.x;
		this.y -= v.y;
	}
	
	public Vecteur scalaireMult(double scalaire){
		
		return new Vecteur(x * scalaire, y * scalaire) ;
	}
	
	public double produitScalaire(Vecteur vecteur){
		
		double res = 0.0 ;
		
		res = ((this.x*vecteur.x) + (this.y*vecteur.y));
		
		return res;
	}

	public double angle(Vecteur cible){

		double tmp = this.produitScalaire(cible)/(norme()*cible.norme());
		tmp = Math.min(1,  tmp);
		tmp = Math.max(-1, tmp);
		double theta = Math.acos(tmp);
		
		theta = (this.produitVectoriel(cible) > 0) ? (theta) : -theta ;
		return theta;
	}
	
	public double produitVectoriel(Vecteur vecteur){
		
		double res = 0;
		
		res = (this.x * vecteur.y) - (this.y * vecteur.x) ;  
				
		return res ;
	}
	
	public void autoRotat(double angle){
		
		double x = this.x;
		double y = this.y;
		
		this.x = (x * Math.cos(angle)) - (y * Math.sin(angle)) ;
		this.y = (x * Math.sin(angle)) + (y * Math.cos(angle)) ;
			
	}
	
	public Vecteur rotationNewVect(double angle){

		Vecteur res = new Vecteur(0,0);

		res.x = (this.x * Math.cos(angle)) - (this.y * Math.sin(angle)) ;
		res.y = (this.x * Math.sin(angle)) + (this.y * Math.sin(angle)) ;

		return res ;
	}

	public void toUnitVec() {

		double norme = this.norme() ;

		this.x /=norme ;
		this.y /=norme ;
	}

}
