<<<<<<< HEAD
=======

>>>>>>> origin/room
import java.awt.Image;

public class Computer extends Furniture implements InteractAble {
    private transient Image comOffImage;
    private boolean Power = true;
    public Computer(String name){
        super(name);
    }
    
    public void takeAction(){
        Power = !Power;
    }

    public Image getComOffImage() {
        return comOffImage;
    }

    public void setComOffImage(Image comOffImage) {
        this.comOffImage = comOffImage;
    }

    public boolean isPower() {
        return Power;
    }

    public void setPower(boolean Power) {
        this.Power = Power;
    }
<<<<<<< HEAD
=======
    
>>>>>>> origin/room
}
