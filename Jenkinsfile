pipeline {
agent any
stages {
    stage("Checkout"){
        steps{
            checkout([$class: 'GitSCM', branches: [[name: '*/main']],
                        userRemoteConfigs: [[url: 'https://github.com/ManicDeva/calculator.git']]])
        }

    }
    stage("Compile"){
        steps{
            sh "./gradlew compileJava"
        }
    }
    stage("Unit test"){
        steps{
            sh "./gradlew test"
        }
    }
    stage("Code coverage"){
        steps{
        sh "./gradlew test jacocoTestCoverageVerification"
        }
    }
}
}