package com.gdp.km.job.bean;

import java.util.Date;

public class RJob {
    private Long idJob;

    private Integer idDirectory;

    private String name;

    private String jobVersion;
    
    private String jobRunrule;

    private Integer jobStatus;

    private Integer idDatabaseLog;

    private String tableNameLog;

    private String createdUser;

    private Date createdDate;

    private String modifiedUser;

    private Date modifiedDate;

    private String useBatchId;

    private String passBatchId;

    private String useLogfield;

    private String sharedFile;

    private String runStatus;

    private String lastUpdate;

    private String autoRestartNum;

    private String repositoryCode;

    private String projectCode;

    public Long getIdJob() {
        return idJob;
    }

    public void setIdJob(Long idJob) {
        this.idJob = idJob;
    }

    public Integer getIdDirectory() {
        return idDirectory;
    }

    public void setIdDirectory(Integer idDirectory) {
        this.idDirectory = idDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getJobVersion() {
        return jobVersion;
    }

    public void setJobVersion(String jobVersion) {
        this.jobVersion = jobVersion == null ? null : jobVersion.trim();
    }
    
    public String getJobRunrule() {
		return jobRunrule;
	}

	public void setJobRunrule(String jobRunrule) {
		this.jobRunrule = jobRunrule;
	}

	public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Integer getIdDatabaseLog() {
        return idDatabaseLog;
    }

    public void setIdDatabaseLog(Integer idDatabaseLog) {
        this.idDatabaseLog = idDatabaseLog;
    }

    public String getTableNameLog() {
        return tableNameLog;
    }

    public void setTableNameLog(String tableNameLog) {
        this.tableNameLog = tableNameLog == null ? null : tableNameLog.trim();
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser == null ? null : createdUser.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser == null ? null : modifiedUser.trim();
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getUseBatchId() {
        return useBatchId;
    }

    public void setUseBatchId(String useBatchId) {
        this.useBatchId = useBatchId == null ? null : useBatchId.trim();
    }

    public String getPassBatchId() {
        return passBatchId;
    }

    public void setPassBatchId(String passBatchId) {
        this.passBatchId = passBatchId == null ? null : passBatchId.trim();
    }

    public String getUseLogfield() {
        return useLogfield;
    }

    public void setUseLogfield(String useLogfield) {
        this.useLogfield = useLogfield == null ? null : useLogfield.trim();
    }

    public String getSharedFile() {
        return sharedFile;
    }

    public void setSharedFile(String sharedFile) {
        this.sharedFile = sharedFile == null ? null : sharedFile.trim();
    }

    public String getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus == null ? null : runStatus.trim();
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate == null ? null : lastUpdate.trim();
    }

    public String getAutoRestartNum() {
        return autoRestartNum;
    }

    public void setAutoRestartNum(String autoRestartNum) {
        this.autoRestartNum = autoRestartNum == null ? null : autoRestartNum.trim();
    }

    public String getRepositoryCode() {
        return repositoryCode;
    }

    public void setRepositoryCode(String repositoryCode) {
        this.repositoryCode = repositoryCode == null ? null : repositoryCode.trim();
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode == null ? null : projectCode.trim();
    }
}