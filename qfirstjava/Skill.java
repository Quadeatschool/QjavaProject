package qfirstjava;

import java.util.List;

public class Skill extends SkillBase {
    
    //------constructor
    public Skill(String name, String description, boolean isUnlocked, List<SkillBase> prerequisites) {
        super(name, description, isUnlocked, prerequisites);
    }
    
    //-------------------Polymorphism 

    @Override
    public boolean canUnlock(PlayerProgress progress){

        return getPrerequisites().stream().allMatch(SkillBase::isUnlocked);
    }

    
}
