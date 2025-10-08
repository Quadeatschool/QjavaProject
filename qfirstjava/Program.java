package qfirstjava;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args)
    {
        // //----- Create skills
        // SkillBase skillA = new Skill("Skill A", "First skill", false, new ArrayList<>());
        // List<SkillBase> prereq = new ArrayList<>();
        // prereq.add(skillA);
        // SkillBase skillB = new Skill("Skill B", "Second skill", false, prereq);

        // //------ Create player progress
        // PlayerProgress progress = new PlayerProgress();

        // //------ Try to unlock Skill B (should fail)
        // System.out.println("Unlock Skill B: " + progress.unlockedSkill(skillB)); // false

        // //----- Unlock Skill A
        // System.out.println("Unlock Skill A: " + progress.unlockedSkill(skillA)); // true

        // //------ Try to unlock Skill B again (should succeed)
        // System.out.println("Unlock Skill B: " + progress.unlockedSkill(skillB)); // true




         // Test SkillFactory and SkillTree creation
        SkillTree tree = SkillFactory.createDefaultTree();
        System.out.println("Total skills in tree: " + tree.getAllSkills().size());

        // Test PlayerProgress unlocking logic
        PlayerProgress progress = new PlayerProgress();

        // Try to unlock a mid-level skill before prerequisites
        SkillBase smallQuestions = tree.getSkill("Small Questions");
        boolean unlockedSmallQuestions = progress.unlockedSkill(smallQuestions);
        System.out.println("Unlocked 'Small Questions' before prerequisites: " + unlockedSmallQuestions); // should be false

        // Unlock prerequisites
        SkillBase onePercent = tree.getSkill("One percent");
        SkillBase microReward = tree.getSkill("Micro Reward");
        progress.unlockedSkill(onePercent);
        progress.unlockedSkill(microReward);

        // Try again to unlock mid-level skill
        unlockedSmallQuestions = progress.unlockedSkill(smallQuestions);
        System.out.println("Unlocked 'Small Questions' after prerequisites: " + unlockedSmallQuestions); // should be true

        // Check advanced skill unlock
        SkillBase doNotAskWhy = tree.getSkill("Do not ask why questions");
        boolean unlockedDoNotAskWhy = progress.unlockedSkill(doNotAskWhy);
        System.out.println("Unlocked 'Do not ask why questions' before mid-level: " + unlockedDoNotAskWhy); // should be false

        // Unlock other mid-level prerequisite
        SkillBase rewardEffort = tree.getSkill("Reward Efforts");
        progress.unlockedSkill(rewardEffort);

        // Now unlock advanced skill
        unlockedDoNotAskWhy = progress.unlockedSkill(doNotAskWhy);
        System.out.println("Unlocked 'Do not ask why questions' after mid-level: " + unlockedDoNotAskWhy); // should be true
    }
    }    



