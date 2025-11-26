pipeline {
agent any

```
environment {
    JAVA_HOME = "/Library/Java/JavaVirtualMachines/temurin-17.jdk/Contents/Home"
    PATH = "${JAVA_HOME}/bin:${PATH}"
    IMAGE_NAME = "mycompany/myapp"
    IMAGE_TAG = "v1.0"
}

stages {

    stage('Verify Java Version') {
        steps {
            sh '''
                echo "JAVA VERSION:"
                java -version
                echo "MAVEN VERSION:"
                mvn -version
            '''
        }
    }

    stage('Checkout') {
        steps {
            checkout scm
        }
    }

    stage('Clean Workspace') {
        steps {
            sh 'mvn clean'
        }
    }

    stage('Build') {
        steps {
            sh 'mvn package -DskipTests'
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
        }
    }

    stage('Push to Registry') {
        steps {
            echo 'Skipping push for now'
        }
    }

    stage('Deploy to Dev Server') {
        steps {
            echo 'Deploying container...'
        }
    }
}
```

}
