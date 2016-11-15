package appart;

import java.util.ArrayList;

import geometrie.Terrain;
import geometrie.Vecteur;

public class AppartImpl implements IAppart {
	
	private Terrain[][] track;
	private Vecteur depart;
	private Vecteur dirDepart, dirArrivee ;
	private String nomCircuit;
	
	
	public AppartImpl(Terrain[][] track, Vecteur depart, Vecteur dirDepart,
			Vecteur dirArrivee,String nomCircuit) {
		super();
		this.track = track;
		this.depart = depart;
		this.dirDepart = dirDepart;
		this.dirArrivee = dirArrivee;
		this.nomCircuit = nomCircuit ;				
		
	}
	
	public Terrain getTerrain(int i, int j){
		return this.track[i][j];
	}

	@Override
	public Terrain getTerrain(Vecteur v) {
		
		return this.track[(int) v.getX()][(int) v.getY()];
	
	}

	@Override
	public Vecteur getPointDepart() {
		
		return this.depart;
	}

	@Override
	public Vecteur getDirectionDepart() {
		
		return this.dirDepart;
	}

	@Override
	public Vecteur getDirectionArrivee() {
		
		return this.dirArrivee;
	}

	@Override
	public int getWidth() {
		
		return this.track.length;
	}

	@Override
	public int getHeight() {
		return this.track[0].length;
	}

	@Override
	public ArrayList<Vecteur> getArrivees() {
		
		ArrayList<Vecteur> res = new ArrayList<Vecteur>() ;
		
		for(int i = 0 ; i < track.length ; i++ ){
			for(int j = 0 ; j < track[0].length ; j++){
				
				if(track[i][j] == Terrain.BandeTour) res.add(new Vecteur(i,j));
			}
		}
		return res;
	}

	@Override
	public double getDist(int i, int j) {
		
		return 0  ;
	}

	@Override
	public Terrain[][] getMatrix() {
		
		return this.track;
	}
	
	public String getName(){
		
		return this.nomCircuit.replaceAll("fichiers/", "");
	}
}
