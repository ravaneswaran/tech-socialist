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

package com.techsocialist.servicebuilder.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.techsocialist.servicebuilder.exception.NoSuchPosterException;
import com.techsocialist.servicebuilder.model.Poster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the poster service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PosterUtil
 * @generated
 */
@ProviderType
public interface PosterPersistence extends BasePersistence<Poster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PosterUtil} to access the poster persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the poster in the entity cache if it is enabled.
	 *
	 * @param poster the poster
	 */
	public void cacheResult(Poster poster);

	/**
	 * Caches the posters in the entity cache if it is enabled.
	 *
	 * @param posters the posters
	 */
	public void cacheResult(java.util.List<Poster> posters);

	/**
	 * Creates a new poster with the primary key. Does not add the poster to the database.
	 *
	 * @param id the primary key for the new poster
	 * @return the new poster
	 */
	public Poster create(long id);

	/**
	 * Removes the poster with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the poster
	 * @return the poster that was removed
	 * @throws NoSuchPosterException if a poster with the primary key could not be found
	 */
	public Poster remove(long id) throws NoSuchPosterException;

	public Poster updateImpl(Poster poster);

	/**
	 * Returns the poster with the primary key or throws a <code>NoSuchPosterException</code> if it could not be found.
	 *
	 * @param id the primary key of the poster
	 * @return the poster
	 * @throws NoSuchPosterException if a poster with the primary key could not be found
	 */
	public Poster findByPrimaryKey(long id) throws NoSuchPosterException;

	/**
	 * Returns the poster with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the poster
	 * @return the poster, or <code>null</code> if a poster with the primary key could not be found
	 */
	public Poster fetchByPrimaryKey(long id);

	/**
	 * Returns all the posters.
	 *
	 * @return the posters
	 */
	public java.util.List<Poster> findAll();

	/**
	 * Returns a range of all the posters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PosterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of posters
	 * @param end the upper bound of the range of posters (not inclusive)
	 * @return the range of posters
	 */
	public java.util.List<Poster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the posters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PosterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of posters
	 * @param end the upper bound of the range of posters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of posters
	 */
	public java.util.List<Poster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Poster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the posters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PosterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of posters
	 * @param end the upper bound of the range of posters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of posters
	 */
	public java.util.List<Poster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Poster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the posters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of posters.
	 *
	 * @return the number of posters
	 */
	public int countAll();

}