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
package de.crowdcode.kissmda.core.uml;

import javax.inject.Inject;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.PrimitiveType.Code;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.uml2.uml.Type;

/**
 * Java Helper class for UML.
 * 
 * @author Lofi Dewanto
 * @since 1.0.0
 * @version 1.0.0
 */
public class JavaHelper {

	@Inject
	private PackageHelper packageHelper;

	@Inject
	private DataTypeUtils dataTypeUtils;

	public void setDataTypeUtils(DataTypeUtils dataTypeUtils) {
		this.dataTypeUtils = dataTypeUtils;
	}

	public void setPackageHelper(PackageHelper packageHelper) {
		this.packageHelper = packageHelper;
	}

	@SuppressWarnings("unchecked")
	public void getType(AST ast, TypeDeclaration td, MethodDeclaration md,
			Type type, String typeNameInput, String sourceDirectoryPackageName) {
		String typeName = packageHelper.removeUmlPrefixes(typeNameInput);
		typeName = packageHelper.getFullPackageName(typeName,
				sourceDirectoryPackageName);
		if (typeName.equalsIgnoreCase("void")) {
			PrimitiveType primitiveType = getAstPrimitiveType(ast,
					type.getName());
			md.setReturnType2(primitiveType);
			td.bodyDeclarations().add(md);
		} else {
			SimpleType tp = getAstSimpleType(ast, typeName);
			md.setReturnType2(tp);
			td.bodyDeclarations().add(md);
		}
	}

	private SimpleType getAstSimpleType(AST ast, String typeName) {
		String javaType = dataTypeUtils.getJavaTypes().get(
				typeName.toLowerCase());
		SimpleType tp = null;
		if (javaType != null) {
			tp = ast.newSimpleType(ast.newName(javaType));
		} else {
			tp = ast.newSimpleType(ast.newName(typeName));
		}
		return tp;
	}

	private PrimitiveType getAstPrimitiveType(AST ast, String name) {
		Code typeCode = dataTypeUtils.getPrimitiveTypeCodes().get(
				name.toLowerCase());
		return ast.newPrimitiveType(typeCode);
	}
}