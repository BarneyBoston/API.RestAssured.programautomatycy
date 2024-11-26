pipeline {
    agent {
        node {
            label "sampleAgent"
        }
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
        timeout(time: 6, unit: 'HOURS')
    }

    stages {
        stage('Compile') {
            steps {
                sh """
                   mvn clean install -DskipTests
                """
            }
        }
        stage('Test') {
            steps {
                sh """
                    mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng.xml
                """
            }
        }
    }

    post {
        success {
            emailext to: 'sampleEmail@gmail.com',
                    mimeType: 'text/html',
                    subject: """API Test Results""",
                    body: '${FILE,path="target/surefire-reports/email-report.html"}'
            allure([
                    includeProperties: false,
                    jdk              : '',
                    properties       : [],
                    reportBuildPolicy: 'ALWAYS',
                    results          : [[path: 'target/allure-results']]
            ])
        }
    }
}