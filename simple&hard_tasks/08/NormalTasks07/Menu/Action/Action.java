package Menu.Action;

public class Action{

    public String action;
    public String description;
    public int numberArguments;
    
    public Action(String action, String description,int numberArguments){
        this.action = action;
        this.description = description;
        this.numberArguments = numberArguments;
    }
    public void action(){
        System.out.println(action);
    }

    public int getNumberArguments(){
        return this.numberArguments;
    }

    public String getDescription(){
        return this.description;
    }
}
