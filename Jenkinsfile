pipeline {
    agent any
    stages {
        stage('Build'){
            steps {
                echo "Build Project"
                sh label: '', script: 'mvn clean install'
            }
        }
        stage('HTML REPORT'){
            steps{
                echo "HTML Report"
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: '/var/lib/jenkins/workspace/so-pipe/', reportFiles: 'ExtentReportResults.html', reportName: 'HTML Report', reportTitles: ''])
            }
        }
        stage('JUnit REPORT'){
            steps{
                echo "JUNIT Reports"
                junit '/var/lib/jenkins/workspace/so-pipe/target/surefire-reports/*.xml'
            }
        }
    }
}
