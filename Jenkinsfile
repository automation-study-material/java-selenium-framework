pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }



    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/automation-study-material/java-selenium-framework',
                    credentialsId: 'github-token'
            }
        }

        stage('Build & Test') {
            steps {
                sh "mvn clean test "
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false,
                        jdk: '',
                        results: [[path: 'allure-results']]
            }
        }
    }

}





