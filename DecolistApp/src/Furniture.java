import java.awt.*;
import java.io.*;
public abstract class Furniture implements Serializable{
    protected String presentColor, name;
    protected transient Image imageArray[];
    protected boolean access;
    
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
        access = false;
        System.out.println("Create Furniture " + name + " Done");
    }
    
    public Image getImage(String color){
        switch(color) {
            case "Red":
                return imageArray[0];
            case "Green":
                return imageArray[1];
            case "Blue":
                return imageArray[2];
            case "Yellow":
                return imageArray[3];
            default:
                return null;
        }
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

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
    
    
}
