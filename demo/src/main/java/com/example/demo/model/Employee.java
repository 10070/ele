package com.example.demo.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ele_employee")
public class Employee {
    /**
     * 表id，主键，供其他表做外键(自己加的)
     */
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    /**
     * 工号
     */
    @Column(name = "employee_num")
    private String employeeNum;

    /**
     * 姓名
     */
    private String name;

    /**
     * 身份证
     */
    @Column(name = "identity_card_num")
    private String identityCardNum;

    /**
     * 性别
     */
    private String gender;

    /**
     * 户口性质
     */
    @Column(name = "household_type")
    private String householdType;

    /**
     * 户籍地址
     */
    @Column(name = "permanent_address")
    private String permanentAddress;

    /**
     * 婚姻状态
     */
    @Column(name = "marital_status")
    private String maritalStatus;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 入职时间
     */
    private Date entrytime;

    /**
     * 岗位
     */
    private String position;

    /**
     * 人员类别
     */
    @Column(name = "person_category")
    private String personCategory;

    /**
     * 工作城市
     */
    @Column(name = "working_city")
    private String workingCity;

    /**
     * 一级部门
     */
    private String department1;

    /**
     * 二级部门
     */
    private String department2;

    /**
     * 三级部门
     */
    private String department3;

    /**
     * 四级部门
     */
    private String department4;

    /**
     * 五级部门
     */
    private String department5;

    /**
     * 六级部门
     */
    private String department6;

    /**
     * 公积金账号
     */
    @Column(name = "housing_fund_account_num")
    private String housingFundAccountNum;

    /**
     * 补充公积金账号
     */
    @Column(name = "housing_fund_account_sup_num")
    private String housingFundAccountSupNum;

    /**
     * 员工状态  暂定：实习/正式/离职 三种状态
     */
    @Column(name = "employee_status")
    private String employeeStatus;

    /**
     * 生效期间
     */
    @Column(name = "enable_period")
    private String enablePeriod;

    /**
     * 离职时间
     */
    @Column(name = "leave_day")
    private Date leaveDay;

    /**
     * 最后工作日
     */
    @Column(name = "last_working_day")
    private Date lastWorkingDay;

    /**
     * 离职类型
     */
    @Column(name = "leave_type")
    private String leaveType;

    /**
     * 获取表id，主键，供其他表做外键(自己加的)
     *
     * @return employee_id - 表id，主键，供其他表做外键(自己加的)
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置表id，主键，供其他表做外键(自己加的)
     *
     * @param employeeId 表id，主键，供其他表做外键(自己加的)
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 获取工号
     *
     * @return employee_num - 工号
     */
    public String getEmployeeNum() {
        return employeeNum;
    }

    /**
     * 设置工号
     *
     * @param employeeNum 工号
     */
    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取身份证
     *
     * @return identity_card_num - 身份证
     */
    public String getIdentityCardNum() {
        return identityCardNum;
    }

