

/**
 * Celestial Body class for NBody
 * @author ola
 *
 */
public class CelestialBody {
	private double myXPos, myYPos;
	private double myXVel, myYVel;
	private double myMass;
	private String myFileName;
	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		// TODO: complete constructor
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		// TODO: complete constructor
		myXPos = b.myXPos;
		myYPos = b.myYPos;
		myXVel = b.myXVel;
		myYVel = b.myYVel;
		myMass = b.myMass;
		myFileName = b.myFileName;
	}
/**
 * Getter method: gets X position
 * @return myXPos
 */
	public double getX() {
		// TODO: complete method
		return myXPos;
	}
	/**
	 * getter method: gets Y position
	 * @return myYPos
	 */
	public double getY() {
		// TODO: complete method
		return myYPos;
	}
	/**
	 * getter method: gets X Velocity
	 * @return myXVel
	 */
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}
	/**
	 * getter method: gets Mass
	 * @return myMass
	 */
	public double getMass() {
		// TODO: complete method
		return myMass;
	}
	/**
	 * getter method: gets Name of CelestialBody file
	 * @return myFileName
	 */
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		double dx = b.getX() - myXPos;
		double dy = b.getY() - myYPos;
        double r2;
        r2 = dx*dx + dy*dy;
        double r = Math.sqrt(r2);
		return r;
	}
	/**
	 * Calculates force exerted by one Celestial Body on other
	 * @param p
	 * @return
	 */
	public double calcForceExertedBy(CelestialBody p) {
		// TODO: complete method
		final double G = 6.67*1e-11;
		double r = calcDistance(p);
		double m2 = p.getMass();
		double F;
		F = G*myMass*m2/(r*r);
		return F;
	}
	/**
	 * Calculates force along X axis
	 * @param p
	 * @return
	 */
	public double calcForceExertedByX(CelestialBody p) {
		// TODO: complete method
		double dx = p.getX() - myXPos;
		double r = calcDistance(p);
		double F = calcForceExertedBy(p);
		double Fx = F*dx/r;
		return Fx;
	}
	/**
	 * Calculates force along y axis
	 * @param p
	 * @return
	 */
	public double calcForceExertedByY(CelestialBody p) {
		// TODO: complete method
		double dy = p.getY() - myYPos;
		double r = calcDistance(p);
		double F = calcForceExertedBy(p);
		double Fy = F*dy/r;
		return Fy;
	}
	/**
	 * Calculates Net Force on a body along X axis
	 * @param bodies
	 * @return
	 */
	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double NFx=0;
		for(CelestialBody b: bodies) {
			if (!b.equals(this)) {
				NFx+=this.calcForceExertedByX(b);
				
			}
		}
		return NFx;
	}
	/**
	 * Calculates Net force along Y axis for a body
	 * @param bodies
	 * @return
	 */
	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		// TODO: complete method
		double NFy=0;
		for(CelestialBody b: bodies) {
			if (!b.equals(this)) {
				NFy+=this.calcForceExertedByY(b);
				
			}
		}
		return NFy;
	}
	/**
	 * updates the characterisitics of celestial body during simulation
	 * @param deltaT
	 * @param xforce
	 * @param yforce
	 */
	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
		double ax, ay;
		ax= xforce/myMass;
		ay=yforce/myMass;
		double nvx,nx,nvy,ny;
		nvx = myXVel + deltaT*ax;
		nvy = myYVel + deltaT*ay;
		nx = myXPos + deltaT*nvx;
		ny = myYPos+deltaT*nvy;
		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;
	}
/**
 * used to draw the animation
 */
	public void draw() {
		// TODO: complete method
		StdDraw.picture(myXPos, myYPos, "images/"+myFileName);
	}
}
