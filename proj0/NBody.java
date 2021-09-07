public class NBody {
    public static double readRadius(String path){
        In in = new In(path);
        int num = in.readInt();
        double r = in.readDouble();
        return r;
    }

    public static Planet[] readPlanets(String path){
        In in = new In(path);
        int num = in.readInt();
        double r = in.readDouble();
        Planet[] p = new Planet[num];
        double xp,yp,xv,yv,m;
        String name;
        for(int i=0;i<num;++i) {
            xp = in.readDouble();
            yp = in.readDouble();
            xv = in.readDouble();
            yv = in.readDouble();
            m = in.readDouble();
            name=in.readString();
            p[i]=new Planet(xp,yp,xv,yv,m,name);
        }
        return p;
    }

    public static void main(String[] argv){
        /*step 1 Collecting All Needed Input*/
        double T =Double.parseDouble(argv[0]);
        double dt =Double.parseDouble(argv[1]);
        String filename = argv[2];
        double r = readRadius(filename);
        Planet[] p =readPlanets(filename);

        /*step 2 Drawing the Background*/
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-r, r);
        String pic = "images/starfield.jpg";

        double[] xForce =new double[p.length];
        double[] yForce =new double[p.length];
        /*main loop*/
        for(double time=0;time<=T;time+=dt){
            /*calc Fx,Fy for each Planet*/
            for(int i=0;i<p.length;++i){
                xForce[i]=p[i].calcNetForceExertedByX(p);
                yForce[i]=p[i].calcNetForceExertedByY(p);
            }
            /*update*/
            for(int i=0;i<p.length;++i){
                p[i].update(dt,xForce[i],yForce[i]);
            }
            /*draw*/
            StdDraw.clear();
            StdDraw.picture(0,0, pic );
            for(Planet pi : p){
                pi.draw();
            }
            StdDraw.show();
            StdDraw.pause(1);
        }

        StdOut.printf("%d\n", p.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < p.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    p[i].xxPos, p[i].yyPos, p[i].xxVel,
                    p[i].yyVel, p[i].mass, p[i].imgFileName);
        }
    }
}
