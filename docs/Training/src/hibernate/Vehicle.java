package hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="name")
	private String name;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "vehicle_owner", joinColumns = {
			@JoinColumn(name = "id") },
			inverseJoinColumns = { @JoinColumn(name = "owner_ID") })
	private List<Owner> ownerList = new ArrayList<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Owner> getOwnerList() {
		return ownerList;
	}
	public void setOwnerList(List<Owner> ownerList) {
		this.ownerList = ownerList;
	}

}
