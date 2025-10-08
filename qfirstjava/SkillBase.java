package qfirstjava;

import java.util.ArrayList;
import java.util.List;

public abstract class SkillBase {
    
    //------------------------variables 
    private String name;

    private String description;

    private boolean isUnlocked;

    private List<SkillBase> prerequisites = new ArrayList<>();
   
    // -----------------------getters
    public boolean isUnlocked() {
        return this.isUnlocked;
    }

    public List<SkillBase> getPrerequisites() {
        return prerequisites;
    }

    public String getName() {
        return name;
    }
// --------------------------Constructer 

    public SkillBase(String name, String description, boolean isUnlocked, List<SkillBase> prerequisites){
        this.name = name;
        this.description = description;
        this.isUnlocked = isUnlocked;
        this.prerequisites = prerequisites;

    }
// ------------------------------- logic

    public void unlock(){
        isUnlocked = true;
    }

    // complete PlayerProgress first

    public boolean canUnlock(PlayerProgress progess){
        System.out.println("try me!!");
        return false;
    }
    


}
