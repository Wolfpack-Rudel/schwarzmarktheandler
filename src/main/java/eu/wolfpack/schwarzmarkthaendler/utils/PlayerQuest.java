package eu.wolfpack.schwarzmarkthaendler.utils;

public class PlayerQuest {

    private final String questName;
    private final String description;
    private String type;
    private final int min;
    private final int points;
    private String material;
    private int max;
    private boolean enabled;

    public PlayerQuest(String questName, String description, String type, int min, int points, String material, int max, boolean enabled) {
        this.questName = questName;
        this.description = description;
        this.type = type;
        this.min = min;
        this.points = points;
        this.material = material;
        this.max = max;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getQuestName() {
        return questName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMin() {
        return min;
    }

    public int getPoints() {
        return points;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getDescription() {
        return description;
    }
}
