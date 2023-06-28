#!/usr/bin/env groovy

import groovy.json.JsonOutput

properties([
    buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')),
    pipelineTriggers([
        //pollSCM('')
    ])
])

node ('master') {
   def mvnHome
   env.JAVA_HOME = tool 'openJDK-11.0.2'

   stage ('Clean') {
      deleteDir()
   }

   stage('Preparation') { // for display purposes
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'Maven 3.8.5'
      echo 'Getting source code...'
      scmInfo = checkout scm
      echo "scm: ${scmInfo}"
   }
   stage('Build') {
        echo "Build njams-messageformat"
        sh "'${mvnHome}/bin/mvn' clean deploy -U -Pjenkins-cli,svn-check -DrevisionNumber=${env.BUILD_NUMBER} -DscmBranch=${scmInfo.GIT_BRANCH} -DscmCommit=${scmInfo.GIT_COMMIT}"
        archiveArtifacts 'target/njams-messageformat*.*'
   }
   
   stage('Javadoc') {
        echo "Javadoc njams-messageformat"
        sh "'${mvnHome}/bin/mvn' generate-sources javadoc:javadoc"
        publishHTML([allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'target/site/apidocs/',
                        reportFiles: 'index.html',
                        reportName: 'Javadoc',
                        reportTitles: ''])
   }
}
