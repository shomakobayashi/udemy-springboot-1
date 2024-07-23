package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class IssueEntity {

    private long id;
    private String summary;
    private String description;

// Lombokを使用するため既存コンストラクタはコメントアウト
//    public IssueEntity(long id, String summary, String description) {
//        this.id = id;
//        this.summary = summary;
//        this.description = description;
//    }

// Lombokを使用するため既存setter,getterはコメントアウト
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getSummary() {
//        return summary;
//    }
//
//    public void setSummary(String summary) {
//        this.summary = summary;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
}
