pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Dockerize') {
            steps {
                sh 'docker build -t my-image .'
                sh 'docker tag my-image my-registry/my-image'
            }
        }
        stage('Push to Registry') {
            steps {
                withDockerRegistry(credentialsId: 'my-docker-registry-credentials', url: 'https://index.docker.io/v1/') {
                    sh 'docker push my-registry/my-image'
                }
            }
        }
        stage('Deploy') {
            steps {
                sh 'kubectl apply -f deployment.yaml'
            }
        }
    }
}