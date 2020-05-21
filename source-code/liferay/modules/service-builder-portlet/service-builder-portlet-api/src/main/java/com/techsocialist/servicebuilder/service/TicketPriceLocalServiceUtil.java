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

package com.techsocialist.servicebuilder.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TicketPrice. This utility wraps
 * <code>com.techsocialist.servicebuilder.service.impl.TicketPriceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TicketPriceLocalService
 * @generated
 */
public class TicketPriceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.techsocialist.servicebuilder.service.impl.TicketPriceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ticket price to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketPrice the ticket price
	 * @return the ticket price that was added
	 */
	public static com.techsocialist.servicebuilder.model.TicketPrice
		addTicketPrice(
			com.techsocialist.servicebuilder.model.TicketPrice ticketPrice) {

		return getService().addTicketPrice(ticketPrice);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new ticket price with the primary key. Does not add the ticket price to the database.
	 *
	 * @param id the primary key for the new ticket price
	 * @return the new ticket price
	 */
	public static com.techsocialist.servicebuilder.model.TicketPrice
		createTicketPrice(long id) {

		return getService().createTicketPrice(id);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the ticket price with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the ticket price
	 * @return the ticket price that was removed
	 * @throws PortalException if a ticket price with the primary key could not be found
	 */
	public static com.techsocialist.servicebuilder.model.TicketPrice
			deleteTicketPrice(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketPrice(id);
	}

	/**
	 * Deletes the ticket price from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketPrice the ticket price
	 * @return the ticket price that was removed
	 */
	public static com.techsocialist.servicebuilder.model.TicketPrice
		deleteTicketPrice(
			com.techsocialist.servicebuilder.model.TicketPrice ticketPrice) {

		return getService().deleteTicketPrice(ticketPrice);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.TicketPriceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.TicketPriceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.techsocialist.servicebuilder.model.TicketPrice
		fetchTicketPrice(long id) {

		return getService().fetchTicketPrice(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the ticket price with the primary key.
	 *
	 * @param id the primary key of the ticket price
	 * @return the ticket price
	 * @throws PortalException if a ticket price with the primary key could not be found
	 */
	public static com.techsocialist.servicebuilder.model.TicketPrice
			getTicketPrice(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTicketPrice(id);
	}

	/**
	 * Returns a range of all the ticket prices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.techsocialist.servicebuilder.model.impl.TicketPriceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket prices
	 * @param end the upper bound of the range of ticket prices (not inclusive)
	 * @return the range of ticket prices
	 */
	public static java.util.List
		<com.techsocialist.servicebuilder.model.TicketPrice> getTicketPrices(
			int start, int end) {

		return getService().getTicketPrices(start, end);
	}

	/**
	 * Returns the number of ticket prices.
	 *
	 * @return the number of ticket prices
	 */
	public static int getTicketPricesCount() {
		return getService().getTicketPricesCount();
	}

	/**
	 * Updates the ticket price in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketPrice the ticket price
	 * @return the ticket price that was updated
	 */
	public static com.techsocialist.servicebuilder.model.TicketPrice
		updateTicketPrice(
			com.techsocialist.servicebuilder.model.TicketPrice ticketPrice) {

		return getService().updateTicketPrice(ticketPrice);
	}

	public static TicketPriceLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketPriceLocalService, TicketPriceLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TicketPriceLocalService.class);

		ServiceTracker<TicketPriceLocalService, TicketPriceLocalService>
			serviceTracker =
				new ServiceTracker
					<TicketPriceLocalService, TicketPriceLocalService>(
						bundle.getBundleContext(),
						TicketPriceLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}