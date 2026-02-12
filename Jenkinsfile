pipeline {

    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    parameters {
        string(name: 'ENV', defaultValue: 'qa')
        string(name: 'HEADLESS', defaultValue: 'true')
        booleanParam(name: 'REMOTE', defaultValue: false)
    }

    environment {
        BROWSERSTACK_USERNAME = credentials('bs-user')
        BROWSERSTACK_ACCESS_KEY = credentials('bs-key')
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


