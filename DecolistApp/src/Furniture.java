import java.awt.*;
public abstract class Furniture {
    protected String presentColor, name;
    protected Image imageArray[];
    protected boolean access;
    
    public Furniture(){
        this("" ,new Image[10]);
    }
    
    public Furniture(String name ,Image[] imgBundle){
        this.name = name;
        imageArray = imgBundle;
        presentColor = "Red";
        access = false;
        System.out.println("Create Furniture " + name + " Done");
    }
    
    public Image getImage(String color){
        switch(color) {
            case "Red":
                presentColor = "Red";
                return imageArray[0];
            case "Green":
                presentColor = "Green";
                return imageArray[1];
            case "Blue":
                presentColor = "Blue";
                return imageArray[2];
            case "Yellow":
                presentColor = "Yellow";
                return imageArray[3];
            default:
                return null;
        }
    }
}
