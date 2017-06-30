package com.example.demo.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ele_employee")
public class Employee {
    /**
     * ��id���������������������(�Լ��ӵ�)
     */
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    /**
     * ����
     */
    @Column(name = "employee_num")
    private String employeeNum;

    /**
     * ����
     */
    private String name;

    /**
     * ���֤
     */
    @Column(name = "identity_card_num")
    private String identityCardNum;

    /**
     * �Ա�
     */
    private String gender;

    /**
     * ��������
     */
    @Column(name = "household_type")
    private String householdType;

    /**
     * ������ַ
     */
    @Column(name = "permanent_address")
    private String permanentAddress;

    /**
     * ����״̬
     */
    @Column(name = "marital_status")
    private String maritalStatus;

    /**
     * ��ϵ�绰
     */
    private String phone;

    /**
     * ��ְʱ��
     */
    private Date entrytime;

    /**
     * ��λ
     */
    private String position;

    /**
     * ��Ա���
     */
    @Column(name = "person_category")
    private String personCategory;

    /**
     * ��������
     */
    @Column(name = "working_city")
    private String workingCity;

    /**
     * һ������
     */
    private String department1;

    /**
     * ��������
     */
    private String department2;

    /**
     * ��������
     */
    private String department3;

    /**
     * �ļ�����
     */
    private String department4;

    /**
     * �弶����
     */
    private String department5;

    /**
     * ��������
     */
    private String department6;

    /**
     * �������˺�
     */
    @Column(name = "housing_fund_account_num")
    private String housingFundAccountNum;

    /**
     * ���乫�����˺�
     */
    @Column(name = "housing_fund_account_sup_num")
    private String housingFundAccountSupNum;

    /**
     * Ա��״̬  �ݶ���ʵϰ/��ʽ/��ְ ����״̬
     */
    @Column(name = "employee_status")
    private String employeeStatus;

    /**
     * ��Ч�ڼ�
     */
    @Column(name = "enable_period")
    private String enablePeriod;

    /**
     * ��ְʱ��
     */
    @Column(name = "leave_day")
    private Date leaveDay;

    /**
     * �������
     */
    @Column(name = "last_working_day")
    private Date lastWorkingDay;

    /**
     * ��ְ����
     */
    @Column(name = "leave_type")
    private String leaveType;

    /**
     * ��ȡ��id���������������������(�Լ��ӵ�)
     *
     * @return employee_id - ��id���������������������(�Լ��ӵ�)
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * ���ñ�id���������������������(�Լ��ӵ�)
     *
     * @param employeeId ��id���������������������(�Լ��ӵ�)
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * ��ȡ����
     *
     * @return employee_num - ����
     */
    public String getEmployeeNum() {
        return employeeNum;
    }

