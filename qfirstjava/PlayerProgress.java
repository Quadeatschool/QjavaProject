package qfirstjava;
import java.util.HashSet;
import java.util.Set;

public class PlayerProgress {
    
    private Set<SkillBase> unlockedSkills = new HashSet<>();

    public PlayerProgress() {
    }

    public boolean isUnlocked(SkillBase skill) {
        return this.unlockedSkills.contains(skill);
    }

    public boolean unlockedSkill(SkillBase skill) {
        // Checks if the skill's unlock conditions are met
        if (skill.canUnlock(this)) {
            skill.unlock(); 
            this.unlockedSkills.add(skill);
            return true;
        }
        return false;
    }
}
