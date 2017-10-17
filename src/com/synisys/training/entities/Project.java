package com.synisys.training.entities;

public class Project extends Entity {

    public static final String TITLE_KEY = "com.synisys.training.title";
    public static final String DESCRIPTION_KEY = "com.synisys.training.description";
    public static final String TOTAL_AMOUNT_KEY = "com.synisys.training.total_amount";
    public static final String CURRENCY_KEY = "com.synisys.training.currency";
    public static final String SUB_SECTOR_KEY = "com.synisys.training.subSector";
    public static final String SECTOR_KEY = "com.synisys.training.sector";

    private final String title;
    private final String description;
    private final int totalAmount;
    private final int currencyId;
    private final int subSectorId;

    public Project(int id, String title, String description,
                   int totalAmount, int currencyId, int subSectorId) {
        super(id);
        this.title = title;
        this.description = description;
        this.totalAmount = totalAmount;
        this.currencyId = currencyId;
        this.subSectorId = subSectorId;
    }

    public Project(Project project) {
        super(project.getId());
        title = project.getTitle();
        description = project.getDescription();
        totalAmount = project.getTotalAmount();
        currencyId = project.getCurrencyId();
        subSectorId = project.getSubSectorId();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public int getSubSectorId() {
        return subSectorId;
    }
}
