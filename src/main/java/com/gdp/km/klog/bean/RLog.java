package com.gdp.km.klog.bean;

import java.util.Date;

public class RLog {
    private Integer id;

    private Long idLog;

    private String name;

    private Integer idLoglevel;

    private Date startDate;

    private Date stopTime;

    private String logContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getIdLoglevel() {
        return idLoglevel;
    }

    public void setIdLoglevel(Integer idLoglevel) {
        this.idLoglevel = idLoglevel;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }
}