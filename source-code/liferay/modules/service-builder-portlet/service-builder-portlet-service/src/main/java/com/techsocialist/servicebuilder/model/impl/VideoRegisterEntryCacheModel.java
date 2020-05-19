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

package com.techsocialist.servicebuilder.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.techsocialist.servicebuilder.model.VideoRegisterEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VideoRegisterEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VideoRegisterEntryCacheModel
	implements CacheModel<VideoRegisterEntry>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VideoRegisterEntryCacheModel)) {
			return false;
		}

		VideoRegisterEntryCacheModel videoRegisterEntryCacheModel =
			(VideoRegisterEntryCacheModel)obj;

		if (id == videoRegisterEntryCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", productionHouseEntryId=");
		sb.append(productionHouseEntryId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VideoRegisterEntry toEntityModel() {
		VideoRegisterEntryImpl videoRegisterEntryImpl =
			new VideoRegisterEntryImpl();

		videoRegisterEntryImpl.setId(id);
		videoRegisterEntryImpl.setProductionHouseEntryId(
			productionHouseEntryId);

		if (type == null) {
			videoRegisterEntryImpl.setType("");
		}
		else {
			videoRegisterEntryImpl.setType(type);
		}

		if (status == null) {
			videoRegisterEntryImpl.setStatus("");
		}
		else {
			videoRegisterEntryImpl.setStatus(status);
		}

		if (createdBy == null) {
			videoRegisterEntryImpl.setCreatedBy("");
		}
		else {
			videoRegisterEntryImpl.setCreatedBy(createdBy);
		}

		if (modifiedBy == null) {
			videoRegisterEntryImpl.setModifiedBy("");
		}
		else {
			videoRegisterEntryImpl.setModifiedBy(modifiedBy);
		}

		if (createdDate == Long.MIN_VALUE) {
			videoRegisterEntryImpl.setCreatedDate(null);
		}
		else {
			videoRegisterEntryImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			videoRegisterEntryImpl.setModifiedDate(null);
		}
		else {
			videoRegisterEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		videoRegisterEntryImpl.resetOriginalValues();

		return videoRegisterEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		productionHouseEntryId = objectInput.readLong();
		type = objectInput.readUTF();
		status = objectInput.readUTF();
		createdBy = objectInput.readUTF();
		modifiedBy = objectInput.readUTF();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(productionHouseEntryId);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (createdBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		if (modifiedBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(modifiedBy);
		}

		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long id;
	public long productionHouseEntryId;
	public String type;
	public String status;
	public String createdBy;
	public String modifiedBy;
	public long createdDate;
	public long modifiedDate;

}