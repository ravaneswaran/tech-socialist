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

package com.techsocialist.servicebuilder.service.base;

import com.liferay.petra.io.AutoDeleteFileInputStream;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.db.DBType;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.File;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.techsocialist.servicebuilder.model.Poster;
import com.techsocialist.servicebuilder.model.PosterContentBlobModel;
import com.techsocialist.servicebuilder.service.PosterLocalService;
import com.techsocialist.servicebuilder.service.persistence.PosterPersistence;
import com.techsocialist.servicebuilder.service.persistence.ProductionHousePersistence;
import com.techsocialist.servicebuilder.service.persistence.TicketPersistence;
import com.techsocialist.servicebuilder.service.persistence.VideoPersistence;

import java.io.InputStream;
import java.io.Serializable;

import java.sql.Blob;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the poster local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.techsocialist.servicebuilder.service.impl.PosterLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.techsocialist.servicebuilder.service.impl.PosterLocalServiceImpl
 * @generated
 */
public abstract class PosterLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, PosterLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>PosterLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.techsocialist.servicebuilder.service.PosterLocalServiceUtil</code>.
	 */

	/**
	 * Adds the poster to the database. Also notifies the appropriate model listeners.
	 *
	 * @param poster the poster
	 * @return the poster that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Poster addPoster(Poster poster) {
		poster.setNew(true);

		return posterPersistence.update(poster);
	}

	/**
	 * Creates a new poster with the primary key. Does not add the poster to the database.
	 *
	 * @param id the primary key for the new poster
	 * @return the new poster
	 */
	@Override
	@Transactional(enabled = false)
	public Poster createPoster(long id) {
		return posterPersistence.create(id);
	}

	/**
	 * Deletes the poster with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the poster
	 * @return the poster that was removed
	 * @throws PortalException if a poster with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Poster deletePoster(long id) throws PortalException {
		return posterPersistence.remove(id);
	}

	/**
	 * Deletes the poster from the database. Also notifies the appropriate model listeners.
	 *
	 * @param poster the poster
	 * @return the poster that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Poster deletePoster(Poster poster) {
		return posterPersistence.remove(poster);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Poster.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return posterPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.PosterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return posterPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.PosterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return posterPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return posterPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return posterPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Poster fetchPoster(long id) {
		return posterPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the poster with the primary key.
	 *
	 * @param id the primary key of the poster
	 * @return the poster
	 * @throws PortalException if a poster with the primary key could not be found
	 */
	@Override
	public Poster getPoster(long id) throws PortalException {
		return posterPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(posterLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Poster.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(posterLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Poster.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(posterLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Poster.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return posterPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return posterLocalService.deletePoster((Poster)persistedModel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return posterPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the posters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.PosterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of posters
	 * @param end the upper bound of the range of posters (not inclusive)
	 * @return the range of posters
	 */
	@Override
	public List<Poster> getPosters(int start, int end) {
		return posterPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of posters.
	 *
	 * @return the number of posters
	 */
	@Override
	public int getPostersCount() {
		return posterPersistence.countAll();
	}

	/**
	 * Updates the poster in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param poster the poster
	 * @return the poster that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Poster updatePoster(Poster poster) {
		return posterPersistence.update(poster);
	}

	@Override
	public PosterContentBlobModel getContentBlobModel(Serializable primaryKey) {
		Session session = null;

		try {
			session = posterPersistence.openSession();

			return (PosterContentBlobModel)session.get(
				PosterContentBlobModel.class, primaryKey);
		}
		catch (Exception exception) {
			throw posterPersistence.processException(exception);
		}
		finally {
			posterPersistence.closeSession(session);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public InputStream openContentInputStream(long id) {
		try {
			PosterContentBlobModel PosterContentBlobModel = getContentBlobModel(
				id);

			Blob blob = PosterContentBlobModel.getContentBlob();

			if (blob == null) {
				return _EMPTY_INPUT_STREAM;
			}

			InputStream inputStream = blob.getBinaryStream();

			if (_useTempFile) {
				inputStream = new AutoDeleteFileInputStream(
					_file.createTempFile(inputStream));
			}

			return inputStream;
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Activate
	protected void activate() {
		DB db = DBManagerUtil.getDB();

		if ((db.getDBType() != DBType.DB2) &&
			(db.getDBType() != DBType.MYSQL) &&
			(db.getDBType() != DBType.MARIADB) &&
			(db.getDBType() != DBType.SYBASE)) {

			_useTempFile = true;
		}
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			PosterLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		posterLocalService = (PosterLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PosterLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Poster.class;
	}

	protected String getModelClassName() {
		return Poster.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = posterPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	protected PosterLocalService posterLocalService;

	@Reference
	protected PosterPersistence posterPersistence;

	@Reference
	protected ProductionHousePersistence productionHousePersistence;

	@Reference
	protected TicketPersistence ticketPersistence;

	@Reference
	protected VideoPersistence videoPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected File _file;

	private static final InputStream _EMPTY_INPUT_STREAM =
		new UnsyncByteArrayInputStream(new byte[0]);

	private boolean _useTempFile;

}