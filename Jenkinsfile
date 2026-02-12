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
                    url: 'https://github.com/your-repo/JavaSeleniumWithCiCD.git'
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



