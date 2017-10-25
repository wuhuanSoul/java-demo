package cn.com.systec.domain;

import cn.com.systec.base.BaseDomain;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户实体类
 * @author xjn
 *
 */
@Entity
@Table(name = "tb_user")
@JsonIgnoreProperties(ignoreUnknown=true)
public class User extends BaseDomain {

	private static final long serialVersionUID = -7752984704596312706L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 账号
	 */
	@Column(name = "account")
	private String account;
	/**
	 * 密码
	 */
	@Column(name = "password")
	private String password;
	/**
	 * 组织机构ID
	 */
	@Column(name = "org_id")
	private Integer orgId;
	/**
	 * 角色ID
	 */
	@Column(name = "role_id")
	private Integer roleId;
	/**
	 * 姓名
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 是否为内部号码（内线） 0：是；1：否
	 */
	@Column(name = "is_internal_num")
	private Integer isInternalNum;

	/**
	 * 电话
	 */
	@Column(name = "phone")
	private String phone;
	/**
	 * 邮箱
	 */
	@Column(name = "email")
	private String email;
	/**
	 * 职位
	 */
	@Column(name = "position")
	private String position;
	/**
	 * 是否启用  0：禁用， 1：启用
	 */
	@Column(name = "is_enable")  
	private Integer isEnable; 
	/**
	 * 描述
	 */
	@Column(name = "description")
	private String description;
	/**
	 * 性别  0：男，1：女
	 */
	@Column(name = "gender") 
	private Integer gender;
	/**
	 * 用户信息在AD的修改时间
	 */
	@Column(name = "when_changed" ) 
	private String whenChanged;
	/**
	 * 用户在AD域的唯一标识
	 */
	@Column(name = "usn_created") 
	private String uSNCreated;
	/**
	 * 是否可以删除    0:不可删除 其他待定 
	 */
	@Column(name = "is_delete") 
	private Integer isDelete;
	/**
	 * 排序字段
	 */
	@Column(name = "sort")
	private Integer sort;
	
	/**
	 * 最大方数
	 */
	@Column(name = "max_attend")
	private Integer max_attend;
	
	/**
	 * 我的联系人（1=是，其他不是）
	 */
	@Column(name = "is_mycontact") 
	private Integer is_mycontact;
	/**
	 * 是安全组用户（1=是，0不是）
	 */
	@Column(name = "is_adGroup_user") 
	private Integer is_adGroup_user;

//	/**
//
//	 * 签到状态
//     */
//	@Transient
//	private Integer signStatus;
//
//
//	/**
//	 * 签到时间
//     */
//	@Transient
//	private Date signDate;
//
//	/**
//	 * 我的联系人分组
//     */
//	@Transient
//	private Integer mycontactgrop;

	/**
	 * NAME全拼
	 */
	private String namePinying;
	
	/**
	 * jf用户id
	 */
	@Column(name = "user_id")
	private String userId;
	
	/**
	 * jf用户所属事业部id
	 */
	@Column(name = "cu_id")
	private String cuId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIs_adGroup_user() {
		return is_adGroup_user;
	}
	
	public void setIs_adGroup_user(Integer is_adGroup_user) {
		this.is_adGroup_user = is_adGroup_user;
	}
	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public Integer getIsInternalNum() {
		return isInternalNum;
	}

	public void setIsInternalNum(Integer isInternalNum) {
		this.isInternalNum = isInternalNum;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getWhenChanged() {
		return whenChanged;
	}

	public void setWhenChanged(String whenChanged) {
		this.whenChanged = whenChanged;
	}

	public String getuSNCreated() {
		return uSNCreated;
	}

	public void setuSNCreated(String uSNCreated) {
		this.uSNCreated = uSNCreated;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

//	public Integer getSignStatus() {
//		return signStatus;
//	}
//
//	public void setSignStatus(int signStatus) {
//		this.signStatus = signStatus;
//	}
//
//	public Date getSignDate() {
//		return signDate;
//	}
//
//	public void setSignDate(Date signDate) {
//		this.signDate = signDate;
//	}

	public String getNamePinying() {
		return namePinying;
	}

	public void setNamePinying(String namePinying) {
		this.namePinying = namePinying;
	}

	public Integer getMax_attend() {
		return max_attend;
	}

	public void setMax_attend(Integer max_attend) {
		this.max_attend = max_attend;
	}

	public Integer getIs_mycontact() {
		return is_mycontact;
	}

	public void setIs_mycontact(Integer is_mycontact) {
		this.is_mycontact = is_mycontact;
	}

//	public Integer getMycontactgrop() {
//		return mycontactgrop;
//	}
//
//	public void setMycontactgrop(Integer mycontactgrop) {
//		this.mycontactgrop = mycontactgrop;
//	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCuId() {
		return cuId;
	}

	public void setCuId(String cuId) {
		this.cuId = cuId;
	}

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", account=" + account + ", password="
//				+ password + ", orgId=" + orgId + ", roleId=" + roleId
//				+ ", name=" + name + ", phone=" + phone + ", email=" + email
//				+ ", position=" + position + ", isEnable=" + isEnable
//				+ ", description=" + description + ", gender=" + gender
//				+ ", whenChanged=" + whenChanged + ", uSNCreated=" + uSNCreated
//				+ ", isDelete=" + isDelete + ", sort=" + sort + "]";
//	}


	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", account='" + account + '\'' +
				", password='" + password + '\'' +
				", orgId=" + orgId +
				", roleId=" + roleId +
				", name='" + name + '\'' +
				", isInternalNum=" + isInternalNum +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", position='" + position + '\'' +
				", isEnable=" + isEnable +
				", description='" + description + '\'' +
				", gender=" + gender +
				", whenChanged='" + whenChanged + '\'' +
				", uSNCreated='" + uSNCreated + '\'' +
				", isDelete=" + isDelete +
				", sort=" + sort +
				", max_attend=" + max_attend +
				", is_mycontact=" + is_mycontact +
				", is_adGroup_user=" + is_adGroup_user +
				", namePinying='" + namePinying + '\'' +
				", userId='" + userId + '\'' +
				", cuId='" + cuId + '\'' +
				'}';
	}
}
