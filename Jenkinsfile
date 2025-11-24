pipeline {
    agent any

    environment {
        IMAGE_NAME = "mycompany/myapp"
        IMAGE_TAG = "v1.0"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME:$IMAGE_TAG .'
            }
        }

        stage('Security Scan') {
            steps {
                echo 'Running Trivy scan...'
                // sh 'trivy image $IMAGE_NAME:$IMAGE_TAG'
            }
        }

        stage('Push to Registry') {
            steps {
                echo 'skip'
            }
        }

        stage('Deploy to Dev Server') {
            steps {
                echo 'Deploying container...'
                // ssh commands or kubectl apply
            }
        }
    }
}
