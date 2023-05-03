import java.io.*;
import java.awt.*;
import javax.imageio.*;
//import java.util.*;
public class RoomModel {
    public static final int FURNITURE_COUNT = 1;
    public static final int COLOR_COUNT = 3;
    public static final String[] ALL_COLOR = {"Red", "Green", "Blue"};
    public static final String[] ALL_FURNITURE = {"bed", "table", "computer", "certain", "poster"};
    private Image room;
    //static private Image table[], computer[], curtain[], poster[]; // 0=red 1=green 2=blue
    private Bed bed;
    private Image icon[];
    private String[] FurnitureColor;
    private boolean FurnitureAccess[];
    
    public RoomModel(){
//        FurnitureAccess = new boolean[5];
//        FurnitureColor = new String[5];
//        icon = new Image[5];
//        bed = new Image[3];
//        
//        try{
//            room = ImageIO.read(new File("room.png"));
//            bed[0] = ImageIO.read(new File("bedRed.png"));
//            bed[1] = ImageIO.read(new File("bedGreen.png"));
//            bed[2] = ImageIO.read(new File("img/bedBlue.png"));
//            icon[0] = ImageIO.read(new File("bedRed icon.png"));
//            System.out.println("image load successfully");
//        }catch(IOException IOe){
//            System.out.println("Image loading Exception. Image file missing" + IOe);
//        }

        try{
            room = ImageIO.read(new File("img/room.png"));
            System.out.println("room image load successfully");
        }catch(IOException IOe){
            System.out.println("Image loading Exception. Image file missing" + IOe);
        }
        Image tempBundle[] = new Image[COLOR_COUNT];
        for(int i=0;i<FURNITURE_COUNT;i++){
            for(int j=0;j<COLOR_COUNT;j++){
                try{
                    File f = new File("img/"+ALL_FURNITURE[i]+ALL_COLOR[j]+".png");
                    tempBundle[j] = ImageIO.read(f);
                }catch(IOException IOe){
                    System.out.println("Image loading Exception. Image file missing" + IOe);
                }
            }
            if(i == 0){
                bed = new Bed(ALL_FURNITURE[i],tempBundle);
            }
        }
    }
    
    public void loadData(){
        
    }

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public Image getRoom() {
        return room;
    }

    public void setRoom(Image room) {
        this.room = room;
    }

    public Image[] getIcon() {
        return icon;
    }

    public void setIcon(Image[] icon) {
        this.icon = icon;
    }

    public String[] getFurnitureColor() {
        return FurnitureColor;
    }

    public void setFurnitureColor(String[] FurnitureColor) {
        this.FurnitureColor = FurnitureColor;
    }

    public boolean[] getFurnitureAccess() {
        return FurnitureAccess;
    }

    public void setFurnitureAccess(boolean[] FurnitureAccess) {
        this.FurnitureAccess = FurnitureAccess;
    }
    
}
