package org.example;

import java.time.LocalDateTime;

public class CommonLogVO {
    private String regEmpId;
    private LocalDateTime regYmdt;

    public CommonLogVO() {

    }

    public CommonLogVO(String regEmpId) {
        this.regEmpId = regEmpId;
    }

    public CommonLogVO(String regEmpId, LocalDateTime regYmdt) {
        this.regEmpId = regEmpId;
        this.regYmdt = regYmdt;
    }

    public String getRegEmpId() {
        return regEmpId;
    }

    public void setRegEmpId(String regEmpId) {
        this.regEmpId = regEmpId;
    }

    public LocalDateTime getRegYmdt() {
        return regYmdt;
    }

    public void setRegYmdt(LocalDateTime regYmdt) {
        this.regYmdt = regYmdt;
    }

    @Override
    public String toString() {
        return "CommonLogVO{" + "regEmpId='" + regEmpId + '\'' + ", regYmdt=" + regYmdt + '}';
    }
}
