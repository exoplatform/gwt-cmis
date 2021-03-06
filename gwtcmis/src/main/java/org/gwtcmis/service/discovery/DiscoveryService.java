/**
 *  Copyright (C) 2010 eXo Platform SAS.
 *
 *  This is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU Lesser General Public License as
 *  published by the Free Software Foundation; either version 2.1 of
 *  the License, or (at your option) any later version.
 *
 *  This software is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this software; if not, write to the Free
 *  Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 *  02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.gwtcmis.service.discovery;

import org.gwtcmis.client.CmisArguments;
import org.gwtcmis.client.CmisMediaTypes;
import org.gwtcmis.marshallers.QueryMarshaller;
import org.gwtcmis.model.actions.Query;
import org.gwtcmis.model.restatom.EntryCollection;
import org.gwtcmis.rest.AsyncRequest;
import org.gwtcmis.rest.AsyncRequestCallback;
import org.gwtcmis.rest.ExceptionThrownEvent;
import org.gwtcmis.rest.HTTPHeader;
import org.gwtcmis.service.discovery.event.QueryResultReceivedEvent;
import org.gwtcmis.unmarshallers.EntryCollectionUnmarshaller;







import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.http.client.RequestBuilder;

/**
 * Created by The eXo Platform SAS.
 *	
 * @author <a href="mailto:zhulevaanna@gmail.com">Ann Zhuleva</a>
 * @version $Id:   ${date} ${time}
 *
 */
public class DiscoveryService
{

   /**
    * Event bus.
    */
   private HandlerManager eventBus;

   /**
    * @param eventBus eventBus
    */
   public DiscoveryService(HandlerManager eventBus)
   {
      this.eventBus = eventBus;
   }

   /**
    * The Discovery Services (query) are used to search for query-able objects within the Repository.
    * 
    * On success results received, {@link QueryResultReceivedEvent} is fired
    * 
    * @param url url
    * @param query query
    */
   public void query(String url, Query query)
   {
      EntryCollection entryCollection = new EntryCollection();
      QueryResultReceivedEvent event = new QueryResultReceivedEvent(entryCollection);
      ExceptionThrownEvent errorEvent = new ExceptionThrownEvent("Query was performed with errors.");
      EntryCollectionUnmarshaller unmarshaller = new EntryCollectionUnmarshaller(entryCollection);

      QueryMarshaller marshaller = new QueryMarshaller(query);

      String params = "";
      params +=
         (query.getIncludeRelationships() == null) ? "" : CmisArguments.INCLUDE_RELATIONSHIPS + "="
            + query.getIncludeRelationships().value() + "&";
      params +=
         (query.getRenditionFilter() == null || query.getRenditionFilter().length() <= 0) ? ""
            : CmisArguments.RENDITION_FILTER + "=" + query.getRenditionFilter() + "&";
      params += CmisArguments.INCLUDE_ALLOWABLE_ACTIONS + "=" + query.getIncludeAllowableActions() + "&";
      params +=
         (query.getMaxItems() == null || query.getMaxItems() < 0) ? "" : CmisArguments.MAX_ITEMS + "="
            + query.getMaxItems() + "&";
      params +=
         (query.getSkipCount() == null || query.getSkipCount() < 0) ? "" : CmisArguments.SKIP_COUNT + "="
            + query.getSkipCount() + "&";
      url = (url.contains("?")) ? (url +"&"+params) : (url + "?" + params);
      AsyncRequestCallback callback = new AsyncRequestCallback(eventBus, unmarshaller, event, errorEvent);
      AsyncRequest.build(RequestBuilder.POST, url).header(HTTPHeader.CONTENT_TYPE,
         CmisMediaTypes.QUERY_DOCUMENT).data(marshaller).send(callback);
   }

}
