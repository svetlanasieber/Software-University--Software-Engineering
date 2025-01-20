package footballTeamGenerator;

public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        this.name = name;
    }

    private void validate(int skillAmount, String skill) {
        if (skillAmount < 0 || skillAmount > 100) {
            throw new IllegalArgumentException(skill + ExceptionMessages.INVALID_SKILL_AMOUNT);
        }
    }

    private void setEndurance(int endurance) {
        validate(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        validate(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        validate(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        validate(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        validate(shooting,"Shooting");
        this.shooting = shooting;
    }

    public String getName() {
        return name;
    }

    public double overallSkillLevel() {
        return (endurance + sprint + dribble + passing + shooting)/5.00;
    }
}
