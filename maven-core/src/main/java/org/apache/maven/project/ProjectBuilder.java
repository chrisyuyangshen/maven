package org.apache.maven.project;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

import java.io.File;

import org.apache.maven.artifact.Artifact;

public interface ProjectBuilder
{

    MavenProject build( File projectFile, ProjectBuildingRequest request )
        throws ProjectBuildingException;

    MavenProject build( Artifact projectArtifact, ProjectBuildingRequest request )
        throws ProjectBuildingException;

    // TODO: this is only to provide a project for plugins that don't need a project to execute but need some
    // of the values from a MavenProject. Ideally this should be something internal and nothing outside Maven
    // would ever need this so it should not be exposed in a public API
    MavenProject buildStandaloneSuperProject( ProjectBuildingRequest request )
        throws ProjectBuildingException;

    // TODO: This also doesn't really belong here as it's a mix of project builder and artifact resolution and belongs
    // in an integration component like the embedder.
    @Deprecated
    MavenProjectBuildingResult buildProjectWithDependencies( File project, ProjectBuildingRequest request )
        throws ProjectBuildingException;

}