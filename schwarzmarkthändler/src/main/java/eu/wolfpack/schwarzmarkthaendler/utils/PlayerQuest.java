package eu.wolfpack.schwarzmarkthaendler.utils;

public class PlayerQuest {

    private String questName;
    private String type;
    private int min;
    private int points;
    private String material;
    private int max;

    public PlayerQuest(String questName, String type, int min, int points, String material, int max) {
        this.questName = questName;
        this.type = type;
        this.min = min;
        this.points = points;
        this.material = material;
        this.max = max;
    }

    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
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

    public void setMin(int min) {
        this.min = min;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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
}
