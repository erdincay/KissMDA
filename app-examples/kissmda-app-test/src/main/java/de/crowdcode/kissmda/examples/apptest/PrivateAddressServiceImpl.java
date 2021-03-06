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

import java.util.Collection;
import java.util.SortedSet;

import de.crowdcode.kissmda.testapp.Address;
import de.crowdcode.kissmda.testapp.Person;
import de.crowdcode.kissmda.testapp.PrivateAddressService;
import de.crowdcode.kissmda.testapp.PrivateCompany;
import de.crowdcode.kissmda.testapp.components.Company;
import de.crowdcode.kissmda.testapp.components.CompanyAttribute;

public class PrivateAddressServiceImpl extends AddressServiceImpl implements
		PrivateAddressService {

	@Override
	public void createPrivateAddressFromPerson(Address privateAddress,
			Person person) {
		privateAddress.setPerson(person);
	}

	@Override
	public Company getPrivateCompanyByPerson(Person person,
			PrivateCompany privateCompany) {
		return privateCompany;
	}

	@Override
	public Collection<Company> getCompanies(
			SortedSet<CompanyAttribute<String, Integer>> companyAttributes) {
		return new PrivateCompanyImpl().getCompanies();
	}
}
