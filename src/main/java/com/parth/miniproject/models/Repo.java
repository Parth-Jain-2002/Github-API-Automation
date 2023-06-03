package com.parth.miniproject.models;

import java.util.Date;

public class Repo {
    private int id;
    private String node_id;
    private String name;
    private String full_name;

    private String owner;

    private Date created_at;
    private Date updated_at;
    private Date pushed_at;

    private int stargazers_count;
    private int watchers_count;

    public Repo() {
    }

    public Repo(int id, String node_id, String name, String full_name, String owner, Date created_at, Date updated_at,
            Date pushed_at, int stargazers_count, int watchers_count) {
        this.id = id;
        this.node_id = node_id;
        this.name = name;
        this.full_name = full_name;
        this.owner = owner;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.pushed_at = pushed_at;
        this.stargazers_count = stargazers_count;
        this.watchers_count = watchers_count;
    }

    public int getId() {
        return id;
    }

    public String getNode_id() {
        return node_id;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getOwner() {
        return owner;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public Date getPushed_at() {
        return pushed_at;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public int getWatchers_count() {
        return watchers_count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public void setPushed_at(Date pushed_at) {
        this.pushed_at = pushed_at;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public void setWatchers_count(int watchers_count) {
        this.watchers_count = watchers_count;
    }

    @Override
    public String toString() {
        return "Repo [created_at=" + created_at + ", full_name=" + full_name + ", id=" + id + ", name=" + name
                + ", node_id=" + node_id + ", owner=" + owner + ", pushed_at=" + pushed_at + ", stargazers_count="
                + stargazers_count + ", updated_at=" + updated_at + ", watchers_count=" + watchers_count + "]";
    }
}
