package com.parth.miniproject.models;

public class RepoRequestDTO {
    private String token;
    private String name;
    private String description;
    private String homepage;
    private String isPrivate;
    private String isTemplate;
    
    public RepoRequestDTO(){
    }

    public RepoRequestDTO(String token, String name, String description, String homepage, String isPrivate, String isTemplate){
        this.token = token;
        this.name = name;
        this.description = description;
        this.homepage = homepage;
        this.isPrivate = isPrivate;
        this.isTemplate = isTemplate;
    }

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getIsTemplate(){
        return isTemplate;
    }

    public void setIsTemplate(String isTemplate){
        this.isTemplate = isTemplate;
    }

    public String getIsPrivate(){
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate){
        this.isPrivate = isPrivate;
    }

    public String getHomepage(){
        return homepage;
    }

    public void setHomepage(String homepage){
        this.homepage = homepage;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}
