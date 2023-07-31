package sailpoint.plugin.admindashboard.rest;

import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.connector.Connector;
import sailpoint.connector.ConnectorFactory;
import sailpoint.object.Application;
import sailpoint.object.QueryOptions;
import sailpoint.rest.plugin.BasePluginResource;
import sailpoint.rest.plugin.RequiredRight;
import sailpoint.tools.Util;

@RequiredRight(value = "dashboardRESTAllow")
@Path("dashboard")
public class DashboardResource extends BasePluginResource {
	public static final Log log = LogFactory.getLog(DashboardResource.class);
	public static SailPointContext context = null;

	@GET
	@Path("applicationstatus")
	@Produces(MediaType.APPLICATION_JSON)
	@RequiredRight(value = "applicationstatus")
	public List getApplicationstatus() {
		List appStatus = new ArrayList<>();
		log.debug("GET applicationstatus");
		// The method is fetch the list of application and show status.
		try {
			context = SailPointFactory.getCurrentContext();
			QueryOptions queryOptions = new QueryOptions();
			Iterator it = context.search(Application.class, queryOptions);
			if (null != it) {
				while (it.hasNext()) {
					Application tempApp = (Application) it.next();
					String appMsg = "";
					if (null != tempApp) {
						try {
							Connector connector = ConnectorFactory.getConnector(tempApp, null);
							connector.testConfiguration();
							appMsg = "sucess";
						} catch (Exception e) {
							log.error("Error occured in test connection for app:" + tempApp.getName()
									+ ", failed with error:" + e);
							appMsg = e.getMessage();
						}

					}
					Map appMap = new HashMap<>();
					appMap.put(tempApp.getName(), appMsg);
					appStatus.add(appMap);
				}
			}
			Util.flushIterator(it);

		} catch (Exception e) {
			log.error("Error occured in application status retrieval:" + e);
		}
		return appStatus;
	}

	@Override
	public String getPluginName() {
		return "adminDashboard";
	}
}
