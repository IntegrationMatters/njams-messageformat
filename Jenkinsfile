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
   env.JAVA_HOME = tool 'openJDK-11.0.20'

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
        // Branch and commit are resolved by git-commit-id-maven-plugin itself — on Jenkins it reads
        // the GIT_LOCAL_BRANCH / GIT_BRANCH the agent already exports — so neither is passed in.
        sh "'${mvnHome}/bin/mvn' clean deploy -U -Pjenkins-cli,svn-check"
        archiveArtifacts 'target/njams-messageformat*.*'
   }
   
   stage('Javadoc') {
        echo "Javadoc njams-messageformat"
        sh "'${mvnHome}/bin/mvn' generate-sources javadoc:javadoc"
        publishHTML([allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: false,
                        reportDir: 'target/reports/apidocs/',
                        reportFiles: 'index.html',
                        reportName: 'Javadoc',
                        reportTitles: ''])
   }
}
