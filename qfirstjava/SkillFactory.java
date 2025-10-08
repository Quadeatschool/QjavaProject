package qfirstjava;
import java.util.ArrayList;
import java.util.List;

public class SkillFactory {

    private SkillFactory(){}

    // Creates and returns a default skill tree with all skill levels.
    public static SkillTree createDefaultTree() {
        var rootSkills = createRootSkills();
        var midSkills = createMidLevelSkills(rootSkills);
        var advancedSkills = createAdvancedSkills(midSkills);
        var expertSkills = createExpertSkills(advancedSkills);

        var allSkills = new ArrayList<SkillBase>();
        allSkills.addAll(rootSkills);
        allSkills.addAll(midSkills);
        allSkills.addAll(advancedSkills);
        allSkills.addAll(expertSkills);

        return new SkillTree(allSkills);
    }

    // Creates and returns the root (beginner) skills.
    private static List<SkillBase> createRootSkills(){
        var onePercentBetter = new Skill("One percent", "Learn the next step", false, new ArrayList<>());
        var smallRewards = new Skill("Micro Reward", "Scaling down your rewards", false, new ArrayList<>());
        return List.of(onePercentBetter, smallRewards);
    }

    // Creates and returns the mid-level skills, using root skills as prerequisites.
    private static List<SkillBase> createMidLevelSkills(List<SkillBase> rootSkills){
        var onePercentBetter = rootSkills.stream().filter(skill -> skill.getName().equals("One percent")).findFirst().orElse(null);
        var smallRewards = rootSkills.stream().filter(skill -> skill.getName().equals("Micro Reward")).findFirst().orElse(null);

        if (onePercentBetter == null || smallRewards == null) {
            throw new IllegalStateException("Missing root skill prerequisite");
        }

        var askSmallerQuestions = new Skill("Small Questions", "Ask smaller questions", false, List.of(onePercentBetter, smallRewards));
        var rewardEffort = new Skill("Reward Efforts", "Only reward effort not success", false, List.of(onePercentBetter, smallRewards));

        return List.of(askSmallerQuestions, rewardEffort);
    }

    // Creates and returns the advanced skills, using mid-level skills as prerequisites.
    private static List<SkillBase> createAdvancedSkills(List<SkillBase> midSkills){
        var askSmallerQuestions = midSkills.stream().filter(skill -> skill.getName().equals("Small Questions")).findFirst().orElse(null);
        var rewardEffort = midSkills.stream().filter(skill -> skill.getName().equals("Reward Efforts")).findFirst().orElse(null);

        var doNotAskWhyQuestions = new Skill("Do not ask why questions", "Stop asking vague questions like why", false, List.of(askSmallerQuestions, rewardEffort));
        var enjoyStress = new Skill("Enjoy Stress", "Learn that stress can be really good", false, List.of(askSmallerQuestions, rewardEffort));

        return List.of(doNotAskWhyQuestions, enjoyStress);
    }

    // Creates and returns the expert skills, using advanced skills as prerequisites.
    private static List<SkillBase> createExpertSkills(List<SkillBase> advancedSkills){
        var DoNotAskWhyQuestions = advancedSkills.stream().filter(skill -> skill.getName().equals("Do not ask why questions")).findFirst().orElse(null);
        var EnjoyStress = advancedSkills.stream().filter(skill -> skill.getName().equals("Enjoy Stress")).findFirst().orElse(null);

        var UnAskedOpinions = new Skill("Un asked for opinions", "Stop giving out your opinion for free", false, List.of(DoNotAskWhyQuestions, EnjoyStress));
        var FeelPain = new Skill("Feel Pain", "Learn to accept good kinds of pain", false, List.of(DoNotAskWhyQuestions, EnjoyStress));

        return List.of(UnAskedOpinions, FeelPain);
    }

}
