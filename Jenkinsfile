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
        sh "./gradlew test jacocoTestReport"
        publishHTML (
        target: [
        reportDir: 'build/reports/jacoco/test/html',
        reportFiles: 'index.html',
        reportName: 'JaCoCo Report'
        ]
        )
        sh "./gradlew test jacocoTestCoverageVerification"
        }
    }
    stage("Static code analysis"){
        steps{
            sh "./gradlew checkstyleMain"
            publishHTML (
            target: [
            reportDir: 'build/reports/checkstyle/',
            reportFiles: 'main.html',
            reportName: 'checkstyle Report'
            ]
            )
        }
    }
}
}