    /**
     * ���ù���
     *
     * @param employeeNum ����
     */
    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
    }

    /**
     * ��ȡ����
     *
     * @return name - ����
     */
    public String getName() {
        return name;
    }

    /**
     * ��������
     *
     * @param name ����
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��ȡ���֤
     *
     * @return identity_card_num - ���֤
     */
    public String getIdentityCardNum() {
        return identityCardNum;
    }

    /**
     * �������֤
     *
     * @param identityCardNum ���֤
     */
    public void setIdentityCardNum(String identityCardNum) {
        this.identityCardNum = identityCardNum;
    }

    /**
     * ��ȡ�Ա�
     *
     * @return gender - �Ա�
     */
    public String getGender() {
        return gender;
    }

    /**
     * �����Ա�
     *
     * @param gender �Ա�
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * ��ȡ��������
     *
     * @return household_type - ��������
     */
    public String getHouseholdType() {
        return householdType;
    }

    /**
     * ���û�������
     *
     * @param householdType ��������
     */
    public void setHouseholdType(String householdType) {
        this.householdType = householdType;
    }

    /**
     * ��ȡ������ַ
     *
     * @return permanent_address - ������ַ
     */
    public String getPermanentAddress() {
        return permanentAddress;
    }

    /**
     * ���û�����ַ
     *
     * @param permanentAddress ������ַ
     */
    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    /**
     * ��ȡ����״̬
     *
     * @return marital_status - ����״̬
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * ���û���״̬
     *
     * @param maritalStatus ����״̬
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * ��ȡ��ϵ�绰
     *
     * @return phone - ��ϵ�绰
     */
    public String getPhone() {
        return phone;
    }

    /**
     * ������ϵ�绰
     *
     * @param phone ��ϵ�绰
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * ��ȡ��ְʱ��
     *
     * @return entrytime - ��ְʱ��
     */
    public Date getEntrytime() {
        return entrytime;
    }

    /**
     * ������ְʱ��
     *
     * @param entrytime ��ְʱ��
     */
    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    /**
     * ��ȡ��λ
     *
     * @return position - ��λ
     */
    public String getPosition() {
        return position;
    }

    /**
     * ���ø�λ
     *
     * @param position ��λ
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * ��ȡ��Ա���
     *
     * @return person_category - ��Ա���
     */
    public String getPersonCategory() {
        return personCategory;
    }

    /**
     * ������Ա���
     *
     * @param personCategory ��Ա���
     */
    public void setPersonCategory(String personCategory) {
        this.personCategory = personCategory;
    }

    /**
     * ��ȡ��������
     *
     * @return working_city - ��������
     */
    public String getWorkingCity() {
        return workingCity;
    }

    /**
     * ���ù�������
     *
     * @param workingCity ��������
     */
    public void setWorkingCity(String workingCity) {
        this.workingCity = workingCity;
    }

    /**
     * ��ȡһ������
     *
     * @return department1 - һ������
     */
    public String getDepartment1() {
        return department1;
    }

    /**
     * ����һ������
     *
     * @param department1 һ������
     */
    public void setDepartment1(String department1) {
        this.department1 = department1;
    }

    /**
     * ��ȡ��������
     *
     * @return department2 - ��������
     */
    public String getDepartment2() {
        return department2;
    }

    /**
     * ���ö�������
     *
     * @param department2 ��������
     */
    public void setDepartment2(String department2) {
        this.department2 = department2;
    }

    /**
     * ��ȡ��������
     *
     * @return department3 - ��������
     */
    public String getDepartment3() {
        return department3;
    }

    /**
     * ������������
     *
     * @param department3 ��������
     */
    public void setDepartment3(String department3) {
        this.department3 = department3;
    }

    /**
     * ��ȡ�ļ�����
     *
     * @return department4 - �ļ�����
     */
    public String getDepartment4() {
        return department4;
    }

    /**
     * �����ļ�����
     *
     * @param department4 �ļ�����
     */
    public void setDepartment4(String department4) {
        this.department4 = department4;
    }

    /**
     * ��ȡ�弶����
     *
     * @return department5 - �弶����
     */
    public String getDepartment5() {
        return department5;
    }

    /**
     * �����弶����
     *
     * @param department5 �弶����
     */
    public void setDepartment5(String department5) {
        this.department5 = department5;
    }

    /**
     * ��ȡ��������
     *
     * @return department6 - ��������
     */
    public String getDepartment6() {
        return department6;
    }

    /**
     * ������������
     *
     * @param department6 ��������
     */
    public void setDepartment6(String department6) {
        this.department6 = department6;
    }

    /**
     * ��ȡ�������˺�
     *
     * @return housing_fund_account_num - �������˺�
     */
    public String getHousingFundAccountNum() {
        return housingFundAccountNum;
    }

    /**
     * ���ù������˺�
     *
     * @param housingFundAccountNum �������˺�
     */
    public void setHousingFundAccountNum(String housingFundAccountNum) {
        this.housingFundAccountNum = housingFundAccountNum;
    }

    /**
     * ��ȡ���乫�����˺�
     *
     * @return housing_fund_account_sup_num - ���乫�����˺�
     */
    public String getHousingFundAccountSupNum() {
        return housingFundAccountSupNum;
    }

    /**
     * ���ò��乫�����˺�
     *
     * @param housingFundAccountSupNum ���乫�����˺�
     */
    public void setHousingFundAccountSupNum(String housingFundAccountSupNum) {
        this.housingFundAccountSupNum = housingFundAccountSupNum;
    }

    /**
     * ��ȡԱ��״̬  �ݶ���ʵϰ/��ʽ/��ְ ����״̬
     *
     * @return employee_status - Ա��״̬  �ݶ���ʵϰ/��ʽ/��ְ ����״̬
     */
    public String getEmployeeStatus() {
        return employeeStatus;
    }

    /**
     * ����Ա��״̬  �ݶ���ʵϰ/��ʽ/��ְ ����״̬
     *
     * @param employeeStatus Ա��״̬  �ݶ���ʵϰ/��ʽ/��ְ ����״̬
     */
    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    /**
     * ��ȡ��Ч�ڼ�
     *
     * @return enable_period - ��Ч�ڼ�
     */
    public String getEnablePeriod() {
        return enablePeriod;
    }

    /**
     * ������Ч�ڼ�
     *
     * @param enablePeriod ��Ч�ڼ�
     */
    public void setEnablePeriod(String enablePeriod) {
        this.enablePeriod = enablePeriod;
    }

    /**
     * ��ȡ��ְʱ��
     *
     * @return leave_day - ��ְʱ��
     */
    public Date getLeaveDay() {
        return leaveDay;
    }

    /**
     * ������ְʱ��
     *
     * @param leaveDay ��ְʱ��
     */
    public void setLeaveDay(Date leaveDay) {
        this.leaveDay = leaveDay;
    }

    /**
     * ��ȡ�������
     *
     * @return last_working_day - �������
     */
    public Date getLastWorkingDay() {
        return lastWorkingDay;
    }

    /**
     * �����������
     *
     * @param lastWorkingDay �������
     */
    public void setLastWorkingDay(Date lastWorkingDay) {
        this.lastWorkingDay = lastWorkingDay;
    }

    /**
     * ��ȡ��ְ����
     *
     * @return leave_type - ��ְ����
     */
    public String getLeaveType() {
        return leaveType;
    }

    /**
     * ������ְ����
     *
     * @param leaveType ��ְ����
     */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }
}