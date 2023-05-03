import java.awt.*;
public abstract class Furniture {
    protected String presentColor, name;
    protected Image presentImage;
    protected Image imageArray[];
    
    public Furniture(){
        this("" ,new Image[10]);
    }
    
    public Furniture(String name ,Image[] imgBundle){
        this.name = name;
        imageArray = imgBundle;
        presentColor = "Red";
    }
    
    public Image getImage(String color){
        switch(color) {
            case "Red":
                presentColor = "Red";
                presentImage = imageArray[0];
                return presentImage;
            case "Green":
                presentColor = "Green";
                presentImage = imageArray[1];
                return presentImage;
            case "Blue":
                presentColor = "Green";
                presentImage = imageArray[2];
                return presentImage;
            default:
                return null;
        }
    }
}
