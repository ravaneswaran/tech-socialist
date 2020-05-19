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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the content column in Poster.
 *
 * @author Brian Wing Shun Chan
 * @see Poster
 * @generated
 */
public class PosterContentBlobModel {

	public PosterContentBlobModel() {
	}

	public PosterContentBlobModel(long id) {
		_id = id;
	}

	public PosterContentBlobModel(long id, Blob contentBlob) {
		_id = id;
		_contentBlob = contentBlob;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Blob getContentBlob() {
		return _contentBlob;
	}

	public void setContentBlob(Blob contentBlob) {
		_contentBlob = contentBlob;
	}

	private long _id;
	private Blob _contentBlob;

}