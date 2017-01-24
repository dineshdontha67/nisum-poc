package x;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author dineshdontha
 * 
 * Application will have some default Roles like User, Guest, Admin & SuperAdmin as seeded data.
 * 
 * Alongside, SuperAdmin has some privileges like adding new privileges.
 *
 */
@Entity
@Table(name="ROLES")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ROLE_ID")
	Integer roleId;
	
	@Column(name = "ROLE_NAME")
	String roleName;
	
	@OneToOne(mappedBy="role")
	UserRoles userRoles;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public UserRoles getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(UserRoles userRoles) {
		this.userRoles = userRoles;
	}

}
