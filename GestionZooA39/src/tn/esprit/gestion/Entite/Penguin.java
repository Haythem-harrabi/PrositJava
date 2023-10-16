package tn.esprit.gestion.Entite;

public class Penguin extends Aquatic{
    private float swimmingDepth;




    public Penguin(float SwimDepth)
    {
        this.swimmingDepth=SwimDepth;
        System.out.println("je suis penguin");
    }
@Override
    public void swim(){
        System.out.println("this penguin is swimming");
    }


    public float getSwimmingD() {
        return this.swimmingDepth;
    }

    public void setSwimmingDepth(float swimmingDepth) {
        this.swimmingDepth = swimmingDepth;
    }
}
