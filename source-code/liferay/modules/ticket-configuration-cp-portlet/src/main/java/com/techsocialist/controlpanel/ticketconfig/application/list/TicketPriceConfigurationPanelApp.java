package com.techsocialist.controlpanel.ticketconfig.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.techsocialist.controlpanel.ticketconfig.constants.TicketPriceConfigurationPanelCategoryKeys;
import com.techsocialist.controlpanel.ticketconfig.constants.TicketPriceConfigurationPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author ravaneswaran
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + TicketPriceConfigurationPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class TicketPriceConfigurationPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return TicketPriceConfigurationPortletKeys.FILM_TICKET_PRICE_CONFIGURATION;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + TicketPriceConfigurationPortletKeys.FILM_TICKET_PRICE_CONFIGURATION + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}