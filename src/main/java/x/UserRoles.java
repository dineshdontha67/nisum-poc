package x;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.nisum.domain.User;

/**
 * @author dineshdontha
 * 
 * This entity keeps track all the users & their associated roles.
 *
 */
@Entity
@Table(name = "USER_ROLES")
public class UserRoles {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="USER_ROLE_ID")
	Integer userRoleId;
	
	@ManyToOne//(fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	User user;
	
	@OneToOne
	@JoinColumn(name = "ROLE_ID")
	Role role;

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
