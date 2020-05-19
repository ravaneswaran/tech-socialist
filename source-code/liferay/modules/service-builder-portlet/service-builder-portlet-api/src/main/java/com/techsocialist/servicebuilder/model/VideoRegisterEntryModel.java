/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.techsocialist.servicebuilder.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.sql.Blob;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the VideoRegisterEntry service. Represents a row in the &quot;video_register&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.techsocialist.servicebuilder.model.impl.VideoRegisterEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.techsocialist.servicebuilder.model.impl.VideoRegisterEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VideoRegisterEntry
 * @generated
 */
@ProviderType
public interface VideoRegisterEntryModel extends BaseModel<VideoRegisterEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a video register entry model instance should use the {@link VideoRegisterEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this video register entry.
	 *
	 * @return the primary key of this video register entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this video register entry.
	 *
	 * @param primaryKey the primary key of this video register entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this video register entry.
	 *
	 * @return the ID of this video register entry
	 */
	public long getId();

	/**
	 * Sets the ID of this video register entry.
	 *
	 * @param id the ID of this video register entry
	 */
	public void setId(long id);

	/**
	 * Returns the production house entry ID of this video register entry.
	 *
	 * @return the production house entry ID of this video register entry
	 */
	public long getProductionHouseEntryId();

	/**
	 * Sets the production house entry ID of this video register entry.
	 *
	 * @param productionHouseEntryId the production house entry ID of this video register entry
	 */
	public void setProductionHouseEntryId(long productionHouseEntryId);

	/**
	 * Returns the content of this video register entry.
	 *
	 * @return the content of this video register entry
	 */
	public Blob getContent();

	/**
	 * Sets the content of this video register entry.
	 *
	 * @param content the content of this video register entry
	 */
	public void setContent(Blob content);

	/**
	 * Returns the type of this video register entry.
	 *
	 * @return the type of this video register entry
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this video register entry.
	 *
	 * @param type the type of this video register entry
	 */
	public void setType(String type);

	/**
	 * Returns the status of this video register entry.
	 *
	 * @return the status of this video register entry
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this video register entry.
	 *
	 * @param status the status of this video register entry
	 */
	public void setStatus(String status);

	/**
	 * Returns the created by of this video register entry.
	 *
	 * @return the created by of this video register entry
	 */
	@AutoEscape
	public String getCreatedBy();

	/**
	 * Sets the created by of this video register entry.
	 *
	 * @param createdBy the created by of this video register entry
	 */
	public void setCreatedBy(String createdBy);

	/**
	 * Returns the modified by of this video register entry.
	 *
	 * @return the modified by of this video register entry
	 */
	@AutoEscape
	public String getModifiedBy();

	/**
	 * Sets the modified by of this video register entry.
	 *
	 * @param modifiedBy the modified by of this video register entry
	 */
	public void setModifiedBy(String modifiedBy);

	/**
	 * Returns the created date of this video register entry.
	 *
	 * @return the created date of this video register entry
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this video register entry.
	 *
	 * @param createdDate the created date of this video register entry
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the modified date of this video register entry.
	 *
	 * @return the modified date of this video register entry
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this video register entry.
	 *
	 * @param modifiedDate the modified date of this video register entry
	 */
	public void setModifiedDate(Date modifiedDate);

}