package qfirstjava;
import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;


public class SkillTree {

private List<SkillBase> allSkills = new ArrayList<>();

// ----------------constrctor 

public SkillTree(List<SkillBase> allSkills) {
    this.allSkills = allSkills;
}

//--------------Getter

public List<SkillBase> getAllSkills() {
    return this.allSkills;
}

//--------------logic 

public void addSkill(SkillBase skill) {
    this.allSkills.add(skill);
}
    
public SkillBase getSkill(String name) {
    return allSkills.stream().filter(skill -> skill.getName().equals(name)).findFirst().orElse(null);
}
}
