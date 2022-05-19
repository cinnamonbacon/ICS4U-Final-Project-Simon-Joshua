public class Tile{
    private String file;
    private String object;
    private boolean movable;
    private boolean interactable;
    public Tile(String file, String object, boolean movable, boolean interactable){
        this.file=file;
        this.object=object;
        this.movable=movable;
        this.interactable=interactable;
        
    }
    public boolean canMove(){
        return movable;
    }
    public boolean isInteractable(){
        return interactable;
    }
    public void makeInteractable(){
        interactable=true;
    }
    public String getFile(){
        return file;
    }
    public String getObject(){
        return object;
    }
}