    /**
     * 设置身份证
     *
     * @param identityCardNum 身份证
     */
    public void setIdentityCardNum(String identityCardNum) {
        this.identityCardNum = identityCardNum;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取户口性质
     *
     * @return household_type - 户口性质
     */
    public String getHouseholdType() {
        return householdType;
    }

    /**
     * 设置户口性质
     *
     * @param householdType 户口性质
     */
    public void setHouseholdType(String householdType) {
        this.householdType = householdType;
    }

    /**
     * 获取户籍地址
     *
     * @return permanent_address - 户籍地址
     */
    public String getPermanentAddress() {
        return permanentAddress;
    }

    /**
     * 设置户籍地址
     *
     * @param permanentAddress 户籍地址
     */
    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    /**
     * 获取婚姻状态
     *
     * @return marital_status - 婚姻状态
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * 设置婚姻状态
     *
     * @param maritalStatus 婚姻状态
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取入职时间
     *
     * @return entrytime - 入职时间
     */
    public Date getEntrytime() {
        return entrytime;
    }

    /**
     * 设置入职时间
     *
     * @param entrytime 入职时间
     */
    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    /**
     * 获取岗位
     *
     * @return position - 岗位
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置岗位
     *
     * @param position 岗位
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取人员类别
     *
     * @return person_category - 人员类别
     */
    public String getPersonCategory() {
        return personCategory;
    }

    /**
     * 设置人员类别
     *
     * @param personCategory 人员类别
     */
    public void setPersonCategory(String personCategory) {
        this.personCategory = personCategory;
    }

    /**
     * 获取工作城市
     *
     * @return working_city - 工作城市
     */
    public String getWorkingCity() {
        return workingCity;
    }

    /**
     * 设置工作城市
     *
     * @param workingCity 工作城市
     */
    public void setWorkingCity(String workingCity) {
        this.workingCity = workingCity;
    }

    /**
     * 获取一级部门
     *
     * @return department1 - 一级部门
     */
    public String getDepartment1() {
        return department1;
    }

    /**
     * 设置一级部门
     *
     * @param department1 一级部门
     */
    public void setDepartment1(String department1) {
        this.department1 = department1;
    }

    /**
     * 获取二级部门
     *
     * @return department2 - 二级部门
     */
    public String getDepartment2() {
        return department2;
    }

    /**
     * 设置二级部门
     *
     * @param department2 二级部门
     */
    public void setDepartment2(String department2) {
        this.department2 = department2;
    }

    /**
     * 获取三级部门
     *
     * @return department3 - 三级部门
     */
    public String getDepartment3() {
        return department3;
    }

    /**
     * 设置三级部门
     *
     * @param department3 三级部门
     */
    public void setDepartment3(String department3) {
        this.department3 = department3;
    }

    /**
     * 获取四级部门
     *
     * @return department4 - 四级部门
     */
    public String getDepartment4() {
        return department4;
    }

    /**
     * 设置四级部门
     *
     * @param department4 四级部门
     */
    public void setDepartment4(String department4) {
        this.department4 = department4;
    }

    /**
     * 获取五级部门
     *
     * @return department5 - 五级部门
     */
    public String getDepartment5() {
        return department5;
    }

    /**
     * 设置五级部门
     *
     * @param department5 五级部门
     */
    public void setDepartment5(String department5) {
        this.department5 = department5;
    }

    /**
     * 获取六级部门
     *
     * @return department6 - 六级部门
     */
    public String getDepartment6() {
        return department6;
    }

    /**
     * 设置六级部门
     *
     * @param department6 六级部门
     */
    public void setDepartment6(String department6) {
        this.department6 = department6;
    }

    /**
     * 获取公积金账号
     *
     * @return housing_fund_account_num - 公积金账号
     */
    public String getHousingFundAccountNum() {
        return housingFundAccountNum;
    }

    /**
     * 设置公积金账号
     *
     * @param housingFundAccountNum 公积金账号
     */
    public void setHousingFundAccountNum(String housingFundAccountNum) {
        this.housingFundAccountNum = housingFundAccountNum;
    }

    /**
     * 获取补充公积金账号
     *
     * @return housing_fund_account_sup_num - 补充公积金账号
     */
    public String getHousingFundAccountSupNum() {
        return housingFundAccountSupNum;
    }

    /**
     * 设置补充公积金账号
     *
     * @param housingFundAccountSupNum 补充公积金账号
     */
    public void setHousingFundAccountSupNum(String housingFundAccountSupNum) {
        this.housingFundAccountSupNum = housingFundAccountSupNum;
    }

    /**
     * 获取员工状态  暂定：实习/正式/离职 三种状态
     *
     * @return employee_status - 员工状态  暂定：实习/正式/离职 三种状态
     */
    public String getEmployeeStatus() {
        return employeeStatus;
    }

    /**
     * 设置员工状态  暂定：实习/正式/离职 三种状态
     *
     * @param employeeStatus 员工状态  暂定：实习/正式/离职 三种状态
     */
    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    /**
     * 获取生效期间
     *
     * @return enable_period - 生效期间
     */
    public String getEnablePeriod() {
        return enablePeriod;
    }

    /**
     * 设置生效期间
     *
     * @param enablePeriod 生效期间
     */
    public void setEnablePeriod(String enablePeriod) {
        this.enablePeriod = enablePeriod;
    }

    /**
     * 获取离职时间
     *
     * @return leave_day - 离职时间
     */
    public Date getLeaveDay() {
        return leaveDay;
    }

    /**
     * 设置离职时间
     *
     * @param leaveDay 离职时间
     */
    public void setLeaveDay(Date leaveDay) {
        this.leaveDay = leaveDay;
    }

    /**
     * 获取最后工作日
     *
     * @return last_working_day - 最后工作日
     */
    public Date getLastWorkingDay() {
        return lastWorkingDay;
    }

    /**
     * 设置最后工作日
     *
     * @param lastWorkingDay 最后工作日
     */
    public void setLastWorkingDay(Date lastWorkingDay) {
        this.lastWorkingDay = lastWorkingDay;
    }

    /**
     * 获取离职类型
     *
     * @return leave_type - 离职类型
     */
    public String getLeaveType() {
        return leaveType;
    }

    /**
     * 设置离职类型
     *
     * @param leaveType 离职类型
     */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }
}