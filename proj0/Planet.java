
public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    public Planet(double xP, double yP, double xV,double yV, double m, String img){
        this.xxPos=xP;
        this.yyPos=yP;
        this.xxVel=xV;
        this.yyVel=yV;
        this.mass=m;
        this.imgFileName=img;
    }
    public Planet(Planet p){
        this.xxPos=p.xxPos;
        this.yyPos=p.yyPos;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
        this.mass=p.mass;
        this.imgFileName=p.imgFileName;
    }
    public double calcDistance(Planet p){
        double dx=this.xxPos-p.xxPos;
        double dy=this.yyPos-p.yyPos;
        double distance=Math.sqrt(dx*dx+dy*dy);
        return distance;
    }
    public double calcForceExertedBy(Planet p){
        double F = 6.67e-11*(this.mass*p.mass)/(calcDistance(p)*calcDistance(p));
        return F;
    }

    public double calcForceExertedByX(Planet p) {
        double F=this.calcForceExertedBy(p);
        double dx=p.xxPos-this.xxPos;
        double r = this.calcDistance(p);
        return dx*F/r;
    }

    public double calcForceExertedByY(Planet p) {
        double F=this.calcForceExertedBy(p);
        double dy=p.yyPos-this.yyPos;
        double r = this.calcDistance(p);
        return dy*F/r;
    }
    public double calcNetForceExertedByX(Planet[] p){
        int length=p.length;
        double Fx=0;
        for(int i=0;i<length;++i){
            if(p[i].equals(this)) continue;
            Fx+=this.calcForceExertedByX(p[i]);
        }
        return Fx;
    }
    public double calcNetForceExertedByY(Planet[] p){
        int length=p.length;
        double Fy=0;
        for(int i=0;i<length;++i){
            if(p[i].equals(this)) continue;
            Fy+=this.calcForceExertedByY(p[i]);
        }
        return Fy;
    }
    public void update(double dt,double fx ,double fy){
        double ax=fx/this.mass;
        double ay=fy/this.mass;
        this.xxVel+=dt*ax;
        this.yyVel+=dt*ay;
        this.xxPos+=dt*this.xxVel;
        this.yyPos+=dt*this.yyVel;
    }
    public void draw(){
        //System.out.println("imfo   "+this.xxPos+"   "+this.yyPos+ "   "+this.imgFileName);
        StdDraw.picture(this.xxPos,this.yyPos, "images/"+this.imgFileName );
    }
}
