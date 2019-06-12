package com.gmm.drp.entity;

/**
 * @ClassName Grading
 * @Description 品质分级
 * @Author baohaipeng
 * @Date 2019-04-15
 * @Version 1.0
 */
public class Grading {
    private Integer id;

    private String grading;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrading() {
        return grading;
    }

    public void setGrading(String grading) {
        this.grading = grading == null ? null : grading.trim();
    }
}
