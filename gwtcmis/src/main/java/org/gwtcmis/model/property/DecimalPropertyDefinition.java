/*
 * Copyright (C) 2010 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.gwtcmis.model.property;

import org.gwtcmis.model.Choice;
import org.gwtcmis.model.EnumCardinality;
import org.gwtcmis.model.EnumPropertyType;
import org.gwtcmis.model.EnumUpdatability;
import org.gwtcmis.model.Precision;

import java.util.List;


/**
 * @author <a href="mailto:oksana.vereshchaka@gmail.com">Oksana Vereshchaka</a>
 * @version $Id: $
 */
public class DecimalPropertyDefinition extends BasePropertyDefinition<Double>
{
   private Precision precision;
   
   private Double minDecimal;
   
   private Double maxDecimal;
   
   /**
    * Default constructor.
    */
   public DecimalPropertyDefinition()
   {
      super();
   }
   
   /**
    * @param id id 
    * @param localName local name
    * @param localNamespace local name space
    * @param queryName query name
    * @param displayName display name
    * @param description description
    * @param cardinality cardinality
    * @param updatability updatability
    * @param inherited inherited
    * @param required required
    * @param queryable queryable
    * @param orderable orderable
    * @param openChoice open choice
    * @param choices choices
    * @param defaultValue default value
    * @param precision precision 
    * @param minDecimal min decimal value
    * @param maxDecimal max decimal value
    */
   public DecimalPropertyDefinition(String id, String localName, String localNamespace,
      String queryName, String displayName, String description, 
      EnumCardinality cardinality,EnumUpdatability updatability, 
      Boolean inherited, Boolean required, Boolean queryable, Boolean orderable, 
      Boolean openChoice, List<Choice<Double>> choices, Double[] defaultValue,
      Precision precision, Double minDecimal, Double maxDecimal)
   {
      super(id, localName, localNamespace, queryName, displayName, description, cardinality, 
         updatability, inherited, required, queryable, orderable, openChoice, choices, 
         defaultValue);
      this.precision = precision;
      this.minDecimal = minDecimal;
      this.maxDecimal = maxDecimal;
   }
   
   /**
    * @return property precision
    */
   public Precision getPrecision()
   {
      return precision;
   }
   
   /**
    * @return property min decimal
    */
   public Double getMinDecimal()
   {
      return minDecimal;
   }
   
   /**
    * @return property max decimal
    */
   public Double getMaxDecimal()
   {
      return maxDecimal;
   }

   /**
    * {@inheritDoc}
    */
   public EnumPropertyType getPropertyType()
   {
      return EnumPropertyType.DECIMAL;
   }
   
   /**
    * Setter for precision.
    * 
    * @param precision precision
    */
   public void setPrecision(Precision precision)
   {
      this.precision = precision;
   }
   
   /**
    * Setter for minDecimal.
    * 
    * @param minDecimal minDecimal
    */
   public void setMinDecimal(Double minDecimal)
   {
      this.minDecimal = minDecimal;
   }
   
   /**
    * Setter for maxDecimal.
    * 
    * @param maxDecimal maxDecimal
    */
   public void setMaxDecimal(Double maxDecimal)
   {
      this.maxDecimal = maxDecimal;
   }

}
