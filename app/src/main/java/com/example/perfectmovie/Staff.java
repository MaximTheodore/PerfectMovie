package com.example.perfectmovie;

public class Staff {
    private int staffId;
    private String nameRu;
    private String nameEn;
    private String description;
    private String posterUrl;
    private String professionText;
    private String professionKey;

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getNameRu() {
        return nameRu;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getProfessionKey() {
        return professionKey;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getProfessionText() {
        return professionText;
    }

    public void setProfessionKey(String professionKey) {
        this.professionKey = professionKey;
    }

    public void setProfessionText(String professionText) {
        this.professionText = professionText;
    }
}
