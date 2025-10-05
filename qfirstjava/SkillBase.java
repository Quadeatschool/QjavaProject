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

    




}
