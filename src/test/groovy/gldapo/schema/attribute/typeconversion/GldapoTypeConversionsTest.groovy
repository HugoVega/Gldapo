/* 
 * Copyright 2007 Luke Daley
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gldapo.schema.attribute.typeconversion;
import javax.naming.directory.BasicAttribute

class GldapoTypeConversionsTest extends GroovyTestCase 
{
	void testStringConversion() 
	{
		def a = new BasicAttribute("", 2)
		def convertd = GldapoTypeConversions.convertToStringType(a)
		assertEquals(String, convertd.class)
		assertEquals("2", convertd)
	}
	
	void testListConversion()
	{
		def a = new BasicAttribute("", 1)
		a.add(2)
		a.add(3)
		def convertd = GldapoTypeConversions.convertToListType(a)
		assert(convertd instanceof List)
		assertEquals([1, 2, 3], convertd)
	}
}