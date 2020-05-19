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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.techsocialist.servicebuilder.model.ProductionHouseEntry;
import com.techsocialist.servicebuilder.service.ProductionHouseEntryLocalService;
import com.techsocialist.servicebuilder.service.persistence.ProductionHouseEntryPersistence;
import com.techsocialist.servicebuilder.service.persistence.VideoEntryPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the production house entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.techsocialist.servicebuilder.service.impl.ProductionHouseEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.techsocialist.servicebuilder.service.impl.ProductionHouseEntryLocalServiceImpl
 * @generated
 */
public abstract class ProductionHouseEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   ProductionHouseEntryLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ProductionHouseEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.techsocialist.servicebuilder.service.ProductionHouseEntryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the production house entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouseEntry the production house entry
	 * @return the production house entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProductionHouseEntry addProductionHouseEntry(
		ProductionHouseEntry productionHouseEntry) {

		productionHouseEntry.setNew(true);

		return productionHouseEntryPersistence.update(productionHouseEntry);
	}

	/**
	 * Creates a new production house entry with the primary key. Does not add the production house entry to the database.
	 *
	 * @param id the primary key for the new production house entry
	 * @return the new production house entry
	 */
	@Override
	@Transactional(enabled = false)
	public ProductionHouseEntry createProductionHouseEntry(long id) {
		return productionHouseEntryPersistence.create(id);
	}

	/**
	 * Deletes the production house entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the production house entry
	 * @return the production house entry that was removed
	 * @throws PortalException if a production house entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProductionHouseEntry deleteProductionHouseEntry(long id)
		throws PortalException {

		return productionHouseEntryPersistence.remove(id);
	}

	/**
	 * Deletes the production house entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouseEntry the production house entry
	 * @return the production house entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ProductionHouseEntry deleteProductionHouseEntry(
		ProductionHouseEntry productionHouseEntry) {

		return productionHouseEntryPersistence.remove(productionHouseEntry);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			ProductionHouseEntry.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return productionHouseEntryPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.ProductionHouseEntryModelImpl</code>.
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

		return productionHouseEntryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.ProductionHouseEntryModelImpl</code>.
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

		return productionHouseEntryPersistence.findWithDynamicQuery(
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
		return productionHouseEntryPersistence.countWithDynamicQuery(
			dynamicQuery);
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

		return productionHouseEntryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ProductionHouseEntry fetchProductionHouseEntry(long id) {
		return productionHouseEntryPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the production house entry with the primary key.
	 *
	 * @param id the primary key of the production house entry
	 * @return the production house entry
	 * @throws PortalException if a production house entry with the primary key could not be found
	 */
	@Override
	public ProductionHouseEntry getProductionHouseEntry(long id)
		throws PortalException {

		return productionHouseEntryPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			productionHouseEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ProductionHouseEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			productionHouseEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			ProductionHouseEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			productionHouseEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ProductionHouseEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return productionHouseEntryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return productionHouseEntryLocalService.deleteProductionHouseEntry(
			(ProductionHouseEntry)persistedModel);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return productionHouseEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the production house entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.ProductionHouseEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of production house entries
	 * @param end the upper bound of the range of production house entries (not inclusive)
	 * @return the range of production house entries
	 */
	@Override
	public List<ProductionHouseEntry> getProductionHouseEntries(
		int start, int end) {

		return productionHouseEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of production house entries.
	 *
	 * @return the number of production house entries
	 */
	@Override
	public int getProductionHouseEntriesCount() {
		return productionHouseEntryPersistence.countAll();
	}

	/**
	 * Updates the production house entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param productionHouseEntry the production house entry
	 * @return the production house entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ProductionHouseEntry updateProductionHouseEntry(
		ProductionHouseEntry productionHouseEntry) {

		return productionHouseEntryPersistence.update(productionHouseEntry);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ProductionHouseEntryLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		productionHouseEntryLocalService =
			(ProductionHouseEntryLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ProductionHouseEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ProductionHouseEntry.class;
	}

	protected String getModelClassName() {
		return ProductionHouseEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				productionHouseEntryPersistence.getDataSource();

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

	protected ProductionHouseEntryLocalService productionHouseEntryLocalService;

	@Reference
	protected ProductionHouseEntryPersistence productionHouseEntryPersistence;

	@Reference
	protected VideoEntryPersistence videoEntryPersistence;

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

}