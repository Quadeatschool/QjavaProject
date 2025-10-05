package qfirstjava;
import java.util.Set;
import java.util.HashSet;

public class PlayerProgress {

    // ------------------------- variables 
    private Set<SkillBase> unlockedSkills = new HashSet<>();
    
    //-----------------getter
    // public Set<SkillBase> getUnlockedSkills(){
    //     return unlockedSkills;
    // }

// -----------------------------logic
    public boolean isUnlocked(SkillBase skill) {
       return unlockedSkills.contains(skill);
    }

    public boolean unlockedSkill(SkillBase skill)
    {
        if (skill.canUnlock(this)){
            skill.Unlock();
            unlockedSkills.add(skill);
            return true;
        }
        return false;
    }
}
