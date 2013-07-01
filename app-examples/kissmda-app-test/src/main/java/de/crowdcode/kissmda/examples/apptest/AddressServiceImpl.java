/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package de.crowdcode.kissmda.examples.apptest;

import de.crowdcode.kissmda.testapp.Address;
import de.crowdcode.kissmda.testapp.AddressService;
import de.crowdcode.kissmda.testapp.Person;

/**
 * AddressService implementation.
 * 
 * @author Lofi Dewanto
 * @version 1.1.0
 */
public class AddressServiceImpl implements AddressService {

	@Override
	public void createAddressFromPerson(Address address, Person person) {
		// We can do anything else to Person and Address like creating a real
		// entity in the database before we set the relationship
		address.setPerson(person);
	}
}