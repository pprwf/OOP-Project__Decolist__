import java.io.*;
import java.awt.*;
import javax.imageio.*;
import javax.swing.*;
public class RoomModel {
    public static final int FURNITURE_COUNT = 5;
    public static final int COLOR_COUNT = 4;
    public static final String[] ALL_COLOR = {"Red", "Green", "Blue", "Yellow"};
    public static final String[] ALL_FURNITURE = {"bed", "table", "computer", "certain", "poster"};
    private RoomView view;
    private Image room;
    private Icon icon[];
    private Icon colorIcon[];
    private Furniture furniture[];
    private Bed bed;
    private Table table;
    private Computer computer;
    private Certain certain;
    private Poster poster;
    private String[] FurnitureColor;
    private boolean FurnitureAccess[];
    private Image comoff;
    
    public RoomModel(){
        File f = new File("resource/datFile/room.dat");
        if(f.exists()){
            loadData(f);
        }else{
            init();
        }
        loadImage();
    }
    
    public void init(){
        furniture = new Furniture[5];
        furniture[0] = bed = new Bed("bed");
        furniture[1] = table = new Table("table");
        furniture[2] = computer = new Computer("computer");
        furniture[3] = certain = new Certain("certain");
        furniture[4] = poster = new Poster("poster");
    }
    
    public void loadImage(){
        try{
            room = ImageIO.read(new File("resource/img/room.png"));
            icon = new Icon[FURNITURE_COUNT];
            icon[0] = new ImageIcon(ImageIO.read(new File("resource/img/bedicon.png")));
            icon[1] = new ImageIcon(ImageIO.read(new File("resource/img/tableicon.png")));
            icon[2] = new ImageIcon(ImageIO.read(new File("resource/img/computericon.png")));
            icon[3] = new ImageIcon(ImageIO.read(new File("resource/img/certainicon.png")));
            icon[4] = new ImageIcon(ImageIO.read(new File("resource/img/postericon.png")));
            
            colorIcon = new Icon[COLOR_COUNT];
            colorIcon[0] = new ImageIcon(ImageIO.read(new File("resource/img/iconred.png")));
            colorIcon[1] = new ImageIcon(ImageIO.read(new File("resource/img/icongreen.png")));
            colorIcon[2] = new ImageIcon(ImageIO.read(new File("resource/img/iconblue.png")));
            colorIcon[3] = new ImageIcon(ImageIO.read(new File("resource/img/iconyellow.png")));
            
            for(int i=0;i<FURNITURE_COUNT;i++){
            Image tempBundle[] = new Image[COLOR_COUNT];
            for(int j=0;j<COLOR_COUNT;j++){
                try{
                    File f = new File("resource/img/"+ALL_FURNITURE[i]+ALL_COLOR[j]+".png");
                    tempBundle[j] = ImageIO.read(f);
                }catch(IOException IOe){
                    System.out.println("furniture image loading Fail. " + IOe);
                }
            }
            if(i == 0){
                bed.setImageArray(tempBundle);
            }else if(i == 1){
                table.setImageArray(tempBundle);
            }else if(i == 2){
                computer.setImageArray(tempBundle);
            }else if(i == 3){
                certain.setImageArray(tempBundle);
            }else if(i == 4){
                poster.setImageArray(tempBundle);
            }
            
            comoff = ImageIO.read(new File("resource/img/computeroff.png"));
            computer.setComOffImage(comoff);
        }
        }catch(IOException IOe){
            System.out.println("icon image loading Fail?. " + IOe);
        }
    }
    
    public void loadData(File f){
        try(FileInputStream fin = new FileInputStream(f);
            ObjectInputStream oin = new ObjectInputStream(fin)){
            furniture = (Furniture[])oin.readObject();
        }catch(IOException IOe){
                IOe.printStackTrace();
        }catch(ClassNotFoundException CNFe){
                CNFe.printStackTrace();
        }
        bed = (Bed)furniture[0];
        table = (Table)furniture[1];
        computer = (Computer)furniture[2];
        certain = (Certain)furniture[3];
        poster = (Poster)furniture[4];
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
        
        view.getBtcol1().setIcon(colorIcon[0]);
        view.getBtcol2().setIcon(colorIcon[1]);
        view.getBtcol3().setIcon(colorIcon[2]);
        view.getBtcol4().setIcon(colorIcon[3]);
    }

    public Icon[] getColorIcon() {
        return colorIcon;
    }

    public void setColorIcon(Icon[] colorIcon) {
        this.colorIcon = colorIcon;
    }

    public Furniture[] getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture[] furniture) {
        this.furniture = furniture;
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
