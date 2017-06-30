package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "ele_si_adjustment")
public class SiAdjustment {
    @Id
    @Column(name = "adjustment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adjustmentId;

    /**
     * 社保档案id
     */
    @Column(name = "si_archive_id")
    private Long siArchiveId;

    @Column(name = "si_period")
    private String siPeriod;

    /**
     * 生效期间
     */
    @Column(name = "active_period_code")
    private String activePeriodCode;

    /**
     * 调前-汇缴基数
     */
    @Column(name = "before_payment_base")
    private BigDecimal beforePaymentBase;

    /**
     * 调前-公积金基数
     */
    @Column(name = "before_housing_fund_base")
    private BigDecimal beforeHousingFundBase;

    /**
     * 调前-补充公积金基数
     */
    @Column(name = "before_housing_fund_sup_base")
    private BigDecimal beforeHousingFundSupBase;

    /**
     * 调前供应商id
     */
    @Column(name = "before_vendor_id")
    private Long beforeVendorId;

    /**
     * 调前-城市id
     */
    @Column(name = "before_city_name")
    private String beforeCityName;

    /**
     * 调前-全额缴纳
     */
    @Column(name = "before_fully_payment_flag")
    private String beforeFullyPaymentFlag;

    /**
     * 调后-汇缴基数
     */
    @Column(name = "after_payment_base")
    private BigDecimal afterPaymentBase;

    /**
     * 调后-公积金基数
     */
    @Column(name = "after_housing_fund_base")
    private BigDecimal afterHousingFundBase;

    /**
     * 调后-补充公积金基数
     */
    @Column(name = "after_housing_fund_sup_base")
    private BigDecimal afterHousingFundSupBase;

    /**
     * 调后供应商id
     */
    @Column(name = "after_vendor_id")
    private Long afterVendorId;

    /**
     * 调后-城市id
     */
    @Column(name = "after_city_name")
    private String afterCityName;

    /**
     * 调后-全额缴纳
     */
    @Column(name = "after_fully_payment_flag")
    private String afterFullyPaymentFlag;

    /**
     * 发送日期  （注意当发送后再次调整时需要置为n）
     */
    @Column(name = "sended_date")
    private Date sendedDate;

    /**
     * 下载标识  y/n
     */
    @Column(name = "sended_flag")
    private String sendedFlag;

    /**
     * @return adjustment_id
     */
    public Long getAdjustmentId() {
        return adjustmentId;
    }

    /**
     * @param adjustmentId
     */
    public void setAdjustmentId(Long adjustmentId) {
        this.adjustmentId = adjustmentId;
    }

    /**
     * 获取社保档案id
     *
     * @return si_archive_id - 社保档案id
     */
    public Long getSiArchiveId() {
        return siArchiveId;
    }

    /**
     * 设置社保档案id
     *
     * @param siArchiveId 社保档案id
     */
    public void setSiArchiveId(Long siArchiveId) {
        this.siArchiveId = siArchiveId;
    }

    /**
     * @return si_period
     */
    public String getSiPeriod() {
        return siPeriod;
    }

    /**
     * @param siPeriod
     */
    public void setSiPeriod(String siPeriod) {
        this.siPeriod = siPeriod;
    }

    /**
     * 获取生效期间
     *
     * @return active_period_code - 生效期间
     */
    public String getActivePeriodCode() {
        return activePeriodCode;
    }

    /**
     * 设置生效期间
     *
     * @param activePeriodCode 生效期间
     */
    public void setActivePeriodCode(String activePeriodCode) {
        this.activePeriodCode = activePeriodCode;
    }

    /**
     * 获取调前-汇缴基数
     *
     * @return before_payment_base - 调前-汇缴基数
     */
    public BigDecimal getBeforePaymentBase() {
        return beforePaymentBase;
    }

    /**
     * 设置调前-汇缴基数
     *
     * @param beforePaymentBase 调前-汇缴基数
     */
    public void setBeforePaymentBase(BigDecimal beforePaymentBase) {
        this.beforePaymentBase = beforePaymentBase;
    }

    /**
     * 获取调前-公积金基数
     *
     * @return before_housing_fund_base - 调前-公积金基数
     */
    public BigDecimal getBeforeHousingFundBase() {
        return beforeHousingFundBase;
    }

    /**
     * 设置调前-公积金基数
     *
     * @param beforeHousingFundBase 调前-公积金基数
     */
    public void setBeforeHousingFundBase(BigDecimal beforeHousingFundBase) {
        this.beforeHousingFundBase = beforeHousingFundBase;
    }

    /**
     * 获取调前-补充公积金基数
     *
     * @return before_housing_fund_sup_base - 调前-补充公积金基数
     */
    public BigDecimal getBeforeHousingFundSupBase() {
        return beforeHousingFundSupBase;
    }

    /**
     * 设置调前-补充公积金基数
     *
     * @param beforeHousingFundSupBase 调前-补充公积金基数
     */
    public void setBeforeHousingFundSupBase(BigDecimal beforeHousingFundSupBase) {
        this.beforeHousingFundSupBase = beforeHousingFundSupBase;
    }

    /**
     * 获取调前供应商id
     *
     * @return before_vendor_id - 调前供应商id
     */
    public Long getBeforeVendorId() {
        return beforeVendorId;
    }

    /**
     * 设置调前供应商id
     *
     * @param beforeVendorId 调前供应商id
     */
    public void setBeforeVendorId(Long beforeVendorId) {
        this.beforeVendorId = beforeVendorId;
    }

    /**
     * 获取调前-城市id
     *
     * @return before_city_name - 调前-城市id
     */
    public String getBeforeCityName() {
        return beforeCityName;
    }

    /**
     * 设置调前-城市id
     *
     * @param beforeCityName 调前-城市id
     */
    public void setBeforeCityName(String beforeCityName) {
        this.beforeCityName = beforeCityName;
    }

    /**
     * 获取调前-全额缴纳
     *
     * @return before_fully_payment_flag - 调前-全额缴纳
     */
    public String getBeforeFullyPaymentFlag() {
        return beforeFullyPaymentFlag;
    }

    /**
     * 设置调前-全额缴纳
     *
     * @param beforeFullyPaymentFlag 调前-全额缴纳
     */
    public void setBeforeFullyPaymentFlag(String beforeFullyPaymentFlag) {
        this.beforeFullyPaymentFlag = beforeFullyPaymentFlag;
    }

    /**
     * 获取调后-汇缴基数
     *
     * @return after_payment_base - 调后-汇缴基数
     */
    public BigDecimal getAfterPaymentBase() {
        return afterPaymentBase;
    }

    /**
     * 设置调后-汇缴基数
     *
     * @param afterPaymentBase 调后-汇缴基数
     */
    public void setAfterPaymentBase(BigDecimal afterPaymentBase) {
        this.afterPaymentBase = afterPaymentBase;
    }

    /**
     * 获取调后-公积金基数
     *
     * @return after_housing_fund_base - 调后-公积金基数
     */
    public BigDecimal getAfterHousingFundBase() {
        return afterHousingFundBase;
    }

    /**
     * 设置调后-公积金基数
     *
     * @param afterHousingFundBase 调后-公积金基数
     */
    public void setAfterHousingFundBase(BigDecimal afterHousingFundBase) {
        this.afterHousingFundBase = afterHousingFundBase;
    }

    /**
     * 获取调后-补充公积金基数
     *
     * @return after_housing_fund_sup_base - 调后-补充公积金基数
     */
    public BigDecimal getAfterHousingFundSupBase() {
        return afterHousingFundSupBase;
    }

    /**
     * 设置调后-补充公积金基数
     *
     * @param afterHousingFundSupBase 调后-补充公积金基数
     */
    public void setAfterHousingFundSupBase(BigDecimal afterHousingFundSupBase) {
        this.afterHousingFundSupBase = afterHousingFundSupBase;
    }

    /**
     * 获取调后供应商id
     *
     * @return after_vendor_id - 调后供应商id
     */
    public Long getAfterVendorId() {
        return afterVendorId;
    }

    /**
     * 设置调后供应商id
     *
     * @param afterVendorId 调后供应商id
     */
    public void setAfterVendorId(Long afterVendorId) {
        this.afterVendorId = afterVendorId;
    }

    /**
     * 获取调后-城市id
     *
     * @return after_city_name - 调后-城市id
     */
    public String getAfterCityName() {
        return afterCityName;
    }

    /**
     * 设置调后-城市id
     *
     * @param afterCityName 调后-城市id
     */
    public void setAfterCityName(String afterCityName) {
        this.afterCityName = afterCityName;
    }

    /**
     * 获取调后-全额缴纳
     *
     * @return after_fully_payment_flag - 调后-全额缴纳
     */
    public String getAfterFullyPaymentFlag() {
        return afterFullyPaymentFlag;
    }

    /**
     * 设置调后-全额缴纳
     *
     * @param afterFullyPaymentFlag 调后-全额缴纳
     */
    public void setAfterFullyPaymentFlag(String afterFullyPaymentFlag) {
        this.afterFullyPaymentFlag = afterFullyPaymentFlag;
    }

    /**
     * 获取发送日期  （注意当发送后再次调整时需要置为n）
     *
     * @return sended_date - 发送日期  （注意当发送后再次调整时需要置为n）
     */
    public Date getSendedDate() {
        return sendedDate;
    }

    /**
     * 设置发送日期  （注意当发送后再次调整时需要置为n）
     *
     * @param sendedDate 发送日期  （注意当发送后再次调整时需要置为n）
     */
    public void setSendedDate(Date sendedDate) {
        this.sendedDate = sendedDate;
    }

    /**
     * 获取下载标识  y/n
     *
     * @return sended_flag - 下载标识  y/n
     */
    public String getSendedFlag() {
        return sendedFlag;
    }

    /**
     * 设置下载标识  y/n
     *
     * @param sendedFlag 下载标识  y/n
     */
    public void setSendedFlag(String sendedFlag) {
        this.sendedFlag = sendedFlag;
    }
}