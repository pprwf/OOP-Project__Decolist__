import java.awt.*;
import java.io.*;
public abstract class Furniture implements Serializable{
    protected String presentColor, name;
    protected transient Image imageArray[];
    protected boolean furAccess;
    protected boolean[] colorAccess;
    
    public Furniture(){
        this("" ,new Image[10]);
    }
    
    public Furniture(String name){
        this(name ,new Image[10]);
    }
    
    public Furniture(String name ,Image[] imgBundle){
        this.name = name;
        imageArray = imgBundle;
        presentColor = "Red";
        furAccess = false;
        colorAccess = new boolean[]{false,false,false,false};
    }
    
    public Image getImage(String color){
        return switch (color) {
            case "Red" -> imageArray[0];
            case "Green" -> imageArray[1];
            case "Blue" -> imageArray[2];
            case "Yellow" -> imageArray[3];
            default -> null;
        };
    }

    public Image[] getImageArray() {
        return imageArray;
    }

    public void setImageArray(Image[] imageArray) {
        this.imageArray = imageArray;
    }

    public String getPresentColor() {
        return presentColor;
    }

    public void setPresentColor(String presentColor) {
        this.presentColor = presentColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFurAccess() {
        return furAccess;
    }

    public void setFurAccess(boolean furAccess) {
        this.furAccess = furAccess;
    }

    public boolean[] getColorAccess() {
        return colorAccess;
    }

    public void setColorAccess(boolean[] colorAccess) {
        this.colorAccess = colorAccess;
    }
}
