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

package org.gwtcmis.model.restatom;

/**
 * Created by The eXo Platform SAS.
 * 
 * @author <a href="mailto:zhulevaanna@gmail.com">Anna Zhuleva</a>
 * @version $Id:
 */

public class AtomContentType
{
   /**
    * Source.
    */
   private String source;

   /**
    * Type.
    */
   private String type;

   /**
    * Accessor for content source.
    * 
    * @return the source
    */
   public String getSource()
   {
      return source;
   }

   /**
    * Mutator for content source.
    * 
    * @param source
    *            the source to set
    */
   public void setSource(String source)
   {
      this.source = source;
   }

   /**
    * @return String
    */
   public String getType()
   {
      return type;
   }

   /**
    * @param type type
    */
   public void setType(String type)
   {
      this.type = type;
   }
}
