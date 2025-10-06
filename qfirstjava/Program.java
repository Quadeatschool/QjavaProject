package qfirstjava;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args)
    {
        // Create skills
        SkillBase skillA = new Skill("Skill A", "First skill", false, new ArrayList<>());
        List<SkillBase> prereq = new ArrayList<>();
        prereq.add(skillA);
        SkillBase skillB = new Skill("Skill B", "Second skill", false, prereq);

        // Create player progress
        PlayerProgress progress = new PlayerProgress();

        // Try to unlock Skill B (should fail)
        System.out.println("Unlock Skill B: " + progress.unlockedSkill(skillB)); // false

        // Unlock Skill A
        System.out.println("Unlock Skill A: " + progress.unlockedSkill(skillA)); // true

        // Try to unlock Skill B again (should succeed)
        System.out.println("Unlock Skill B: " + progress.unlockedSkill(skillB)); // true
    }    


}
