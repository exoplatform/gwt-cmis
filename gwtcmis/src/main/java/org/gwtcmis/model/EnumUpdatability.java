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

package org.gwtcmis.model;

/**
 * @author 
 * @version $Id: 
 *
 */
public enum EnumUpdatability 
{
   /**
    * Read only.
    */
   READONLY("readonly"), 
   
   /**
    * Read write.
    */
   READWRITE("readwrite"), 
   
   /**
    * When checked out.
    */
   WHENCHECKEDOUT("whencheckedout"), 
   
   /**
    * On create.
    */
   ONCREATE("oncreate");
   
   /**
    * Value.
    */
   private final String value;

   /**
    * @param v value
    */
   EnumUpdatability(String v)
   {
      value = v;
   }

   /**
    * @return String
    */
   public String value()
   {
      return value;
   }

   /**
    * @param v value
    * @return {@link EnumUpdatability}
    */
   public static EnumUpdatability fromValue(String v)
   {
      for (EnumUpdatability c : EnumUpdatability.values())
      {
         if (c.value.equals(v))
         {
            return c;
         }
      }
      throw new IllegalArgumentException(v);
   }

}
