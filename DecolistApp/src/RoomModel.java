import java.io.*;
import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
//import java.util.*;
public class RoomModel {
    public static final int FURNITURE_COUNT = 5;
    public static final int COLOR_COUNT = 4;
    public static final String[] ALL_COLOR = {"Red", "Green", "Blue", "Yellow"};
    public static final String[] ALL_FURNITURE = {"bed", "table", "computer", "certain", "poster"};
    public RoomView view;
    private Image room;
    private Icon icon[];
    //static private Image table[], computer[], curtain[], poster[]; // 0=red 1=green 2=blue
    private Bed bed;
    private Table table;
    private Computer computer;
    private Certain certain;
    private Poster poster;
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
            icon = new Icon[5];
            icon[0] = new ImageIcon(ImageIO.read(new File("img/bedicon.png")));
            icon[1] = new ImageIcon(ImageIO.read(new File("img/tableicon.png")));
            icon[2] = new ImageIcon(ImageIO.read(new File("img/computericon.png")));
            icon[3] = new ImageIcon(ImageIO.read(new File("img/certainicon.png")));
            icon[4] = new ImageIcon(ImageIO.read(new File("img/postericon.png")));
        }catch(IOException IOe){
            System.out.println("Image loading Exception. Image file missing" + IOe);
        }
        for(int i=0;i<FURNITURE_COUNT;i++){
            Image tempBundle[] = new Image[COLOR_COUNT];
            for(int j=0;j<COLOR_COUNT;j++){
                try{
                    File f = new File("img/"+ALL_FURNITURE[i]+ALL_COLOR[j]+".png");
                    tempBundle[j] = ImageIO.read(f);
                    System.out.println(ALL_FURNITURE[i] + ALL_COLOR[j]);
                }catch(IOException IOe){
                    System.out.println("Image loading Exception. Image file missing" + IOe);
                }
            }
            if(i == 0){
                bed = new Bed(ALL_FURNITURE[i],tempBundle);
                System.out.println("model bed create done");
            }else if(i == 1){
                table = new Table(ALL_FURNITURE[i],tempBundle);
                System.out.println("model table create done");
            }else if(i == 2){
                computer = new Computer(ALL_FURNITURE[i],tempBundle);
                System.out.println("model computer create done");
            }else if(i == 3){
                certain = new Certain(ALL_FURNITURE[i],tempBundle);
                System.out.println("model certain create done");
            }else if(i == 4){
                poster = new Poster(ALL_FURNITURE[i],tempBundle);
                System.out.println("model poster create done");
            }
        }
        
    }
    
    public void loadData(){
        
    }

    public void addContactView(RoomView rv){
        view = rv;
    }
    public void addIconToView(){
        view.getBtBed().setIcon(icon[0]);
        view.getBtTable().setIcon(icon[1]);
        view.getBtComputer().setIcon(icon[2]);
        view.getBtCertain().setIcon(icon[3]);
        view.getBtPoster().setIcon(icon[4]);
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Certain getCertain() {
        return certain;
    }

    public void setCertain(Certain certain) {
        this.certain = certain;
    }

    public Poster getPoster() {
        return poster;
    }

    public void setPoster(Poster poster) {
        this.poster = poster;
    }

    public Icon[] getIcon() {
        return icon;
    }

    public void setIcon(Icon[] icon) {
        this.icon = icon;
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
