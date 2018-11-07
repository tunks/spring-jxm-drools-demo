package com.att.ssot.model;

public class Incident {
	private String name;
	private int numberOfAlarms;
	
	private String enetSwitch;
	public Incident() {
		super();
	}

	public Incident(String name, int numberOfAlarms) {
		super();
		this.name = name;
		this.numberOfAlarms = numberOfAlarms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfAlarms() {
		return numberOfAlarms;
	}

	public void setNumberOfAlarms(int numberOfAlarms) {
		this.numberOfAlarms = numberOfAlarms;
	}

	public String getEnetSwitch() {
		return enetSwitch;
	}

	public void setEnetSwitch(String enetSwitch) {
		this.enetSwitch = enetSwitch;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enetSwitch == null) ? 0 : enetSwitch.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incident other = (Incident) obj;
		if (enetSwitch == null) {
			if (other.enetSwitch != null)
				return false;
		} else if (!enetSwitch.equals(other.enetSwitch))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Incident [name=" + name + ", numberOfAlarms=" + numberOfAlarms + ", enetSwitch=" + enetSwitch + "]";
	}

}
