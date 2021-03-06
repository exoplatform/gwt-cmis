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

package org.gwtcmis.service.object.event;

import org.gwtcmis.model.restatom.AtomEntry;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by The eXo Platform SAS.
 * 
 * Event is fired when document was created
 * 
 * @author <a href="mailto:zhulevaanna@gmail.com">Anna Zhuleva</a>
 * @version $Id:
 */
public class DocumentCreatedEvent extends GwtEvent<DocumentCreatedHandler>
{
   /**
    * Type.
    */
   public static final GwtEvent.Type<DocumentCreatedHandler> TYPE = 
      new GwtEvent.Type<DocumentCreatedHandler>();

   /**
    * Document.
    */
   private AtomEntry document;

   /**
    * @param document document
    */
   public DocumentCreatedEvent(AtomEntry document)
   {
      this.document = document;
   }

   /**
    * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
    * 
    * @param handler handler
    */
   @Override
   protected void dispatch(DocumentCreatedHandler handler)
   {
      handler.onDocumentCreated(this);
   }

   /**
    * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
    * 
    * @return Type {@link DocumentCreatedHandler}
    */
   @Override
   public Type<DocumentCreatedHandler> getAssociatedType()
   {
      return TYPE;
   }

   /**
    * @return {@link AtomEntry}
    */
   public AtomEntry getDocument()
   {
      return document;
   }
}
