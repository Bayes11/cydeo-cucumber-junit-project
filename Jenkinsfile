node {
    stage('Clone code') {
        git 'https://github.com/mehmetCt/demo-project.git'
    }

    stage('Run tests'){
        if(isUnix()){
            sh "mvn clean test -Dcucumber.filter.tags=\"@test\""
        } else {
            bat "mvn clean test -Dcucumber.filter.tags=\"@test\""
        }

    }

    stage('Generate report'){
           cucumber failedFeaturesNumber: -1,
            failedScenariosNumber: -1,
            failedStepsNumber: -1,
            fileIncludePattern: '**/*.json',
            pendingStepsNumber: -1,
            skippedStepsNumber: -1,
            sortingMethod: 'ALPHABETICAL',
            undefinedStepsNumber: -1
    }
}