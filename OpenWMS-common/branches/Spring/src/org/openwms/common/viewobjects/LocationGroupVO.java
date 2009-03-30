/*
 * OpenWMS, the Open Warehouse Management System
 * 
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package org.openwms.common.viewobjects;

/**
 * A LocationGroup as ViewObject.
 * <p>
 * Used to group <code>Location</code>s with same characteristics.
 * 
 * @author <a href="heiko.scherrer@gmx.de">Heiko Scherrer</a>
 * @version $Revision: 110 $
 */
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.openwms.common.domain.Location;

public class LocationGroupVO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static enum STATE {
		AVAILABLE,NOT_AVAILABLE;
	};

	private Long id;

	/**
	 * Unique identifier of a <code>LocationGroup</code>.
	 */
	private String name;

	/**
	 * Description for this <code>LocationGroup</code>.
	 */
	private String description;

	/**
	 * Type of this <code>LocationGroup</code>.
	 */
	private String groupType;

	/**
	 * Is this <code>LocationGroup</code> be integrated in the calculation of <code>TransportUnit</code>s.
	 * <p>
	 * true : Location is been included in calculation of <code>TransportUnit</code>s.<br>
	 * false: Location is not been included in calculation of <code>TransportUnit</code>s.
	 */
	private boolean locationGroupCountingActive = true;

	/**
	 * Number of <code>Location</code>s belonging to this <code>LocationGroup</code>.
	 */
	private int noLocations = 0;

	/**
	 * Inbound status of this <code>LocationGroup</code>.
	 */
	private STATE groupStateIn = STATE.AVAILABLE;

	/**
	 * Outbound status of this <code>LocationGroup</code>.
	 */
	private STATE groupStateOut = STATE.AVAILABLE;

	/**
	 * Maximum fill level for this <code>LocationGroup</code>.
	 */
	private float maxFillLevel = 0;

	/**
	 * Last update timestamp.
	 */
	private Date lastUpdated;

	/**
	 * Name of the plc system, coupled with this <code>LocationGroup</code>.
	 */
	private String systemCode;

	/**
	 * Version field
	 */
	private long version;

	/* ------------------- collection mapping ------------------- */
	/**
	 * Parent <code>LocationGroup</code>.
	 */
	private LocationGroupVO parent;

	/**
	 * Child <code>LocationGroup</code>s.
	 */
	private Set<LocationGroupVO> locationGroups = new HashSet<LocationGroupVO>();

	/**
	 * Child <code>Location</code>s.
	 */
	private Set<Location> locations = new HashSet<Location>();

	/* ----------------------------- methods ------------------- */
	/**
	 * Accessed by persistence provider.
	 */
	@SuppressWarnings("unused")
	private LocationGroupVO() {}

	/**
	 * Create a new <code>LocationGroup</code> with an unique name.
	 */
	public LocationGroupVO(String name) {
		this.name = name;
	}

	public Long getId() {
		return this.id;
	}

	/**
	 * Returns true if this is a transient object.
	 * 
	 * @return
	 */
	public boolean isNew() {
		return this.id == null;
	}

	/**
	 * Get the name of this <code>LocationGroup</code>.
	 * 
	 * @return the name.
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the inbound state of this <code>LocationGroup</code>.
	 * 
	 * @return
	 */
	public STATE getGroupStateIn() {
		return this.groupStateIn;
	}

	public void setGroupStateIn(STATE groupStateIn) {
		this.groupStateIn = groupStateIn;
	}

	/**
	 * Get the outbound state of this <code>LocationGroup</code>.
	 * 
	 * @return the groupStateOut.
	 */
	public STATE getGroupStateOut() {
		return groupStateOut;
	}

	public void setGroupStateOut(STATE groupStateOut) {
		this.groupStateOut = groupStateOut;
	}

	/**
	 * Returns the number of all sub <code>Location</code>s.
	 * 
	 * @return
	 */
	public int getNoLocations() {
		return this.noLocations;
	}
	
	public void setNoLocations(int noLocations) {
		this.noLocations = noLocations;
	}

	/**
	 * Returns the maximum fill level of this <code>LocationGroup</code>.<br>
	 * The maximum fill level defines how many <code>Location</code>s of this <code>LocationGroup</code> can be occupied
	 * with <code>TransportUnit</code>s.
	 * <p>
	 * The maximum fill level must be value between 0 and 1 and reflects a percentage value.
	 * 
	 * @return maxFillLevel.
	 */
	public float getMaxFillLevel() {
		return this.maxFillLevel;
	}

	/**
	 * Set the maximum fill level for this <code>LocationGroup</code>.
	 * <p>
	 * Pass a value between 0 and 1.<br>
	 * For example maxFillLevel = 0.85 means 85% of all sub <code>Location</code>s can be occupied.
	 * 
	 * @param maxFillLevel
	 */
	public void setMaxFillLevel(float maxFillLevel) {
		this.maxFillLevel = maxFillLevel;
	}

	/**
	 * Returns the type of this <code>LocationGroup</code>.
	 * 
	 * @return
	 */
	public String getGroupType() {
		return this.groupType;
	}

	/**
	 * Set the type of this <code>LocationGroup</code>.
	 * 
	 * @param groupType
	 */
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	/**
	 * Returns the last modification date of this <code>LocationGroup</code>.
	 * 
	 * @return lastUpdated.
	 */
	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	/**
	 * Set the date of the last modification of this <code>LocationGroup</code>.
	 * 
	 * @param lastUpdated
	 */
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * Get the description text.
	 * 
	 * @return description.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Set the description text.
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get parent LocationGroup.
	 * 
	 * @return parent LocationGroup.
	 */
	public LocationGroupVO getParent() {
		return this.parent;
	}

	/**
	 * Set parent LocationGroup.
	 * 
	 * @param parent
	 */
	public void setParent(LocationGroupVO parent) {
		this.parent = parent;
	}

	/**
	 * Get all child LocationGroups.
	 * 
	 * @return child LocationGroups.
	 */
	public Set<LocationGroupVO> getLocationGroups() {
		return locationGroups;
	}

	/**
	 * Get all locations.
	 * 
	 * @return all Locations.
	 */
	public Set<Location> getLocations() {
		return Collections.unmodifiableSet(locations);
	}

	/**
	 * Get the systemCode.
	 * 
	 * @return the systemCode.
	 */
	public String getSystemCode() {
		return systemCode;
	}

	/**
	 * Set the systemCode.
	 * 
	 * @param systemCode
	 *            The systemCode to set.
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	/**
	 * Get the locationGroupCountingActive.
	 * 
	 * @return the locationGroupCountingActive.
	 */
	public boolean isLocationGroupCountingActive() {
		return locationGroupCountingActive;
	}

	/**
	 * Set the locationGroupCountingActive.
	 * 
	 * @param locationGroupCountingActive
	 *            The locationGroupCountingActive to set.
	 */
	public void setLocationGroupCountingActive(boolean locationGroupCountingActive) {
		this.locationGroupCountingActive = locationGroupCountingActive;
	}

	/**
	 * JPA optimistic locking: Returns version field.
	 * 
	 * @return
	 */
	public long getVersion() {
		return this.version;
	}

	@Override
	public String toString() {
		return getName();
	}

}
